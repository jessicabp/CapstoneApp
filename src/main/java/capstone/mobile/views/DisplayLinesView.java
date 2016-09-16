package capstone.mobile.views;

import capstone.mobile.App;
import capstone.mobile.classes.Line;
import capstone.mobile.classes.ListDataSource;
import capstone.mobile.classes.Walk;
import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.control.Icon;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import com.gluonhq.connect.GluonObservableList;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;

import java.util.List;

/**
 * Fetches and displays searchable list of available lines from server
 * Allows user to open line, checks password
 */
public class DisplayLinesView extends View {

    private Walk       walk;

    public DisplayLinesView(String name, Walk walk) {
        super(name);

        this.walk = walk;

        getStylesheets().add(DisplayLinesView.class.getResource("primary.css").toExternalForm());

        List<Line> linesList = ListDataSource.fetchLinesList();

        GluonObservableList<Line> observableLinesList = new GluonObservableList<>();
        if(linesList != null) {
            observableLinesList.addAll(linesList);
        }
        observableLinesList.add(new Line("Gorge")); // TODO: remove

        ListView<Line> linesListView = new ListView<>(observableLinesList);
        linesListView.setCellFactory(lv -> new ListCell<Line>() {

            @Override
            protected void updateItem(Line line, boolean empty) {
                super.updateItem(line, empty);
                if(!empty) {
                    setText(line.getName());
                } else {
                    setText(null);
                }
            }
        });

        linesListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Line>() {
            @Override
            public void changed(ObservableValue<? extends Line> observable, Line oldValue, Line newValue) {
                Line line = (Line) newValue;
                linesListView.getSelectionModel().clearSelection(); //TODO: throws error
                selectLine(line);
            }
        });

        VBox controls = new VBox(15.0, linesListView);
        controls.setAlignment(Pos.CENTER);
        setCenter(controls);
    }

    public void selectLine(Line line) {
        walk.setLine(line);
        // TODO: show loading screen?
        App.getInstance().switchView(App.SET_UP_WALK_VIEW);
    }

    @Override
    protected void updateAppBar(AppBar appBar) {
        appBar.setNavIcon(MaterialDesignIcon.MENU.button(e -> MobileApplication.getInstance().showLayer(App.MENU_LAYER)));
        appBar.setTitleText("Select a line");
    }

}
