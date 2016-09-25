import capstone.mobile.classes.*;
import org.junit.*;

import static java.util.Arrays.asList;

public class WalkTest {

    Walk    walk;
    Line    line;
    Trap    trap1;
    Trap    trap2;
    Capture capture;

    @Before
    public void beforeTests() {
        // Set up walk
        walk = new Walk();
        line = new Line("gorge");
        trap1 = new Trap(1, 40, 175, true);
        trap2 = new Trap(2, 41, 176, false);
        capture = new Capture(1, 2);
        try {
            walk.setLine(line);
        } catch (DataUnavailableException e) {
            e.printStackTrace();
        }
        walk.getLine().setTraps(asList(trap1, trap2));
    }

    @After
    public void afterTests() {
        walk = null;
    }

    private void startWalk() {
        // Set up & start walk
        walk.startWalk(walk.getLine().getTraps().get(0), walk.getLine().getTraps().get(1));
        walk.addCapture(capture);
        walk.addChangedTrap(trap2);
        walk.addNewLine(line);

        // Assume walk is started and is set up correctly
        Assume.assumeTrue(Walk.isWalking().getValue());
        Assume.assumeTrue(walk.getCaptures().contains(capture));
        Assume.assumeTrue(walk.getChangedTraps().contains(trap2));
        Assume.assumeTrue(walk.getNewLines().contains(line));
        Assume.assumeNotNull(walk.getLine());
        Assume.assumeNotNull(walk.getFinishTrap());
        Assume.assumeNotNull(walk.getCurrentTrap());
    }

    @Test
    public void startWalkTest() {
        // Start walk
        walk.startWalk(trap1, trap2);

        // Assert walk has started and is set up correctly
        Assert.assertTrue(Walk.isWalking().getValue());
        Assert.assertTrue(walk.getDirection());
        Assert.assertEquals(trap1, walk.getCurrentTrap());
        Assert.assertEquals(trap2, walk.getFinishTrap());
    }

    @Test
    public void finishWalkTest() {
        // Set up walk and assume is has worked
        startWalk();

        // Finish walk
        walk.finishWalk();

        // Assert walk has finished and is reset correctly
        Assert.assertFalse(Walk.isWalking().getValue());
        Assert.assertFalse(walk.getCaptures().contains(capture));
        Assert.assertFalse(walk.getChangedTraps().contains(trap2));
        Assert.assertFalse(walk.getNewLines().contains(line));
        Assert.assertNull(walk.getLine());
        Assert.assertNull(walk.getFinishTrap());
        Assert.assertNull(walk.getCurrentTrap());
    }

    @Test
    public void finishCurrentTrapTest() {
        // Set up walk
        startWalk();

        // Finish current trap
        walk.finishCurrentTrap();

        // Assert finish current trap worked
        Assert.assertTrue(walk.getCurrentTrap().equals(trap2));
    }
}
