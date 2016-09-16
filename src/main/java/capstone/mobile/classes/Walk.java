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
    private Trap startTrap;
    private Trap finishTrap;
    private Trap currentTrap;
    private Trap nextTrap;
    private boolean  direction; // TODO: direction will be the same as Trap.side when the user will find the trap on the left. Direction will be false when trap number increases (e.g. sth to nth in gorge) - this is partially dealt with in SetUpWalkView
    private List<Capture> captures     = new ArrayList<>();
    private List<Trap>    changedTraps = new ArrayList<>();

    public Walk() {
    }

    public static BooleanProperty isWalking() {
        return walking;
    }

    public static void setWalking(boolean walking) {
        Walk.walking.setValue(walking);
    }

    public Line getLine() {
        return line;
    }

    public void setLine(Line line) {
        this.line = line;
        line.setTraps(ListDataSource.fetchTrapsList(line.getId()));
    }

    public Trap getStartTrap() {
        return startTrap;
    }

    public void setStartTrap(Trap startTrap) {
        this.index = line.getTraps().indexOf(startTrap);
        this.startTrap = startTrap;
    }

    public Trap getFinishTrap() {
        return finishTrap;
    }

    public void setFinishTrap(Trap finishTrap) {
        this.finishTrap = finishTrap;
    }

    public Trap getCurrentTrap() {
        return currentTrap;
    }

    public void setCurrentTrap(Trap currentTrap) {
        this.currentTrap = currentTrap;
    }

    public Trap getNextTrap() {
        return nextTrap;
    }

    public void setNextTrap(Trap nextTrap) {
        this.nextTrap = nextTrap;
    }

    public boolean getDirection() {
        return direction;
    }

    public void setDirection(boolean direction) {
        this.direction = direction;
    }


    public void startWalk(Trap start, Trap end) {
        walking.setValue(true);
        startTrap = start;
        finishTrap = end;
    }

    public void finishWalk() {
        walking.setValue(false);
    }

    /**
     * Changes current trap to be the next trap
     */
    public void finishCurrentTrap() {
        currentTrap = nextTrap;
        if (direction) {
            index++;
        } else {
            index--;
        }
        if (currentTrap != finishTrap) {
            nextTrap = line.getNextTrap(index);
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
