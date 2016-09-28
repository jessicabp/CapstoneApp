import gluonhq.maps.MapPoint;
import org.junit.Assert;
import org.junit.Test;

public class MapPointTest {

    @Test
    public void mapPointsAreEqual() {
        MapPoint p1 = new MapPoint(3, 4);
        MapPoint p2 = new MapPoint(3, 4);

        Assert.assertEquals(p1, p2);
    }
}
