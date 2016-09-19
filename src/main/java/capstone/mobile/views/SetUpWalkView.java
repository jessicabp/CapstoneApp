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
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Screen;


public class SetUpWalkView extends View {

    private Walk walk;
    private int startIndex;
    private int endIndex;

    public SetUpWalkView(String name, Walk walk) {
        super(name);

        System.out.println(App.getInstance().getScreenWidth()); // 1920.0
        System.out.println(App.getInstance().getScreenHeight()); // 1032.0


        Rectangle2D bounds = Screen.getPrimary().getVisualBounds(); // same as above!
        System.out.println(bounds.getHeight());

        MapView mapView = new MapView();
        mapView.setMaxSize(100, 100);
        this.walk = walk;
        this.startIndex = -1;
        this.endIndex = -1;

        Pane mapPane = new Pane();
        mapPane.setStyle("-fx-background-color: black;");
        mapPane.setMaxSize(200, 200);
        mapPane.getChildren().add(mapView);

        getStylesheets().add(SetUpWalkView.class.getResource("secondary.css").toExternalForm());

        // MOCK FUNCTIONALITY - Does nothing
//        Label  label  = new Label("Enter start point");
//        Button button = new Button("Select point on map");
//        button.setGraphic(new Icon(MaterialDesignIcon.MAP));
//        button.setOnAction(e -> {
//            if (label.getText().equals("Enter start point")) {
//                label.setText("Enter end point");
//                start = traps.get(0);
//            } else {
//                end = traps.get(1);
//                walk.startWalk(start, end);
//                App.getInstance().switchView(App.DO_WALK_VIEW);
//            }
//        });

        PoiLayer mapLayer = new PoiLayer();
        Node icon1 = new Circle(7, Color.BLUE);
        mapLayer.addPoint(new MapPoint(50.8458,4.724), icon1);
        mapView.addLayer(mapLayer);

        int index = 0;
        // List<Trap> traps = ListDataSource.fetchTrapsList(walk.getLine().getId());
        for(Trap trap : walk.getLine().getTraps()) {
            Node icon = new Circle(7, Color.BLUE);
            icon.setId("" + index++);
            icon.setOnMouseClicked(e -> {
                selectTrapIndex(Integer.parseInt(icon.getId()));
                System.out.println("Index: " + Integer.parseInt(icon.getId()));
            });
            mapLayer.addPoint(new MapPoint(trap.getLatitude(), trap.getLongitude()), icon);
        }

        Button startWalkButton = new Button();
        startWalkButton.setText("Start Walk");
        // startWalkButton.setDisable(true);
        startWalkButton.setOnMouseClicked(e -> {
            if(endIndex != -1) {
                App.getInstance().switchView(App.DO_WALK_VIEW);
            }
        });

        VBox controls = new VBox(15.0, startWalkButton, mapPane);
        controls.setAlignment(Pos.CENTER);

        setCenter(controls);
    }

    private void selectTrapIndex(int index) {
        if(startIndex == -1) {
            startIndex = index;
        } else {
            endIndex = index;
        }
    }

    private void selectStart(Trap trap) {
        walk.setStartTrap(trap);
    }

    private void selectEnd(Trap trap) {
        walk.setFinishTrap(trap);
        if (trap.getNumber() > walk.getStartTrap().getNumber()) {
            walk.setDirection(false);
        } else {
            walk.setDirection(true);
        }
    }

    @Override
    protected void updateAppBar(AppBar appBar) {
        appBar.setNavIcon(MaterialDesignIcon.MENU.button(e -> MobileApplication.getInstance().showLayer(App.MENU_LAYER)));
        appBar.setTitleText("Set Up Walk");
        appBar.getActionItems().add(MaterialDesignIcon.UNDO.button(e -> App.getInstance().switchToPreviousView()));
    }

}
