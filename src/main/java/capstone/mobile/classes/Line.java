package capstone.mobile.classes;

import java.util.List;


/**
 * Holds list of traps and other line data
 * Can be fetched from server or created on device
 */
public class Line {

    private int        id;
    private String     name;
    private List<Trap> traps;
    private boolean    newLine;

    public Line() {
    }

    public Line(String name) {
        this.name = name;
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
     * Returns trap with given number
     *
     * @param index - index of requested trap in trap list
     * @return trap
     */
    public Trap getNextTrap(int index) {
        return traps.get(index);
    }

}
