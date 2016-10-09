package capstone.mobile.classes;

public class Validator {

    // TODO: determine allowed format
    public static boolean validateCoordinate(String coordinate) {
        String pattern = "^(\\-)?\\d{2,3}\\.\\d{4}$";
        return coordinate.matches(pattern);
    }
}

