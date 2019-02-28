import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class FIFOTest {

    private FIFO fifo;

    @BeforeEach
    void setUp() {
        fifo = new FIFO();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void add() {
        int size = 0;

        fifo.add(7);
        assertEquals(fifo.size(), ++size);

        fifo.add(19);
        assertEquals(fifo.size(), ++size);

        fifo.add(3);
        assertEquals(fifo.size(), ++size);

        // first element must be 7
        assertEquals(fifo.first(), Integer.valueOf(7));
    }

    @Test
    void first() {
        assertThrows(NoSuchElementException.class, () -> fifo.first());
        // add first element
        fifo.add(5);
        assertEquals(fifo.first(), Integer.valueOf(5));

        // add an other element
        fifo.add(5);
        assertEquals(fifo.first(), Integer.valueOf(5));
    }

    @Test
    void isEmpty() {
        assertTrue(fifo.isEmpty());
        // add 1 element
        fifo.add(5);
        assertFalse(fifo.isEmpty());
        // add an other element
        fifo.add(12);
        assertFalse(fifo.isEmpty());
    }

    @Test
    void removeFirst() {
        assertThrows(NoSuchElementException.class, () -> fifo.removeFirst());

        // add 2 elements
        fifo.add(5);
        fifo.add(8);

        fifo.removeFirst();
        // first element must be 8
        assertEquals(fifo.first(), Integer.valueOf(8));

        fifo.removeFirst();
        assertTrue(fifo.isEmpty());

    }

    @Test
    void size() {

        int size = 0;
        assertEquals(fifo.size(), size);
        // add 1 element
        fifo.add(7);
        assertEquals(fifo.size(), ++size);
        // add an other element
        fifo.add(19);
        assertEquals(fifo.size(), ++size);
        // add an other element
        fifo.add(3);
        assertEquals(fifo.size(), ++size);


        // remove first element
        fifo.removeFirst();
        assertEquals(fifo.size(), --size);

        // remove an other first element
        fifo.removeFirst();
        assertEquals(fifo.size(), --size);

    }
}