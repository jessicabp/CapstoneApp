package capstone.mobile.views;

import capstone.mobile.App;
import capstone.mobile.classes.CustomGridPane;
import capstone.mobile.classes.Trap;
import capstone.mobile.classes.Walk;
import capstone.mobile.maps.CustomMapView;
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


/**
 * View showing user where the next trap is and lets them find or skip it
 * TODO: Display current position
 */
public class DoWalkView extends View {

    private Walk            walk;
    private Label           side;
    private Label           moved;
    private Label           broken;
    private VBox            messages;
    private CustomMapView   mapView;
    private PoiLayer        markersLayer;
    private PoiLayer        numbersLayer;

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
        numbersLayer = mapView.createLayer();

        // Create VBox for messages
        messages = new VBox(15.0, side);
        messages.setAlignment(Pos.CENTER);
        messages.setPadding(new Insets(40, 40, 40, 40));
        setTop(messages);

        // Show buttons to enter data or skip trap
        Button found = new Button("Found");
        found.setMaxWidth(Double.MAX_VALUE);
        found.setOnAction(e -> App.getInstance().switchView(App.ENTER_DATA_VIEW));
        Button skip = new Button("Skip");
        skip.setMaxWidth(Double.MAX_VALUE);
        skip.setOnAction(e -> {
            if (walk.getCurrentTrap() != walk.getFinishTrap()) {
                walk.finishCurrentTrap();
                // Switch to another view and back to refresh data on screen
                App.getInstance().switchView(App.ENTER_DATA_VIEW);
                App.getInstance().switchView(App.DO_WALK_VIEW);
            } else {
                App.getInstance().switchView(App.END_WALK_VIEW);
            }
        });

        // Put buttons in a grid so they fill screen width
        CustomGridPane grid = new CustomGridPane();
        grid.add(found, 0, 0);
        grid.add(skip, 1, 0);

        // Create VBox for map & buttons
        VBox controls = new VBox(mapView, messages, grid);
        controls.setAlignment(Pos.TOP_CENTER);
        // controls.setPadding(new Insets(0, 40, 40, 40));
        setCenter(controls);
    }

    @Override
    protected void updateAppBar(AppBar appBar) {
        appBar.setNavIcon(MaterialDesignIcon.MENU.button(e -> MobileApplication.getInstance().showLayer(App.MENU_LAYER)));
        appBar.setTitleText("Walking: " + walk.getLine().getName());

        // Update message about side of path for trap
        side.setText("Trap indicator on " + (walk.getDirection() == walk.getCurrentTrap().getSide() ? "left" : "right") + " side");

        if (walk.getCurrentTrap().isMoved()) {
            messages.getChildren().add(moved);
        }
        if (walk.getCurrentTrap().isBroken()) {
            messages.getChildren().add(broken);
        }

        Node icon = new Circle(7, Color.BLUE);
        Trap currentTrap = walk.getCurrentTrap();
        MapPoint mapPoint = new MapPoint(currentTrap.getLatitude(), currentTrap.getLongitude());
        markersLayer = mapView.clearMarkers(markersLayer);
        mapView.addMarker(markersLayer, mapPoint, icon);
        //trapsLayer.addPoint(mapPoint, icon);
        mapView.setCenter(currentTrap.getLatitude(), currentTrap.getLongitude());

        // TODO: Remove print statements
        System.out.println("Showing trap #" + walk.getCurrentTrap().getNumber());
        System.out.println("(from DoWalkView ln 109)");
    }

}
