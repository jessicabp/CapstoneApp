package manual.dataHandlers;

import capstone.mobile.dataHandlers.LocalDatabase;

import capstone.mobile.models.Animal;
import capstone.mobile.models.Walk;
import capstone.mobile.userInterfaces.EnterDataView;
import com.gluonhq.charm.down.common.JavaFXPlatform;
import com.gluonhq.charm.down.common.PlatformFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.List;

import static java.util.Arrays.asList;

public class LocalDatabaseTest {


    private File db;
    private String dbUrl;

    @Before
    public void establishDatabaseConnection() {
        try {
            // Get database file

            db = new File(PlatformFactory.getPlatform().getPrivateStorage(), "TrapTrackerDatabase");
            dbUrl = "jdbc:sqlite:" + db.getAbsolutePath();

            // Get sql access for platform
            if (JavaFXPlatform.isAndroid()) {
                Class.forName("org.sqldroid.SQLDroidDriver");
            } else if (JavaFXPlatform.isIOS()) {
                Class.forName("SQLite.JDBCDriver");
            } else { // desktop and embedded
                Class.forName("org.sqlite.JDBC");
            }
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void setUpLocalDatabaseTest() {
        List<String> tables = asList("lines", "traps", "catches", "animals");

        // Delete the existing database file, then create the database
        db.delete();
        LocalDatabase.setUpLocalDatabase();

        try (Connection dbConnection = DriverManager.getConnection(dbUrl)) {
            DatabaseMetaData dbm = DriverManager.getConnection(dbUrl).getMetaData();
            // For each table
            for (String table : tables) {
                ResultSet existingTables = dbm.getTables(null, null, table, null);
                // Assert the table exists
                Assert.assertTrue(existingTables.next());
                existingTables.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void loadDatafromLocalDatabaseTest() {
        boolean success = false;
        String testAnimalName = "testAnimal";
        Walk walk = new Walk();
        Statement stmt = null;

        // Insert test animal into the database
        try (Connection dbConnection = DriverManager.getConnection(dbUrl)) {
            stmt = dbConnection.createStatement();
            stmt.executeUpdate("insert or ignore into animals(id, name) values(NULL, '" + testAnimalName + "')");


            // Restore data from database
            LocalDatabase.setUpLocalDatabase(); // TODO: Get clarification on this.
            LocalDatabase.loadDatafromLocalDatabase(walk);

            // If the test animal is in the app, set success to true
            List<Animal> animalList = EnterDataView.getAnimalList();
            for (Animal animal : animalList) {
                if (animal.getName().equals(testAnimalName)) {
                    success = true;
                }
            }

            // Assert animal was found
            Assert.assertTrue(success);

            // Clean up added animal
            stmt.executeUpdate("delete from animals where name like '%" + testAnimalName + "%'");
            stmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
