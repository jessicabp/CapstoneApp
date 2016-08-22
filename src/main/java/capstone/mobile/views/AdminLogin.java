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


public class AdminLogin extends View {

    public AdminLogin(String name) {
        super(name);

        getStylesheets().add(SetUpWalk.class.getResource("secondary.css").toExternalForm());

        Label label = new Label("Administrator login");

        Button button = new Button("Enter valid administrator details (will be saved for session)");
        button.setWrapText(TRUE);
        button.setGraphic(new Icon(MaterialDesignIcon.LOCK_OPEN));
        button.setOnAction(e -> getNextPage());

        VBox controls = new VBox(15.0, label, button);
        controls.setAlignment(Pos.CENTER);

        setCenter(controls);
    }

    private void getNextPage() {
        if (App.getAddLine()) {
            App.getInstance().switchView(App.ADD_LINE);
        } else {
            App.getInstance().switchView(App.ADD_TRAP);
        }
    }

    @Override
    protected void updateAppBar(AppBar appBar) {
        appBar.setNavIcon(MaterialDesignIcon.MENU.button(e -> MobileApplication.getInstance().showLayer(App.MENU_LAYER)));
        appBar.setTitleText("Set Up");
        appBar.getActionItems().add(MaterialDesignIcon.UNDO.button(e -> App.getInstance().switchToPreviousView()));
    }
}
