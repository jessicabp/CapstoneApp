package capstone.mobile.classes;


/**
 * Animal which can be referenced by a trap to indicate what was caught
 * TODO: this class currently not used
 */
public class Animal {
    private int    id;
    private String name;

    public Animal(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
