package capstone.mobile.classes;


import javafx.scene.image.Image;

import java.time.LocalDateTime;

public class TrapData {

    private String        species;
    private int           ID;
    private String        maintenance;
    private Image         image;
    private LocalDateTime time;

    public TrapData(int ID) {
        this.ID = ID;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public void setMaintenance(String maintenance) {
        this.maintenance = maintenance;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
}
