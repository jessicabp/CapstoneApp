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
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


/**
 * View showing user where the next trap is and lets them find or skip it
 */
public class DoWalkView extends View {

    Walk  walk;
    Label label;

    public DoWalkView(String name, Walk walk) {
        super(name);

        this.walk = walk;

        getStylesheets().add(DoWalkView.class.getResource("secondary.css").toExternalForm());

        // TODO: show map with users location
        Icon map = new Icon(MaterialDesignIcon.MAP);

        // Show buttons to enter data or skip trap
        HBox   hb    = new HBox(15.0);
        Button found = new Button("Found");
        found.setOnAction(e -> App.getInstance().switchView(App.ENTER_DATA_VIEW));
        Button skip = new Button("Skip");
        skip.setOnAction(e -> {
            walk.getCurrentTrap().setSkipped(true);
            walk.finishCurrentTrap();
        });
        hb.getChildren().addAll(found, skip);
        hb.setAlignment(Pos.CENTER);

        VBox controls = new VBox(15.0, label, map, hb);
        controls.setAlignment(Pos.CENTER);
        setCenter(controls);
    }

    @Override
    protected void updateAppBar(AppBar appBar) {
        appBar.setNavIcon(MaterialDesignIcon.MENU.button(e -> MobileApplication.getInstance().showLayer(App.MENU_LAYER)));
        appBar.setTitleText(walk.getLine().getName());

        label = new Label("Trap indicator on " + (walk.getDirection() == walk.getCurrentTrap().getSide() ? "left" : "right") + " side");

    }

}
