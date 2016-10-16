package capstone.mobile.models;

import capstone.mobile.App;
import capstone.mobile.dataHandlers.DataUnavailableException;
import capstone.mobile.dataHandlers.LocalDatabase;
import capstone.mobile.other.CustomMapView;
import capstone.mobile.userInterfaces.DoWalkView;
import com.gluonhq.charm.down.common.PlatformFactory;
import com.gluonhq.charm.down.common.SettingService;
import gluonhq.maps.MapPoint;
import gluonhq.maps.PoiLayer;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

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
    private Trap endTrap;
    private Trap currentTrap;
    private List<Capture> captures     = new ArrayList<>();
    private List<Trap>    changedTraps = new ArrayList<>();

    /**
     * direction == Trap.side when the user will find the trap on the left. Direction will be true when trap number increases (e.g. start at trap 1, end at trap 5)
     */
    private boolean direction;

    public static BooleanProperty isWalking() {
        return walking;
    }

    public Line getLine() {
        return line;
    }

    /**
     * Set line in walk, fetch traps from server, save traps in database, set currentLine on device
     *
     * @param line
     * @throws DataUnavailableException
     */
    public void setLine(Line line) throws DataUnavailableException {
        this.line = line;
        line.setTraps(LocalDatabase.updateTraps(line.getId()));
        PlatformFactory.getPlatform().getSettingService().store(App.currentLineID, String.valueOf(line.getId()));
    }

    /**
     * Sets line if restoring data after app closes
     *
     * @param line
     */
    public void setLineAtRestart(Line line) {
        this.line = line;
    }

    public Trap getCurrentTrap() {
        return currentTrap;
    }

    public Trap getEndTrap() {
        return endTrap;
    }

    /**
     * Changes current trap to be the next trap, ends walk if the last trap has been reached
     */
    public void endCurrentTrap() {
        if (!currentTrap.equals(endTrap)) {
            if (direction) {
                index++;
            } else {
                index--;
            }
            currentTrap = line.getTrapByIndex(index);
            PlatformFactory.getPlatform().getSettingService().store(App.currentTrapID, String.valueOf(currentTrap.getId()));
        } else {
            App.getInstance().switchScreen(App.END_WALK_VIEW);
        }
    }

    /**
     * Add new trap to be sent to the server
     *
     * @param trap
     */
    public void addChangedTrap(Trap trap) {
        this.changedTraps.add(trap);
        LocalDatabase.changeTrap(trap);
    }

    /**
     * Returns traps to be sent to the server
     *
     * @return
     */
    public List<Trap> getChangedTraps() {
        return changedTraps;
    }

    /**
     * Add a newly created trap to the database, list of changed traps, and map
     *
     * @param trap
     */
    public void addNewTrap(Trap trap) {
        changedTraps.add(trap);
        line.addTrap(trap);
        LocalDatabase.addNewTrap(trap);
        final Circle        marker   = new Circle(5, Color.YELLOW);
        final MapPoint      mapPoint = new MapPoint(trap.getLatitude(), trap.getLongitude());
        final CustomMapView mapview  = DoWalkView.getMapView();
        final PoiLayer      layer    = DoWalkView.getMarkersLayer();
        mapview.addMarker(layer, mapPoint, marker);
    }

    public boolean isDirection() {
        return direction;
    }

    /**
     * Start the walk, setting the first and last traps in the walk to be current and end, and setting the direction & index
     *
     * @param start
     * @param end
     */
    public void startWalk(Trap start, Trap end) {
        walking.setValue(true);
        currentTrap = start;
        endTrap = end;
        direction = currentTrap.getNumber() < endTrap.getNumber();
        index = line.getTraps().indexOf(start);
        PlatformFactory.getPlatform().getSettingService().store(App.currentTrapID, String.valueOf(start.getId()));
        PlatformFactory.getPlatform().getSettingService().store(App.endTrapID, String.valueOf(end.getId()));
    }

    /**
     * Finish the walk, erasing data about the current walk and changing to the home view.
     * Do NOT use unless server has successfully received data.
     */
    public void endWalk() {
        walking.setValue(false);
        line = null;
        endTrap = null;
        currentTrap = null;
        captures = new ArrayList<>();
        changedTraps = new ArrayList<>();
        final SettingService settingService = PlatformFactory.getPlatform().getSettingService();
        settingService.remove(App.currentLineID);
        settingService.remove(App.currentTrapID);
        settingService.remove(App.endTrapID);
        LocalDatabase.endWalk();
    }

    public List<Capture> getCaptures() {
        return captures;
    }

    /**
     * Add a capture to the walk and the local database
     *
     * @param capture
     */
    public void addCapture(Capture capture) {
        this.captures.add(capture);
        LocalDatabase.addCapture(capture);
    }

    /**
     * Add a capture from the local database to the walk
     *
     * @param capture
     */
    public void addCaptureFromDB(Capture capture) {
        this.captures.add(capture);
    }
}
