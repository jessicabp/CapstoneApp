package manual.other;

import capstone.mobile.other.CustomMapView;
import org.junit.Assert;
import org.junit.Test;

public class CustomMapViewTest {

    @Test
    public void defaultConstructorTest() {
        CustomMapView customMapView = new CustomMapView();
        Assert.assertEquals(280.0, customMapView.getMaxHeight(), 0);
        Assert.assertEquals(Double.MAX_VALUE, customMapView.getMaxWidth(), 0);
    }

    @Test
    public void maxHeightConstructorTest() {
        CustomMapView customMapView = new CustomMapView(100.0);
        Assert.assertEquals(100.0, customMapView.getMaxHeight(), 0);
        Assert.assertEquals(Double.MAX_VALUE, customMapView.getMaxWidth(), 0);
    }

}