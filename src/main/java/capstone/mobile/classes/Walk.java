package capstone.mobile.classes;

import capstone.mobile.App;
import capstone.mobile.maps.CustomMapView;
import capstone.mobile.views.DoWalkView;
import com.gluonhq.charm.down.common.PlatformFactory;
import com.gluonhq.charm.down.common.SettingService;
import gluonhq.maps.MapPoint;
import gluonhq.maps.PoiLayer;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


/**
 * The walk the user is on
 * Holds BooleanProperty walking to determine which side menu bar items are enabled
 * Holds the line, start and end traps
 */
public class Walk {

    private static BooleanProperty walking = new SimpleBooleanProperty(false);
    private Line line;
    private int  index;
    private Trap finishTrap;
    private Trap currentTrap;
    private List<Capture> captures     = new ArrayList<>();
    private List<Trap>    changedTraps = new ArrayList<>();

    /**
     * direction == Trap.side when the user will find the trap on the left. Direction will be true when trap number increases (e.g. sth to nth in gorge)
     */
    private boolean direction;

    public static BooleanProperty isWalking() {
        return walking;
    }

    public Line getLine() {
        return line;
    }

    public void setLine(Line line) throws DataUnavailableException {
        this.line = line;
        line.setTraps(RetrieveData.fetchTrapsList(line.getId()));

        try {
            // Update local database
            Connection dbConnection = DriverManager.getConnection(App.getInstance().dbUrl);
            if (dbConnection != null) {
                Statement stmt = dbConnection.createStatement();
                stmt.executeUpdate("DELETE FROM traps WHERE lineId = " + line.getId());
                for (Trap trap : line.getTraps()) {
                    stmt.executeUpdate("insert into traps values(" + line.getId() + ", " + trap.getId() + ", " + trap.getNumber() + ", " + trap.getLatitude() + ", " + trap.getLongitude() + ", " + (trap.getSide() ? 1 : 0) + ", " + (trap.isMoved() ? 1 : 0) + ", " + (trap.isBroken() ? 1 : 0) + ", NULL)");
                }
                stmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        PlatformFactory.getPlatform().getSettingService().store(App.CURRENTLINEID, String.valueOf(line.getId()));
    }

    public void setLineAtRestart(Line line) {
        this.line = line;
    }

    public Trap getFinishTrap() {
        return finishTrap;
    }

    public Trap getCurrentTrap() {
        return currentTrap;
    }

    public boolean getDirection() {
        return direction;
    }

    /**
     * Start the walk, setting the first and last traps in the walk to be start and end.
     *
     * @param start
     * @param end
     */
    public void startWalk(Trap start, Trap end) {
        walking.setValue(true);
        currentTrap = start;
        finishTrap = end;
        direction = currentTrap.getNumber() < finishTrap.getNumber();
        index = line.getTraps().indexOf(start);
        PlatformFactory.getPlatform().getSettingService().store(App.CURRENTTRAPID, String.valueOf(start.getId()));
        PlatformFactory.getPlatform().getSettingService().store(App.ENDTRAPID, String.valueOf(end.getId()));
    }

    /**
     * Finish the walk, erasing data about the current walk and changing to the home view.
     * Do NOT use unless server has successfully received data.
     */
    public void finishWalk() {
        walking.setValue(false);
        line = null;
        finishTrap = null;
        currentTrap = null;
        captures = new ArrayList<>();
        changedTraps = new ArrayList<>();
        SettingService settingService = PlatformFactory.getPlatform().getSettingService();
        settingService.remove(App.CURRENTLINEID);
        settingService.remove(App.CURRENTTRAPID);
        settingService.remove(App.ENDTRAPID);

        try (Connection dbConnection = DriverManager.getConnection(App.getInstance().dbUrl)) {
            if (dbConnection != null) {
                Statement stmt = dbConnection.createStatement();
                stmt.executeUpdate("DELETE FROM captures");
                stmt.executeUpdate("update traps set changed = NULL;");
                stmt.executeUpdate("DELETE FROM traps WHERE id = NULL");
                stmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Changes current trap to be the next trap, ends walk if the last trap has been reached
     */
    public void finishCurrentTrap() {
        if (currentTrap != finishTrap) {
            if (direction) {
                index++;
            } else {
                index--;
            }
            currentTrap = line.getNextTrap(index);
            PlatformFactory.getPlatform().getSettingService().store(App.CURRENTTRAPID, String.valueOf(currentTrap.getId()));
        } else {
            App.getInstance().switchScreen(App.END_WALK_VIEW);
        }
    }

    public List<Capture> getCaptures() {
        return captures;
    }

    public void addCapture(Capture capture) {
        this.captures.add(capture);
        try (Connection dbConnection = DriverManager.getConnection(App.getInstance().dbUrl)) {
            Statement stmt = dbConnection.createStatement();
            String    sql  = "insert into captures values(" + capture.getTrapId() + ", " + capture.getTime() + ", " + capture.getAnimalId() + ")";
            stmt.executeUpdate(sql);
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Add new trap to be sent to the server
     *
     * @param trap
     */
    public void addChangedTrap(Trap trap) {
        this.changedTraps.add(trap);
        try (Connection dbConnection = DriverManager.getConnection(App.getInstance().dbUrl)) {
            Statement stmt = dbConnection.createStatement();
            stmt.executeUpdate("update traps set changed = 'true' WHERE id = " + trap.getId() + ";");
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns traps to be sent to the server
     *
     * @return
     */
    public List<Trap> getChangedTraps() {
        return changedTraps;
    }

    public void addNewTrap(Trap trap) {
        this.changedTraps.add(trap);
        try (Connection dbConnection = DriverManager.getConnection(App.getInstance().dbUrl)) {
            Statement stmt = dbConnection.createStatement();
            String    sql  = "insert into traps(id, lineId, number, latitude, longitude, side, moved, broken) values(NULL, " + trap.getLineId() + ", " + trap.getNumber() + ", " + trap.getLatitude() + ", " + trap.getLongitude() + ", " + (trap.getSide() ? 1 : 0) + ", 0, 0)";
            stmt.executeUpdate(sql);
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Circle        marker   = new Circle(5, Color.YELLOW);
        MapPoint      mapPoint = new MapPoint(trap.getLatitude(), trap.getLongitude());
        CustomMapView mapview  = DoWalkView.getMapView();
        PoiLayer      layer    = DoWalkView.getMarkersLayer();
        if (layer != null) {
            System.out.println("layer not null");
        }
        mapview.addMarker(layer, mapPoint, marker);
    }
}
