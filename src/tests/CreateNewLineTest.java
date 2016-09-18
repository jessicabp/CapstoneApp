package tests;

import org.junit.Assert;
import org.junit.Test;

import capstone.mobile.classes.Line;
import capstone.mobile.classes.Trap;

public class CreateNewLineTest {

    @Test
    public void createNewLineConstructorTest() {
        String name = "Gorge";
        String password = "Secret";

        Line newLine = new Line(name, password);

        Assert.assertEquals(newLine.getName(), name);
        Assert.assertEquals(newLine.getPassword(), password);
        Assert.assertEquals(newLine.getId(), 0);
        Assert.assertEquals(newLine.getTraps().size(), 0);
        Assert.assertTrue(newLine.isNewLine());
    }

    @Test
    public void createNewLineWithTrapsTest() {
        Line newLine = new Line("Gorge", "Secret");
        newLine.addTrap(new Trap());
        newLine.addTrap(new Trap());
        newLine.addTrap(new Trap());

        Assert.assertEquals(newLine.getTraps().size(), 3);
    }
}