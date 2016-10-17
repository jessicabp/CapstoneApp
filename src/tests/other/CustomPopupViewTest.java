package other;

import capstone.mobile.App;
import capstone.mobile.other.CustomPopupView;
import com.gluonhq.charm.glisten.application.GlassPane;
import javafx.scene.layout.VBox;
import org.junit.Assert;
import org.junit.Test;

public class CustomPopupViewTest {

    @Test
    public void PopupListenerTest() {
        VBox owner = new VBox();
        CustomPopupView popupView = new CustomPopupView(owner);

        popupView.showingProperty().setValue(false);
        Assert.assertTrue(App.getInstance().getGlassPane().getBackgroundFade() == 0);
        popupView.showingProperty().setValue(true);
        Assert.assertTrue(App.getInstance().getGlassPane().getBackgroundFade() == GlassPane.DEFAULT_BACKGROUND_FADE_LEVEL);
    }
}
