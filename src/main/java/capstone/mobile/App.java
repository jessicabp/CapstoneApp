package capstone.mobile;

import capstone.mobile.dataHandlers.LocalDatabase;
import capstone.mobile.models.Walk;
import capstone.mobile.userInterfaces.*;
import com.gluonhq.charm.down.common.PlatformFactory;
import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.control.Avatar;
import com.gluonhq.charm.glisten.control.NavigationDrawer;
import com.gluonhq.charm.glisten.control.NavigationDrawer.Header;
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

    // Strings naming the views, and providing reference to them
    public static final String DISPLAY_LINES_VIEW   = "Display lines";
    public static final String FAVOURITE_LINES_VIEW = "Display favourite lines";
    public static final String SET_UP_WALK_VIEW     = "Set up walk";
    public static final String DO_WALK_VIEW         = "Do walk";
    public static final String ENTER_DATA_VIEW      = "Enter data";
    public static final String MAINTENANCE          = "Maintenance";
    public static final String CREATE_TRAP_VIEW     = "Add trap";
    public static final String END_WALK_VIEW        = "End walk";
    public static final String MENU_LAYER           = "Side Menu";
    // Strings to name values stored on device
    public static String currentPage   = "CURRENTPAGE";
    public static String currentLineID = "CURRENTLINE";
    public static String currentTrapID = "CURRENTTRAP";
    public static String endTrapID     = "ENDTRAP";
    private static App a;
    // Items to appear in the side menu bar
    private Item homeItem;
    private Item createTrapItem;
    private Item endWalkItem;

    /**
     * Listener for the side menu bar selections
     */
    private final ChangeListener listener = (obs, oldItem, newItem) -> {
        hideLayer(MENU_LAYER);
        if (newItem.equals(homeItem)) {
            switchScreen(HOME_VIEW);
        } else if (newItem.equals(createTrapItem)) {
            switchScreen(CREATE_TRAP_VIEW);
        } else if (newItem.equals(endWalkItem)) {
            switchScreen(END_WALK_VIEW);
        }
    };

    public static App getInstance() {
        return a;
    }

    /**
     * Sets up app, creates views, local database, & sidebar menu
     */
    @Override
    public void init() {

//        // TODO: remove
//        PlatformFactory.getPlatform().getSettingService().remove(App.currentPage);

        a = this;

        // Initializing walk object
        final Walk walk = new Walk();

        LocalDatabase.setUpLocalDatabase();
        createViews(walk);

        // Create items to populate side menu bar
        homeItem = new Item("Home", MaterialDesignIcon.HOME.graphic());
        createTrapItem = new Item("Add Trap", MaterialDesignIcon.ADD_LOCATION.graphic());
        endWalkItem = new Item("End Walk", MaterialDesignIcon.EXIT_TO_APP.graphic());

        // Create side menu bar
        final NavigationDrawer drawer = new NavigationDrawer();
        final Header           header = new NavigationDrawer.Header("Trap Tracker", "Pest Trap Line Tool", new Avatar(21, new Image(App.class.getResourceAsStream("/icon.png"))));
        drawer.setHeader(header);
        drawer.getItems().addAll(homeItem, createTrapItem, endWalkItem);
        drawer.selectedItemProperty().addListener(listener);
        addLayerFactory(MENU_LAYER, () -> new SidePopupView(drawer));

        /* Remove and re-add side menu bar listener
           Updates menu if view is changed another way
           Sets selected item to null so user can select item even if already in the view */
        viewProperty().addListener((obs, ov, nv) -> {
            drawer.selectedItemProperty().removeListener(listener);
            if (nv.getName().equals(HOME_VIEW)) {
                homeItem.setSelected(false);
                drawer.setSelectedItem(null);
            } else if (nv.getName().equals(CREATE_TRAP_VIEW)) {
                createTrapItem.setSelected(false);
                drawer.setSelectedItem(null);
            } else if (nv.getName().equals(END_WALK_VIEW)) {
                endWalkItem.setSelected(false);
                drawer.setSelectedItem(null);
            }
            drawer.selectedItemProperty().addListener(listener);
        });

        // Load data from database
        LocalDatabase.loadDatafromLocalDatabase(walk);
    }

    /**
     * Runs after init, assigns app colour and sets sidebar menu items to disable when irrelevant
     *
     * @param scene
     */
    @Override
    public void postInit(Scene scene) {
        Swatch.GREEN.assignTo(scene);
        scene.getStylesheets().add(App.class.getResource("style.css").toExternalForm());
        ((Stage) scene.getWindow()).getIcons().add(new Image(App.class.getResourceAsStream("/icon.png")));

        // Disable adding a trap or ending a walk if the user is not currently doing a walk
        homeItem.disableProperty().bind(Walk.isWalking());
        createTrapItem.disableProperty().bind(Walk.isWalking().not());
        endWalkItem.disableProperty().bind(Walk.isWalking().not());
    }

    /**
     * Sets the variable on the device to match the current (new) screen, then changes to that screen
     *
     * @param viewName
     */
    public void switchScreen(String viewName) {
        if (viewName != CREATE_TRAP_VIEW) {
            PlatformFactory.getPlatform().getSettingService().store(currentPage, viewName);
        }
        switchView(viewName);
    }

    /**
     * Creates all the screens
     *
     * @param walk
     */
    private void createViews(Walk walk) {
        addViewFactory(DISPLAY_LINES_VIEW, () -> new DisplayLinesView(DISPLAY_LINES_VIEW, walk));
        addViewFactory(FAVOURITE_LINES_VIEW, () -> new FavouriteLinesView(FAVOURITE_LINES_VIEW, walk));
        addViewFactory(SET_UP_WALK_VIEW, () -> new SetUpWalkView(SET_UP_WALK_VIEW, walk));
        addViewFactory(DO_WALK_VIEW, () -> new DoWalkView(DO_WALK_VIEW, walk));
        addViewFactory(ENTER_DATA_VIEW, () -> new EnterDataView(ENTER_DATA_VIEW, walk));
        addViewFactory(MAINTENANCE, () -> new EnterMaintenance(MAINTENANCE, walk));
        addViewFactory(CREATE_TRAP_VIEW, () -> new CreateTrapView(CREATE_TRAP_VIEW, walk));
        addViewFactory(END_WALK_VIEW, () -> new EndWalkView(END_WALK_VIEW, walk));
        addViewFactory(HOME_VIEW, () -> new HomeView(HOME_VIEW, walk));
    }
}
