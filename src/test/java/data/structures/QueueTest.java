package data.structures;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {
    private final Queue<String> queue = new Queue<>();

    @Test
    void turn() {
        List<String> expected = List.of("turn one", "turn two");

        queue.turn("turn one");
        List<String> actual = queue.turn("turn two");

        assertEquals(expected, actual);
    }

    @Test
    void forward() {
        String itemExpected = "turn one";
        List<String> expected = List.of("turn two", "turn three");

        queue.turn("turn one");
        queue.turn("turn two");
        queue.turn("turn three");

        String itemActual = queue.forward();
        List<String> actual = queue.getData();

        assertEquals(itemExpected, itemActual);
        assertEquals(expected, actual);
    }

    @Test
    void forward_fail() {
        Exception exception = assertThrows(ArrayIndexOutOfBoundsException.class, queue::forward);

        String expectedMsg = "the data is empty";
        String actualMsg = exception.getMessage();

        assertTrue(actualMsg.contains(expectedMsg));
    }

    @Test
    void first() {
        String itemExpected = "turn one";

        queue.turn("turn one");
        queue.turn("turn two");
        queue.turn("turn three");

        String itemActual = queue.first();

        assertEquals(itemExpected, itemActual);
    }

    @Test
    void last() {
        String itemExpected = "turn three";

        queue.turn("turn one");
        queue.turn("turn two");
        queue.turn("turn three");

        String itemActual = queue.last();

        assertEquals(itemExpected, itemActual);
    }

    @Test
    void inverse() {
        List<String> expected = List.of("turn three", "turn two", "turn one");

        queue.turn("turn one");
        queue.turn("turn two");
        queue.turn("turn three");

        List<String> actual = queue.inverse();

        assertEquals(expected, actual);
    }

    @Test
    void concat() {
        List<String> expected = List.of("turn one", "turn two", "turn a", "turn b");

        List<String> tmp = List.of("turn a", "turn b");

        queue.turn("turn one");
        queue.turn("turn two");

        List<String> actual = queue.concat(tmp);

        assertEquals(expected, actual);
    }
}