package capstone.mobile.views;

import capstone.mobile.App;
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


/**
 * Adds a trap to the line a user is currently in - trap needs reference to line ID
 */
public class CreateTrapView extends View {

    Walk walk;

    public CreateTrapView(String name, Walk walk) {
        super(name);

        this.walk = walk;

        getStylesheets().add(CreateTrapView.class.getResource("secondary.css").toExternalForm());

        Label label = new Label("Enter GPS location on map");

        Button button = new Button("Select point on map, enter ID & side of track");
        button.setGraphic(new Icon(MaterialDesignIcon.MAP));
        button.setOnAction(e -> createTrap(1)); // TODO: implement to input data incl. trap number

        VBox controls = new VBox(15.0, label, button);
        controls.setAlignment(Pos.CENTER);
        setCenter(controls);
    }

    private void createTrap(int num) {
        // TODO: create createTrap functionality
        App.getInstance().switchView(App.DO_WALK_VIEW);
    }

    @Override
    protected void updateAppBar(AppBar appBar) {
        appBar.setNavIcon(MaterialDesignIcon.MENU.button(e -> MobileApplication.getInstance().showLayer(App.MENU_LAYER)));
        appBar.setTitleText("Set Up");
        appBar.getActionItems().add(MaterialDesignIcon.UNDO.button(e -> App.getInstance().switchToPreviousView()));
    }
}
