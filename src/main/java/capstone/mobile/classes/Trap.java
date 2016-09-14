package capstone.mobile.classes;

/**
 * Holds information about the trap
 * Some is retrieved from the server or created on the device (eg id & location)
 * The rest is data collected at a trap (e.g. time, skipped, species)
 */
public class Trap {

    private int     id;
    private int     number;
    private int     side;
    private double  longitude;
    private double  latitude;
    private boolean isBroken;
    private boolean isMoved;

    public Trap() {
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

    public int getSide() {
        return side;
    }

    public void setSide(int side) {
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

    public boolean getIsBroken() {
        return isBroken;
    }

    public void setIsBroken(boolean isBroken) {
        this.isBroken = isBroken;
    }

    public boolean getIsMoved() {
        return isMoved;
    }

    public void setIsMoved(boolean isMoved) {
        isMoved = isMoved;
    }

    public void changeIsMoved() {
        this.isMoved = !this.isMoved;
    }

    public void enterSpecies() {
        // TODO: create functionality to enter a species for a trap
    }
}
