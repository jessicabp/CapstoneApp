package capstone.mobile.classes;

import java.util.ArrayList;
import java.util.List;


/**
 * Holds list of traps and other line data
 * Can be fetched from server or created on device
 */
public class Line {

    private int    id;
    private String name;
    private List<Trap> traps = new ArrayList<>();

    public Line() {
    }

    public Line(int id, String name) {
        this.id = id;
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

    public void addTrap(Trap trap) {
        this.traps.add(trap);
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
