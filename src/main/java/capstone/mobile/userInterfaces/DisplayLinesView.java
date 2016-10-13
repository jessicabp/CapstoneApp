package capstone.mobile.userInterfaces;

import capstone.mobile.App;
import capstone.mobile.dataHandlers.DataUnavailableException;
import capstone.mobile.dataHandlers.LocalDatabase;
import capstone.mobile.dataHandlers.RetrieveData;
import capstone.mobile.models.Animal;
import capstone.mobile.models.Line;
import capstone.mobile.models.Walk;
import capstone.mobile.other.CustomPopupView;
import com.gluonhq.charm.down.common.PlatformFactory;
import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import com.gluonhq.connect.GluonObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Fetches and displays searchable list of available lines from server
 * Allows user to open line, checks password
 */
public class DisplayLinesView extends View {

    private static GluonObservableList<Line> observableLinesList = new GluonObservableList<>();
    private Walk walk;
    private VBox controls;
    private TextField      filter        = new TextField();
    private ListView<Line> linesListView = new ListView<>();

    public DisplayLinesView(String name, Walk walk) {
        super(name);
        this.walk = walk;

        getStylesheets().add(DisplayLinesView.class.getResource("LineList.css").toExternalForm());
        getStylesheets().add(DisplayLinesView.class.getResource("secondary.css").toExternalForm());

        // Create VBox to hold items
        controls = new VBox();
        controls.setAlignment(Pos.CENTER);
        setTop(controls);

        // Create ListView to hold lines
        linesListView = new ListView<>(observableLinesList);

        // Create filter so users can search lines
        filter.setPromptText("Search");
        filter.textProperty().addListener((observable, oldValue, newValue) -> {
            String             search = filter.getText().toLowerCase();
            FilteredList<Line> f      = new FilteredList<>(observableLinesList);
            f.setPredicate(s -> s.getName().toLowerCase().contains(search));
            linesListView.setItems(f);
        });

        // Set cell factory to create a cell for each line
        linesListView.setCellFactory(lv -> new ListCell<Line>() {
            @Override
            protected void updateItem(Line line, boolean empty) {
                super.updateItem(line, empty);
                if (!empty) {
                    setText(line.getName());
                } else {
                    setText(null);
                }
                setPadding(new Insets(5, 10, 5, 10));
                setWrapText(true);
            }
        });

        // Add listener to cells
        linesListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newLine) -> {
            if (newLine != null) {
                LocalDatabase.setCurrentLine(newLine);
                selectLine(newLine, controls);
            }
        });

        // Add items to VBox
        controls.getChildren().addAll(filter, linesListView);
    }

    public static GluonObservableList<Line> getObservableLinesList() {
        return observableLinesList;
    }

    /**
     * Gets password, if correct: set's the walk's line to the given line, switches to SetUpWalkView
     *
     * @param line
     */
    public void selectLine(Line line, VBox owner) {
        linesListView.getSelectionModel().clearSelection();
        String password = PlatformFactory.getPlatform().getSettingService().retrieve("password" + line.getId());
        if (password != null) {
            try {
                if (RetrieveData.checkAuthorisation(line.getId(), password) > 0) {
                    PlatformFactory.getPlatform().getSettingService().store("password" + line.getId(), password);
                    walk.setLine(line);
                    App.getInstance().switchScreen(App.SET_UP_WALK_VIEW);
                } else {
                    askForPassword(owner, line);
                }
            } catch (DataUnavailableException e) {
                e.printStackTrace();
                showServerError();
            }
        } else {
            askForPassword(owner, line);
        }
    }

    private void askForPassword(VBox owner, Line line) {
        // Create popup to request password
        CustomPopupView passwordPopup = new CustomPopupView(owner);

        // Create layout for buttons with correct spacing
        VBox controls = new VBox(20);
        controls.setPadding(new Insets(40, 40, 40, 40));
        controls.setAlignment(Pos.CENTER);

        // Add title
        Text titleText = new Text("Password:");
        titleText.setTextAlignment(TextAlignment.CENTER);
        controls.getChildren().add(titleText);

        PasswordField passwordField = new PasswordField();
        passwordField.maxWidthProperty().bind(owner.widthProperty().subtract(25));
        controls.getChildren().add(passwordField);

        Button popupCancel = new Button("Cancel");
        popupCancel.setOnAction(ev -> passwordPopup.hide());
        Button popupDone = new Button("Save");
        popupDone.setOnAction(ev -> {
            try {
                String enteredPassword = passwordField.getText();
                if (RetrieveData.checkAuthorisation(line.getId(), enteredPassword) > 0) {
                    PlatformFactory.getPlatform().getSettingService().store("password" + line.getId(), enteredPassword);
                    walk.setLine(line);
                    passwordPopup.hide();
                    App.getInstance().switchScreen(App.SET_UP_WALK_VIEW);
                } else {
                    passwordField.setText("");
                    titleText.setText("Try again:");
                }
            } catch (DataUnavailableException e) {
                e.printStackTrace();
                showServerError();
            }
        });
        HBox hb = new HBox(popupCancel, popupDone);
        hb.setSpacing(15);
        hb.setAlignment(Pos.CENTER);
        controls.getChildren().add(hb);

        passwordPopup.setContent(controls);
        passwordPopup.show();
    }

    /**
     * Shows a pop-up explaining that the server connection has failed and pre-saved data is being used.
     */
    protected void showServerError() {
        CustomPopupView serverError  = new CustomPopupView(controls);
        Text            errorMessage = new Text("There has been an error connecting to the server. Information has not been updated.");
        errorMessage.wrappingWidthProperty().bind(linesListView.widthProperty().subtract(100));
        // Button to hide popup and reload lines from server
        Button retry = new Button("Okay");
        retry.setOnAction(ev -> serverError.hide());
        VBox popupVB = new VBox(20, errorMessage, retry);
        popupVB.setPadding(new Insets(40, 40, 40, 40));
        popupVB.setAlignment(Pos.TOP_CENTER);
        serverError.setContent(popupVB);
        serverError.show();
    }

    /**
     * Fetches lines from the server, shows popup if it fails
     */
    private void updateLinesList() {
        List<Line>   linesList  = new ArrayList<>();
        List<Animal> animalList = null;

        // Load data from server
        try {
            linesList = LocalDatabase.updateLines();
            animalList = LocalDatabase.updateAnimals();
        } catch (DataUnavailableException | SQLException e) {
            showServerError();
            e.printStackTrace();
        }

        // Add lines to observable list so they are displayed in the ListView
        observableLinesList.clear();
        if (linesList != null) {
            observableLinesList.addAll(linesList);
        }

        // Add animals to list of animals
        EnterDataView.setAnimalList(animalList);

        // Clear search box
        filter.setText("");
    }

    @Override
    protected void updateAppBar(AppBar appBar) {
        appBar.setNavIcon(MaterialDesignIcon.MENU.button(e -> MobileApplication.getInstance().showLayer(App.MENU_LAYER)));
        appBar.setTitleText("Select a line");
        appBar.getActionItems().add(MaterialDesignIcon.UNDO.button(e -> App.getInstance().switchScreen(App.HOME_VIEW)));
        linesListView.getSelectionModel().clearSelection();
        updateLinesList();
    }
}
