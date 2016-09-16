package capstone.mobile.classes;

import com.gluonhq.connect.converter.JsonConverter;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

/**
 * TODO: Exception handling and possible refactoring. - should throw errors if can't get data
 */
public class ListDataSource {

    public static List<Line> fetchLinesList() {
        try {
            InputStream jsonInputStream = new URL("http://localhost:8080/line").openStream();

            List<Line> list       = new ArrayList<>();
            JsonReader jsonReader = Json.createReader(jsonInputStream);
            JsonObject jsonObject = jsonReader.readObject();
            jsonReader.close();
            jsonInputStream.close();

            JsonArray           jsonArray = jsonObject.getJsonArray("lines");
            JsonConverter<Line> c         = new JsonConverter<>(Line.class);

            for (int i = 0; i < jsonArray.size(); i++) {
                Line line = c.readFromJson(jsonArray.getJsonObject(i));
                list.add(line);
            }

            return list;
        } catch (Exception ex) {
            return null;
        }
    }

    public static List<Species> fetchSpeciesList() {
        try {
            InputStream jsonInputStream = new URL("http://localhost:8080/species").openStream();

            List<Species> list       = new ArrayList<>();
            JsonReader    jsonReader = Json.createReader(jsonInputStream);
            JsonObject    jsonObject = jsonReader.readObject();
            jsonReader.close();
            jsonInputStream.close();

            JsonArray              jsonArray = jsonObject.getJsonArray("species");
            JsonConverter<Species> c         = new JsonConverter<>(Species.class);

            for (int i = 0; i < jsonArray.size(); i++) {
                Species species = c.readFromJson(jsonArray.getJsonObject(i));
                list.add(species);
            }
            // TODO: sort by number

            return list;
        } catch (Exception ex) {
            return null;
        }
    }

    public static List<Trap> fetchTrapsList(int lineId) {
        try {
//            InputStream jsonInputStream = new URL("http://localhost:8080/traps?trap_id" + lineId).openStream();
//
//            List<Trap> list       = new ArrayList<>();
//            JsonReader jsonReader = Json.createReader(jsonInputStream);
//            JsonObject jsonObject = jsonReader.readObject();
//            jsonReader.close();
//            jsonInputStream.close();
//
//            JsonArray           jsonArray = jsonObject.getJsonArray("traps");
//            JsonConverter<Trap> c         = new JsonConverter<>(Trap.class);
//
//            for (int i = 0; i < jsonArray.size(); i++) {
//                Trap Trap = c.readFromJson(jsonArray.getJsonObject(i));
//                list.add(Trap);
//            }
            List<Trap> list = asList(new Trap(1, 1, true, false, false), new Trap(2, 2, false, false, false)); // TODO: remove and uncomment above

            return list;
        } catch (Exception ex) {
            return null;
        }
    }

}
