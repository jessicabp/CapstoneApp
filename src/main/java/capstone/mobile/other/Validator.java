package capstone.mobile.other;

/**
 * Validates user entered values for allowed format.
 */
public class Validator {

    /**
     * Determines if the provided string is correctly formatted as a coordinate. The allowed format consists of an
     * optional minus sign, followed by 2-3 digits, a period, and then 4-7 digits.
     *
     * @param coordinate String representation of coordinate value
     * @return boolean true if coordinate in correct format
     */
    public static boolean isCoordinate(final String coordinate) {
        final String pattern = "^(\\-)?\\d{1,3}\\.\\d{4,7}$";
        return coordinate.matches(pattern);
    }

    /**
     * Determines if the provided number is an allowed trap number. Trap numbers must start with a non-zero digit, and
     * may contain up to 5 digits.
     *
     * @param number String representation of number value
     * @return boolean true if number in correct format
     */
    public static boolean isNumber(final String number) {
        final String pattern = "^[1-9]\\d{0,4}$";
        return number.matches(pattern);
    }
}

