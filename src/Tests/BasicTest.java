package tests;

import org.junit.Assert;
import org.junit.Test;

public class BasicTest {

    @Test
    public void trueTest() {
        Assert.assertTrue(true);
    }

    @Test
    public void falseTest() {
        Assert.assertFalse(true);
    }
}