package capstone.mobile.views;

import capstone.mobile.App;
import capstone.mobile.classes.Walk;
import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


/**
 * View for users to enter data about a trap (e.g. species)
 */
public class EnterDataView extends View {

    Walk walk;

    public EnterDataView(String name, Walk walk) {
        super(name);

        this.walk = walk;

        getStylesheets().add(EnterDataView.class.getResource("secondary.css").toExternalForm());

        // Create species selection buttons
        // TODO: load species from line?
        HBox   hb1   = new HBox(15.0);
        Button empty = new Button("Empty");
        // TODO: complete enterSpecies and update to complete functionality
        empty.setOnAction(e -> walk.getCurrentTrap().enterSpecies());
        Button rat = new Button("Rat");
        // TODO: complete enterSpecies and update to complete functionality
        rat.setOnAction(e -> walk.getCurrentTrap().enterSpecies());
        hb1.getChildren().addAll(empty, rat);
        hb1.setAlignment(Pos.CENTER);
        HBox   hb2   = new HBox(15.0);
        Button stoat = new Button("Stoat");
        // TODO: complete enterSpecies and update to complete functionality
        stoat.setOnAction(e -> walk.getCurrentTrap().enterSpecies());
        Button hedgehog = new Button("Hedgehog");
        // TODO: complete enterSpecies and update to complete functionality
        hedgehog.setOnAction(e -> walk.getCurrentTrap().enterSpecies());
        hb2.getChildren().addAll(stoat, hedgehog);
        hb2.setAlignment(Pos.CENTER);

        // Add button to mark trap as done
        Button save = new Button("Done");
        save.setOnAction(e -> {
            walk.finishCurrentTrap();
            App.getInstance().switchView(App.DO_WALK_VIEW);
        });
        save.setGraphic(MaterialDesignIcon.SAVE.graphic());

        // TODO: add selector for alternate species
        Button other = new Button("Other Species");

        // Add buttons to add image or maintenance info
        HBox   hb3   = new HBox(15.0);
        Button photo = new Button("Photo");
        photo.setOnAction(e -> App.getInstance().switchView(App.CAMERA));
        Button maintenance = new Button("Maintenance");
        maintenance.setOnAction(e -> App.getInstance().switchView(App.MAINTENANCE));
        hb3.getChildren().addAll(photo, maintenance);
        hb3.setAlignment(Pos.CENTER);

        VBox controls = new VBox(15.0, hb1, hb2, save, other, hb3);
        controls.setAlignment(Pos.CENTER);
        setCenter(controls);
    }

    @Override
    protected void updateAppBar(AppBar appBar) {
        appBar.setNavIcon(MaterialDesignIcon.MENU.button(e -> MobileApplication.getInstance().showLayer(App.MENU_LAYER)));
        appBar.setTitleText("TrapData #" + walk.getCurrentTrap().getNumber());
    }
}