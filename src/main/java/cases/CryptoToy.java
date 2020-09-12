package cases;

import data.structures.Queue;
import data.structures.Stack;
import utils.MathUtils;

public class CryptoToy {
    private static final String VOWELS = "AEIOUaeiou";

    public static void main(String[] args) {
        String result = encode("Anacleto, agente secreto");
        System.out.println("result: " + result);
    }

    public static String encode(String message) {
        Queue<Character> xP = encodePart1(message);
        return encodePart2(xP);
    }

    public void decodePart1() {
        
    }

    public static String encodePart2(Queue<Character> xP) {
        String xPP = "";
        int n = 1;
        while (!xP.isEmpty()) {
            char x;
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
            //System.out.println("xPP: " + xPP);
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
}
