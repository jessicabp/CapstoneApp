package capstone.mobile.views;

import capstone.mobile.App;
import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;


public class EnterMaintenance extends View {

    public EnterMaintenance(String name) {
        super(name);

        getStylesheets().add(SetUpWalk.class.getResource("secondary.css").toExternalForm());

        Button damaged = new Button("Damaged");

        Button moved = new Button("Moved");

        Button save = new Button("Done");
        save.setOnAction(e -> App.getInstance().switchView(App.ENTER_DATA));
        save.setGraphic(MaterialDesignIcon.SAVE.graphic());

        VBox controls = new VBox(15.0, damaged, moved, save);
        controls.setAlignment(Pos.CENTER);

        setCenter(controls);
    }

    @Override
    protected void updateAppBar(AppBar appBar) {
        appBar.setNavIcon(MaterialDesignIcon.MENU.button(e -> MobileApplication.getInstance().showLayer(App.MENU_LAYER)));
        appBar.setTitleText("Maintenance");
        appBar.getActionItems().add(MaterialDesignIcon.UNDO.button(e -> App.getInstance().switchToPreviousView()));
    }
}
