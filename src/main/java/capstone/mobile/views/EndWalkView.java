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

        // Add button to manually send data to server and finish walk
        Button send = new Button("Click to send to server once internet is connected");
        send.setWrapText(true);
        send.setOnAction(e -> { sendData();
            App.getInstance().switchView(App.HOME_VIEW);
        });

        VBox controls = new VBox(15.0, send);
        controls.setAlignment(Pos.CENTER);
        setCenter(controls);
    }

    private void sendData() {
        SendData.sendCaptureData(walk);
        // TODO: ensure all data is sent (incl. edited/new traps - SO ADD METHOD TO SEND TRAPS/NEW LINE) - if all successful, THEN end walk and go to home screen
        walk.finishWalk();
    }

    @Override
    protected void updateAppBar(AppBar appBar) {
        appBar.setNavIcon(MaterialDesignIcon.MENU.button(e -> MobileApplication.getInstance().showLayer(App.MENU_LAYER)));
        appBar.setTitleText("Finished: " + walk.getLine().getName());
    }
}
