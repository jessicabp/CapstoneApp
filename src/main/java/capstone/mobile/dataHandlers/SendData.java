package capstone.mobile.dataHandlers;

import capstone.mobile.models.Catch;
import capstone.mobile.models.Trap;
import capstone.mobile.models.Walk;
import com.gluonhq.charm.down.common.PlatformFactory;

import javax.net.ssl.HttpsURLConnection;
import java.net.URL;


/**
 * Sends data from traps when connected
 * TODO: Requires clean up
 */
public class SendData {

    private static final String HOST             = "traptracker.pythonanywhere.com";
    private static       int    FULFILLED        = 201;
    private static       int    INVALID_PASSWORD = 403;


    public static int sendWalkData(Walk walk) {
        final int traps = sendTrapsData(walk);
        if (traps != FULFILLED) {
            if (traps == INVALID_PASSWORD) {
                return 1;
            } else {
                return 2;
            }
        }
        walk.trapsSent();
        final int catches = sendCatchesData(walk);
        if (catches != FULFILLED) {
            if (catches == INVALID_PASSWORD) {
                return 1;
            } else {
                return 2;
            }
        }
        walk.catchesSent();
        return 0;
    }

    /**
     * Sends catch data to the server in JSON format.
     *
     * @param walk The walk object containing the catch data
     * @return int Response code from put request if successful, else returns 500
     */
    private static int sendCatchesData(Walk walk) {
        final String location = "https://" + HOST + "/api/catch";
        try {
            final URL                url        = new URL(location);
            final HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            connection.setRequestMethod("PUT");
            connection.setDoOutput(true);
            connection.addRequestProperty("Content-Type", "application/json");

            String password = PlatformFactory.getPlatform().getSettingService().retrieve("password" + walk.getLine().getId());
            if (password == null) {
                password = "";
            }

            // Use string concatenation to create json to send to server
            String lineIdJson   = "\"lineId\":\"" + walk.getLine().getId() + "\"";
            String passwordJson = "\"password\":\"" + password + "\"";
            String catchJson    = "\"catches\":[";
            for (Catch nextCatch : walk.getCatches()) {
                if (catchJson.length() > 12) {
                    catchJson += ",";
                }
                catchJson += "{\"time\":" + nextCatch.getTime() + ",\"animalId\":" + nextCatch.getAnimalId() + ",\"trapId\":" + nextCatch.getTrapId() + "}";
            }
            catchJson += "]";

            String catchesJsonObject = "{" + lineIdJson + "," + passwordJson + "," + catchJson + "}";
            System.out.println(catchesJsonObject);

            connection.setRequestProperty("Content-Length", Integer.toString(catchesJsonObject.length()));
            connection.getOutputStream().write(catchesJsonObject.getBytes("UTF-8"));

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
            final URL                url        = new URL(location);
            final HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            connection.setRequestMethod("PUT");
            connection.setDoOutput(true);
            connection.addRequestProperty("Content-Type", "application/json");

            String password = PlatformFactory.getPlatform().getSettingService().retrieve("password" + walk.getLine().getId());
            if (password == null) {
                password = "";
            }

            // Use string concatenation to create json to send to server
            String lineIdJson   = "\"lineId\":\"" + walk.getLine().getId() + "\"";
            String passwordJson = "\"password\":\"" + password + "\"";
            String trapJson     = "\"traps\":[";
            for (Trap trap : walk.getChangedTraps()) {
                if (trapJson.length() > 10) {
                    trapJson += ",";
                }
                if (!(trap.getId() > 0)) {
                    trapJson += "{\"number\":" + trap.getNumber() + ",\"side\":" + trap.getSide() + ",\"latitude\":" + trap.getLatitude() + ",\"lineId\":" + trap.getLineId() + ",\"longitude\":" + trap.getLongitude() + "}";
                } else {
                    trapJson += "{\"broken\":" + trap.isBroken() + ",\"number\":" + trap.getNumber() + ",\"side\":" + trap.getSide() + ",\"latitude\":" + trap.getLatitude() + ",\"moved\":" + trap.isMoved() + ",\"lineId\":" + trap.getLineId() + ",\"id\":" + trap.getId() + ",\"longitude\":" + trap.getLongitude() + "}";
                }
            }
            trapJson += "]";

            String trapsJsonObject = "{" + lineIdJson + "," + passwordJson + "," + trapJson + "}";
            System.out.println(trapsJsonObject);

            connection.setRequestProperty("Content-Length", Integer.toString(trapsJsonObject.length()));
            connection.getOutputStream().write(trapsJsonObject.getBytes("UTF-8"));

            final int responseCode = connection.getResponseCode();
            System.out.println(responseCode);

            return responseCode;
        } catch (Exception ex) {
            ex.printStackTrace();

            return 500;
        }
    }
}
