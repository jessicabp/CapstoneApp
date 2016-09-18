package capstone.mobile.classes;

/**
 * Holds information about the trap
 * Some is retrieved from the server or created on the device (eg id & location)
 * The rest is data collected at a trap (e.g. time, skipped, species)
 */
public class Trap {

    private int     id;
    private int     number;
    private boolean side;
    private double  longitude;
    private double  latitude;
    private boolean broken;
    private boolean moved;

    public Trap() {
    }

    /**
     * Constructor used to create new traps
     */
    public Trap(int number, double latitude, double longitude, boolean side) {
        this.id = 0;
        this.number = number;
        this.latitude = latitude;
        this.longitude = longitude;
        this.side = side;
        this.moved = false;
        this.broken = false;
    }

    public Trap(int id, int number, boolean side, boolean moved, boolean broken) {
        this.id = id;
        this.number = number;
        this.side = side;
        this.moved = moved;
        this.broken = broken;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public boolean getSide() {
        return side;
    }

    public void setSide(boolean side) {
        this.side = side;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void changeIsMoved() {
        this.moved = !this.moved;
    }

    public boolean isBroken() {
        return broken;
    }

    public void setBroken(boolean broken) {
        this.broken = broken;
    }

    public boolean isMoved() {
        return moved;
    }

    public void setMoved(boolean moved) {
        this.moved = moved;
    }
}
