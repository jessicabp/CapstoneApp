package capstone.mobile.models;

import capstone.mobile.App;
import capstone.mobile.dataHandlers.DataUnavailableException;
import capstone.mobile.dataHandlers.LocalDatabase;
import capstone.mobile.dataHandlers.RetrieveData;
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
        LocalDatabase.saveTraps(line);
        PlatformFactory.getPlatform().getSettingService().store(App.currentLineID, String.valueOf(line.getId()));
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
        PlatformFactory.getPlatform().getSettingService().store(App.currentTrapID, String.valueOf(start.getId()));
        PlatformFactory.getPlatform().getSettingService().store(App.endTrapID, String.valueOf(end.getId()));
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
        settingService.remove(App.currentLineID);
        settingService.remove(App.currentTrapID);
        settingService.remove(App.endTrapID);
        LocalDatabase.finishWalk();
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
            PlatformFactory.getPlatform().getSettingService().store(App.currentTrapID, String.valueOf(currentTrap.getId()));
        } else {
            App.getInstance().switchScreen(App.END_WALK_VIEW);
        }
    }

    public List<Capture> getCaptures() {
        return captures;
    }

    public void addCapture(Capture capture) {
        this.captures.add(capture);
        LocalDatabase.addCapture(capture);
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

    public void addNewTrap(Trap trap) {
        this.changedTraps.add(trap);
        LocalDatabase.addNewTrap(trap);
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
