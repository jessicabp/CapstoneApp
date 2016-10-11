package capstone.mobile.classes;

public class Validator {

    public static boolean isCoordinate(String coordinate) {
        String pattern = "^(\\-)?\\d{2,3}\\.\\d{4,7}$";
        return coordinate.matches(pattern);
    }

    public static boolean isNumber(String number) {
        String pattern = "^[1-9]$";
        return number.matches(pattern);
    }
}

