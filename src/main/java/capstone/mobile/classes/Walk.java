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

    static BooleanProperty walking = new SimpleBooleanProperty(false);
    Line line;
    Trap startTrap;
    Trap finishTrap;
    Trap currentTrap;
    Trap nextTrap;
    int  direction; // TODO: direction will be the same as Trap.side when the user will find the trap on the left. Direction will be 0 when trap number increases (e.g. sth to nth in gorge) - this is partially delt with in SetUpWalkView
    private List<Capture> captures;

    public Walk() {
        // TODO: set other defaults
        setCaptures(new ArrayList<>());
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
    }

    public Trap getStartTrap() {
        return startTrap;
    }

    public void setStartTrap(Trap startTrap) {
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

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }



    public void startWalk() {
        walking.setValue(true);
        // TODO: complete startWalk functionality
    }

    public void skipCurrent() {
        // TODO: create skipCurrent functionality
    }

    public void finishWalk() {
        walking.setValue(false);
        // TODO: complete finishWalk functionality
    }

    /**
     * Changes current trap to be the next trap
     */
    public void finishCurrentTrap() {
        currentTrap = nextTrap;
        nextTrap = line.getNextTrap(direction == 0 ? currentTrap.getNumber() + 1 : currentTrap.getNumber() - 1); // TODO: this assumes trap numbers always increment by one
    }

    public List<Capture> getCaptures() {
        return captures;
    }

    public void setCaptures(List<Capture> captures) {
        this.captures = captures;
    }
}
