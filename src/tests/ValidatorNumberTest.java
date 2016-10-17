import capstone.mobile.other.Validator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class ValidatorNumberTest {

    private String number;
    private boolean expected;

    @Parameterized.Parameters
    public static Collection numbers() {
        return Arrays.asList(new Object[][]{
                {"4", true},
                {"42", true},
                {" 4", false},
                {"4 ", false},
                {"a", false},
                {"3a", false},
                {"09", false},
                {"12345", true},
                {"12000", true}
        });
    }

    public ValidatorNumberTest(String coordinate, boolean valid) {
        this.number = coordinate;
        this.expected = valid;
    }

    @Test
    public void testIsCoordinate() {
        assertEquals(expected, Validator.isNumber(number));
    }
}
