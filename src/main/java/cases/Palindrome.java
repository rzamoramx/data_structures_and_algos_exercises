package cases;

import data.structures.Queue;
import data.structures.Stack;

public class Palindrome {
    public static void main(String[] args) {
        String sentence = "dabale arroz a la zorra el abad";

        boolean isPalindrome = isPalindromeUsingStack(sentence);
        if (isPalindrome)
            System.out.println("IS palindrome, using STACK");
        else
            System.out.println("is NOT palindrome, using STACK");

        isPalindrome = isPalindromeUsingQueue(sentence);
        if (isPalindrome)
            System.out.println("IS palindrome, using QUEUE");
        else
            System.out.println("is NOT palindrome, using QUEUE");
    }

    public static boolean isPalindromeUsingQueue(String sentence) {
        sentence = sentence.replace(" ", "");
        System.out.println(sentence);

        Queue<Character> input = new Queue<>();

        sentence.chars()
                .mapToObj(i -> (char)i)
                .forEach(input::turn);

        boolean b = true;
        while (b && !input.isEmpty()) {
            b = input.first().equals(input.last());
            input.forward();
            if (!input.isEmpty())
                input.quiteLast();
            System.out.println(input.toString());
        }

        input = null;
        return b;
    }

    public static boolean isPalindromeUsingStack(String sentence) {
        sentence = sentence.replace(" ", "");
        System.out.println(sentence);

        Stack<Character> input = new Stack<>();

        sentence.chars()
                .mapToObj(i -> (char)i)
                .forEach(input::push);

        Stack<Character> tmp = new Stack<>();

        for (int i=0; i < sentence.length()/2; i++) {
            char top = input.top();
            input.pop();
            tmp.push(top);
        }

        if (sentence.length()%2 != 0)
            input.pop();

        boolean b = true;
        while (b && !input.isEmpty()) {
            b = tmp.top().equals(input.top());
            input.pop();
            tmp.pop();
            System.out.println(input.toString());
            System.out.println(tmp.toString());
        }

        input = null; tmp = null;
        return b;
    }
}
