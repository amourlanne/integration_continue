import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class TriTableauTest {

    private int tableau[];

    @BeforeEach
    void setUp() {
        tableau = new int[]{5, 2, 1, 7, 3, 4, 8, 18, 11};
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void trier() {
        try {
            TriTableau.trier(tableau);

            // same test as TriDecroissant
            // retrieve first value
            int _i = tableau[0];

            for (int i : tableau ) {
                assertTrue( _i >= i);
                _i = i;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void triCroissant() {
        TriTableau.triCroissant(tableau);

        // retrieve first value
        int _i = tableau[0];

        for (int i : tableau ) {
            assertTrue( _i <= i);
            _i = i;
        }
    }

    @Test
    void triDecroissant() {
        TriTableau.triDecroissant(tableau);

        // retrieve first value
        int _i = tableau[0];

        for (int i : tableau ) {
            assertTrue( _i >= i);
            _i = i;
        }
    }
}