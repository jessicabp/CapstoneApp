package capstone.mobile.classes;

import java.util.List;


/**
 * Holds list of traps and other line data
 * Can be fetched from server or created on device
 */
public class Line {

    int        id;
    String     name;
    List<Trap> traps;
    boolean    newLine;

    public Line() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Trap> getTraps() {
        return traps;
    }

    public void setTraps(List<Trap> traps) {
        this.traps = traps;
    }

    public boolean isNewLine() {
        return newLine;
    }

    public void setNewLine(boolean newLine) {
        this.newLine = newLine;
    }

    public void addTrap() {
    }

    public void removeTrap() {
    }

    /**
     * Returns trap with given number // TODO: this assumes trap numbers start at one
     *
     * @param number - number of requested trap
     * @return trap with given number
     */
    public Trap getNextTrap(int number) {
        return traps.get(number + 1);
    }

}
