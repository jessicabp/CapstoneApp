package capstone.mobile.views;


import capstone.mobile.App;
import capstone.mobile.classes.Line;
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

public class DoWalk extends View {

    public DoWalk(String name) {
        super(name);

        getStylesheets().add(SetUpWalk.class.getResource("secondary.css").toExternalForm());

        // TODO: This isn't updating when switching back to the view - need to update during runtime??
        Label label = new Label("TrapData indicator on " + Line.getSide(Line.getCurrentTrap()) + " side");

        Icon map = new Icon(MaterialDesignIcon.MAP);

        HBox   hb    = new HBox(15.0);
        Button found = new Button("Found");
        found.setOnAction(e -> App.getInstance().switchView(App.ENTER_DATA));
        Button skip = new Button("Skip");
        skip.setOnAction(e -> nextTrap());
        hb.getChildren().addAll(found, skip);
        hb.setAlignment(Pos.CENTER);

        VBox controls = new VBox(15.0, label, map, hb);
        controls.setAlignment(Pos.CENTER);

        setCenter(controls);
    }

    private void nextTrap() {
        App.getInstance().switchView(App.ENTER_DATA);
        App.getInstance().switchView(App.DO_WALK);
    }

    @Override
    protected void updateAppBar(AppBar appBar) {
        appBar.setNavIcon(MaterialDesignIcon.MENU.button(e -> MobileApplication.getInstance().showLayer(App.MENU_LAYER)));
        appBar.setTitleText("Walk Line");
    }

}
