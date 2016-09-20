package capstone.mobile.views;


import capstone.mobile.App;
import capstone.mobile.classes.SendData;
import capstone.mobile.classes.Walk;
import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class EndWalkView extends View {

    Walk walk;

    public EndWalkView(String name, Walk walk) {
        super(name);

        this.walk = walk;

        Button send = new Button("Click to send to server once internet is connected");
        send.setWrapText(true);
        send.setOnAction(e -> {
            SendData.sendCaptureData(walk);
            // TODO: ensure all data is sent (incl. edited/new traps) - if all successful, THEN go to next screen
            App.getInstance().switchView(App.DISPLAY_LINES_VIEW);
            walk.finishWalk();
        });

        VBox controls = new VBox(15.0, send);
        controls.setAlignment(Pos.CENTER);
        setCenter(controls);
    }

    @Override
    protected void updateAppBar(AppBar appBar) {
        appBar.setNavIcon(MaterialDesignIcon.MENU.button(e -> MobileApplication.getInstance().showLayer(App.MENU_LAYER)));
        appBar.setTitleText("Finished: " + walk.getLine().getName());
    }
}
