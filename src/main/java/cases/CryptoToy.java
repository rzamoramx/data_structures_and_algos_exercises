package cases;

import data.structures.Queue;
import data.structures.Stack;
import utils.MathUtils;

public class CryptoToy {
    private static final String VOWELS = "AEIOUaeiou";

    public static void main(String[] args) {
        String encodeResult = encode("Anacleto, agente secreto");
        System.out.println("encode result: " + encodeResult);
        String decodeResult = decode(encodeResult);
        System.out.println("decode result: " + decodeResult);
    }

    public static String decode(String message) {
        Queue<Character> xP = decodePart1(message);
        System.out.println("decode part 1: " + xP.toString());
        return decodePart2(xP);
    }

    public static String encode(String message) {
        Queue<Character> xP = encodePart1(message);
        System.out.println("encode part 1: " + xP.toString());
        return encodePart2(xP);
    }

    public static String decodePart2(Queue<Character> xP) {
        String x = "";
        Stack<Character> s = new Stack<>();
        xP.inverse();

        while (!xP.isEmpty()) {
            if (!isVowel(xP.first())) {
                s.push(xP.first());
            }
            else {
                x += dumpStackIntoString(s) + xP.first();
            }
            xP.forward();
        }

        x += dumpStackIntoString(s);
        return x;
    }

    public static Queue<Character> decodePart1(String message) {
        Queue<Character> xP = new Queue<>();
        Stack<Character> s = new Stack<>();

        int n = 1;
        for (char ch: message.toCharArray()) {
            if (!MathUtils.isEven(n))
                xP.turn(ch);
            else
                s.push(ch);
            n++;
        }

        while (!s.isEmpty()) {
            xP.turn(s.top());
            s.pop();
        }

        return xP;
    }

    public static String encodePart2(Queue<Character> xP) {
        String xPP = "";
        int n = 1;
        char x;
        while (!xP.isEmpty()) {
            if (MathUtils.isEven(n)) {
                x = xP.first();
                xP.forward();
            }
            else {
                x = xP.last();
                xP.quiteLast();
            }
            xPP += x;
            n++;
        }
        return xPP;
    }

    public static Queue<Character> encodePart1(String x) {
        Queue<Character> xP = new Queue<>();
        Stack<Character> s = new Stack<>();

        for (Character ch: x.toCharArray()) {
            if (!isVowel(ch)) {
                s.push(ch);
            }
            else {
                dumpStackIntoQueue(s, xP);
                xP.turn(ch);
            }
        }
        dumpStackIntoQueue(s, xP);
        return xP;
    }

    private static boolean isVowel(char c) {
        return VOWELS.indexOf(c) >= 0;
    }

    private static void dumpStackIntoQueue(Stack<Character> s, Queue<Character> q) {
        while (!s.isEmpty()) {
            q.turn(s.top());
            s.pop();
        }
    }

    private static String dumpStackIntoString(Stack<Character> s) {
        String x = "";
        while (!s.isEmpty()) {
            x += s.top();
            s.pop();
        }
        return x;
    }
}
