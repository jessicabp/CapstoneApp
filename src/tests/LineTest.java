import capstone.mobile.classes.Line;
import capstone.mobile.classes.Trap;
import org.junit.Assert;
import org.junit.Test;

public class LineTest {

    @Test
    public void addTrapTest() {
        Trap trap = new Trap(1, 41, 175, true);
        Line line = new Line();

        line.addTrap(trap);

        Assert.assertTrue(line.getTraps().contains(trap));
    }

    @Test
    public void getNextTrapTest() {
        Trap trap = new Trap(1, 41, 175, true);
        Line line = new Line();

        line.addTrap(trap);

        Assert.assertTrue(line.getNextTrap(0).equals(trap));
    }
}