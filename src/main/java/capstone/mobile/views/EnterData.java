package capstone.mobile.views;

import capstone.mobile.App;
import capstone.mobile.classes.Line;
import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class EnterData extends View {

    public EnterData(String name) {
        super(name);

        getStylesheets().add(SetUpWalk.class.getResource("secondary.css").toExternalForm());

        HBox   hb1   = new HBox(15.0);
        Button empty = new Button("Empty");
        Button rat   = new Button("Rat");
        hb1.getChildren().addAll(empty, rat);
        hb1.setAlignment(Pos.CENTER);
        HBox   hb2      = new HBox(15.0);
        Button stoat    = new Button("Stoat");
        Button hedgehog = new Button("Hedgehog");
        hb2.getChildren().addAll(stoat, hedgehog);
        hb2.setAlignment(Pos.CENTER);

        Button save = new Button("Done");
        save.setOnAction(e -> returnToWalk());
        save.setGraphic(MaterialDesignIcon.SAVE.graphic());

        Button other = new Button("Other Species");

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

    private void returnToWalk() {
        Line.getNextTrap();
        if (Line.getCurrentTrap() > 2) {
            App.getInstance().switchView(App.END);
        } else {
            App.getInstance().switchView(App.DO_WALK);
        }
    }

    @Override
    protected void updateAppBar(AppBar appBar) {
        appBar.setNavIcon(MaterialDesignIcon.MENU.button(e -> MobileApplication.getInstance().showLayer(App.MENU_LAYER)));
        appBar.setTitleText("TrapData #" + Line.getCurrentTrap());
    }
}
