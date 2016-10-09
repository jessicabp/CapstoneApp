package capstone.mobile.views;

import com.gluonhq.charm.glisten.animation.BounceInRightTransition;
import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import capstone.mobile.App;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import java.net.URL;

public class MapView extends View {

    private WebView webView;
    private WebEngine webEngine;

    public MapView(String name) {
        super(name);

        getStylesheets().add(SecondaryView.class.getResource("secondary.css").toExternalForm());

        this.webView = new WebView();
        // this.webView.setMaxSize(20.0, 20.0);
        // this.webView.setStyle("-fx-background-color: red");
        this.webEngine = webView.getEngine();

        final URL template = App.class.getResource("template.html");
        this.webEngine.load(template.toExternalForm());

        Button playSound = new Button("Play Sound");
        playSound.setOnAction(e -> {
            webEngine.executeScript("document.play();");
        });

        VBox controls = new VBox(playSound);
        controls.setAlignment(Pos.CENTER);
        setCenter(controls);

        setShowTransitionFactory(BounceInRightTransition::new);

//        getLayers().add(new FloatingActionButton(MaterialDesignIcon.INFO.text,
//                e -> System.out.println("Info")));
    }

    @Override
    protected void updateAppBar(AppBar appBar) {
        appBar.setNavIcon(MaterialDesignIcon.MENU.button(e -> MobileApplication.getInstance().showLayer(App.MENU_LAYER)));
        appBar.setTitleText("Map View");
        appBar.getActionItems().add(MaterialDesignIcon.FAVORITE.button(e -> System.out.println("Favorite")));
    }

}
