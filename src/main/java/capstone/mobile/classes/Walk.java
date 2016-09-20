package capstone.mobile.classes;

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
    private int index;
    private Trap finishTrap;
    private Trap currentTrap;
    private boolean  direction; // TODO: direction will be the same as Trap.side when the user will find the trap on the left. Direction will be false when trap number increases (e.g. sth to nth in gorge) - this is partially dealt with in SetUpWalkView
    private List<Capture> captures     = new ArrayList<>();
    private List<Trap>    changedTraps = new ArrayList<>();

    public Walk() {
    }

    public static BooleanProperty isWalking() {
        return walking;
    }

    public Line getLine() {
        return line;
    }

    public void setLine(Line line) throws DataUnavailableException {
        this.line = line;
        line.setTraps(ListDataSource.fetchTrapsList(line.getId()));
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


    public void startWalk(Trap start, Trap end) {
        walking.setValue(true);
        currentTrap = start;
        finishTrap = end;
        direction = currentTrap.getNumber() > finishTrap.getNumber();
    }

    public void finishWalk() {
        walking.setValue(false);
    }

    /**
     * Changes current trap to be the next trap
     */
    public void finishCurrentTrap() {
        if (currentTrap != finishTrap) {
            if (direction) {
                index++;
            } else {
                index--;
            }
            currentTrap = line.getNextTrap(index);
        }
    }

    public List<Capture> getCaptures() {
        return captures;
    }

    public void addCapture(Capture capture) {
        this.captures.add(capture);
    }

    public void addChangedTrap(Trap trap) {
        this.changedTraps.add(trap);
    }

    public List<Trap> getChangedTraps() {
        return changedTraps;
    }
}
