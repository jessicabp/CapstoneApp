/*
This file is part of Trap Tracker.

Trap Tracker is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

Trap Tracker is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with Trap Tracker.  If not, see <http://www.gnu.org/licenses/>.
 */

package capstone.mobile.dataHandlers;

import capstone.mobile.models.Animal;
import capstone.mobile.models.Line;
import capstone.mobile.models.Trap;
import com.gluonhq.connect.converter.JsonConverter;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
            final URL                url             = new URL(HOST + "/line");
            final HttpsURLConnection connection      = (HttpsURLConnection) url.openConnection();
            final InputStream        jsonInputStream = connection.getInputStream();

            final JsonReader jsonReader = Json.createReader(jsonInputStream);
            final JsonObject jsonObject = jsonReader.readObject();
            jsonReader.close();
            jsonInputStream.close();
            connection.disconnect();

            if (!jsonObject.containsKey("result")) {
                throw new DataUnavailableException(KEY_ERROR);
            }

            final JsonArray     jsonArray     = jsonObject.getJsonArray("result");
            JsonConverter<Line> jsonConverter = new JsonConverter<>(Line.class);
            final List<Line>    linesList     = new ArrayList<>();

            for (int i = 0; i < jsonArray.size(); i++) {
                final Line line = jsonConverter.readFromJson(jsonArray.getJsonObject(i));
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
            final URL                url             = new URL(HOST + "/trap?line_id=" + lineId);
            final HttpsURLConnection connection      = (HttpsURLConnection) url.openConnection();
            final InputStream        jsonInputStream = connection.getInputStream();

            final JsonReader jsonReader = Json.createReader(jsonInputStream);
            final JsonObject jsonObject = jsonReader.readObject();
            jsonReader.close();
            jsonInputStream.close();
            connection.disconnect();

            if (!jsonObject.containsKey("result")) {
                throw new DataUnavailableException(KEY_ERROR);
            }

            final JsonArray           jsonArray     = jsonObject.getJsonArray("result");
            final JsonConverter<Trap> jsonConverter = new JsonConverter<>(Trap.class);
            final List<Trap>          trapsList     = new ArrayList<>();

            for (int i = 0; i < jsonArray.size(); i++) {
                final Trap trap = jsonConverter.readFromJson(jsonArray.getJsonObject(i));
                trapsList.add(trap);
            }

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
            final URL                url             = new URL(HOST + "/animal");
            final HttpsURLConnection connection      = (HttpsURLConnection) url.openConnection();
            final InputStream        jsonInputStream = connection.getInputStream();

            final JsonReader jsonReader = Json.createReader(jsonInputStream);
            final JsonObject jsonObject = jsonReader.readObject();
            jsonReader.close();
            jsonInputStream.close();
            connection.disconnect();

            if (!jsonObject.containsKey("result")) {
                throw new DataUnavailableException(KEY_ERROR);
            }

            final JsonArray             jsonArray     = jsonObject.getJsonArray("result");
            final JsonConverter<Animal> jsonConverter = new JsonConverter<>(Animal.class);
            final List<Animal>          animalList    = new ArrayList<>();

            for (int i = 0; i < jsonArray.size(); i++) {
                final Animal animal = jsonConverter.readFromJson(jsonArray.getJsonObject(i));
                animalList.add(animal);
            }

            // Sorts trap numbers (smallest to largest) to ensure correct ordering.
            Collections.sort(animalList, (a, b) -> a.getId() - b.getId());

            return animalList;
        } catch (IOException ex) {
            throw new DataUnavailableException(ex.getMessage());
        }
    }

    /**
     * Returns authorisation level of password.
     *
     * @return int -- 0 = no authorisation, 1 = user, 2 = admin
     */
    public static int checkAuthorisation(int lineId, String password) throws DataUnavailableException {
        try {
            final URL                url             = new URL(HOST + "/checkauth?line_id=" + lineId + "&password=" + password);
            final HttpsURLConnection connection      = (HttpsURLConnection) url.openConnection();
            final InputStream        jsonInputStream = connection.getInputStream();

            final JsonReader jsonReader = Json.createReader(jsonInputStream);
            final JsonObject jsonObject = jsonReader.readObject();
            jsonReader.close();
            jsonInputStream.close();
            connection.disconnect();

            if (!jsonObject.containsKey("result")) {
                throw new DataUnavailableException(KEY_ERROR);
            }

            return jsonObject.getInt("result");
        } catch (IOException ex) {
            throw new DataUnavailableException(ex.getMessage());
        }
    }
}
