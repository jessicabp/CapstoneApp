package capstone.mobile.views;

import capstone.mobile.App;
import capstone.mobile.classes.Walk;
import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


/**
 * View used to enter optional maintenance data for the current trap
 */
public class EnterMaintenance extends View {

    private Walk walk;

    public EnterMaintenance(String name, Walk walk) {
        super(name);

        this.walk = walk;

        getStylesheets().add(EnterMaintenance.class.getResource("secondary.css").toExternalForm());
    }

    @Override
    protected void updateAppBar(AppBar appBar) {
        appBar.setNavIcon(MaterialDesignIcon.MENU.button(e -> MobileApplication.getInstance().showLayer(App.MENU_LAYER)));
        appBar.setTitleText("Maintenance");
        appBar.getActionItems().add(MaterialDesignIcon.UNDO.button(e -> App.getInstance().switchToPreviousView()));

        // buttons for damage
        ToggleGroup damage = new ToggleGroup();
        ToggleButton broken = new ToggleButton("Broken");
        broken.setSelected(walk.getCurrentTrap().isBroken());
        broken.setOnAction(e -> walk.getCurrentTrap().setBroken(broken.isSelected()));
        broken.setToggleGroup(damage);
        ToggleButton fixed = new ToggleButton("Fixed");
        fixed.setSelected(!walk.getCurrentTrap().isBroken());
        fixed.setOnAction(e -> walk.getCurrentTrap().setBroken(fixed.isSelected()));
        fixed.setToggleGroup(damage);
        HBox damageHB = new HBox(15, broken, fixed);
        damageHB.setAlignment(Pos.CENTER);

        // button for moved trap
        ToggleButton moved = new ToggleButton("Moved");
        moved.setSelected(walk.getCurrentTrap().isMoved());
        moved.setOnAction(e -> walk.getCurrentTrap().setMoved(moved.isSelected()));

        // button to save
        Button save = new Button("Done");
        save.setOnAction(e -> {
            if (broken.isSelected() != walk.getCurrentTrap().isBroken() || moved.isSelected() != walk.getCurrentTrap().isMoved()) {
                walk.addChangedTrap(walk.getCurrentTrap());
            }
            App.getInstance().switchView(App.ENTER_DATA_VIEW);
        });
        save.setGraphic(MaterialDesignIcon.SAVE.graphic());

        VBox controls = new VBox(15.0, damageHB, moved, save);
        controls.setAlignment(Pos.CENTER);
        setCenter(controls);
    }
}
