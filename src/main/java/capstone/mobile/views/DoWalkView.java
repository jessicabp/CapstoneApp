package capstone.mobile.views;

import capstone.mobile.App;
import capstone.mobile.classes.Trap;
import capstone.mobile.classes.Walk;
import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.control.Icon;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import com.gluonhq.maps.MapPoint;
import com.gluonhq.maps.MapView;
import com.gluonhq.maps.demo.PoiLayer;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.ArrayList;
import java.util.List;


/**
 * View showing user where the next trap is and lets them find or skip it
 */
public class DoWalkView extends View {

    private Walk  walk;
    private Label label;
    private int index = 0;

    public DoWalkView(String name, Walk walk) {
        super(name);

        this.walk = walk;


        getStylesheets().add(DoWalkView.class.getResource("secondary.css").toExternalForm());

        MapView  mapView  = new MapView();
        PoiLayer mapLayer = new PoiLayer();
        mapView.addLayer(mapLayer);

        index = 0;
        List<Trap> traps = walk.getLine().getTraps();
        List<Node> nodes = new ArrayList<>();
        for (Trap trap : traps) {
            Node icon = new Circle(7, Color.BLUE);
            icon.setId("" + index++);
            nodes.add(icon);
            mapLayer.addPoint(new MapPoint(trap.getLatitude(), trap.getLongitude()), icon);
        }

        // Show buttons to enter data or skip trap
        label = new Label("filler text");
        HBox   hb    = new HBox(15.0);
        Button found = new Button("Found");
        found.setOnAction(e -> App.getInstance().switchView(App.ENTER_DATA_VIEW));
        Button skip = new Button("Skip");
        skip.setOnAction(e -> {
            walk.finishCurrentTrap();
            // Switch to another view and back to refresh data on screen
            App.getInstance().switchView(App.ENTER_DATA_VIEW);
            App.getInstance().switchView(App.DO_WALK_VIEW);
        });
        hb.getChildren().addAll(found, skip);
        hb.setAlignment(Pos.CENTER);

        VBox controls = new VBox(15.0, label, mapView, hb);
        controls.setAlignment(Pos.CENTER);
        setCenter(controls);


        Circle c = new Circle(6, Color.ORANGE);
    }

    @Override
    protected void updateAppBar(AppBar appBar) {
        appBar.setNavIcon(MaterialDesignIcon.MENU.button(e -> MobileApplication.getInstance().showLayer(App.MENU_LAYER)));
        appBar.setTitleText("Walking: " + walk.getLine().getName());

        System.out.println("direction: " + walk.getDirection());
        System.out.println("side: " + walk.getCurrentTrap().getSide());

        label.setText("Trap indicator on " + (walk.getDirection() == walk.getCurrentTrap().getSide() ? "left" : "right") + " side");
        // TODO: add message if trap is moved/broken

        System.out.println("SHOWING..");

    }

}
