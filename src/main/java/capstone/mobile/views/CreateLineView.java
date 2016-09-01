package capstone.mobile.views;

import capstone.mobile.App;
import capstone.mobile.classes.Walk;
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


/**
 * Adds a line
 */
public class CreateLineView extends View {

    Walk walk;

    public CreateLineView(String name, Walk walk) {
        super(name);

        this.walk = walk;

        getStylesheets().add(CreateLineView.class.getResource("secondary.css").toExternalForm());

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
        hb2.setVisible(false);

        // Create button to create line
        Button button = new Button("Create");
        button.setGraphic(new Icon(MaterialDesignIcon.MAP));
        button.setOnAction(e -> createLine("Line name")); // TODO: implement correctly

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
        appBar.setTitleText("Create Line");
        appBar.getActionItems().add(MaterialDesignIcon.UNDO.button(e -> App.getInstance().switchToPreviousView()));
    }
}
