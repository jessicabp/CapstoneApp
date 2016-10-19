package manual.other;

import capstone.mobile.other.CustomGridPane;
import org.junit.Assert;
import org.junit.Test;

public class CustomGridPaneTest {

    @Test
    public void CustomGridColumnWidthTest() {
        int            colCount = 2;
        CustomGridPane gridPane = new CustomGridPane(colCount);

        for (int i = 0; i < colCount; i++) {
            Assert.assertEquals(gridPane.getColumnConstraints().get(0).getPercentWidth(), 100 / colCount, 1);
        }
    }
}
