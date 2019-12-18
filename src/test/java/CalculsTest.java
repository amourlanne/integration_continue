
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@RunWith(Parameterized.class)
class CalculsTest {

    @ParameterizedTest(name="Multiplication de {0} par {1}, resultat attendu {2}")
    @MethodSource("multiplierGetSource")
    public void multiplier(int first, int last, int result) {
        Calculs calculs = new Calculs(first,last);
        assertEquals(result,calculs.multiplier());
    }

    public static Stream<Arguments> multiplierGetSource() throws Throwable {
        return Stream.of(
                Arguments.of(2,2,4),
                Arguments.of(3,3,9),
                Arguments.of(3,4,12));
    }

    @ParameterizedTest(name="Addition de {0} par {1}, resultat attendu {2}")
    @CsvFileSource(resources = "/data.csv")
    public void additionner(int first, int last, int result) {
        Calculs calculs = new Calculs(first,last);
        assertEquals(result,calculs.additionner());
    }

    @Test
    public void diviser() {
        Calculs calculs = new Calculs(4,2);
        assertEquals(2,calculs.diviser());

        Calculs finalCalculs = new Calculs(10,0);
        assertThrows(ArithmeticException.class,() -> finalCalculs.diviser());
    }

    @Test
    public void soustraire() {
        Calculs calculs = new Calculs(2,3);
        assertEquals(-1,calculs.soustraire());

        calculs = new Calculs(8,3);
        assertEquals(5,calculs.soustraire());
    }
}
