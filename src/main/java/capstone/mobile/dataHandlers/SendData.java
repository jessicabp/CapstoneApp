package capstone.mobile.dataHandlers;

import capstone.mobile.models.Walk;
import com.gluonhq.charm.down.common.PlatformFactory;
import org.json.JSONObject;

import javax.net.ssl.HttpsURLConnection;
import java.net.URL;


/**
 * Sends data from traps when connected
 * TODO: Requires clean up
 */
public class SendData {

    private static final String HOST = "traptracker.pythonanywhere.com";
    private static int FULFILLED = 201;
    private static int INVALID_PASSWORD = 403;


    public static int sendWalkData(Walk walk) {
        final int traps = sendTrapsData(walk);
        if (traps != FULFILLED) {
            if (traps == INVALID_PASSWORD) {
                return 1;
            } else {
                return 2;
            }
        }
        final int captures = sendCapturesData(walk);
        if (captures != FULFILLED) {
            if (captures == INVALID_PASSWORD) {
                return 1;
            } else {
                return 2;
            }
        }
        return 0;
    }

    /**
     * Sends capture data to the server in JSON format.
     *
     * @param walk The walk object containing the capture data
     * @return int Response code from put request if successful, else returns 500
     */
    private static int sendCapturesData(Walk walk) {
        final String location = "https://" + HOST + "/api/catch";
        try {
            final URL url = new URL(location);
            final HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            connection.setRequestMethod("PUT");
            connection.setDoOutput(true);
            connection.addRequestProperty("Content-Type", "application/json");

            String password = PlatformFactory.getPlatform().getSettingService().retrieve("password" + walk.getLine().getId());
            if (password == null) {
                password = "";
            }

            // Create the JSON object that will be sent to the server
            final JSONObject capturesObject = new JSONObject();
            capturesObject.put("lineId", walk.getLine().getId());
            capturesObject.put("password", password);
            capturesObject.put("catches", walk.getCaptures());

            String body = capturesObject.toString();
            System.out.println(body);

            connection.setRequestProperty("Content-Length", Integer.toString(body.length()));
            connection.getOutputStream().write(body.getBytes("UTF-8"));

            final int responseCode = connection.getResponseCode();
            System.out.println(responseCode);

            return responseCode;
        } catch (Exception ex) {
            ex.printStackTrace();

            return 500;
        }
    }

    /**
     * Sends trap data to the server in JSON format.
     *
     * @param walk The walk object containing the trap data
     * @return int Response code from put request if successful, else returns 500
     */
    private static int sendTrapsData(Walk walk) {
        final String location = "https://" + HOST + "/api/trap";
        try {
            final URL url = new URL(location);
            final HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            connection.setRequestMethod("PUT");
            connection.setDoOutput(true);
            connection.addRequestProperty("Content-Type", "application/json");

            String password = PlatformFactory.getPlatform().getSettingService().retrieve("password" + walk.getLine().getId());
            if (password == null) {
                password = "";
            }

            // Create the JSON object that will be sent to the server
            final JSONObject trapsObject = new JSONObject();
            trapsObject.put("lineId", walk.getLine().getId());
            trapsObject.put("password", password);
            trapsObject.put("traps", walk.getChangedTraps());

            String body = trapsObject.toString();
            System.out.println(body);

            connection.setRequestProperty("Content-Length", Integer.toString(body.length()));
            connection.getOutputStream().write(body.getBytes("UTF-8"));

            final int responseCode = connection.getResponseCode();
            System.out.println(responseCode);

            return responseCode;
        } catch (Exception ex) {
            ex.printStackTrace();

            return 500;
        }
    }
}
