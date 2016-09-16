package capstone.mobile.views;

import capstone.mobile.App;
import capstone.mobile.classes.Capture;
import capstone.mobile.classes.SendData;
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
 * View for users to enter data about a trap (e.g. species)
 */
public class EnterDataView extends View {

    private Walk    walk;
    private Capture capture;

    public EnterDataView(String name, Walk walk) {
        super(name);

        this.walk = walk;

        getStylesheets().add(EnterDataView.class.getResource("secondary.css").toExternalForm());

        // Create species selection buttons
        ToggleGroup group = new ToggleGroup();
        // TODO: load species from line?
        HBox         hb1   = new HBox(15.0);
        ToggleButton empty = new ToggleButton("Empty");
        empty.setToggleGroup(group);
        empty.setOnAction(e -> capture.setSpeciesId(0));
        ToggleButton rat = new ToggleButton("Rat");
        rat.setToggleGroup(group);
        rat.setOnAction(e -> capture.setSpeciesId(1));
        hb1.getChildren().addAll(empty, rat);
        hb1.setAlignment(Pos.CENTER);
        HBox         hb2   = new HBox(15.0);
        ToggleButton stoat = new ToggleButton("Stoat");
        stoat.setToggleGroup(group);
        stoat.setOnAction(e -> capture.setSpeciesId(2));
        ToggleButton hedgehog = new ToggleButton("Hedgehog");
        hedgehog.setToggleGroup(group);
        hedgehog.setOnAction(e -> capture.setSpeciesId(3));
        hb2.getChildren().addAll(stoat, hedgehog);
        hb2.setAlignment(Pos.CENTER);
        ToggleButton other = new ToggleButton("Other");
        other.setToggleGroup(group);
        // TODO: complete other species selector
        other.setOnAction(e -> capture.setSpeciesId(4));

        // Add button to mark trap as done
        Button save = new Button("Done");
        save.setOnAction(e -> {
            if (group.getSelectedToggle() != null) {
                walk.addCapture(capture);
                if (walk.getCurrentTrap() != walk.getFinishTrap()) {
                    walk.finishCurrentTrap();
                    App.getInstance().switchView(App.DO_WALK_VIEW);
                } else {
                    App.getInstance().switchView(App.END_WALK_VIEW);
                }
            } else {
                save.setText("Please select a species");
            }
        });
        save.setGraphic(MaterialDesignIcon.SAVE.graphic());

        // Add buttons to add image or maintenance info
        HBox   hb3   = new HBox(15.0);
        Button photo = new Button("Photo");
        photo.setOnAction(e -> App.getInstance().switchView(App.CAMERA));
        Button maintenance = new Button("Maintenance");
        maintenance.setOnAction(e -> App.getInstance().switchView(App.MAINTENANCE));
        hb3.getChildren().addAll(photo, maintenance);
        hb3.setAlignment(Pos.CENTER);

        VBox controls = new VBox(15.0, hb1, hb2, other, save, hb3);
        controls.setAlignment(Pos.CENTER);
        setCenter(controls);
    }

    @Override
    protected void updateAppBar(AppBar appBar) {
        appBar.setNavIcon(MaterialDesignIcon.MENU.button(e -> MobileApplication.getInstance().showLayer(App.MENU_LAYER)));
        appBar.setTitleText("Trap #" + walk.getCurrentTrap().getNumber());

        capture = new Capture(walk.getCurrentTrap().getId());
    }
}