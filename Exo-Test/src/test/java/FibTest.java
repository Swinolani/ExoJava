import static org.junit.jupiter.api.Assertions.*;

import org.example.simpleTest.Fib;
import org.junit.jupiter.api.Test;
import java.util.List;

public class FibTest {

    @Test
    public void testGetFibSeriesRange1() {
        // Lors du déclanchement de la fonction GetFibSeries() avec un Range de 1
        Fib fib = new Fib(1);
        List<Integer> result = fib.getFibSeries();

        // Le résultat n’est pas vide
        assertFalse(result.isEmpty(), "La liste ne doit pas être vide");

        // Le résultat correspond à une liste qui contient {0}
        assertEquals(List.of(0), result, "La liste doit contenir {0}");
    }

    @Test
    public void testGetFibSeriesRange6() {
        // Lors du déclanchement de la fonction GetFibSeries() avec un Range de 6
        Fib fib = new Fib(6);
        List<Integer> result = fib.getFibSeries();

        // Le résultat contient le chiffre 3
        assertTrue(result.contains(3), "La liste doit contenir le chiffre 3");

        // Le résultat contient 6 éléments
        assertEquals(6, result.size(), "La liste doit contenir 6 éléments");

        // Le résultat n’a pas le chiffre 4 en son sein
        assertFalse(result.contains(4), "La liste ne doit pas contenir le chiffre 4");

        // Le résultat correspond à une liste qui contient {0, 1, 1, 2, 3, 5}
        assertEquals(List.of(0, 1, 1, 2, 3, 5), result, "La liste doit contenir {0, 1, 1, 2, 3, 5}");

        // Le résultat est trié de façon ascendance
        for (int i = 1; i < result.size(); i++) {
            assertTrue(result.get(i - 1) <= result.get(i), "La liste doit être triée de façon ascendente");
        }
    }
}
