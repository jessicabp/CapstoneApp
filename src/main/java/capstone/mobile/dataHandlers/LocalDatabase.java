package capstone.mobile.dataHandlers;


import capstone.mobile.models.*;
import capstone.mobile.userInterfaces.DisplayLinesView;
import capstone.mobile.userInterfaces.EnterDataView;
import com.gluonhq.charm.down.common.JavaFXPlatform;
import com.gluonhq.charm.down.common.PlatformFactory;

import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LocalDatabase {

    public static String dbUrl;

    /**
     * Gets/creates local database according to platform, creates tables if they don't exist
     */
    public static void setUpLocalDatabase() {
        try {
            final File db = new File(PlatformFactory.getPlatform().getPrivateStorage(), "TrapTrackerDatabase");
            dbUrl = "jdbc:sqlite:" + db.getAbsolutePath();
        } catch (IOException ex) {
            System.out.println("Error " + ex);
        }

        try {
            if (JavaFXPlatform.isAndroid()) {
                Class.forName("org.sqldroid.SQLDroidDriver");
            } else if (JavaFXPlatform.isIOS()) {
                Class.forName("SQLite.JDBCDriver");
            } else { // desktop and embedded
                Class.forName("org.sqlite.JDBC");
            }

            final Connection dbConnection = DriverManager.getConnection(dbUrl);

            if (dbConnection != null) {
                final Statement stmt = dbConnection.createStatement();
                // TODO: remove table deletion
//                stmt.executeUpdate("DROP TABLE IF EXISTS lines");
//                stmt.executeUpdate("DROP TABLE IF EXISTS traps");
//                stmt.executeUpdate("DROP TABLE IF EXISTS captures");
//                stmt.executeUpdate("DROP TABLE IF EXISTS animals");
                stmt.executeUpdate("CREATE TABLE IF NOT EXISTS lines (" +
                                   "id INTEGER PRIMARY KEY NOT NULL, " +
                                   "name TEXT NOT NULL, " +
                                   "a1 INTEGER, " +
                                   "a2 INTEGER, " +
                                   "a3 INTEGER, " +
                                   "favourite TEXT)");
                stmt.executeUpdate("CREATE TABLE IF NOT EXISTS traps (" +
                                   "lineId INTEGER REFERENCES lines(id) ON UPDATE CASCADE ON DELETE CASCADE, " +
                                   "id INTEGER, " +
                                   "number INTEGER NOT NULL, " +
                                   "latitude REAL NOT NULL, " +
                                   "longitude REAL NOT NULL, " +
                                   "side INTEGER NOT NULL, " +
                                   "moved INTEGER NOT NULL, " +
                                   "broken INTEGER NOT NULL, " +
                                   "changed TEXT)");
                stmt.executeUpdate("CREATE TABLE IF NOT EXISTS captures (" +
                                   "trapId INTEGER NOT NULL, " +
                                   "time REAL NOT NULL, " +
                                   "animalId INTEGER NOT NULL)");
                stmt.executeUpdate("CREATE TABLE IF NOT EXISTS animals (" +
                                   "id INTEGER PRIMARY KEY, " +
                                   "name TEXT NOT NULL)");
                stmt.close();
            }
            dbConnection.close();
        } catch (ClassNotFoundException e) {
            System.out.println("Error class not found " + e);
        } catch (SQLException ex) {
            System.out.println("SQL Exception " + ex);
        }
    }

    /**
     * Loads any data from the local database into the app
     *
     * @param walk
     */
    public static void loadDatafromLocalDatabase(Walk walk) {
        try (Connection dbConnection = DriverManager.getConnection(dbUrl)) {
            final Statement stmt    = dbConnection.createStatement();
            final Statement stmt2   = dbConnection.createStatement();
            final ResultSet linesRS = stmt.executeQuery("SELECT * FROM lines;");
            while (linesRS.next()) {
                // load line from database
                final int  lineId = linesRS.getInt("id");
                final Line line   = new Line(lineId, linesRS.getString("name"), linesRS.getInt("a1"), linesRS.getInt("a2"), linesRS.getInt("a3"));
                // get traps on line
                final ResultSet trapRS = stmt2.executeQuery("SELECT * FROM traps WHERE lineId = " + lineId + ";");
                while (trapRS.next()) {
                    if (trapRS.getObject("id") != null) {
                        // add trap from line
                        final Trap trap = new Trap(trapRS.getInt("id"), trapRS.getInt("lineId"), trapRS.getInt("number"), trapRS.getDouble("latitude"), trapRS.getDouble("longitude"), trapRS.getInt("side"), trapRS.getInt("broken"), trapRS.getInt("moved"));
                        line.addTrap(trap);
                        if (trapRS.getString("changed") != null && trapRS.getString("changed").equals("true")) {
                            walk.addChangedTrap(trap);
                        }
                    } else {
                        // add new trap
                        walk.addChangedTrap(new Trap(trapRS.getInt("lineId"), trapRS.getInt("number"), trapRS.getDouble("latitude"), trapRS.getDouble("longitude"), trapRS.getInt("side") == 1));
                    }
                }
                trapRS.close();
                DisplayLinesView.addToObservableLinesList(line);
            }
            linesRS.close();
            // load captures
            final ResultSet captureRS = stmt.executeQuery("SELECT * FROM captures;");
            while (captureRS.next()) {
                walk.addCaptureFromDB(new Capture(captureRS.getInt("trapID"), captureRS.getInt("animalID"), captureRS.getLong("time")));
            }
            captureRS.close();
            // load animal
            final ResultSet animalRS = stmt.executeQuery("SELECT * FROM animals;");
            while (animalRS.next()) {
                final Animal animal = new Animal(animalRS.getInt("id"), animalRS.getString("name"));
                EnterDataView.addAnimalFromDB(animal);
            }
            animalRS.close();
            stmt.close();
            stmt2.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Creates a new capture entry in the database
     *
     * @param capture
     */
    public static void addCapture(Capture capture) {
        try (Connection dbConnection = DriverManager.getConnection(dbUrl)) {
            final Statement stmt = dbConnection.createStatement();
            stmt.executeUpdate("insert into captures values(" + capture.getTrapId() + ", " + capture.getTime() + ", " + capture.getAnimalId() + ")");
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Mark trap as having been changed, ensure moved and broken are updated
     *
     * @param trap
     */
    public static void changeTrap(Trap trap) {
        try (Connection dbConnection = DriverManager.getConnection(dbUrl)) {
            final Statement stmt = dbConnection.createStatement();
            stmt.executeUpdate("update traps set changed = 'true' WHERE id = " + trap.getId() + ";");
            stmt.executeUpdate("update traps set broken = '" + String.valueOf(trap.isBroken()) + "' WHERE id = " + trap.getId() + ";");
            stmt.executeUpdate("update traps set moved = '" + String.valueOf(trap.isMoved()) + "' WHERE id = " + trap.getId() + ";");
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Add a newly created trap to the database
     *
     * @param trap
     */
    public static void addNewTrap(Trap trap) {
        try (Connection dbConnection = DriverManager.getConnection(dbUrl)) {
            final Statement stmt = dbConnection.createStatement();
            stmt.executeUpdate("insert into traps(id, lineId, number, latitude, longitude, side, moved, broken) values(NULL, " + trap.getLineId() + ", " + trap.getNumber() + ", " + trap.getLatitude() + ", " + trap.getLongitude() + ", " + (trap.getSide() ? 1 : 0) + ", 0, 0)");
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Add new traps from the server to th database
     *
     * @return List of all traps in the database for the line
     * @throws SQLException
     * @throws DataUnavailableException
     */
    public static List<Trap> updateTraps(int lineId) throws DataUnavailableException {
        final List<Trap> trapsList = RetrieveData.fetchTrapsList(lineId);
        try (Connection dbConnection = DriverManager.getConnection(dbUrl)) {
            // Update local database
            if (dbConnection != null) {
                final Statement stmt = dbConnection.createStatement();
                for (Trap trap : trapsList) {
                    if (!stmt.executeQuery("SELECT * FROM traps WHERE id = " + trap.getId()).next()) {
                        stmt.executeUpdate("insert into traps values(" + lineId + ", " + trap.getId() + ", " + trap.getNumber() + ", " + trap.getLatitude() + ", " + trap.getLongitude() + ", " + (trap.getSide() ? 1 : 0) + ", " + (trap.isMoved() ? 1 : 0) + ", " + (trap.isBroken() ? 1 : 0) + ", NULL)");
                    }
                }
                trapsList.clear();
                final ResultSet trapRS = stmt.executeQuery("SELECT * FROM traps WHERE lineId = " + lineId);
                while (trapRS.next()) {
                    trapsList.add(new Trap(trapRS.getInt("id"), trapRS.getInt("lineId"), trapRS.getInt("number"), trapRS.getDouble("latitude"), trapRS.getDouble("longitude"), trapRS.getInt("side"), trapRS.getInt("broken"), trapRS.getInt("moved")));
                }
                trapRS.close();
                stmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Sorts trap numbers (smallest to largest) to ensure correct ordering.
        Collections.sort(trapsList, (a, b) -> a.getNumber() - b.getNumber());

        return trapsList;
    }

    /**
     * Remove all captures, mark all traps as not changed, delete traps without ids (newly created traps)
     */
    public static void endWalk() {
        try (Connection dbConnection = DriverManager.getConnection(dbUrl)) {
            if (dbConnection != null) {
                final Statement stmt = dbConnection.createStatement();
                stmt.executeUpdate("DELETE FROM captures");
                stmt.executeUpdate("update traps set changed = NULL;");
                stmt.executeUpdate("DELETE FROM traps WHERE id = NULL");
                stmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Mark the current line as current
     *
     * @param line
     */
    public static void setCurrentLine(Line line) {
        try (Connection dbConnection = DriverManager.getConnection(dbUrl)) {
            final Statement stmt = dbConnection.createStatement();
            stmt.executeUpdate("UPDATE lines SET favourite = 'true' WHERE id = " + line.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Add new lines from the server to the database
     *
     * @return List of all lines in the database
     * @throws SQLException
     * @throws DataUnavailableException
     */
    public static List<Line> updateLines() throws SQLException, DataUnavailableException {
        final List<Line> linesList = RetrieveData.fetchLinesList();
        try (Connection dbConnection = DriverManager.getConnection(dbUrl)) {
            // Update local database
            if (dbConnection != null) {
                final Statement stmt = dbConnection.createStatement();
                for (Line line : linesList) {
                    stmt.executeUpdate("insert or ignore into lines(id, name, a1, a2, a3) values(" + line.getId() + ", '" + line.getName() + "', " + line.getAnimal1() + ", " + line.getAnimal2() + ", " + line.getAnimal3() + ")");
                }
                linesList.clear();
                final ResultSet lineRS = stmt.executeQuery("SELECT * FROM lines");
                while (lineRS.next()) {
                    linesList.add(new Line(lineRS.getInt("id"), lineRS.getString("name"), lineRS.getInt("a1"), lineRS.getInt("a2"), lineRS.getInt("a3")));
                }
                lineRS.close();
                stmt.close();
            }
            return linesList;
        } catch (SQLException e) {
            throw e;
        }
    }

    /**
     * Add new animals from the server to the database
     *
     * @return List of all animals in the database
     * @throws SQLException
     * @throws DataUnavailableException
     */
    public static List<Animal> updateAnimals() throws SQLException, DataUnavailableException {
        final List<Animal> animalList = RetrieveData.fetchAnimalList();
        try (Connection dbConnection = DriverManager.getConnection(dbUrl)) {
            // Update local database
            if (dbConnection != null) {
                final Statement stmt = dbConnection.createStatement();
                for (Animal animal : animalList) {
                    stmt.executeUpdate("insert or ignore into animals(id, name) values(" + animal.getId() + ", '" + animal.getName() + "')");
                }
                animalList.clear();
                final ResultSet animalRS = stmt.executeQuery("SELECT * FROM animals");
                while (animalRS.next()) {
                    animalList.add(new Animal(animalRS.getInt("id"), animalRS.getString("name")));
                }
                animalRS.close();
                stmt.close();
            }
            return animalList;
        } catch (SQLException e) {
            throw e;
        }
    }

    /**
     * Gets all lines from the database marked as favourite
     *
     * @return List of lines
     * @throws SQLException
     */
    public static List<Line> fetchLines() throws SQLException {
        final List<Line> linesList = new ArrayList<>();
        try (Connection dbConnection = DriverManager.getConnection(dbUrl)) {
            final Statement stmt    = dbConnection.createStatement();
            final ResultSet linesRS = stmt.executeQuery("SELECT * FROM lines WHERE favourite like '%true%';");
            while (linesRS.next()) {
                // load line from database
                final Line line = new Line(linesRS.getInt("id"), linesRS.getString("name"), linesRS.getInt("a1"), linesRS.getInt("a2"), linesRS.getInt("a3"));
                linesList.add(line);
            }
            linesRS.close();
            stmt.close();
            return linesList;
        } catch (SQLException e) {
            throw e;
        }
    }
}
