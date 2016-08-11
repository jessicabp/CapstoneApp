package capstone.mobile.views;

import capstone.mobile.map.GoogleMap;
import com.gluonhq.charm.down.common.PlatformFactory;
import com.gluonhq.charm.down.common.Position;
import com.gluonhq.charm.down.common.PositionService;
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

import java.util.Random;

public class MapView extends View {

    public MapView(String name) {
        super(name);

        getStylesheets().add(SecondaryView.class.getResource("secondary.css").toExternalForm());

        GoogleMap map = new GoogleMap();
        WebEngine engine = map.load();

        Button setMarker = new Button("Set Marker");
        setMarker.setOnAction(e -> {
            PositionService positionService = PlatformFactory.getPlatform().getPositionService();
            Position position = positionService.getPosition();
            if(position == null) {
                Random random = new Random();
                double x = random.nextInt(20) - 40 + random.nextDouble();
                double y = random.nextInt(165) + 20 + random.nextDouble();
                position = new Position(x, y);
                System.out.println("Randomly generated position");
            }
            System.out.println("Current GPS position: " + position.getLatitude() + "," + position.getLongitude());

            double lat = position.getLatitude();
            double lon = position.getLongitude();
            engine.executeScript("document.setMarker(" + lat + ", " + lon + " );");
        });

        VBox controls = new VBox(setMarker, map);
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
