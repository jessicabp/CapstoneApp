package capstone.mobile.models;

import java.util.ArrayList;
import java.util.List;


/**
 * Holds list of traps and other line data
 * Can be fetched from server or created on device
 */
public class Line {

    private int    id;
    private int    animal1;
    private int    animal2;
    private int    animal3;
    private String name;
    private List<Trap> traps = new ArrayList<>();

    public Line() {
    }

    public Line(int id, String name, int animal1, int animal2, int animal3) {
        this.id = id;
        this.name = name;
        this.animal1 = animal1;
        this.animal2 = animal2;
        this.animal3 = animal3;
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

    public int getAnimal1() {
        return animal1;
    }

    // TODO: make setters for animals

    public int getAnimal2() {
        return animal2;
    }

    public int getAnimal3() {
        return animal3;
    }

    /**
     * Returns trap with given number
     *
     * @param index - index of requested trap in trap list
     * @return trap
     */
    public Trap getTrapByIndex(int index) {
        return traps.get(index);
    }
}
