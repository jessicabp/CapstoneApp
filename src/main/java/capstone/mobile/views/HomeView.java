package capstone.mobile.views;


import capstone.mobile.App;
import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class HomeView extends View {

    public HomeView(String name) {
        super(name);

        getStylesheets().add(DisplayLinesView.class.getResource("primary.css").toExternalForm());

        // Create VBox to hold items
        VBox controls = new VBox();
        controls.setPadding(new Insets(40));
        controls.setSpacing(40);
        controls.setAlignment(Pos.CENTER);
        setCenter(controls);

        // Button to view lines
        Button lines = new Button("Select an existing line");
        lines.setMaxWidth(Double.MAX_VALUE);
        lines.setOnAction(e -> App.getInstance().switchView(App.DISPLAY_LINES_VIEW));
        controls.getChildren().add(lines);

        // Button to create line
        Button create = new Button("Create a new line");
        create.setMaxWidth(Double.MAX_VALUE);
        create.setOnAction(e -> App.getInstance().switchView(App.ENTER_DATA_VIEW));
        controls.getChildren().add(create);

    }

    @Override
    protected void updateAppBar(AppBar appBar) {
        appBar.setNavIcon(MaterialDesignIcon.MENU.button(e -> MobileApplication.getInstance().showLayer(App.MENU_LAYER)));
        appBar.setTitleText("Home");
    }
}
