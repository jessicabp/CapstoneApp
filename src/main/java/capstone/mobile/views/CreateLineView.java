package capstone.mobile.views;

import capstone.mobile.App;
import capstone.mobile.classes.DataUnavailableException;
import capstone.mobile.classes.Line;
import capstone.mobile.classes.LocationProvider;
import capstone.mobile.classes.Walk;
import com.gluonhq.charm.down.common.Position;
import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.control.Icon;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;


/**
 * Adds a line
 */
public class CreateLineView extends View {

    private Walk walk;

    public CreateLineView(String name, Walk walk) {
        super(name);
        this.walk = walk;

        getStylesheets().add(CreateLineView.class.getResource("secondary.css").toExternalForm());

        Label warning = new Label("This will erase any data from the current walk!"); // TODO: can we make it so data from multiple lines is sent at the end?

        Label label = new Label("Enter name and password");

        // Create name entry field
        TextField nameField = new TextField();
        nameField.setPromptText("enter name");
        HBox hb1 = new HBox();
        hb1.setAlignment(Pos.CENTER);
        hb1.getChildren().addAll(nameField);
        hb1.setSpacing(10);

        // Create password entry field
        HBox          hb2           = new HBox();
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("enter password");
        hb2.getChildren().addAll(passwordField);
        hb2.setAlignment(Pos.CENTER);
        // hb2.setVisible(false);

        // Create button to create line
        Button button = new Button("Create");
        button.setGraphic(new Icon(MaterialDesignIcon.MAP));
        button.setOnAction(e -> {
            String lineName = nameField.getText();
            String linePassword = passwordField.getText();
            Line newLine = new Line();
            newLine.setName(lineName);
            newLine.setPassword(linePassword);
            newLine.setTraps(new ArrayList<>());
            walk.addLine(newLine);

            try {
                walk.setLine(newLine);
            } catch (DataUnavailableException e1) {
                e1.printStackTrace();
            } //TODO: try/catch?

            App.getInstance().switchView(App.CREATE_TRAP_VIEW);
        });

        VBox controls = new VBox(15.0, label, hb1, hb2, button);
        controls.setAlignment(Pos.CENTER);
        setCenter(controls);
    }

    private void createLine(String name) {
        // Finish walk if the user is doing a walk
        if (walk.isWalking().get()) {
            walk.finishWalk();
        }

        // TODO: create createLine functionality
        App.getInstance().switchView(App.DO_WALK_VIEW);
    }

    @Override
    protected void updateAppBar(AppBar appBar) {
        appBar.setNavIcon(MaterialDesignIcon.MENU.button(e -> MobileApplication.getInstance().showLayer(App.MENU_LAYER)));
        appBar.setTitleText("Create New Line");
        appBar.getActionItems().add(MaterialDesignIcon.UNDO.button(e -> App.getInstance().switchToPreviousView()));
    }
}
