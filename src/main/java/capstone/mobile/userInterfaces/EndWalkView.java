package capstone.mobile.userInterfaces;


import capstone.mobile.App;
import capstone.mobile.dataHandlers.SendData;
import capstone.mobile.models.Walk;
import capstone.mobile.other.CustomPopupView;
import com.gluonhq.charm.down.common.PlatformFactory;
import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class EndWalkView extends View {

    private Walk walk;
    private Button send;
    private Button cont;
    private       int   OKAY             = 0;
    private       int   INVALID_PASSWORD = 1;
    private final int[] count            = {0}; // stored as an array so it is effectively final for use in lambda expression

    public EndWalkView(String name, Walk walk) {
        super(name);
        this.walk = walk;

        // VBox to display elements
        VBox controls = new VBox(15.0);
        controls.setPadding(new Insets(40));
        controls.setAlignment(Pos.CENTER);
        setCenter(controls);

        // Add button to manually send data to server and finish walk
        Label sendDescription = new Label("Once there is an internet connection, click the below to send the data to the server and return to the home page. If you want to complete more traps on this line before you send data to the server, click the button to set up the next part of your walk.");
        sendDescription.setWrapText(true);
        send = new Button("Send to server");
        send.setWrapText(true);
        send.setTextAlignment(TextAlignment.CENTER);
        send.setOnAction(e -> sendData(send, controls));
        controls.getChildren().addAll(sendDescription, send);

        // Add button to continue walk
        cont = new Button("Set up walk");
        cont.setWrapText(true);
        cont.setTextAlignment(TextAlignment.CENTER);
        cont.setOnAction(e -> App.getInstance().switchScreen(App.SET_UP_WALK_VIEW));
        controls.getChildren().addAll(cont);
    }

    /**
     * Update text in app bar & reset retry count back to 0
     *
     * @param appBar
     */
    @Override
    protected void updateAppBar(AppBar appBar) {
        appBar.setNavIcon(MaterialDesignIcon.MENU.button(e -> MobileApplication.getInstance().showLayer(App.MENU_LAYER)));
        appBar.setTitleText("Finished: " + walk.getLine().getName());

        count[0] = 0;
        send.setText("Send to server");
    }

    /**
     * Sends data from walk to the server
     * If sending data is unsuccessful, prompt user to try again and count retries
     * If line password is incorrect when sending, create popup and request password
     *
     * @param send
     * @param controls
     */
    private void sendData(Button send, VBox controls) {
        int response = SendData.sendWalkData(walk);
        if (response == OKAY) {
            walk.endWalk();
            App.getInstance().switchScreen(App.HOME_VIEW);
        } else {
            count[0]++;
            // Update button text to propt user to retry, and count retries
            send.setText("Click to retry sending to server once internet is connected. (Retry #" + count[0] + ")");

            if (response == INVALID_PASSWORD) {
                // Create popup to request password
                CustomPopupView passwordPopup = new CustomPopupView(controls);

                // Create layout for buttons with correct spacing
                VBox passControls = new VBox(20);
                passControls.setPadding(new Insets(40, 40, 40, 40));
                passControls.setAlignment(Pos.CENTER);

                // Add titles
                Text titleText = new Text("Stored password is incorrect.");
                titleText.setTextAlignment(TextAlignment.CENTER);
                passControls.getChildren().add(titleText);
                Text passText = new Text("Enter password:");
                passText.setTextAlignment(TextAlignment.CENTER);
                passControls.getChildren().add(passText);

                // Add password entry field
                PasswordField passwordField = new PasswordField();
                passwordField.maxWidthProperty().bind(controls.widthProperty().subtract(25));
                passControls.getChildren().add(passwordField);

                // Add cancel/save buttons
                Button popupCancel = new Button("Cancel");
                popupCancel.setOnAction(ev -> passwordPopup.hide());
                Button popupDone = new Button("Save");
                popupDone.setOnAction(ev -> {
                    // Save entered password to device storage, hide popup
                    String enteredPassword = passwordField.getText();
                    PlatformFactory.getPlatform().getSettingService().store("password" + walk.getLine().getId(), enteredPassword);
                    passwordPopup.hide();
                });
                HBox hb = new HBox(popupCancel, popupDone);
                hb.setSpacing(15);
                hb.setAlignment(Pos.CENTER);
                passControls.getChildren().add(hb);

                passwordPopup.setContent(passControls);
                passwordPopup.show();
            }
        }
    }
}
