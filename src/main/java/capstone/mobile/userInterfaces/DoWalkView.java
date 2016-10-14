package capstone.mobile.userInterfaces;

import capstone.mobile.App;
import capstone.mobile.models.Trap;
import capstone.mobile.models.Walk;
import capstone.mobile.other.CustomGridPane;
import capstone.mobile.other.CustomMapView;
import com.gluonhq.charm.down.common.PlatformFactory;
import com.gluonhq.charm.down.common.Position;
import com.gluonhq.charm.down.common.PositionService;
import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import gluonhq.maps.MapPoint;
import gluonhq.maps.PoiLayer;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.List;


/**
 * Displays where the next trap is and the users position. Once found, capture and maintenance data may be created for
 * the trap, or the trap may be skipped.
 */
public class DoWalkView extends View {

    private static CustomMapView mapView;
    private static PoiLayer      markersLayer;
    private        Walk          walk;
    private        Label         side;
    private        Label         moved;
    private        Label         broken;
    private        VBox          messages;
    private        PoiLayer      currentLayer;
    private        PoiLayer      positionLayer;
    private        Label         waitingMessage;
    private boolean waitingMessageVisible = true;

    public DoWalkView(String name, Walk walk) {
        super(name);
        this.walk = walk;

        getStylesheets().add(DoWalkView.class.getResource("secondary.css").toExternalForm());

        // Create labels with side of path and maintenance info
        side = new Label("text updated when user changes to this view");
        side.setWrapText(true);
        moved = new Label("Warning: this trap has been marked as moved.");
        moved.setWrapText(true);
        broken = new Label("Warning: this trap has been marked as broken.");
        broken.setWrapText(true);

        // Creating map with position and trap marker layers
        mapView = new CustomMapView();
        markersLayer = mapView.createLayer();
        currentLayer = mapView.createLayer();
        positionLayer = mapView.createLayer();

        // Create VBox for messages
        messages = new VBox(15.0, side);
        messages.setAlignment(Pos.CENTER);
        messages.setPadding(new Insets(40, 40, 40, 40));
        setTop(messages);

        // Show buttons to enter data or skip trap
        Button found = new Button("Found");
        found.setMaxWidth(Double.MAX_VALUE);
        found.setOnAction(e -> App.getInstance().switchScreen(App.ENTER_DATA_VIEW));

        Button skip = new Button("Skip");
        skip.setMaxWidth(Double.MAX_VALUE);
        skip.setOnAction(e -> skipCurrentTrap());

        // Put buttons in a grid so they fill screen width
        CustomGridPane grid = new CustomGridPane(2);
        grid.add(found, 0, 0);
        grid.add(skip, 1, 0);

        // Create waiting message to be displayed until the current position
        // can be obtained from the GPS.
        waitingMessage = new Label();
        waitingMessage.setStyle("-fx-text-fill: red;");
        waitingMessage.setText("Waiting on GPS for position..");

        // Create VBox for map & buttons
        VBox controls = new VBox(mapView, waitingMessage, messages, grid);
        controls.setAlignment(Pos.TOP_CENTER);
        // controls.setPadding(new Insets(0, 40, 40, 40));
        setCenter(controls);

        List<Trap> traps = walk.getLine().getTraps();
        for (Trap trap : traps) {
            Circle   marker   = new Circle(5, Color.ORANGE);
            MapPoint mapPoint = new MapPoint(trap.getLatitude(), trap.getLongitude());
            mapView.addMarker(markersLayer, mapPoint, marker);
        }

        PositionService positionService = PlatformFactory.getPlatform().getPositionService();
        positionService.positionProperty().addListener((observableValue, oldValue, newValue) ->
                                                               updateCurrentPosition(newValue)
                                                      );
    }

    // TODO: provide utility method to give same results
    public static CustomMapView getMapView() {
        return mapView;
    }

    public static PoiLayer getMarkersLayer() {
        return markersLayer;
    }

    @Override
    protected void updateAppBar(AppBar appBar) {
        appBar.setNavIcon(MaterialDesignIcon.MENU.button(e -> MobileApplication.getInstance().showLayer(App.MENU_LAYER)));
        appBar.setTitleText("Trap " + walk.getCurrentTrap().getNumber() + " - " + walk.getLine().getName());

        displayCurrentTrap();
    }

    /**
     * TODO: Comment
     */
    private void displayCurrentTrap() {
        // Update message about side of path for trap
        side.setText("Trap indicator on " + (walk.isDirection() == walk.getCurrentTrap().getSide() ? "left" : "right") + " side");

        if (walk.getCurrentTrap().isMoved()) {
            messages.getChildren().add(moved);
        }
        if (walk.getCurrentTrap().isBroken()) {
            messages.getChildren().add(broken);
        }

        Node     icon        = new Circle(7, Color.BLUE);
        Trap     currentTrap = walk.getCurrentTrap();
        MapPoint mapPoint    = new MapPoint(currentTrap.getLatitude(), currentTrap.getLongitude());
        currentLayer = mapView.clearMarkers(currentLayer);
        mapView.addMarker(currentLayer, mapPoint, icon);
    }

    /**
     * TODO: Comment
     *
     * @param position
     */
    private void updateCurrentPosition(Position position) {
        if (waitingMessageVisible) {
            waitingMessageVisible = false;
            waitingMessage.setVisible(false);
            waitingMessage.setManaged(false);
        }
        positionLayer = mapView.clearMarkers(positionLayer);
        MapPoint mapPoint = new MapPoint(position.getLatitude(), position.getLongitude());
        mapView.addMarker(positionLayer, mapPoint, new Circle(5, Color.GREEN));
        mapView.setCenter(position.getLatitude(), position.getLongitude());
    }

    /**
     * TODO: Comment
     */
    private void skipCurrentTrap() {
        if (walk.getCurrentTrap().equals(walk.getEndTrap())) {
            App.getInstance().switchScreen(App.END_WALK_VIEW);
        } else {
            walk.endCurrentTrap();
            // TODO: fix refreshing
            // Switch to another view and back to refresh data on screen
            App.getInstance().switchScreen(App.ENTER_DATA_VIEW);
            App.getInstance().switchScreen(App.DO_WALK_VIEW);
        }
    }
}
