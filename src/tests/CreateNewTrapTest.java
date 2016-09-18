package tests;

import org.junit.Assert;
import org.junit.Test;

import capstone.mobile.classes.Trap;

public class CreateNewTrapTest {

    @Test
    public void CreateNewTrapConstructorTest() {
        int number = 101;
        double latitude = 8.38794;
        double longitude = 135.08785;
        boolean side = true;

        Trap newTrap = new Trap(number, latitude, longitude, side);
        Assert.assertEquals(newTrap.getId(), 0);
        Assert.assertEquals(newTrap.getNumber(), number);
        Assert.assertEquals(newTrap.getLatitude(), latitude, 0);
        Assert.assertEquals(newTrap.getLongitude(), longitude, 0);
        Assert.assertTrue(newTrap.getSide());
        Assert.assertFalse(newTrap.isBroken());
        Assert.assertFalse(newTrap.isMoved());
    }
}