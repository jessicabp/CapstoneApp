package capstone.mobile.dataHandlers;

import capstone.mobile.models.Walk;
import com.gluonhq.charm.down.common.PlatformFactory;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.json.JSONObject;

import java.net.URI;

/**
 * Sends data from traps when connected
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
     * Converts captures in walk to json, sends to server
     *
     * @param walk The walk object
     */
    public static int sendCapturesData(Walk walk) {
        final URIBuilder builder = new URIBuilder();
        builder.setScheme("https");
        builder.setHost(HOST);
        builder.setPath("/api/catch");

        try {
            final URI uri = builder.build();
            System.out.println(uri);

            final CloseableHttpClient httpclient = HttpClients.createDefault();
            final HttpPut             httpPut    = new HttpPut(uri);
            httpPut.addHeader("Content-Type", "application/json");
            httpPut.addHeader("Accept", "application/json");

            String password = PlatformFactory.getPlatform().getSettingService().retrieve("password" + walk.getLine().getId());
            if (password.equals(null)) {
                password = "";
            }

            // Create the JSON object that will be sent to the server
            final JSONObject capturesObject = new JSONObject();
            capturesObject.put("lineId", walk.getLine().getId());
            capturesObject.put("password", password);
            capturesObject.put("catches", walk.getCaptures());

            httpPut.setEntity(new StringEntity(capturesObject.toString()));
            final CloseableHttpResponse response = httpclient.execute(httpPut);

            return response.getStatusLine().getStatusCode();
        } catch (Exception e) {
            e.printStackTrace();

            return 500;
        }
    }

    public static int sendTrapsData(Walk walk) {
        final URIBuilder builder = new URIBuilder();
        builder.setScheme("https");
        builder.setHost(HOST);
        builder.setPath("/api/trap");

        try {
            final URI uri = builder.build();
            System.out.println(uri);

            final CloseableHttpClient httpclient = HttpClients.createDefault();
            final HttpPut             httpPut    = new HttpPut(uri);
            httpPut.addHeader("Content-Type", "application/json");
            httpPut.addHeader("Accept", "application/json");

            String password = PlatformFactory.getPlatform().getSettingService().retrieve("password" + walk.getLine().getId());
            if (password.equals(null)) {
                password = "";
            }

            // Create the JSON object that will be sent to the server
            final JSONObject trapsObject = new JSONObject();
            trapsObject.put("lineId", walk.getLine().getId());
            trapsObject.put("password", password);
            trapsObject.put("traps", walk.getChangedTraps());

            httpPut.setEntity(new StringEntity(trapsObject.toString()));
            final CloseableHttpResponse response = httpclient.execute(httpPut);

            return response.getStatusLine().getStatusCode();
        } catch (Exception e) {
            e.printStackTrace();

            return 500;
        }
    }
}
