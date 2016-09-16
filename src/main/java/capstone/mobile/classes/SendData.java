package capstone.mobile.classes;


import com.gluonhq.connect.converter.JsonConverter;

import javax.json.JsonObject;
import java.util.ArrayList;
import java.util.List;

/**
 * Checks for network conenction and sends data from traps when connected
 */
public class SendData {

    public SendData() {
    }

    public static void sendCaptureData(Walk walk) {
//        List<Capture> captures = new ArrayList<>();
//        captures.add(new Capture(101, 1));
//        captures.add(new Capture(102, 2));
//        captures.add(new Capture(103, 3));
//        this.walk.setCaptures(captures);

        JsonConverter<Capture> converter = new JsonConverter<>(Capture.class);
        StringBuilder stringBuilder = new StringBuilder();
        for(Capture capture : walk.getCaptures()) {
            JsonObject object = converter.writeToJson(capture);
            stringBuilder.append(object.toString());
        }

        String jsonString = stringBuilder.toString();
        System.out.println(jsonString);
    }
}
