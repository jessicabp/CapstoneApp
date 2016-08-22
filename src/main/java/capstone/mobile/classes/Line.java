package capstone.mobile.classes;

import java.util.List;

import static java.util.Arrays.asList;


public class Line {

    private static int currentTrap = 0;

    private static List<String> trapLocations = asList("left", "right", "left");

    public static String getSide(int index) {
        return trapLocations.get(index);
    }

    public static int getCurrentTrap() {
        return currentTrap;
    }

    public static void getNextTrap() {
        currentTrap += 1;
    }
}
