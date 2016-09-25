package capstone.mobile.classes;

import java.util.ArrayList;
import java.util.List;


/**
 * Holds list of traps and other line data
 * Can be fetched from server or created on device
 */
public class Line {

    private int        id;
    private String     name;
    private List<Trap> traps;
    private String password;

    public Line() {
    }

    public Line(String name, String password) {
        this.id = 0;
        this.name = name;
        this.password = password;
        this.traps = new ArrayList<>();
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

    public void addTrap(Trap trap) {
        this.traps.add(trap);
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


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
