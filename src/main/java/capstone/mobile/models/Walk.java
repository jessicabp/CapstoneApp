/*
This file is part of Trap Tracker.

Trap Tracker is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

Trap Tracker is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with Trap Tracker.  If not, see <http://www.gnu.org/licenses/>.
 */

package capstone.mobile.models;

import capstone.mobile.App;
import capstone.mobile.dataHandlers.DataUnavailableException;
import capstone.mobile.dataHandlers.LocalDatabase;
import com.gluonhq.charm.down.common.PlatformFactory;
import com.gluonhq.charm.down.common.SettingService;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

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
    private List<Catch> catches      = new ArrayList<>();
    private List<Trap>  changedTraps = new ArrayList<>();

    /**
     * direction == Trap.side when the user will find the trap on the left. Direction will be true when trap number increases (e.g. start at trap 1, end at trap 5)
     */
    private Boolean direction;

    public Boolean isDirection() {
        return direction;
    }

    public void setDirection(Boolean direction) {
        this.direction = direction;
    }

    public static BooleanProperty isWalking() {
        return walking;
    }

    public Line getLine() {
        return line;
    }

    /**
     * Constructor
     */
    public Walk() {
        this.direction = null;
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
     * Start the walk in an instance where there are no existing traps
     */
    public void startWalkWithoutTraps() {
        walking.setValue(true);
        currentTrap = null;
        endTrap = null;
        direction = null;
        index = 0;
        PlatformFactory.getPlatform().getSettingService().remove(App.currentTrapID);
        PlatformFactory.getPlatform().getSettingService().remove(App.endTrapID);
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
        direction = null;
        final SettingService settingService = PlatformFactory.getPlatform().getSettingService();
        settingService.remove(App.currentLineID);
        settingService.remove(App.currentTrapID);
        settingService.remove(App.endTrapID);
    }

    public List<Catch> getCatches() {
        return catches;
    }

    /**
     * Add a catch to the walk and the local database
     *
     * @param newCatch
     */
    public void addCatch(Catch newCatch) {
        this.catches.add(newCatch);
        LocalDatabase.addCatch(newCatch);
    }

    /**
     * Add a catch from the local database to the walk
     *
     * @param newCatch
     */
    public void addCatchFromDB(Catch newCatch) {
        this.catches.add(newCatch);
    }

    /**
     * Delete changed trap data so it won't be sent more than once.
     * Do NOT use unless server has successfully received trap data.
     */
    public void trapsSent() {
        changedTraps = new ArrayList<>();
        LocalDatabase.removeNewTraps();
    }

    /**
     * Delete catch data so it won't be sent more than once.
     * Do NOT use unless server has successfully received catch data.
     */
    public void catchesSent() {
        catches = new ArrayList<>();
        LocalDatabase.removeCatches();
    }
}
