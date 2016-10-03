package capstone.mobile.views;

import capstone.mobile.App;
import capstone.mobile.classes.*;
import capstone.mobile.maps.CustomMapView;
import com.gluonhq.charm.down.common.PlatformFactory;
import com.gluonhq.charm.down.common.Position;
import com.gluonhq.charm.down.common.PositionService;
import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.control.TextField;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import gluonhq.maps.MapPoint;
import gluonhq.maps.PoiLayer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import java.util.List;


/**
 * Adds a trap to the line a user is currently in - trap needs reference to line ID
 */
public class CreateTrapView extends View {

    private Walk          walk;
    private CustomMapView mapView;
    private PoiLayer      currentLayer;
    private PoiLayer      markersLayer;
    private PoiLayer      numbersLayer;
    private PoiLayer      positionLayer;
    private double        longitude;
    private double        latitude;
    private ToggleGroup   sideGroup;
    private ToggleGroup   locationGroup;
    private Position      currentPosition;

    public CreateTrapView(String name, Walk walk) {
        super(name);
        this.walk = walk;

        getStylesheets().add(CreateTrapView.class.getResource("secondary.css").toExternalForm());

        // Create layout for buttons with correct spacing
        VBox controls = new VBox();
        controls.setAlignment(Pos.TOP_CENTER);
        setCenter(controls);

        // Creating map with position and trap marker layers
        mapView = new CustomMapView();
        markersLayer = mapView.createLayer();
        currentLayer = mapView.createLayer();
        numbersLayer = mapView.createLayer();
        positionLayer = mapView.createLayer();
        VBox mapVB = new VBox(mapView);
        mapVB.setPadding(new Insets(15, 0, 15, 0));
        controls.getChildren().add(mapVB);

        // Create listview so user can scroll through items if there are too many
        ListView<VBox>       content = new ListView<>();
        ObservableList<VBox> items   = FXCollections.observableArrayList();
        content.setItems(items);
        controls.getChildren().add(content);

        // Show buttons to set location
        locationGroup = new ToggleGroup();
        ToggleButton useMap = new ToggleButton("Use current location from map");
        useMap.setMaxWidth(Double.MAX_VALUE);
        useMap.setToggleGroup(locationGroup);
        useMap.setOnAction(e -> {
            // useMap.setStyle("-fx-background-color: lightblue");
            setMapLocation();
        });
        ToggleButton useInput = new ToggleButton("Manually enter longitude and latitude values");
        useInput.setMaxWidth(Double.MAX_VALUE);
//        useInput.setOnAction(e -> ); // TODO: provide manual location input
        useInput.setToggleGroup(locationGroup);
        VBox locationVB = new VBox(10, useMap, useInput);
        locationVB.setPadding(new Insets(0, 0, 15, 0));
        items.add(locationVB);


        // Trap number entry
        Label     numberlbl = new Label("Trap number:");
        TextField number    = new TextField(); // TODO: restrict to numeric input
        VBox      numberVB  = new VBox(5, numberlbl, number);
        numberVB.setPadding(new Insets(15, 0, 15, 0));
        items.add(numberVB);

        // Show buttons to set side of path
        Label side = new Label("Side of path:");
        sideGroup = new ToggleGroup();
        ToggleButton left = new ToggleButton("Left");
        left.setMaxWidth(Double.MAX_VALUE);
        left.setToggleGroup(sideGroup);
        ToggleButton right = new ToggleButton("Right");
        right.setMaxWidth(Double.MAX_VALUE);
        right.setToggleGroup(sideGroup);
        // Put buttons in a grid so they fill screen width
        CustomGridPane sideGrid = new CustomGridPane(2);
        sideGrid.add(side, 0, 0);
        sideGrid.add(left, 0, 1);
        sideGrid.add(right, 1, 1);
        VBox sideVB = new VBox(5, side, sideGrid);
        sideVB.setPadding(new Insets(15, 0, 15, 0));
        items.add(sideVB);

        // Show buttons to save or cancel
        Button save = new Button("Save");
        save.setMaxWidth(Double.MAX_VALUE);
        save.setOnAction(e -> {
            if (number.getText().length() == 0 || locationGroup.getSelectedToggle() == null || sideGroup.getSelectedToggle() == null) {
                save.setText("Please complete all details");
            } else {
                Trap trap = new Trap(walk.getLine().getId(), Integer.parseInt(number.getText()), latitude, longitude, (sideGroup.getSelectedToggle() == left ? true : false));
                walk.addNewTrap(trap);
                App.getInstance().switchScreen(App.DO_WALK_VIEW);
            }
        });
        Button cancel = new Button("Cancel");
        cancel.setMaxWidth(Double.MAX_VALUE);
        cancel.setOnAction(e -> App.getInstance().switchToPreviousView());
        // Put buttons in a grid so they fill screen width
        CustomGridPane actionGrid = new CustomGridPane(2);
        actionGrid.add(save, 0, 0);
        actionGrid.add(cancel, 1, 0);
        VBox actionVB = new VBox(actionGrid);
        actionVB.setPadding(new Insets(15, 0, 15, 0));
        items.add(actionVB);

        List<Trap> traps = walk.getLine().getTraps();
        for (Trap trap : traps) {
            Circle   marker   = new Circle(5, Color.ORANGE);
            MapPoint mapPoint = new MapPoint(trap.getLatitude(), trap.getLongitude());
            mapView.addMarker(markersLayer, mapPoint, marker);
        }

        PositionService positionService = PlatformFactory.getPlatform().getPositionService();
        positionService.positionProperty().addListener(
                (observableValue, oldValue, newValue) -> updatePosition(newValue)
        );
    }

    private void updatePosition(Position position) {
        positionLayer = mapView.clearMarkers(positionLayer);
        MapPoint mapPoint = new MapPoint(position.getLatitude(), position.getLongitude());
        mapView.addMarker(positionLayer, mapPoint, new Circle(5, Color.GREEN));
        mapView.setCenter(position.getLatitude(), position.getLongitude());
        currentPosition = position;
    }

    private void setMapLocation() {
        if(currentPosition != null) {

            System.out.println("Using position: lon " + currentPosition.getLongitude() + ", lat " + currentPosition.getLatitude());
        }
    }

    @Override
    protected void updateAppBar(AppBar appBar) {
        appBar.setNavIcon(MaterialDesignIcon.MENU.button(e -> MobileApplication.getInstance().showLayer(App.MENU_LAYER)));
        appBar.setTitleText("Create New Trap");
        appBar.getActionItems().add(MaterialDesignIcon.UNDO.button(e -> App.getInstance().switchToPreviousView()));

        sideGroup.selectToggle(null);
        locationGroup.selectToggle(null);
    }
}
