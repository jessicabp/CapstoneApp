package manual.other;

import capstone.mobile.other.Validator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class ValidatorCoordinateTest {

    private String coordinate;
    private boolean expected;

    @Parameterized.Parameters
    public static Collection coordinates() {
        return Arrays.asList(new Object[][]{
                {"-40.3550", true},
                {"175.6117", true},
                {" 175.6117", false},
                {"175.6117 ", false},
                {"175 .6117", false},
                {"a175.6117", false},
                {" 175.6117b", false},
                {"1175.6117", false},
                {"175.61171", true},
                {"75.611724", true},
                {"175.6117444", true},
                {"175.61174444", false},
                {"175.611", false},
                {"--40.3550", false}
        });
    }

    public ValidatorCoordinateTest(String coordinate, boolean valid) {
        this.coordinate = coordinate;
        this.expected = valid;
    }

    @Test
    public void testIsCoordinate() {
        assertEquals(expected, Validator.isCoordinate(coordinate));
    }
}