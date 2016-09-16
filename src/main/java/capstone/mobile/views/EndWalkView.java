package capstone.mobile.views;


import capstone.mobile.classes.SendData;
import capstone.mobile.classes.Walk;
import com.gluonhq.charm.glisten.mvc.View;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class EndWalkView extends View {

    Walk walk;

    public EndWalkView(String name, Walk walk) {
        super(name);

        this.walk = walk;

        // Add button to mark trap as done
        Button send = new Button("Click to send to server once internet is connected");
        send.setWrapText(true);
        send.setOnAction(e -> {
            SendData.sendCaptureData(walk);
            // TODO: ensure all data is sent (incl. edited/new traps)
            walk.finishWalk();
        });

        VBox controls = new VBox(15.0, send);
        controls.setAlignment(Pos.CENTER);
        setCenter(controls);
    }
}
