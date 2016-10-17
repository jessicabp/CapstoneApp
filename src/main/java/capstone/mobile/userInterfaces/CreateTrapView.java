package capstone.mobile.userInterfaces;

import capstone.mobile.App;
import capstone.mobile.models.Trap;
import capstone.mobile.models.Walk;
import capstone.mobile.other.CustomGridPane;
import capstone.mobile.other.CustomMapView;
import capstone.mobile.other.CustomPopupView;
import capstone.mobile.other.Validator;
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
import javafx.scene.text.Text;

import java.util.List;

/*
    TODO: Consider GPS is null and the user wants to use this to create the new trap.
 */

/**
 * Provides ability to create new trap objects while in a walk. The new trap objects coordinates may be obtained from
 * the current GPS position or entered manually. Trap number and side are also required.
 */
public class CreateTrapView extends View {

    private Walk          walk;
    private CustomMapView mapView;
    private PoiLayer      currentLayer;
    private PoiLayer      markersLayer;
    private PoiLayer      numbersLayer;
    private PoiLayer      positionLayer;
    private ToggleGroup   sideGroup;
    private ToggleGroup   locationGroup;
    private Position      currentPosition;
    private Label         waitingMessage;
    private VBox          coordinatesVBox;
    private Label         latitudeLabel;
    private Label         longitudeLabel;
    private ToggleButton  mapCoordinatesToggle;
    private ToggleButton  manualCoordinatesToggle;
    private TextField     latitudeTextField;
    private TextField     longitudeTextField;
    private TextField     numberTextField;
    private ToggleButton  leftToggleButton;
    private ToggleButton  rightToggleButton;
    private Button        saveButton;
    private boolean waitingMessageVisible = true;


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

        // Create waiting message to be displayed until the current position
        // can be obtained from the GPS.
        waitingMessage = new Label();
        waitingMessage.setStyle("-fx-text-fill: red;");
        waitingMessage.setText("Waiting on GPS for position..");
        controls.getChildren().add(waitingMessage);

        // Create list view so user can scroll through items if there are too many
        ListView<VBox>       content = new ListView<>();
        ObservableList<VBox> items   = FXCollections.observableArrayList();
        content.setItems(items);
        controls.getChildren().add(content);

        // Show buttons to set location
        locationGroup = new ToggleGroup();
        mapCoordinatesToggle = new ToggleButton("Use current location from map");
        mapCoordinatesToggle.setMaxWidth(Double.MAX_VALUE);
        mapCoordinatesToggle.setToggleGroup(locationGroup);

        manualCoordinatesToggle = new ToggleButton("Manually enter longitude and latitude values");
        manualCoordinatesToggle.setMaxWidth(Double.MAX_VALUE);
        manualCoordinatesToggle.setToggleGroup(locationGroup);
        manualCoordinatesToggle.selectedProperty().addListener((observableValue, oldValue, newValue) -> toggleCoordinatesToggle(newValue));

        // Latitude Label and TextField.
        latitudeLabel = new Label();
        latitudeLabel.setText("Enter Latitude: (at least 4 decimal places)");
        latitudeTextField = new TextField();
        latitudeTextField.setStyle("-fx-border-width: 2; -fx-border-color: white");
        latitudeTextField.textProperty().addListener((observableValue, oldValue, newValue) -> validateCoordinateInput(newValue, latitudeTextField));

        // Longitude Label and TextField.
        longitudeLabel = new Label();
        longitudeLabel.setText("Enter Longitude: (at least 4 decimal places)");
        longitudeTextField = new TextField();
        longitudeTextField.setStyle("-fx-border-width: 2; -fx-border-color: white");
        longitudeTextField.textProperty().addListener((observableValue, oldValue, newValue) -> validateCoordinateInput(newValue, longitudeTextField));

        // VBox containing Labels and TextFields for manually entering coordinates. The Visible
        // and Managed properties are set to false to initially hide the controls, which can be
        // toggled via the Button to manually enter the coordinates.
        coordinatesVBox = new VBox();
        coordinatesVBox.setVisible(false);
        coordinatesVBox.setManaged(false);
        coordinatesVBox.getChildren().addAll(
                latitudeLabel, latitudeTextField, longitudeLabel, longitudeTextField
                                            );

        VBox locationVB = new VBox(10, mapCoordinatesToggle, manualCoordinatesToggle, coordinatesVBox);
        locationVB.setPadding(new Insets(0, 0, 15, 0));
        items.add(locationVB);

        // Trap number Label and TextField.
        Label numberLabel = new Label("Enter Trap number:");
        numberTextField = new TextField();
        numberTextField.setStyle("-fx-border-width: 2; -fx-border-color: white");
        numberTextField.textProperty().addListener((observableValue, oldValue, newValue) -> validateNumberInput(newValue, numberTextField));

        VBox numberVB = new VBox(5, numberLabel, numberTextField);
        numberVB.setPadding(new Insets(15, 0, 15, 0));
        items.add(numberVB);

        // Show buttons to set side of path
        Label side = new Label("Side of path:");
        sideGroup = new ToggleGroup();
        leftToggleButton = new ToggleButton("Left");
        leftToggleButton.setMaxWidth(Double.MAX_VALUE);
        leftToggleButton.setToggleGroup(sideGroup);
        rightToggleButton = new ToggleButton("Right");
        rightToggleButton.setMaxWidth(Double.MAX_VALUE);
        rightToggleButton.setToggleGroup(sideGroup);

        // Put buttons in a grid so they fill screen width
        CustomGridPane sideGrid = new CustomGridPane(2);
        sideGrid.add(side, 0, 0);
        sideGrid.add(leftToggleButton, 0, 1);
        sideGrid.add(rightToggleButton, 1, 1);
        VBox sideVB = new VBox(5, side, sideGrid);
        sideVB.setPadding(new Insets(15, 0, 15, 0));
        items.add(sideVB);

        // Save Button.
        saveButton = new Button("Save");
        saveButton.setMaxWidth(Double.MAX_VALUE);
        saveButton.setOnAction(e -> saveNewTrap(controls));

        // Cancel Button.
        Button cancelButton = new Button("Cancel");
        cancelButton.setMaxWidth(Double.MAX_VALUE);
        cancelButton.setOnAction(e -> App.getInstance().switchToPreviousView());

        // Put buttons in a grid so they fill screen width
        CustomGridPane actionGrid = new CustomGridPane(2);
        actionGrid.add(saveButton, 0, 0);
        actionGrid.add(cancelButton, 1, 0);

        VBox actionVB = new VBox(actionGrid);
        actionVB.setPadding(new Insets(15, 0, 15, 0));
        items.add(actionVB);

        markersLayer = mapView.clearMarkers(markersLayer);
        List<Trap> traps = walk.getLine().getTraps();
        for (Trap trap : traps) {
            Circle   marker   = new Circle(5, Color.ORANGE);
            MapPoint mapPoint = new MapPoint(trap.getLatitude(), trap.getLongitude());
            mapView.addMarker(markersLayer, mapPoint, marker);
        }

        // Adding listener for obtaining current GPS location.
        PositionService positionService = PlatformFactory.getPlatform().getPositionService();
        positionService.positionProperty().addListener((observableValue, oldValue, newValue) -> updateCurrentPosition(newValue));
    }

    @Override
    protected void updateAppBar(AppBar appBar) {
        appBar.setNavIcon(MaterialDesignIcon.MENU.button(e -> MobileApplication.getInstance().showLayer(App.MENU_LAYER)));
        appBar.setTitleText("Create New Trap");
        appBar.getActionItems().add(MaterialDesignIcon.UNDO.button(e -> App.getInstance().switchToPreviousView()));

        resetControls();
    }

    /**
     * TODO: Comment
     */
    private void resetControls() {
        sideGroup.selectToggle(null);
        locationGroup.selectToggle(null);
        latitudeTextField.setText("");
        longitudeTextField.setText("");
        numberTextField.setText("");

        markersLayer = mapView.clearMarkers(markersLayer);
        for (Trap trap : walk.getLine().getTraps()) {
            Circle   marker   = new Circle(5, Color.ORANGE);
            MapPoint mapPoint = new MapPoint(trap.getLatitude(), trap.getLongitude());
            mapView.addMarker(markersLayer, mapPoint, marker);
        }
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
        currentPosition = position;
    }

    /**
     * TODO: Comment
     */
    private void toggleCoordinatesToggle(boolean selected) {
        if (selected) {
            coordinatesVBox.setVisible(true);
            coordinatesVBox.setManaged(true);
        } else {
            coordinatesVBox.setVisible(false);
            coordinatesVBox.setManaged(false);
        }
    }

    /**
     * TODO: Comment
     */
    private void validateCoordinateInput(String coordinate, TextField textField) {
        if (!Validator.isCoordinate(coordinate)) {
            textField.setStyle("-fx-border-width: 2;-fx-border-color: red");
        } else {
            textField.setStyle("-fx-border-width: 2;-fx-border-color: green");
        }
    }

    /**
     * TODO: Comment
     */
    private void validateNumberInput(String number, TextField textField) {
        if (!Validator.isNumber(number)) {
            textField.setStyle("-fx-border-width: 2;-fx-border-color: red");
        } else {
            textField.setStyle("-fx-border-width: 2;-fx-border-color: green");
        }
    }

    /**
     * TODO: Comment
     *
     * @param popUpOwner
     */
    private void saveNewTrap(VBox popUpOwner) {
        boolean validInputs = true;

        // Validate trap number.
        if (!Validator.isNumber(numberTextField.getText())) {
            validInputs = false;
        }

        // Check for location method selection.
        if (locationGroup.getSelectedToggle() == null) {
            validInputs = false;
        }

        // Validate manually entered coordinates if option selected.
        if (manualCoordinatesToggle.isSelected()) {
            boolean isLatitudeValid  = Validator.isCoordinate(latitudeTextField.getText());
            boolean isLongitudeValid = Validator.isCoordinate(longitudeTextField.getText());
            if (!(isLatitudeValid && isLongitudeValid)) {
                validInputs = false;
            }
        }

        // Make sure the position provided by the GPS is not null if option selected.
        if (mapCoordinatesToggle.isSelected()) {
            if (currentPosition == null) {
                validInputs = false;
            }
        }

        // Make sure a side has been selected.
        if (sideGroup.getSelectedToggle() == null) {
            validInputs = false;
        }

        // If there are not issues proceed to create the new trap.
        if (validInputs) {
            double  latitude;
            double  longitude;
            boolean side = leftToggleButton.isSelected();

            if (mapCoordinatesToggle.isSelected()) {
                latitude = currentPosition.getLatitude();
                longitude = currentPosition.getLongitude();
            } else {
                latitude = Double.parseDouble(latitudeTextField.getText());
                longitude = Double.parseDouble(longitudeTextField.getText());
            }

            int lineId     = walk.getLine().getId();
            int trapNumber = Integer.parseInt(numberTextField.getText());

            Trap newTrap = new Trap(lineId, trapNumber, latitude, longitude, side);

            walk.addNewTrap(newTrap);

            if (walk.getCurrentTrap() != null) {
                App.getInstance().switchScreen(App.DO_WALK_VIEW);
            } else {
                askIfDoneAddingTraps(popUpOwner);
            }
        } else {
            saveButton.setText("Please complete all details"); // TODO: better way?
            saveButton.setWrapText(true);
        }
    }

    /**
     * Create popup to ask if the user wants to add another trap or finish the walk
     * Only call if all traps on the line are new
     *
     * @param ownerNode
     */
    private void askIfDoneAddingTraps(VBox ownerNode) {
        CustomPopupView popup        = new CustomPopupView(ownerNode);
        Text            errorMessage = new Text("Do you want to create a new trap or finish the walk?");
        errorMessage.wrappingWidthProperty().bind(ownerNode.widthProperty().subtract(100));
        // Button to create trap
        Button newTrap = new Button("Create Trap");
        newTrap.setOnAction(ev -> {
            popup.hide();
            resetControls();
        });
        // Button to finish walk
        Button finish = new Button("Finish Walk");
        finish.setOnAction(ev -> {
            popup.hide();
            App.getInstance().switchScreen(App.END_WALK_VIEW);
        });
        VBox popupVB = new VBox(20, errorMessage, newTrap, finish);
        popupVB.setPadding(new Insets(40, 40, 40, 40));
        popupVB.setAlignment(Pos.TOP_CENTER);
        popup.setContent(popupVB);
        popup.show();
    }
}
