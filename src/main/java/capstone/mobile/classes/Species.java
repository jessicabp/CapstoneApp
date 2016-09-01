package capstone.mobile.classes;


/**
 * Species which can be referenced by a trap to indicate what was caught
 */
public class Species {
    int    id;
    String name;

    public Species() {
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
