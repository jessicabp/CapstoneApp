package capstone.mobile.views;

import capstone.mobile.App;
import capstone.mobile.classes.DataUnavailableException;
import capstone.mobile.classes.Line;
import capstone.mobile.classes.ListDataSource;
import capstone.mobile.classes.Walk;
import com.gluonhq.charm.glisten.application.GlassPane;
import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.control.Icon;
import com.gluonhq.charm.glisten.layout.layer.PopupView;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import com.gluonhq.connect.GluonObservableList;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.util.List;

/**
 * Fetches and displays searchable list of available lines from server
 * Allows user to open line, checks password
 */
public class DisplayLinesView extends View {

    private Walk walk;
    private ListView<Line> linesListView = new ListView<>();

    public DisplayLinesView(String name, Walk walk) {
        super(name);

        this.walk = walk;

        getStylesheets().add(DisplayLinesView.class.getResource("primary.css").toExternalForm());

        VBox controls = new VBox();
        controls.setAlignment(Pos.CENTER);
        setCenter(controls);

        try {
            List<Line> linesList = ListDataSource.fetchLinesList();

            GluonObservableList<Line> observableLinesList = new GluonObservableList<>();
            if (linesList != null) {
                observableLinesList.addAll(linesList);
            }

            linesListView = new ListView<>(observableLinesList);
            linesListView.setCellFactory(lv -> new ListCell<Line>() {

                @Override
                protected void updateItem(Line line, boolean empty) {
                    super.updateItem(line, empty);
                    if (!empty) {
                        setText(line.getName());
                    } else {
                        setText(null);
                    }
                }
            });

            linesListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
                if (newValue != null) {
                    Line line = newValue;
                    try {
                        selectLine(line);
                    } catch (DataUnavailableException e) {
                        showServerError(controls);
                        e.printStackTrace();
                    }
                }
            });
            controls.getChildren().add(linesListView);
        } catch (DataUnavailableException ex) {
            showServerError(controls);
            ex.printStackTrace();
        }
    }

    public void selectLine(Line line) throws DataUnavailableException {
        walk.setLine(line);
        App.getInstance().switchView(App.SET_UP_WALK_VIEW);
    }

    private void showServerError(Node node) {
        PopupView serverError = new PopupView(node);
        Label errorMessage = new Label("There has been an error connecting to the server. Please retry."); // TODO: text not wrapping
        errorMessage.setWrapText(true);
        Button okay = new Button("Okay");
        okay.setOnAction(ev -> {
            serverError.hide();
            App.getInstance().getGlassPane().setBackgroundFade(0);
        });
        VBox popupVB = new VBox(20, errorMessage, okay);
        popupVB.setPadding(new Insets(40, 40, 40, 40));
        popupVB.setAlignment(Pos.TOP_CENTER);
        serverError.setContent(popupVB);
        serverError.show();
        App.getInstance().getGlassPane().setBackgroundFade(GlassPane.DEFAULT_BACKGROUND_FADE_LEVEL);
    }

    @Override
    protected void updateAppBar(AppBar appBar) {
        appBar.setNavIcon(MaterialDesignIcon.MENU.button(e -> MobileApplication.getInstance().showLayer(App.MENU_LAYER)));
        appBar.setTitleText("Select a line");
        linesListView.getSelectionModel().clearSelection();
    }

}
