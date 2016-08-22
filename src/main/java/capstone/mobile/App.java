package capstone.mobile;

import capstone.mobile.views.*;
import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.control.Avatar;
import com.gluonhq.charm.glisten.control.NavigationDrawer;
import com.gluonhq.charm.glisten.control.NavigationDrawer.Item;
import com.gluonhq.charm.glisten.layout.layer.SidePopupView;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import com.gluonhq.charm.glisten.visual.Swatch;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import com.gluonhq.charm.glisten.license.License;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

@License(key="60820384-1db6-43c0-a456-1ed0ede425b4")
public class App extends MobileApplication {

    public static final String VIEW_LINES  = HOME_VIEW;
    public static final String SET_UP_WALK = "Set up walk";
    public static final String DO_WALK = "Do walk";
    public static final String ENTER_DATA = "Enter data";
    public static final String CAMERA = "Camera";
    public static final String MAINTENANCE = "Maintenance";
    public static final String END = "End";
    public static final String ADMIN_LOGIN = "Admin Login";
    public static final String ADD_LINE = "Add line";
    public static final String ADD_TRAP = "Add trap";
    public static final String MENU_LAYER  = "Side Menu";

    private static boolean walking = FALSE;
    private static boolean addLine = TRUE;

    public static void setWalking(boolean currentWalking) {
        walking = currentWalking;
    }

    public static boolean getAddLine() {
        return addLine;
    }
    
    @Override
    public void init() {
        addViewFactory(VIEW_LINES, () -> new ViewLines(VIEW_LINES));
        addViewFactory(SET_UP_WALK, () -> new SetUpWalk(SET_UP_WALK));
        addViewFactory(DO_WALK, () -> new DoWalk(DO_WALK));
        addViewFactory(ENTER_DATA, () -> new EnterData(ENTER_DATA));
        addViewFactory(CAMERA, () -> new Camera(CAMERA));
        addViewFactory(MAINTENANCE, () -> new EnterMaintenance(MAINTENANCE));
        addViewFactory(END, () -> new End(END));
        addViewFactory(ADMIN_LOGIN, () -> new AdminLogin(ADMIN_LOGIN));
        addViewFactory(ADD_LINE, () -> new AddLine(ADD_LINE));
        addViewFactory(ADD_TRAP, () -> new AddTrap(ADD_TRAP));
        
        NavigationDrawer drawer = new NavigationDrawer();
        
        NavigationDrawer.Header header = new NavigationDrawer.Header("TrapData Tracker",
                "Pest TrapData Line Tool",
                new Avatar(21, new Image(App.class.getResourceAsStream("/icon.png"))));
        drawer.setHeader(header);
        
        final Item createLineItem = new Item("Create Line", MaterialDesignIcon.TIMELINE.graphic());
        final Item createTrapItem = new Item("Add TrapData", MaterialDesignIcon.ADD_LOCATION.graphic());
        final Item endWalkItem = new Item("End Walk", MaterialDesignIcon.EXIT_TO_APP.graphic());
        // TODO: This never updates so createLine is the only available option ever
        if (walking) {
            drawer.getItems().addAll(createLineItem, createTrapItem, endWalkItem);
        } else {
            drawer.getItems().addAll(createLineItem);
        }
        
        drawer.selectedItemProperty().addListener((obs, oldItem, newItem) -> {
            hideLayer(MENU_LAYER);
            if (newItem.equals(createLineItem)) {
                addLine = TRUE;
                switchView(ADMIN_LOGIN);
            } else  if (newItem.equals(createTrapItem)) {
                addLine = FALSE;
                switchView(ADMIN_LOGIN);
            } else if (newItem.equals(endWalkItem)) {
                switchView(END);
            }
        });
        
        addLayerFactory(MENU_LAYER, () -> new SidePopupView(drawer));
    }

    @Override
    public void postInit(Scene scene) {
        Swatch.GREEN.assignTo(scene);

        scene.getStylesheets().add(App.class.getResource("style.css").toExternalForm());
        ((Stage) scene.getWindow()).getIcons().add(new Image(App.class.getResourceAsStream("/icon.png")));
    }
}
