package capstone.mobile.views;

import capstone.mobile.App;
import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import static java.lang.Boolean.TRUE;


public class End extends View {

    public End(String name) {
        super(name);

        getStylesheets().add(SetUpWalk.class.getResource("secondary.css").toExternalForm());

        Label label = new Label("Thanks for completing the line! Please don't quit the app until the data has been sent");
        label.setWrapText(TRUE);
        Button exit = new Button("Go to home");
        exit.setOnAction(e -> App.getInstance().switchView(App.VIEW_LINES));

        VBox controls = new VBox(15.0, label, exit);
        controls.setAlignment(Pos.CENTER);

        setCenter(controls);
    }

    @Override
    protected void updateAppBar(AppBar appBar) {
        appBar.setNavIcon(MaterialDesignIcon.MENU.button(e -> MobileApplication.getInstance().showLayer(App.MENU_LAYER)));
        appBar.setTitleText("End of Line");
    }
}
