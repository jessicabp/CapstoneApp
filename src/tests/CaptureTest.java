import capstone.mobile.models.Capture;
import org.junit.Assert;
import org.junit.Test;

public class CaptureTest {

    @Test
    public void createCaptureTest() {
        Capture capture = new Capture(1, 0);

        Assert.assertTrue(capture.getAnimalId() == 0);
        Assert.assertTrue(capture.getTrapId() == 1);
    }
}
