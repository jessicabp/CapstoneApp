package capstone.mobile.views;

import capstone.mobile.App;
import capstone.mobile.classes.Line;
import capstone.mobile.classes.Walk;
import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.control.Icon;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.util.List;

/**
 * Fetches and displays searchable list of available lines from server
 * Allows user to open line, checks password
 */
public class DisplayLinesView extends View {

    private Walk       walk;
    private List<Line> lines;

    public DisplayLinesView(String name, Walk walk) {
        super(name);

        this.walk = walk;

        getStylesheets().add(DisplayLinesView.class.getResource("primary.css").toExternalForm());

        Label label = new Label("Searchable list of lines");

        // TODO: get list of lines from server, create ListView for lines
        Button button = new Button("Select a line and enter correct password");
        button.setGraphic(new Icon(MaterialDesignIcon.MAP));
        button.setOnAction(e -> selectLine(new Line())); // TODO: this should use the line the user has selected and fetch its data from the server

        VBox controls = new VBox(15.0, label, button);
        controls.setAlignment(Pos.CENTER);
        setCenter(controls);
    }

    private void selectLine(Line line) {
        walk.setLine(line);
        App.getInstance().switchView(App.SET_UP_WALK_VIEW);
    }

    @Override
    protected void updateAppBar(AppBar appBar) {
        appBar.setNavIcon(MaterialDesignIcon.MENU.button(e -> MobileApplication.getInstance().showLayer(App.MENU_LAYER)));
        appBar.setTitleText("Select a line");
    }

}
