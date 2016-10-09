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
 * TODO: Create exceptions for errors
 */
public class SendData {


    private static final String HOST = "traptracker.pythonanywhere.com";

    // TODO: Comment
    public static boolean sendWalkData(Walk walk) {
        sendCapturesData(walk);
        sendTrapsData(walk);
        return true;
    }

    /**
     * Converts captures in walk to json, sends to server
     *
     * @param walk The walk object
     */
    public static void sendCapturesData(Walk walk) {
        URIBuilder builder = new URIBuilder();
        builder.setScheme("http");
        builder.setHost(HOST);
        builder.setPath("/api/catch");

        try {
            URI uri = builder.build();
            System.out.println(uri);

            CloseableHttpClient httpclient = HttpClients.createDefault();
            HttpPut httpPut = new HttpPut(uri);
            httpPut.addHeader("Content-Type", "application/json");
            httpPut.addHeader("Accept", "application/json");

            String password = PlatformFactory.getPlatform().getSettingService().retrieve("password" + walk.getLine().getId());

            // Create the JSON object that will be sent to the server
            JSONObject capturesObject = new JSONObject();
            capturesObject.put("lineId", walk.getLine().getId());
            capturesObject.put("password", password); // TODO: get password from storage
            capturesObject.put("catches", walk.getCaptures());

            System.out.println(capturesObject.toString());
            System.out.println(new StringEntity(capturesObject.toString()));

            httpPut.setEntity(new StringEntity(capturesObject.toString()));
            CloseableHttpResponse response = httpclient.execute(httpPut);

            System.out.println("Response Code: " + response.getStatusLine().getStatusCode());
            System.out.println(EntityUtils.toString(response.getEntity()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // TODO: Comment
    public static void sendTrapsData(Walk walk) {
        URIBuilder builder = new URIBuilder();
        builder.setScheme("http");
        builder.setHost(HOST);
        builder.setPath("/api/trap");

        try {
            URI uri = builder.build();
            System.out.println(uri);

            CloseableHttpClient httpclient = HttpClients.createDefault();
            HttpPut httpPut = new HttpPut(uri);
            httpPut.addHeader("Content-Type", "application/json");
            httpPut.addHeader("Accept", "application/json");

            // Create the JSON object that will be sent to the server
            JSONObject capturesObject = new JSONObject();
            capturesObject.put("lineId", walk.getLine().getId());
            capturesObject.put("password", "password"); // TODO: get password from storage
            capturesObject.put("traps", walk.getChangedTraps());

            System.out.println(capturesObject.toString());
            System.out.println(new StringEntity(capturesObject.toString()));

            httpPut.setEntity(new StringEntity(capturesObject.toString()));
            CloseableHttpResponse response = httpclient.execute(httpPut);

            System.out.println("Response Code: " + response.getStatusLine().getStatusCode());
            System.out.println(EntityUtils.toString(response.getEntity()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
