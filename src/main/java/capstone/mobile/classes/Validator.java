package capstone.mobile.classes;

public class Validator {

    // TODO: comment and determine allowed format
    public static boolean isCoordinate(String coordinate) {
        String pattern = "^(\\-)?\\d{2,3}\\.\\d{4}$";
        return coordinate.matches(pattern);
    }

    // TODO: comment
    public static boolean isNumber(String number) {
        String pattern = "^[1-9]$";
        return number.matches(pattern);
    }
}

