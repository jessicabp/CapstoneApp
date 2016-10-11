package capstone.mobile.classes;

import com.gluonhq.charm.down.common.PlatformFactory;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.net.URI;

/**
 * Sends data from traps when connected
 */
public class SendData {


    private static final String HOST = "traptracker.pythonanywhere.com";

    public static int sendWalkData(Walk walk) {
        int traps = sendTrapsData(walk);
        if (traps != 201) {
            if (traps == 403) {
                return 1;
            } else {
                return 2;
            }
        }
        int caps = sendCapturesData(walk);
        if (caps != 201) {
            if (caps == 403) {
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
        URIBuilder builder = new URIBuilder();
        builder.setScheme("https");
        builder.setHost(HOST);
        builder.setPath("/api/catch");

        try {
            URI uri = builder.build();
            System.out.println(uri);

            CloseableHttpClient httpclient = HttpClients.createDefault();
            HttpPut             httpPut    = new HttpPut(uri);
            httpPut.addHeader("Content-Type", "application/json");
            httpPut.addHeader("Accept", "application/json");

            String password = PlatformFactory.getPlatform().getSettingService().retrieve("password" + walk.getLine().getId());
            if (!(password != null)) {
                password = "";
            }

            // Create the JSON object that will be sent to the server
            JSONObject capturesObject = new JSONObject();
            capturesObject.put("lineId", walk.getLine().getId());
            capturesObject.put("password", password);
            capturesObject.put("catches", walk.getCaptures());

            System.out.println(capturesObject.toString());
            System.out.println(new StringEntity(capturesObject.toString()));

            httpPut.setEntity(new StringEntity(capturesObject.toString()));
            CloseableHttpResponse response = httpclient.execute(httpPut);

            System.out.println("Response Code: " + response.getStatusLine().getStatusCode());
            System.out.println(EntityUtils.toString(response.getEntity()));

            return response.getStatusLine().getStatusCode();
        } catch (Exception e) {
            e.printStackTrace();

            return 500;
        }
    }

    public static int sendTrapsData(Walk walk) {
        URIBuilder builder = new URIBuilder();
        builder.setScheme("https");
        builder.setHost(HOST);
        builder.setPath("/api/trap");

        try {
            URI uri = builder.build();
            System.out.println(uri);

            CloseableHttpClient httpclient = HttpClients.createDefault();
            HttpPut             httpPut    = new HttpPut(uri);
            httpPut.addHeader("Content-Type", "application/json");
            httpPut.addHeader("Accept", "application/json");

            String password = PlatformFactory.getPlatform().getSettingService().retrieve("password" + walk.getLine().getId());
            if (!(password != null)) {
                password = "";
            }

            // Create the JSON object that will be sent to the server
            JSONObject trapsObject = new JSONObject();
            trapsObject.put("lineId", walk.getLine().getId());
            trapsObject.put("password", password);
            trapsObject.put("traps", walk.getChangedTraps());

            System.out.println(trapsObject.toString());
            System.out.println(new StringEntity(trapsObject.toString()));

            httpPut.setEntity(new StringEntity(trapsObject.toString()));
            CloseableHttpResponse response = httpclient.execute(httpPut);

            System.out.println("Response Code: " + response.getStatusLine().getStatusCode());
            System.out.println(EntityUtils.toString(response.getEntity()));

            return response.getStatusLine().getStatusCode();
        } catch (Exception e) {
            e.printStackTrace();

            return 500;
        }
    }
}
