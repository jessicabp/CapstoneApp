package capstone.mobile.models;

import java.util.Date;

/**
 * Used to store what has been found in a trap along with the time.
 */
public class Capture {

    private int  trapId;
    private long time;
    private int  animalId;

    /**
     * Constructor.
     *
     * @param trapId   The ID number of the trap
     * @param animalId The ID number of the animal
     */
    public Capture(int trapId, int animalId) {
        this.trapId = trapId;
        this.animalId = animalId;
        time = new Date().getTime();
    }

    /**
     * Constructor.
     *
     * @param trapId   The ID number of the trap
     * @param animalId The ID of the animal
     * @param time     Timestamp containing the capture time
     */
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
