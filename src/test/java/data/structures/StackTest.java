package data.structures;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class StackTest {
    private Stack stack = new Stack();

    @Test
    @Order(1)
    void isEmpty() {
        assertTrue(stack.isEmpty(), "expected true");
    }

    @Test
    @Order(2)
    void pop_fail() {
        Exception exception = assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            stack.pop();
        });

        String expectedMsg = "the stack is empty";
        String actualMsg = exception.getMessage();

        assertTrue(actualMsg.contains(expectedMsg));
    }

    @Test
    @Order(3)
    void push() {
        List<String> expected = new ArrayList<>(List.of("hi world!"));
        List<String> actual = stack.push("hi world!");

        assertEquals(expected, actual);
    }

    @Test
    @Order(4)
    void top() {
        String expected = "hi world!";

        stack.push("one element");
        stack.push("hi world!");
        String actual = stack.top();

        assertEquals(expected, actual);
    }

    @Test
    @Order(5)
    void pop_ok() {
        List<String> expected = new ArrayList<>(List.of("one element"));

        stack.push("one element");
        stack.push("hi world!");

        List<String> actual = stack.pop();

        assertEquals(expected, actual);
    }
}