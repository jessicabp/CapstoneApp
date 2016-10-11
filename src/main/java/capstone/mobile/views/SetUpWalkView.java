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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

import java.util.List;


public class SetUpWalkView extends View {

    private final static double MAP_HEIGHT = 200;

    private Walk          walk;
    private Trap          startTrap;
    private Trap          endTrap;
    private CustomMapView startMapView;
    private CustomMapView endMapView;
    private PoiLayer      startMarkersLayer;
    private PoiLayer      endMarkersLayer;
    private PoiLayer      startNumbersLayer;
    private PoiLayer      endNumbersLayer;
    private Circle        startCircle;
    private Circle        endCircle;


    public SetUpWalkView(String name, Walk walk) {
        super(name);
        this.walk = walk;

        getStylesheets().add(SetUpWalkView.class.getResource("secondary.css").toExternalForm());

        // Creating the map displays
        startMapView = new CustomMapView(MAP_HEIGHT);
        endMapView = new CustomMapView(MAP_HEIGHT);

        // Creating the map layers on which markers and numbers will be added, note that
        // ORDERING of layers is IMPORTANT for interacting with the map markers.
        startNumbersLayer = startMapView.createLayer();
        endNumbersLayer = endMapView.createLayer();
        startMarkersLayer = startMapView.createLayer();
        endMarkersLayer = endMapView.createLayer();

        // Creating the labels and button
        Label startLabel = new Label();
        startLabel.setText("Select starting trap:");
        Label endLabel = new Label();
        endLabel.setText("Select ending trap:");

        Button startButton = new Button();
        startButton.setText("Start Walk");
        startButton.setOnMouseClicked(e -> {
            if (startTrap != null && endTrap != null) {
                walk.startWalk(startTrap, endTrap);
                App.getInstance().switchScreen(App.DO_WALK_VIEW);
            }
        });
        // Create VBox and add all items
        VBox controls = new VBox(startLabel, startMapView, endLabel, endMapView, startButton);
        // controls.setPadding(new Insets(0, 40, 40, 40));
        controls.setAlignment(Pos.TOP_CENTER);
        setCenter(controls);
    }

    @Override
    protected void updateAppBar(AppBar appBar) {
        appBar.setNavIcon(MaterialDesignIcon.MENU.button(e -> MobileApplication.getInstance().showLayer(App.MENU_LAYER)));
        appBar.setTitleText("Set Up Walk");
        appBar.getActionItems().add(MaterialDesignIcon.UNDO.button(e -> App.getInstance().switchToPreviousView()));

        // Add each trap to the map with listeners
        List<Trap> traps = walk.getLine().getTraps();

        for (Trap trap : traps) {
            MapPoint mapPoint = new MapPoint(trap.getLatitude(), trap.getLongitude());

            Node numberStart = new Text("   " + trap.getNumber());
            Node numberEnd   = new Text("   " + trap.getNumber());

            Circle circleStart = new Circle(7, Color.BLUE);
            circleStart.setOnMouseClicked(e -> {
                if (startCircle == null) {
                    startCircle = circleStart;
                    circleStart.setFill(Color.RED);
                } else {
                    startCircle.setFill(Color.BLUE);
                    startCircle = circleStart;
                    circleStart.setFill(Color.RED);
                }
                startTrap = trap;
            });

            startMapView.addMarker(startMarkersLayer, mapPoint, circleStart);
            startMapView.addMarker(startNumbersLayer, mapPoint, numberStart);

            Circle circleEnd = new Circle(7, Color.BLUE);
            circleEnd.setOnMouseClicked(e -> {
                if (endCircle == null) {
                    endCircle = circleEnd;
                    circleEnd.setFill(Color.RED);
                } else {
                    endCircle.setFill(Color.BLUE);
                    endCircle = circleEnd;
                    circleEnd.setFill(Color.RED);
                }
                endTrap = trap;
            });

            endMapView.addMarker(endMarkersLayer, mapPoint, circleEnd);
            endMapView.addMarker(endNumbersLayer, mapPoint, numberEnd);
        }

        Trap s = traps.get(0);
        startMapView.setCenter(s.getLatitude(), s.getLongitude());

        Trap e = traps.get(traps.size() - 1);
        endMapView.setCenter(e.getLatitude(), e.getLongitude());
    }

}
