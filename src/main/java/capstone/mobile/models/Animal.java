package capstone.mobile.models;


/**
 * Animal which can be referenced by a trap to indicate what was caught
 */
public class Animal {
    private int    id;
    private String name;

    /**
     * Empty constructor and all setters and getters required for json conversions
     */
    public Animal() {
    }

    public Animal(int id, String name) {
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
}
