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

    private final int[]  count            = {0}; // stored as an array so it is effectively final for use in lambda expression
    private Walk   walk;
    private Button send;
    private Button cont;
    private       String SENDTEXT         = "Send to server";
    private       int    OKAY             = 0;
    private       int    INVALID_PASSWORD = 1;

    public EndWalkView(String name, Walk walk) {
        super(name);
        this.walk = walk;

        getStylesheets().add(DisplayLinesView.class.getResource("userinterface.css").toExternalForm());

        // VBox to display elements
        VBox controls = new VBox(15.0);
        controls.getStylesheets().add(DisplayLinesView.class.getResource("userinterface.css").toExternalForm());
        controls.setPadding(new Insets(40));
        controls.setAlignment(Pos.CENTER);
        setCenter(controls);

        // Add button to manually send data to server and finish walk
        Label sendDescription = new Label("Once there is an internet connection, click the below to send the data to the server and return to the home page. If you want to complete more traps on this line before you send data to the server, click the button to set up the next part of your walk.");
        sendDescription.setWrapText(true);
        send = new Button(SENDTEXT);
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
        send.setText(SENDTEXT);
    }

    /**
     * Sends data from walk to the server
     * If sending data is unsuccessful, prompt user to try again and count retries
     * If line password is incorrect when sending, create popup and request password
     *
     * @param send
     * @param ownerNode
     */
    private void sendData(Button send, VBox ownerNode) {
        int response = SendData.sendWalkData(walk);
        if (response == OKAY) {
            walk.endWalk();
            // Create popup to inform user send was successful
            CustomPopupView successPopup = new CustomPopupView(ownerNode);

            // Create layout for buttons with correct spacing
            VBox successControls = new VBox(20);
            successControls.getStylesheets().add(DisplayLinesView.class.getResource("userinterface.css").toExternalForm());
            successControls.setPadding(new Insets(40, 40, 40, 40));
            successControls.setAlignment(Pos.CENTER);

            // Add text
            Text titleText = new Text("Collected data has been sent successfully");
            titleText.getStyleClass().add("text");
            titleText.wrappingWidthProperty().bind(ownerNode.widthProperty().subtract(100));
            titleText.setTextAlignment(TextAlignment.CENTER);
            successControls.getChildren().add(titleText);

            // Add okay button
            Button okayButton = new Button("Okay");
            okayButton.setOnAction(ev -> {
                successPopup.hide();
                App.getInstance().switchScreen(App.HOME_VIEW);
            });
            successControls.getChildren().add(okayButton);

            successPopup.setContent(successControls);
            successPopup.show();
        } else {
            count[0]++;
            // Update button text to propt user to retry, and count retries
            send.setText(SENDTEXT + " (Retry #" + count[0] + ")");

            if (response == INVALID_PASSWORD) {
                // Create popup to request password
                CustomPopupView passwordPopup = new CustomPopupView(ownerNode);

                // Create layout for buttons with correct spacing
                VBox passControls = new VBox(20);
                passControls.getStylesheets().add(DisplayLinesView.class.getResource("userinterface.css").toExternalForm());
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
                passwordField.maxWidthProperty().bind(ownerNode.widthProperty().subtract(25));
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
