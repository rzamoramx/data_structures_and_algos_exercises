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
    private final Stack<String> stack = new Stack<String>();

    @Test
    @Order(1)
    void isEmpty() {
        assertTrue(stack.isEmpty(), "expected true");
    }

    @Test
    @Order(2)
    void pop_fail() {
        Exception exception = assertThrows(ArrayIndexOutOfBoundsException.class, stack::pop);

        String expectedMsg = "the data is empty";
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

    @Test
    void interlace() {
        List<String> expected = List.of(
                "one element, second list", "one element, first list",
                "two element, second list", "two element, first list");

        stack.push("one element, first list");
        stack.push("two element, first list");

        List<String> second_list = List.of("one element, second list", "two element, second list");

        List<String> actual = stack.interlace(second_list);

        System.out.println(actual);

        assertEquals(expected, actual);
    }

    @Test
    void concat() {
        List<String> expected = List.of(
                "one element, first list", "two element, first list",
                "one element, second list", "two element, second list");

        stack.push("one element, first list");
        stack.push("two element, first list");

        List<String> second_list = List.of("one element, second list", "two element, second list");

        List<String> actual = stack.concat(second_list);

        System.out.println(actual);

        assertEquals(expected, actual);
    }

    @Test
    void dup() {
        List<String> expected = List.of(
                "one element", "one element",
                "two element", "two element");

        stack.push("one element");
        stack.push("two element");

        List<String> actual = stack.dup();

        System.out.println(actual);

        assertEquals(expected, actual);
    }

    @Test
    void inverse() {
        List<String> expected = List.of(
                "two element", "one element");

        stack.push("one element");
        stack.push("two element");

        List<String> actual = stack.inverse();

        System.out.println(actual);
        System.out.println("indexTop: " + stack.getIndexTop());

        assertEquals(expected, actual);
    }
}