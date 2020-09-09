package algos;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

import static org.junit.jupiter.api.Assertions.*;

class DivideAndConquerTest {
    private static DivideAndConquer divideAndConquer;

    @BeforeAll
    public static void setup() {
        divideAndConquer = new DivideAndConquer();
    }

    @Test
    void guessNumber() {
        long expected = 1999000999000999L;
        long actual = divideAndConquer.guessNumber(1999000999000999L);

        assertEquals(expected, actual);
    }
}