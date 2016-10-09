package capstone.mobile;

import capstone.mobile.classes.*;
import capstone.mobile.views.*;
import com.gluonhq.charm.down.common.JavaFXPlatform;
import com.gluonhq.charm.down.common.PlatformFactory;
import com.gluonhq.charm.down.common.SettingService;
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

import java.io.File;
import java.io.IOException;
import java.sql.*;

@License(key = "60820384-1db6-43c0-a456-1ed0ede425b4")

/**
 * Creates views and side menu bar, and holds reference to the walk.
 */
public class App extends MobileApplication {

    // Strings naming the views, and providing reference to them
    public static final String DISPLAY_LINES_VIEW = "Display lines";
    public static final String FAVOURITE_LINES_VIEW = "Display favourite lines";
    public static final String SET_UP_WALK_VIEW   = "Set up walk";
    public static final String DO_WALK_VIEW       = "Do walk";
    public static final String ENTER_DATA_VIEW    = "Enter data";
    public static final String CAMERA             = "Camera";
    public static final String MAINTENANCE        = "Maintenance";
    public static final String CREATE_TRAP_VIEW   = "Add trap";
    public static final String END_WALK_VIEW      = "End walk";
    public static final String MENU_LAYER         = "Side Menu";

    // Strings to name values stored on device
    public static String CURRENTPAGE   = "CURRENTPAGE";
    public static String CURRENTLINEID = "CURRENTLINE";
    public static String CURRENTTRAPID = "CURRENTTRAP";
    public static String ENDTRAPID     = "ENDTRAP";

    private static App    a;
    public         String dbUrl;
    private        Walk   walk;

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
            // TODO ???
            // CreateTrapView.getTimeline().stop();
            // DoWalkView.getTimeline().stop();
            switchScreen(CREATE_TRAP_VIEW);
        } else if (newItem.equals(endWalkItem)) {
            // TODO ???
            // CreateTrapView.getTimeline().stop();
            // DoWalkView.getTimeline().stop();
            switchScreen(END_WALK_VIEW);
        }
    };

    public static App getInstance() {
        return a;
    }

    @Override
    public void init() {

        // TODO: remove
        PlatformFactory.getPlatform().getSettingService().remove(App.CURRENTPAGE);

        a = this;

        // Initializing walk object
        walk = new Walk();

        try {
            File db = new File(PlatformFactory.getPlatform().getPrivateStorage(), "TrapTrackerDatabase");
            dbUrl = "jdbc:sqlite:" + db.getAbsolutePath();
        } catch (IOException ex) {
            System.out.println("Error " + ex);
        }

        try {
            if (JavaFXPlatform.isAndroid()) {
                Class.forName("org.sqldroid.SQLDroidDriver");
            } else if (JavaFXPlatform.isIOS()) {
                Class.forName("SQLite.JDBCDriver");
            } else { // desktop and embedded
                Class.forName("org.sqlite.JDBC");
            }

            Connection dbConnection = DriverManager.getConnection(dbUrl);

            if (dbConnection != null) {
                Statement stmt = dbConnection.createStatement();
                // TODO: remove table deletion
//                stmt.executeUpdate("DROP TABLE IF EXISTS lines");
//                stmt.executeUpdate("DROP TABLE IF EXISTS traps");
//                stmt.executeUpdate("DROP TABLE IF EXISTS captures");
//                stmt.executeUpdate("DROP TABLE IF EXISTS animals");
                stmt.executeUpdate("CREATE TABLE IF NOT EXISTS lines (" +
                                   "id INTEGER PRIMARY KEY NOT NULL, " +
                                   "name TEXT NOT NULL, " +
                                   "a1 INTEGER, " +
                                   "a2 INTEGER, " +
                                   "a3 INTEGER, " +
                                   "favourite TEXT)");
                stmt.executeUpdate("CREATE TABLE IF NOT EXISTS traps (" +
                                   "lineId INTEGER REFERENCES lines(id) ON UPDATE CASCADE ON DELETE CASCADE, " +
                                   "id INTEGER, " +
                                   "number INTEGER NOT NULL, " +
                                   "latitude REAL NOT NULL, " +
                                   "longitude REAL NOT NULL, " +
                                   "side INTEGER NOT NULL, " +
                                   "moved INTEGER NOT NULL, " +
                                   "broken INTEGER NOT NULL, " +
                                   "changed TEXT)");
                stmt.executeUpdate("CREATE TABLE IF NOT EXISTS captures (" +
                                   "trapId INTEGER NOT NULL, " +
                                   "time REAL NOT NULL, " +
                                   "animalId INTEGER NOT NULL)");
                stmt.executeUpdate("CREATE TABLE IF NOT EXISTS animals (" +
                                   "id INTEGER PRIMARY KEY, " +
                                   "name TEXT NOT NULL)");
                stmt.close();
            }
            dbConnection.close();
        } catch (ClassNotFoundException e) {
            System.out.println("Error class not found " + e);
        } catch (SQLException ex) {
            System.out.println("SQL Exception " + ex);
        }

        // Create all views
        addViewFactory(DISPLAY_LINES_VIEW, () -> new DisplayLinesView(DISPLAY_LINES_VIEW, walk));
        addViewFactory(FAVOURITE_LINES_VIEW, () -> new FavouriteLinesView(FAVOURITE_LINES_VIEW, walk));
        addViewFactory(SET_UP_WALK_VIEW, () -> new SetUpWalkView(SET_UP_WALK_VIEW, walk));
        addViewFactory(DO_WALK_VIEW, () -> new DoWalkView(DO_WALK_VIEW, walk));
        addViewFactory(ENTER_DATA_VIEW, () -> new EnterDataView(ENTER_DATA_VIEW, walk));
        addViewFactory(CAMERA, () -> new Camera(CAMERA));
        addViewFactory(MAINTENANCE, () -> new EnterMaintenance(MAINTENANCE, walk));
        addViewFactory(CREATE_TRAP_VIEW, () -> new CreateTrapView(CREATE_TRAP_VIEW, walk));
        addViewFactory(END_WALK_VIEW, () -> new EndWalkView(END_WALK_VIEW, walk));
        addViewFactory(HOME_VIEW, () -> new HomeView(HOME_VIEW, walk));

        // Create items to populate side menu bar
        homeItem = new Item("Home", MaterialDesignIcon.HOME.graphic());
        createTrapItem = new Item("Add Trap", MaterialDesignIcon.ADD_LOCATION.graphic());
        endWalkItem = new Item("End Walk", MaterialDesignIcon.EXIT_TO_APP.graphic());

        // Create side menu bar
        NavigationDrawer        drawer = new NavigationDrawer();
        NavigationDrawer.Header header = new NavigationDrawer.Header("Trap Tracker", "Pest Trap Line Tool", new Avatar(21, new Image(App.class.getResourceAsStream("/icon.png"))));
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
        try (Connection dbConnection = DriverManager.getConnection(dbUrl)) {
            Statement stmt    = dbConnection.createStatement();
            ResultSet linesRS = stmt.executeQuery("SELECT * FROM lines;");
            while (linesRS.next()) {
                // load line from database
                int  lineId = linesRS.getInt("id");
                Line line   = new Line(lineId, linesRS.getString("name"), linesRS.getInt("a1"), linesRS.getInt("a2"), linesRS.getInt("a3"));
                // get traps on line
                ResultSet trapRS = stmt.executeQuery("SELECT * FROM traps WHERE lineId = " + lineId + ";");
                while (trapRS.next()) {
                    if (trapRS.getObject("id") != null) {
                        // add trap from line
                        Trap trap = new Trap(trapRS.getInt("id"), trapRS.getInt("lineId"), trapRS.getInt("number"), trapRS.getDouble("latitude"), trapRS.getDouble("longitude"), trapRS.getInt("side"), trapRS.getInt("broken"), trapRS.getInt("moved"));
                        line.addTrap(trap);
                        if (trapRS.getString("changed") !=null && trapRS.getString("changed").equals("true")) {
                            walk.addChangedTrap(trap);
                        }
                    } else {
                        // add new trap
                        walk.addChangedTrap(new Trap(trapRS.getInt("lineId"), trapRS.getInt("number"), trapRS.getDouble("latitude"), trapRS.getDouble("longitude"), trapRS.getInt("side"), trapRS.getInt("broken"), trapRS.getInt("moved")));
                    }
                }
                trapRS.close();
                DisplayLinesView.getObservableLinesList().add(line);
            }
            linesRS.close();
            // load captures
            ResultSet captureRS = stmt.executeQuery("SELECT * FROM captures;");
            while (captureRS.next()) {
                walk.addCapture(new Capture(captureRS.getInt("trapID"), captureRS.getInt("animalID"), captureRS.getLong("time")));
            }
            captureRS.close();
            // load animal
            ResultSet animalRS = stmt.executeQuery("SELECT * FROM animals;");
            while (animalRS.next()) {
                Animal animal = new Animal(animalRS.getInt("id"), animalRS.getString("name"));
                EnterDataView.addAnimalFromDB(animal);
            }
            animalRS.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

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

    public void switchScreen(String viewName) {
        PlatformFactory.getPlatform().getSettingService().store(CURRENTPAGE, viewName);
        switchView(viewName);
    }
}
