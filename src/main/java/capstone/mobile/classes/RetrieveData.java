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
 * TODO: Comment and possibly refactor, fix animals
 */
public class RetrieveData {

    private static final String HOST      = "https://traptracker.pythonanywhere.com/api";
    private static final String KEY_ERROR = "Key not contained within object.";

    /**
     * Returns a list of line objects (containing the lines id and name).
     *
     * @return list of line objects
     * @throws DataUnavailableException if an error occurs
     */
    public static List<Line> fetchLinesList() throws DataUnavailableException {
        try {
            URL               url             = new URL(HOST + "/line");
            HttpURLConnection connection      = (HttpURLConnection) url.openConnection();
            InputStream       jsonInputStream = connection.getInputStream();

            List<Line> linesList  = new ArrayList<>();
            JsonReader jsonReader = Json.createReader(jsonInputStream);
            JsonObject jsonObject = jsonReader.readObject();
            jsonReader.close();
            jsonInputStream.close();
            connection.disconnect();

            if (!jsonObject.containsKey("result")) {
                throw new DataUnavailableException(KEY_ERROR);
            }

            JsonArray           jsonArray     = jsonObject.getJsonArray("result");
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
     *
     * @param lineId the specified lines id
     * @return list of trap objects
     * @throws DataUnavailableException if an error occurs
     */
    public static List<Trap> fetchTrapsList(int lineId) throws DataUnavailableException {
        try {
            URL               url             = new URL(HOST + "/trap?line_id=" + lineId);
            HttpURLConnection connection      = (HttpURLConnection) url.openConnection();
            InputStream       jsonInputStream = connection.getInputStream();

            List<Trap> trapsList  = new ArrayList<>();
            JsonReader jsonReader = Json.createReader(jsonInputStream);
            JsonObject jsonObject = jsonReader.readObject();
            jsonReader.close();
            jsonInputStream.close();
            connection.disconnect();

            if (!jsonObject.containsKey("result")) {
                throw new DataUnavailableException(KEY_ERROR);
            }

            JsonArray           jsonArray     = jsonObject.getJsonArray("result");
            JsonConverter<Trap> jsonConverter = new JsonConverter<>(Trap.class);

            for (int i = 0; i < jsonArray.size(); i++) {
                Trap trap = jsonConverter.readFromJson(jsonArray.getJsonObject(i));
                trapsList.add(trap);
            }

            // Sorts trap numbers (smallest to largest) to ensure correct ordering.
            Collections.sort(trapsList, (a, b) -> a.getNumber() - b.getNumber());

            return trapsList;
        } catch (IOException ex) {
            throw new DataUnavailableException(ex.getMessage());
        }
    }

    /**
     * Returns a list of animal objects.
     *
     * @return list of animal objects
     */
    public static List<Animal> fetchAnimalList() throws DataUnavailableException {
        try {
            URL               url             = new URL(HOST + "/animal");
            HttpURLConnection connection      = (HttpURLConnection) url.openConnection();
            InputStream       jsonInputStream = connection.getInputStream();

            List<Animal> animalList = new ArrayList<>();
            JsonReader   jsonReader = Json.createReader(jsonInputStream);
            JsonObject   jsonObject = jsonReader.readObject();
            jsonReader.close();
            jsonInputStream.close();
            connection.disconnect();

            if (!jsonObject.containsKey("result")) {
                throw new DataUnavailableException(KEY_ERROR);
            }

            JsonArray             jsonArray     = jsonObject.getJsonArray("result");
            JsonConverter<Animal> jsonConverter = new JsonConverter<>(Animal.class);

            for (int i = 0; i < jsonArray.size(); i++) {
                Animal animal = jsonConverter.readFromJson(jsonArray.getJsonObject(i));
                animalList.add(animal);
            }

            // Sorts trap numbers (smallest to largest) to ensure correct ordering.
            Collections.sort(animalList, (a, b) -> a.getId() - b.getId());

            return animalList;
        } catch (IOException ex) {
            throw new DataUnavailableException(ex.getMessage());
        }
    }
}
