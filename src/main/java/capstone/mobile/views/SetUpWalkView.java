package capstone.mobile.views;

import capstone.mobile.App;
import capstone.mobile.classes.Trap;
import capstone.mobile.classes.Walk;
import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import com.gluonhq.maps.MapPoint;
import com.gluonhq.maps.MapView;
import com.gluonhq.maps.demo.PoiLayer;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Screen;

import java.util.List;


public class SetUpWalkView extends View {

    private Walk       walk;
    private List<Trap> traps;
    private Trap       start;
    private Trap       end;
    private Label      prompt;
    private PoiLayer   mapLayer;


    public SetUpWalkView(String name, Walk walk) {
        super(name);
        this.walk = walk;

        getStylesheets().add(SetUpWalkView.class.getResource("secondary.css").toExternalForm());

        System.out.println("Screen width: " + App.getInstance().getScreenWidth()); // 1920.0
        System.out.println("Screen height: " + App.getInstance().getScreenHeight()); // 1032.0
        System.out.println("(from SetupWalkView ln 40)");

        Rectangle2D bounds = Screen.getPrimary().getVisualBounds(); // same as above!
        System.out.println("Visual bounds height: " + bounds.getHeight());
        System.out.println("(from SetupWalkView ln 46)");

        // Create label to prompt user
        prompt = new Label("Please pick a start point");

        // Create map
        MapView mapView = new MapView();
        mapView.setMaxSize(100, 100);
        Pane mapPane = new Pane();
        mapPane.setStyle("-fx-background-color: black;");
        mapPane.setMaxSize(200, 200);
        mapPane.getChildren().add(mapView);
        mapLayer = new PoiLayer();
        Node icon1 = new Circle(7, Color.BLUE);
        mapLayer.addPoint(new MapPoint(50.8458, 4.724), icon1);
        mapView.addLayer(mapLayer);

        // Create VBox and add all items
        VBox controls = new VBox(15.0, prompt, mapPane);
        controls.setPadding(new Insets(40, 40, 40, 40));
        controls.setAlignment(Pos.CENTER);
        setCenter(controls);
    }

    @Override
    protected void updateAppBar(AppBar appBar) {
        appBar.setNavIcon(MaterialDesignIcon.MENU.button(e -> MobileApplication.getInstance().showLayer(App.MENU_LAYER)));
        appBar.setTitleText("Set Up Walk");
        appBar.getActionItems().add(MaterialDesignIcon.UNDO.button(e -> App.getInstance().switchToPreviousView()));

        // Update prompt text
        prompt.setText("Please pick a start point");

        // Add each trap to the map with listeners
        traps = walk.getLine().getTraps();
        for (Trap trap : traps) {
            Node icon = new Circle(7, Color.BLUE);
            icon.setOnMouseClicked(e -> {
                if (prompt.getText().equals("Please pick a start point")) {
                    prompt.setText("Please pick a end point");
                    start = trap;
                } else {
                    end = trap;
                    walk.startWalk(start, end);
                    App.getInstance().switchView(App.DO_WALK_VIEW);
                }
            });
            mapLayer.addPoint(new MapPoint(trap.getLatitude(), trap.getLongitude()), icon);
        }
    }

}
