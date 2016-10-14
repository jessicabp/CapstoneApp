package capstone.mobile.userInterfaces;

import capstone.mobile.App;
import capstone.mobile.models.Trap;
import capstone.mobile.models.Walk;
import capstone.mobile.other.CustomMapView;
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

/**
 * TODO: Comment
 */
public class SetUpWalkView extends View {

    private final static double MAP_HEIGHT             = 200;
    private final static int    TRAP_MARKER_SIZE       = 10;
    private final static Color  TRAP_UNSELECTED_COLOUR = Color.BLUE;
    private final static Color  TRAP_SELECTED_COLOUR   = Color.RED;

    private Walk          walk;
    private CustomMapView startMapView;
    private CustomMapView endMapView;
    private PoiLayer      startMarkersLayer;
    private PoiLayer      endMarkersLayer;
    private PoiLayer      startNumbersLayer;
    private PoiLayer      endNumbersLayer;
    private Circle        selectedStartCircle;
    private Circle        selectedEndCircle;
    private Trap          selectedStartTrap;
    private Trap          selectedEndTrap;


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
        startButton.setOnMouseClicked(e -> startWalk());
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

        renderTraps();
    }


    /**
     * TODO: Comment
     */
    private void renderTraps() {
        List<Trap> traps = walk.getLine().getTraps();
        for (Trap trap : traps) {
            MapPoint mapPoint = new MapPoint(trap.getLatitude(), trap.getLongitude());

            Node numberStart = new Text("   " + trap.getNumber());
            Node numberEnd   = new Text("   " + trap.getNumber());

            Circle circleStart = new Circle(TRAP_MARKER_SIZE, Color.BLUE);
            circleStart.setOnMouseClicked(e -> toggleStartCircle(circleStart, trap));

            startMapView.addMarker(startMarkersLayer, mapPoint, circleStart);
            startMapView.addMarker(startNumbersLayer, mapPoint, numberStart);

            Circle circleEnd = new Circle(TRAP_MARKER_SIZE, Color.BLUE);
            circleEnd.setOnMouseClicked(e -> toggleEndCircle(circleEnd, trap));

            endMapView.addMarker(endMarkersLayer, mapPoint, circleEnd);
            endMapView.addMarker(endNumbersLayer, mapPoint, numberEnd);
        }

        Trap s = traps.get(0);
        startMapView.setCenter(s.getLatitude(), s.getLongitude());

        Trap e = traps.get(traps.size() - 1);
        endMapView.setCenter(e.getLatitude(), e.getLongitude());
    }


    /**
     * TODO: Comment
     */
    private void toggleStartCircle(Circle startCircle, Trap startTrap) {
        if (selectedStartCircle == null) {
            startCircle.setFill(TRAP_SELECTED_COLOUR);
            selectedStartCircle = startCircle;
        } else {
            selectedStartCircle.setFill(TRAP_UNSELECTED_COLOUR);
            startCircle.setFill(TRAP_SELECTED_COLOUR);
            selectedStartCircle = startCircle;
        }
        selectedStartTrap = startTrap;
    }


    /**
     * TODO: Comment
     */
    private void toggleEndCircle(Circle endCircle, Trap endTrap) {
        if (selectedEndCircle == null) {
            endCircle.setFill(TRAP_SELECTED_COLOUR);
            selectedEndCircle = endCircle;
        } else {
            selectedEndCircle.setFill(TRAP_UNSELECTED_COLOUR);
            endCircle.setFill(TRAP_SELECTED_COLOUR);
            selectedEndCircle = endCircle;
        }
        selectedEndTrap = endTrap;
    }


    /**
     * TODO: Comment
     */
    private void startWalk() {
        if (selectedStartTrap != null && selectedEndTrap != null) {
            walk.startWalk(selectedStartTrap, selectedEndTrap);
            App.getInstance().switchScreen(App.DO_WALK_VIEW);
        }
    }

}
