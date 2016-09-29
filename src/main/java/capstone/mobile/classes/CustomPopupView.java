package capstone.mobile.classes;

import capstone.mobile.App;
import com.gluonhq.charm.glisten.application.GlassPane;
import com.gluonhq.charm.glisten.layout.layer.PopupView;
import javafx.scene.Node;


public class CustomPopupView extends PopupView {

    public CustomPopupView(Node ownerNode) {
        super(ownerNode);


        showingProperty().addListener((obs, ov, nv) -> {
            if (nv) {
                App.getInstance().getGlassPane().setBackgroundFade(GlassPane.DEFAULT_BACKGROUND_FADE_LEVEL);
            } else {
                App.getInstance().getGlassPane().setBackgroundFade(0);
            }
        });
    }
}
