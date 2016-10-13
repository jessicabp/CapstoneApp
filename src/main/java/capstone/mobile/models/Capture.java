package capstone.mobile.models;

import java.util.Date;

public class Capture {

    private int  trapId;
    private long time;
    private int  animalId;

    public Capture(int trapId, int animalId) {
        this.trapId = trapId;
        this.animalId = animalId;
        time = new Date().getTime();
    }

    public Capture(int trapId, int animalId, long time) {
        this.trapId = trapId;
        this.animalId = animalId;
        this.time = time;
    }

    public int getTrapId() {
        return trapId;
    }

    public void setTrapId(int trapId) {
        this.trapId = trapId;
    }

    public int getAnimalId() {
        return animalId;
    }

    public void setAnimalId(int animalId) {
        this.animalId = animalId;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
