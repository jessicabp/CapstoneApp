package capstone.mobile.views;

import capstone.mobile.App;
import capstone.mobile.classes.LocationProvider;
import capstone.mobile.classes.Trap;
import capstone.mobile.classes.Walk;
import com.gluonhq.charm.down.common.Position;
import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.control.Icon;
import com.gluonhq.charm.glisten.control.TextField;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;


/**
 * Adds a trap to the line a user is currently in - trap needs reference to line ID
 */
public class CreateTrapView extends View {

    private Walk walk;
    private boolean side;

    public CreateTrapView(String name, Walk walk) {
        super(name);
        this.walk = walk;

        getStylesheets().add(CreateTrapView.class.getResource("secondary.css").toExternalForm());

        Label label = new Label("Enter GPS location on map");

        // TODO: get GPS, ask for number, ask left or right
        // TODO: Create new Trap, add to end of trap list, walk.addChangedTrap(newTrap)
        // TODO: Go to data entry for trap

        Button button = new Button("Select point on map, enter number & side of track");
        button.setGraphic(new Icon(MaterialDesignIcon.MAP));
        button.setOnAction(e -> createTrap(1)); // TODO: implement to input data incl. trap number


        TextField numberField = new TextField();


        Button buttonLeft = new Button();
        buttonLeft.setText("Left");
        buttonLeft.setOnMouseClicked(e -> {
            side = false;
        });

        Button buttonRight = new Button();
        buttonRight.setText("Right");
        buttonLeft.setOnMouseClicked(e -> {
            side = true;
        });

        HBox sideControls = new HBox(15.0, buttonLeft, buttonRight);


        Button buttonCreate = new Button();
        buttonCreate.setText("Create");
        buttonCreate.setOnMouseClicked(e -> {
            int number = Integer.parseInt(numberField.getText());
            Position position = LocationProvider.getPosition();

            Trap newTrap = new Trap();
            newTrap.setNumber(number);
            newTrap.setSide(side);
            newTrap.setLatitude(position.getLatitude());
            newTrap.setLongitude(position.getLongitude());

            walk.getLine().addTrap(newTrap);
        });

        VBox controls = new VBox(15.0, label, button, numberField, sideControls, buttonCreate);
        controls.setAlignment(Pos.CENTER);
        setCenter(controls);
    }

    private void createTrap(int num) {
        // TODO: create createTrap functionality
        App.getInstance().switchView(App.DO_WALK_VIEW);
    }

    @Override
    protected void updateAppBar(AppBar appBar) {
        appBar.setNavIcon(MaterialDesignIcon.MENU.button(e -> MobileApplication.getInstance().showLayer(App.MENU_LAYER)));
        appBar.setTitleText("Create New Trap");
        appBar.getActionItems().add(MaterialDesignIcon.UNDO.button(e -> App.getInstance().switchToPreviousView()));
    }
}
