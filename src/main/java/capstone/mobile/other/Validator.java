/*
This file is part of Trap Tracker.

Trap Tracker is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

Trap Tracker is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with Trap Tracker.  If not, see <http://www.gnu.org/licenses/>.
 */

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

