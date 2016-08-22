package capstone.mobile.views;

import capstone.mobile.App;
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
public class AddTrap extends View {

    public AddTrap(String name) {
        super(name);

        getStylesheets().add(SetUpWalk.class.getResource("secondary.css").toExternalForm());

        Label label = new Label("Enter GPS location on map");

        Button button = new Button("Select point on map, enter ID & side of track");
        button.setGraphic(new Icon(MaterialDesignIcon.MAP));
        button.setOnAction(e -> App.getInstance().switchView(App.DO_WALK));

        VBox controls = new VBox(15.0, label, button);
        controls.setAlignment(Pos.CENTER);

        setCenter(controls);
    }

    @Override
    protected void updateAppBar(AppBar appBar) {
        appBar.setNavIcon(MaterialDesignIcon.MENU.button(e -> MobileApplication.getInstance().showLayer(App.MENU_LAYER)));
        appBar.setTitleText("Set Up");
        appBar.getActionItems().add(MaterialDesignIcon.UNDO.button(e -> App.getInstance().switchToPreviousView()));
    }
}
