import capstone.mobile.models.Trap;
import org.junit.Assert;
import org.junit.Test;

public class CreateTrapTest {

    @Test
    public void createTrapConstructorTest() {
        int     number    = 101;
        double  latitude  = 8.38794;
        double  longitude = 135.08785;
        boolean side      = true;

        Trap newTrap = new Trap(1, number, latitude, longitude, side);
        Assert.assertEquals(newTrap.getLineId(), 1);
        Assert.assertEquals(newTrap.getNumber(), number);
        Assert.assertEquals(newTrap.getLatitude(), latitude, 0);
        Assert.assertEquals(newTrap.getLongitude(), longitude, 0);
        Assert.assertTrue(newTrap.getSide());
        Assert.assertFalse(newTrap.isBroken());
        Assert.assertFalse(newTrap.isMoved());
    }
}