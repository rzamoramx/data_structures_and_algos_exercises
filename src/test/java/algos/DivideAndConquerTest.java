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

    @Test
    void coincidenceIndexIn() {
        int expected = 2;
        int actual = divideAndConquer.coincidenceIndexIn(new int[]{0,1,2,3,4,5}, 0, 5);

        assertEquals(expected, actual);
    }

    @Test
    void existsNumberIn() {
        boolean expected = false;
        boolean actual = divideAndConquer.existsNumberIn(7, new int[] {10,12,33,41,50,69,75,87,99,100});
        System.out.println("exists? " + actual);

        assertEquals(expected, actual);
    }
}