package capstone.mobile.classes;


import com.gluonhq.connect.converter.JsonConverter;

import javax.json.JsonObject;

/**
 * Sends data from traps when connected
 */
public class SendData {

    private static final String HOST = "http://traptracker.pythonanywhere.com/api";

    public SendData() {
    }

    /**
     * Converts captures in walk to json, sends to server
     *
     * @param walk
     */
    public static void sendCaptureData(Walk walk) {
        JsonConverter<Capture> converter     = new JsonConverter<>(Capture.class);
        StringBuilder          stringBuilder = new StringBuilder();
        for (Capture capture : walk.getCaptures()) {
            JsonObject object = converter.writeToJson(capture);
            stringBuilder.append(object.toString());
        }

        String jsonString = stringBuilder.toString(); // TODO: send to server
        System.out.println("Capture jsonstring: " + jsonString);
        System.out.println("(from SendData ln 28)");
    }
}
