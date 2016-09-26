package capstone.mobile.views;

import capstone.mobile.App;
import capstone.mobile.classes.Trap;
import capstone.mobile.classes.Walk;
import capstone.mobile.maps.CustomMapView;
import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import gluonhq.maps.MapPoint;
import gluonhq.maps.PoiLayer;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import java.util.List;


public class SetUpWalkView extends View {

    private Walk            walk;
    private Trap            start;
    private Trap            end;
    private Label           prompt;
    private CustomMapView   mapView;
    private PoiLayer        markersLayer;
    private PoiLayer        numbersLayer;

    public SetUpWalkView(String name, Walk walk) {
        super(name);
        this.walk = walk;

        getStylesheets().add(SetUpWalkView.class.getResource("secondary.css").toExternalForm());

        // Create label to prompt user
        prompt = new Label("Please pick a start point");

        // Creating the map display
        mapView = new CustomMapView();

        // Creating the map layers on which markers and numbers will be added, note that
        // ORDERING of layers is IMPORTANT for interacting with the map markers.
        numbersLayer = mapView.createLayer();
        markersLayer = mapView.createLayer();

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
        // markersLayer.clear();

        // Add each trap to the map with listeners
        List<Trap> traps = walk.getLine().getTraps();

        // TODO: Replace circle with image markers
        for (Trap trap : traps) {
            MapPoint mapPoint = new MapPoint(trap.getLatitude(), trap.getLongitude());

            Circle circle = new Circle(7, Color.BLUE);
            circle.setOnMouseClicked(e -> {
                circle.setFill(Color.RED);
                if (prompt.getText().equals("Please pick a start point")) {
                    prompt.setText("Please pick a end point");
                    start = trap;
                } else {
                    end = trap;
                    walk.startWalk(start, end);
                    App.getInstance().switchView(App.DO_WALK_VIEW);
                }
            });

            Node number = new Text("   " + trap.getNumber());

            mapView.addMarker(markersLayer, mapPoint, circle);
            mapView.addMarker(numbersLayer, mapPoint, number);
        }

        // TODO: Correct map placement and zoom based on positions of the traps
        Trap trap = walk.getLine().getTraps().get(0);
        mapView.setCenter(trap.getLatitude(), trap.getLongitude());
    }

}
