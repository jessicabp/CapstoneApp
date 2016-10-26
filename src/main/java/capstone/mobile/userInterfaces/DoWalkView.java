/*
This file is part of Trap Tracker.

Trap Tracker is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

Trap Tracker is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with Trap Tracker.  If not, see <http://www.gnu.org/licenses/>.
 */

package capstone.mobile.userInterfaces;

import capstone.mobile.App;
import capstone.mobile.models.Trap;
import capstone.mobile.models.Walk;
import capstone.mobile.other.CustomGridPane;
import capstone.mobile.other.CustomMapView;
import capstone.mobile.other.CustomPopupView;
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
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;


/**
 * Displays where the next trap is and the users position. Once found, catch and maintenance data may be created for
 * the trap, or the trap may be skipped.
 */
public class DoWalkView extends View {

    private static CustomMapView mapView;
    private static PoiLayer      markersLayer;
    private        Walk          walk;
    private        Label         side;
    private        Label         moved;
    private        Label         broken;
    private        PoiLayer      currentLayer;
    private        PoiLayer      positionLayer;
    private        Label         waitingMessage;
    private boolean waitingMessageVisible = true;
    private VBox controls;

    public DoWalkView(String name, Walk walk) {
        super(name);
        this.walk = walk;

        getStylesheets().add(DoWalkView.class.getResource("userinterface.css").toExternalForm());

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
        controls = new VBox(15, mapView, waitingMessage, moved, broken, grid);
        controls.getStylesheets().add(DisplayLinesView.class.getResource("linelist.css").toExternalForm());
        controls.getStylesheets().add(DisplayLinesView.class.getResource("userinterface.css").toExternalForm());
        controls.setAlignment(Pos.TOP_CENTER);
        // controls.setPadding(new Insets(0, 40, 40, 40));
        setCenter(controls);

        PositionService positionService = PlatformFactory.getPlatform().getPositionService();
        positionService.positionProperty().addListener((observableValue, oldValue, newValue) -> updateCurrentPosition(newValue));
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
        appBar.getActionItems().add(MaterialDesignIcon.HELP.button(e -> displayLegend()));

        displayTraps();
    }

    /**
     * TODO: Comment
     */
    private void displayTraps() {
        // Update message about side of path for trap
        side.setText("Trap indicator on " + (walk.isDirection() == walk.getCurrentTrap().getSide() ? "left" : "right") + " side");

        moved.setVisible(walk.getCurrentTrap().isMoved());
        broken.setVisible(walk.getCurrentTrap().isBroken());

        markersLayer = mapView.clearMarkers(markersLayer);
        for (Trap trap : walk.getLine().getTraps()) {
            Circle   marker   = new Circle(10, Color.ORANGE);
            MapPoint mapPoint = new MapPoint(trap.getLatitude(), trap.getLongitude());
            mapView.addMarker(markersLayer, mapPoint, marker);
        }

        Node     icon        = new Circle(10, Color.BLUE);
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
        mapView.addMarker(positionLayer, mapPoint, new Circle(7, Color.RED));
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
            // Switch to another view and back to refresh data on screen
            App.getInstance().switchScreen(App.ENTER_DATA_VIEW);
            App.getInstance().switchScreen(App.DO_WALK_VIEW);
        }
    }

    /**
     * Displays a legend pop up.
     */
    private void displayLegend() {
        final double radius  = 14.0;
        final double spacer  = 50.0;
        final double labelsX = 55.0;
        final double labelsY = 55.0;
        final double iconsX  = 30.0;
        final double iconsY  = 50.0;

        // Creating custom pop up
        CustomPopupView legendPopup = new CustomPopupView(controls);

        // Overall layout for pop up
        VBox container = new VBox(20);
        container.setPadding(new Insets(40, 40, 40, 40));
        container.setAlignment(Pos.CENTER);

        // Label at the top
        Label legendLabel    = new Label("Legend");
        HBox  labelContainer = new HBox();
        labelContainer.setAlignment(Pos.CENTER);
        labelContainer.getChildren().addAll(legendLabel);

        // Canvas for displaying icons and description text
        Canvas          legendCanvas    = new Canvas(200, 200);
        GraphicsContext graphicsContext = legendCanvas.getGraphicsContext2D();

        String[] labels  = {"Your Position", "Next Trap Marker", "Other Trap Markers"};
        Color[]  colours = {Color.RED, Color.BLUE, Color.ORANGE};

        for (int i = 0; i < labels.length; i++) {
            graphicsContext.setFill(Color.BLACK);
            graphicsContext.fillText(labels[i], labelsX, labelsY + i * spacer);
            graphicsContext.beginPath();
            graphicsContext.setFill(colours[i]);
            graphicsContext.arc(iconsX, iconsY + i * spacer, radius, radius, 0, 360.0);
            graphicsContext.fill();
        }

        // Button to close pop up
        Button closeButton = new Button("Close");
        closeButton.setOnAction(ev -> {
            legendPopup.hide();
        });

        // Adding all controls for pop up
        container.getChildren().addAll(labelContainer, legendCanvas, closeButton);

        legendPopup.setContent(container);
        legendPopup.show();
    }
}
