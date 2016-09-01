package capstone.mobile;

import capstone.mobile.classes.Walk;
import capstone.mobile.views.*;
import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.control.Avatar;
import com.gluonhq.charm.glisten.control.NavigationDrawer;
import com.gluonhq.charm.glisten.control.NavigationDrawer.Item;
import com.gluonhq.charm.glisten.layout.layer.SidePopupView;
import com.gluonhq.charm.glisten.license.License;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import com.gluonhq.charm.glisten.visual.Swatch;
import javafx.beans.value.ChangeListener;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

@License(key = "60820384-1db6-43c0-a456-1ed0ede425b4")

/**
 * Creates views and side menu bar, and holds reference to the walk.
 */
public class App extends MobileApplication {

    /**
     * Strings naming the views, and providing reference to them
     */
    public static final String DISPLAY_LINES_VIEW = HOME_VIEW;
    public static final String SET_UP_WALK_VIEW   = "Set up walk";
    public static final String DO_WALK_VIEW       = "Do walk";
    public static final String ENTER_DATA_VIEW    = "Enter data";
    public static final String CAMERA             = "Camera";
    public static final String MAINTENANCE        = "Maintenance";
    public static final String ADMIN_LOGIN        = "Admin Login";
    public static final String CREATE_LINE_VIEW   = "Add line";
    public static final String CREATE_TRAP_VIEW   = "Add trap";
    public static final String MENU_LAYER         = "Side Menu";
    private static boolean addLine;
    private        Walk    walk;
    /**
     * Items to appear in the side menu bar
     */
    private Item createLineItem;
    private Item createTrapItem;
    private Item endWalkItem;
    /**
     * Listener for the side menu bar selections
     */
    private final ChangeListener listener = (obs, oldItem, newItem) -> {
        hideLayer(MENU_LAYER);
        hideLayer(MENU_LAYER);
        if (newItem.equals(createLineItem)) {
            addLine = true;
            switchView(ADMIN_LOGIN);
        } else if (newItem.equals(createTrapItem)) {
            addLine = false;
            switchView(ADMIN_LOGIN);
        } else if (newItem.equals(endWalkItem)) {
            // TODO: end walk
        }
    };

    public static boolean isAddLine() {
        return addLine;
    }

    @Override
    public void init() {
        /**
         * Create all views
         */
        addViewFactory(DISPLAY_LINES_VIEW, () -> new DisplayLinesView(DISPLAY_LINES_VIEW, walk));
        addViewFactory(SET_UP_WALK_VIEW, () -> new SetUpWalkView(SET_UP_WALK_VIEW, walk));
        addViewFactory(DO_WALK_VIEW, () -> new DoWalkView(DO_WALK_VIEW, walk));
        addViewFactory(ENTER_DATA_VIEW, () -> new EnterDataView(ENTER_DATA_VIEW, walk));
        addViewFactory(CAMERA, () -> new Camera(CAMERA));
        addViewFactory(MAINTENANCE, () -> new EnterMaintenance(MAINTENANCE, walk));
        addViewFactory(ADMIN_LOGIN, () -> new AdminLogin(ADMIN_LOGIN));
        addViewFactory(CREATE_LINE_VIEW, () -> new CreateLineView(CREATE_LINE_VIEW, walk));
        addViewFactory(CREATE_TRAP_VIEW, () -> new CreateTrapView(CREATE_TRAP_VIEW, walk));

        /**
         * Create items to populate side menu bar
         */
        createLineItem = new Item("Create Line", MaterialDesignIcon.TIMELINE.graphic());
        createTrapItem = new Item("Add Trap", MaterialDesignIcon.ADD_LOCATION.graphic());
        endWalkItem = new Item("End Walk", MaterialDesignIcon.EXIT_TO_APP.graphic());

        /**
         * Create side menu bar
         */
        NavigationDrawer        drawer = new NavigationDrawer();
        NavigationDrawer.Header header = new NavigationDrawer.Header("Trap Tracker", "Pest Trap Line Tool", new Avatar(21, new Image(App.class.getResourceAsStream("/icon.png"))));
        drawer.setHeader(header);
        drawer.getItems().addAll(createLineItem, createTrapItem, endWalkItem);
        drawer.selectedItemProperty().addListener(listener);
        addLayerFactory(MENU_LAYER, () -> new SidePopupView(drawer));

        /**
         * Remove and re-add side menu bar listener
         * Updates menu if view is changed another way
         * Sets selected item to null so user can select item even if already in the view
         */
        viewProperty().addListener((obs, ov, nv) -> {
            drawer.selectedItemProperty().removeListener(listener);
            if (nv.getName().equals(CREATE_LINE_VIEW)) {
                createLineItem.setSelected(false);
                drawer.setSelectedItem(null);
            } else if (nv.getName().equals(CREATE_TRAP_VIEW)) {
                createTrapItem.setSelected(false);
                drawer.setSelectedItem(null);
            } else {
                drawer.setSelectedItem(null);
            }
            drawer.selectedItemProperty().addListener(listener);
        });
    }

    @Override
    public void postInit(Scene scene) {
        Swatch.GREEN.assignTo(scene);

        scene.getStylesheets().add(App.class.getResource("style.css").toExternalForm());
        ((Stage) scene.getWindow()).getIcons().add(new Image(App.class.getResourceAsStream("/icon.png")));

        /**
         * Disable adding a trap or ending a walk if the user is not currently doing a walk
         */
        createTrapItem.disableProperty().bind(Walk.isWalking().not());
        endWalkItem.disableProperty().bind(Walk.isWalking().not());
    }
}
