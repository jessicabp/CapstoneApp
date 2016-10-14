package capstone.mobile.models;

/**
 * Contains information about a specific trap. Some properties are retrieved from the server, and some are created on
 * the device (eg id & location). The rest is data collected at a trap (e.g. time, skipped, animal).
 */
public class Trap {

    private int     id;
    private int     lineId;
    private int     number;
    private boolean side;
    private double  longitude;
    private double  latitude;
    private boolean broken;
    private boolean moved;

    public Trap() {
        // Empty constructor and all setters and getters required for json conversions
    }

    /**
     * Constructor used to create a new trap object.
     *
     * @param lineId    The ID number of the line to which the trap belongs to
     * @param number    The number of the trap
     * @param latitude  The latitude coordinate
     * @param longitude The Longitude coordinate
     * @param side      The side of the path the trap is on, true indicates on left in ascending order
     */
    public Trap(int lineId, int number, double latitude, double longitude, boolean side) {
        this.lineId = lineId;
        this.number = number;
        this.latitude = latitude;
        this.longitude = longitude;
        this.side = side;
        this.moved = false;
        this.broken = false;
    }

    /**
     * Constructor used when restoring existing traps from the local database.
     *
     * @param id        The ID number of the trap
     * @param lineId    The ID number of the line to which the trap belongs to
     * @param number    The number of the trap
     * @param latitude  The latitude coordinate
     * @param longitude The Longitude coordinate
     * @param side      The integer representation of the side of the path the trap is on
     * @param broken    The integer representation of the trap being broken
     * @param moved     The integer representation of the trap being moved
     */
    public Trap(int id, int lineId, int number, double latitude, double longitude, int side, int broken, int moved) {
        this.id = id;
        this.lineId = lineId;
        this.number = number;
        this.latitude = latitude;
        this.longitude = longitude;
        this.side = side == 1;
        this.moved = moved == 1;
        this.broken = broken == 1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLineId() {
        return lineId;
    }

    public void setLineId(int lineId) {
        this.lineId = lineId;
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
