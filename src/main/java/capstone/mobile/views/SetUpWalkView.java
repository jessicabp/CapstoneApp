package capstone.mobile.views;

import capstone.mobile.App;
import capstone.mobile.classes.Trap;
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
 * Prompts user to enter start and end point of walk, using a map interface indicating trap and entry/exit locations
 */
public class SetUpWalkView extends View {

    List<Trap> traps;
    Walk       walk;

    public SetUpWalkView(String name, Walk walk) {
        super(name);

        this.walk = walk;

        getStylesheets().add(SetUpWalkView.class.getResource("secondary.css").toExternalForm());

        // MOCK FUNCTIONALITY - Does nothing
        Label  label  = new Label("Enter start point");
        Button button = new Button("Select point on map");
        button.setGraphic(new Icon(MaterialDesignIcon.MAP));
        button.setOnAction(e -> {
            if (label.getText().equals("Enter start point")) {
                label.setText("Enter end point");
            } else {
                Walk.setWalking(true);
                App.getInstance().switchView(App.DO_WALK_VIEW);
            }
        });

        VBox controls = new VBox(15.0, label, button);
        controls.setAlignment(Pos.CENTER);

        setCenter(controls);
    }

    private void selectStart(Trap trap) {
        walk.setStartTrap(trap);
    }

    private void selectEnd(Trap trap) {
        walk.setFinishTrap(trap);
        if (trap.getNumber() > walk.getStartTrap().getNumber()) {
            walk.setDirection(0);
        } else {
            walk.setDirection(1);
        }
    }

    @Override
    protected void updateAppBar(AppBar appBar) {
        appBar.setNavIcon(MaterialDesignIcon.MENU.button(e -> MobileApplication.getInstance().showLayer(App.MENU_LAYER)));
        appBar.setTitleText("Set Up");
        appBar.getActionItems().add(MaterialDesignIcon.UNDO.button(e -> App.getInstance().switchToPreviousView()));
    }

}