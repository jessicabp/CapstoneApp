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

import java.util.ArrayList;
import java.util.List;


/**
 * Contains the traps and popular animals for a particular line.
 */
public class Line {

    private int    id;
    private int    animal1;
    private int    animal2;
    private int    animal3;
    private String name;
    private List<Trap> traps = new ArrayList<>();

    public Line() {
        // Empty constructor and all setters and getters required for json conversions
    }

    /**
     * Constructor.
     *
     * @param id      The ID number of the line
     * @param name    The name of the line
     * @param animal1 The most popular animal selection for the line
     * @param animal2 The second most popular animal selection for the line
     * @param animal3 The third most popular animal selection for the line
     */
    public Line(int id, String name, int animal1, int animal2, int animal3) {
        this.id = id;
        this.name = name;
        this.animal1 = animal1;
        this.animal2 = animal2;
        this.animal3 = animal3;
    }

    /**
     * Adds a trap to the list of traps.
     *
     * @param trap The trap object to be added to the line
     */
    public void addTrap(Trap trap) {
        this.traps.add(trap);
    }

    /**
     * Returns the trap at the specified index.
     *
     * @param index The index of the desired trap
     * @return trap
     */
    public Trap getTrapByIndex(int index) {
        return traps.get(index);
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

    public int getAnimal1() {
        return animal1;
    }

    public void setAnimal1(int animal1) {
        this.animal1 = animal1;
    }

    public int getAnimal2() {
        return animal2;
    }

    public void setAnimal2(int animal2) {
        this.animal2 = animal2;
    }

    public int getAnimal3() {
        return animal3;
    }

    public void setAnimal3(int animal3) {
        this.animal3 = animal3;
    }

    public List<Trap> getTraps() {
        return traps;
    }

    public void setTraps(List<Trap> traps) {
        this.traps = traps;
    }

}
