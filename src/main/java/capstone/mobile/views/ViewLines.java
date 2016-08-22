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

/**
 * Fetches and displays searchable list of available lines from server
 * Allows user to open line, checks password
 */
public class ViewLines extends View {

    public ViewLines(String name) {
        super(name);

        getStylesheets().add(ViewLines.class.getResource("primary.css").toExternalForm());

        Label label = new Label("Searchable list of lines");

        Button button = new Button("Select a line and enter correct password");
        button.setGraphic(new Icon(MaterialDesignIcon.MAP));
        button.setOnAction(e -> App.getInstance().switchView(App.SET_UP_WALK));

        VBox controls = new VBox(15.0, label, button);
        controls.setAlignment(Pos.CENTER);

        setCenter(controls);
    }

    @Override
    protected void updateAppBar(AppBar appBar) {
        appBar.setNavIcon(MaterialDesignIcon.MENU.button(e -> MobileApplication.getInstance().showLayer(App.MENU_LAYER)));
        appBar.setTitleText("Select a line");
    }

}
