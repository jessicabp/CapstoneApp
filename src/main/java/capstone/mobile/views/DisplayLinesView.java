package capstone.mobile.views;

import capstone.mobile.App;
import capstone.mobile.classes.DataUnavailableException;
import capstone.mobile.classes.Line;
import capstone.mobile.classes.RetrieveData;
import capstone.mobile.classes.Walk;
import com.gluonhq.charm.glisten.application.GlassPane;
import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.layout.layer.PopupView;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import com.gluonhq.connect.GluonObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.util.List;

/**
 * Fetches and displays searchable list of available lines from server
 * Allows user to open line, checks password
 */
public class DisplayLinesView extends View {

    private Walk walk;
    private VBox controls;
    private TextField                 filter              = new TextField();
    private ListView<Line>            linesListView       = new ListView<>();
    private GluonObservableList<Line> observableLinesList = new GluonObservableList<>();

    public DisplayLinesView(String name, Walk walk) {
        super(name);
        this.walk = walk;

        getStylesheets().add(DisplayLinesView.class.getResource("secondary.css").toExternalForm());

        // Create VBox to hold items
        controls = new VBox();
        controls.setAlignment(Pos.CENTER);
        setTop(controls);

        // Get lines from server
        updateLinesList();

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
        linesListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                Line line = newValue;
                selectLine(line);
            }
        });

        // Add items to VBox
        controls.getChildren().addAll(filter, linesListView);
    }

    /**
     * Set's the walk's line to the given line, switches to SetUpWalkView
     *
     * @param line
     */
    public void selectLine(Line line) {
        try {
            walk.setLine(line);
        } catch (DataUnavailableException e) {
            showServerError();
            e.printStackTrace();
        }
        App.getInstance().switchView(App.SET_UP_WALK_VIEW);
    }

    /**
     * Shows a pop-up explaining that the server connection has failed. Will reload line list when closed.
     */
    private void showServerError() {
        PopupView serverError  = new PopupView(controls);
        Text      errorMessage = new Text("There has been an error connecting to the server. Please retry."); // TODO: text not wrapping
//        errorMessage.setWrapText(true);
        errorMessage.wrappingWidthProperty().bind(linesListView.widthProperty().subtract(100));
        // Button to hide popup and reload lines from server
        Button retry = new Button("Retry");
        retry.setOnAction(ev -> {
            serverError.hide();
            App.getInstance().getGlassPane().setBackgroundFade(0);
            updateLinesList();
        });
        VBox popupVB = new VBox(20, errorMessage, retry);
        popupVB.setPadding(new Insets(40, 40, 40, 40));
        popupVB.setAlignment(Pos.TOP_CENTER);
        serverError.setContent(popupVB);
        serverError.show();
        App.getInstance().getGlassPane().setBackgroundFade(GlassPane.DEFAULT_BACKGROUND_FADE_LEVEL);
    }

    /**
     * Fetches lines from the server, shows popup if it fails
     */
    private void updateLinesList() {
        List<Line> linesList = null;
        try {
            linesList = RetrieveData.fetchLinesList();
        } catch (DataUnavailableException e) {
            showServerError();
            e.printStackTrace();
        }

        // Add lines to observable list so they are displayed in the ListView
        observableLinesList.clear();
        if (linesList != null) {
            observableLinesList.addAll(linesList);
        }

        // Clear search box
        filter.setText("");
    }

    @Override
    protected void updateAppBar(AppBar appBar) {
        appBar.setNavIcon(MaterialDesignIcon.MENU.button(e -> MobileApplication.getInstance().showLayer(App.MENU_LAYER)));
        appBar.setTitleText("Select a line");
        appBar.getActionItems().add(MaterialDesignIcon.UNDO.button(e -> App.getInstance().switchToPreviousView()));
        linesListView.getSelectionModel().clearSelection();
        updateLinesList();
    }

}
