package capstone.mobile.views;

import capstone.mobile.App;
import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class AdminLogin extends View {

    public AdminLogin(String name) {
        super(name);

        getStylesheets().add(AdminLogin.class.getResource("secondary.css").toExternalForm());

        Label label = new Label("Administrator login");

        // Input for username
        Label     label1    = new Label("Username:");
        TextField textField = new TextField();
        HBox      hb1       = new HBox();
        hb1.getChildren().addAll(label1, textField);
        hb1.setSpacing(10);

        // Input for password
        Label         label2        = new Label("Password:");
        PasswordField passwordField = new PasswordField();
        HBox          hb2           = new HBox();
        hb2.getChildren().addAll(label2, passwordField);
        hb2.setSpacing(10);

        //Add button to log user in
        Button nextButton = new Button("Enter");
        nextButton.setGraphic(MaterialDesignIcon.LOCK_OPEN.graphic());
        nextButton.setOnAction(e -> {
            String pass = "pass"; // TODO: check username and password against server
            if (pass.equals(passwordField.getText())) {
                getNextPage();
            } else {
                passwordField.setText("");
            }
        });
        nextButton.setMaxWidth(Double.MAX_VALUE);

        VBox controls = new VBox(15.0, label, hb1, hb2, nextButton);
        controls.setAlignment(Pos.CENTER);
        setCenter(controls);
    }

    // Goes to create line or create trap depending on which was selected
    private void getNextPage() {
        if (App.isAddLine()) {
            App.getInstance().switchView(App.CREATE_LINE_VIEW);
        } else {
            App.getInstance().switchView(App.CREATE_TRAP_VIEW);
        }
    }

    @Override
    protected void updateAppBar(AppBar appBar) {
        appBar.setNavIcon(MaterialDesignIcon.MENU.button(e -> MobileApplication.getInstance().showLayer(App.MENU_LAYER)));
        appBar.setTitleText("Set Up");
        appBar.getActionItems().add(MaterialDesignIcon.UNDO.button(e -> App.getInstance().switchToPreviousView()));
    }
}
