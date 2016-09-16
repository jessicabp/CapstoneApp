package capstone.mobile.classes;

import com.gluonhq.connect.converter.JsonConverter;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * TODO: Comment and possibly refactor, fix species
 */
public class ListDataSource {

    private static final String HOST = "http://localhost:8080";
    private static final String KEY_ERROR = "Key not contained within object.";

    /**
     * Returns a list of line objects (containing the lines id and name).
     * @throws DataUnavailableException if an error occurs
     * @return list of line objects
     */
    public static List<Line> fetchLinesList() throws DataUnavailableException {
        try {
            URL url = new URL(HOST + "/line");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            InputStream jsonInputStream = connection.getInputStream();

            List<Line> linesList = new ArrayList<>();
            JsonReader jsonReader = Json.createReader(jsonInputStream);
            JsonObject jsonObject = jsonReader.readObject();
            jsonReader.close();
            jsonInputStream.close();
            connection.disconnect();

            if(!jsonObject.containsKey("lines")) {
                throw new DataUnavailableException(KEY_ERROR);
            }

            JsonArray jsonArray = jsonObject.getJsonArray("lines");
            JsonConverter<Line> jsonConverter = new JsonConverter<>(Line.class);

            for (int i = 0; i < jsonArray.size(); i++) {
                Line line = jsonConverter.readFromJson(jsonArray.getJsonObject(i));
                linesList.add(line);
            }

            // Sorts line names alphabetically (A -> Z).
            Collections.sort(linesList, (a, b) -> a.getName().compareTo(b.getName()));

            return linesList;
        } catch (IOException ex) {
            throw new DataUnavailableException(ex.getMessage());
        }
    }

    /**
     * Returns a list of trap objects that are associated with the specified line.
     * @param lineId the specified lines id
     * @throws DataUnavailableException if an error occurs
     * @return list of trap objects
     */
    public static List<Trap> fetchTrapsList(int lineId) throws DataUnavailableException {
        try {
            URL url = new URL(HOST + "/traps?line_id=" + lineId);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            InputStream jsonInputStream = connection.getInputStream();

            List<Trap> trapsList = new ArrayList<>();
            JsonReader jsonReader = Json.createReader(jsonInputStream);
            JsonObject jsonObject = jsonReader.readObject();
            jsonReader.close();
            jsonInputStream.close();

            if(!jsonObject.containsKey("traps")) {
                throw new DataUnavailableException(KEY_ERROR);
            }

            JsonArray jsonArray = jsonObject.getJsonArray("traps");
            JsonConverter<Trap> jsonConverter = new JsonConverter<>(Trap.class);

            for (int i = 0; i < jsonArray.size(); i++) {
                Trap trap = jsonConverter.readFromJson(jsonArray.getJsonObject(i));
                trapsList.add(trap);
            }

            // Sorts trap numbers (smallest to largest) to ensure correct ordering.
            Collections.sort(trapsList, (a, b) -> a.getNumber() - b.getNumber());

            return trapsList;
        }  catch (IOException ex) {
            throw new DataUnavailableException(ex.getMessage());
        }
    }

    /**
     * Returns a list of species objects.
     * @return list of species objects
     */
    public static List<Species> fetchSpeciesList() {

        List<Species> speciesList = new ArrayList<>();

        speciesList.add(new Species(0, "Empty"));
        speciesList.add(new Species(1, "Rat"));
        speciesList.add(new Species(2, "Stoat"));
        speciesList.add(new Species(3, "Hedgehog"));
        speciesList.add(new Species(4, "Other"));

        return speciesList;
    }
}
