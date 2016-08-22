package capstone.mobile.views;

import capstone.mobile.App;
import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.control.Icon;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import static java.lang.Boolean.TRUE;

/**
 * Propts user to enter start and end point of walk, using a map interface indicating trap and entry/exit locations
 */
public class SetUpWalk extends View {

    public SetUpWalk(String name) {
        super(name);

        getStylesheets().add(SetUpWalk.class.getResource("secondary.css").toExternalForm());

        Label label = new Label("Enter start point");

        Button button = new Button("Select point on map");
        button.setGraphic(new Icon(MaterialDesignIcon.MAP));
        button.setOnAction(e -> update(label));

        VBox controls = new VBox(15.0, label, button);
        controls.setAlignment(Pos.CENTER);

        setCenter(controls);
    }

    private void update(Label label) {
        System.out.println(label.getText());
        if (label.getText().equals("Enter start point")) {
            label.setText("Enter end point");
        } else {
            App.setWalking(TRUE);
            App.getInstance().switchView(App.DO_WALK);
        }
    }

    @Override
    protected void updateAppBar(AppBar appBar) {
        appBar.setNavIcon(MaterialDesignIcon.MENU.button(e -> MobileApplication.getInstance().showLayer(App.MENU_LAYER)));
        appBar.setTitleText("Set Up");
        appBar.getActionItems().add(MaterialDesignIcon.UNDO.button(e -> App.getInstance().switchToPreviousView()));
    }

}
