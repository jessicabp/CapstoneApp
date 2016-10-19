package manual.dataHandlers;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.net.URL;

public class ServerTest {

    private static final String HOST = "https://traptracker.pythonanywhere.com/api";

    @Test
    public void CreateConnectionTest() {
        boolean thrown = false;
        try {
            URL url = new URL(HOST + "/line");
            url.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
            thrown = true;
        }

        Assert.assertFalse(thrown);
    }
}
