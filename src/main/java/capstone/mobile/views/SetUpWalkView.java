package capstone.mobile.views;

import capstone.mobile.App;
import capstone.mobile.classes.Trap;
import capstone.mobile.classes.Walk;
import capstone.mobile.maps.CustomMapView;
import capstone.mobile.maps.CustomPoiLayer;
import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import gluonhq.maps.MapPoint;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import java.util.List;


public class SetUpWalkView extends View {

    private Walk            walk;
    private Trap            start;
    private Trap            end;
    private Label           prompt;
    private CustomMapView   mapView;
    private CustomPoiLayer  poiLayer;

    public SetUpWalkView(String name, Walk walk) {
        super(name);
        this.walk = walk;

        getStylesheets().add(SetUpWalkView.class.getResource("secondary.css").toExternalForm());

        // Create label to prompt user
        prompt = new Label("Please pick a start point");

        // Creating the map display
        mapView = new CustomMapView();

        // Creating the map layer on which markers will be added
        poiLayer = new CustomPoiLayer();
        mapView.addLayer(poiLayer);

        // Create VBox and add all items
        VBox controls = new VBox(mapView, prompt);
        // controls.setPadding(new Insets(0, 40, 40, 40));
        controls.setAlignment(Pos.TOP_CENTER);
        setCenter(controls);
    }

    @Override
    protected void updateAppBar(AppBar appBar) {
        appBar.setNavIcon(MaterialDesignIcon.MENU.button(e -> MobileApplication.getInstance().showLayer(App.MENU_LAYER)));
        appBar.setTitleText("Set Up Walk");
        appBar.getActionItems().add(MaterialDesignIcon.UNDO.button(e -> App.getInstance().switchToPreviousView()));

        // Update prompt text
        prompt.setText("Please pick a start point");

        // Clear the map layer to remove any existing points
        poiLayer.clear();

        // Add each trap to the map with listeners
        List<Trap> traps = walk.getLine().getTraps();

        for (Trap trap : traps) {
            Node icon = new Circle(7, Color.BLUE);
            icon.setOnMouseClicked(e -> {
                if (prompt.getText().equals("Please pick a start point")) {
                    prompt.setText("Please pick a end point");
                    start = trap;
                } else {
                    end = trap;
                    walk.startWalk(start, end);
                    App.getInstance().switchView(App.DO_WALK_VIEW);
                }
            });
            poiLayer.addPoint(new MapPoint(trap.getLatitude(), trap.getLongitude()), icon);
        }

        // TODO: Correct map placement and zoom based on positions of the traps
        Trap trap = walk.getLine().getTraps().get(0);
        mapView.setCenter(trap.getLatitude(), trap.getLongitude());
    }

}
