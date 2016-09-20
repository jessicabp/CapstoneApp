package capstone.mobile.classes;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Capture {

    private int  trapId;
    private long time;

    /**
     * 0 - Empty
     * 1 - Rat
     * 2 - Stoat
     * 3 - Hedgehog
     * 4 - Cat
     * 5 - Other
     */
    private int speciesId;

    public Capture(int trapId, int speciesId) {
        this.trapId = trapId;
        this.speciesId = speciesId;
        time = Timestamp.valueOf(LocalDateTime.now()).getTime();
    }

    public int getTrapId() {
        return trapId;
    }

    public void setTrapId(int trapId) {
        this.trapId = trapId;
    }

    public int getSpeciesId() {
        return speciesId;
    }

    public void setSpeciesId(int speciesId) {
        this.speciesId = speciesId;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
