package algos;

import java.util.Arrays;

public class DivideAndConquer {
    private long numberToGuess = 0;

    // ************ Coincidence number **********
    public int coincidenceIndexIn(int[] in, int i, int s) {
        System.out.println("in: " + Arrays.toString(in) + ", i: " + i + ", s: " + s);
        if (i > s)
            return -1;
        if (i == s)
            return i;

        int m = (i + s) / 2;

        if (m < in[m])
            return coincidenceIndexIn(in, i, m - 1);
        if (m == in[m])
            return m;
        if (m > in[m])
            return coincidenceIndexIn(in, m + 1, s);

        return -1;
    }

    // ************ Existing number **********
    public boolean existsNumberIn(int search, int[] in) {
        if (in.length==0)
            return false;

        if (in.length == 1 && in[0] != search)
            return false;
        else if (in.length == 1)
            return true;

        int m = (in.length-1) / 2;

        if (search == in[m]) {
            return true;
        }

        int i = 0;
        int e = m;

        if (search > in[m]) {
            i = m + 1;
            e = in.length;
        }

        System.out.println("i: " + i + ", e: " + e + ", range: " + Arrays.toString(Arrays.copyOfRange(in, i, e)));

        return existsNumberIn(search, Arrays.copyOfRange(in, i, e));
    }

    // ************ Guess number ************
    public long guessNumber(long numberToGuess) {
        this.numberToGuess = numberToGuess;

        long inf = 1;
        long sup = 1;
        // Search the limits
        while (!minorOrEqual(sup)) {
            inf = sup + 1;
            sup = 2 * sup;
            System.out.println("inf: " + inf + ", sup: " + sup);
        }
        System.out.println("ends search the limits");

        // Search the number to guess
        return binarySearch(inf, sup);
    }

    private long binarySearch(long inf, long sup) {
        if (inf == sup) {
            System.out.println("inf and sup are EQUAL, END recursion, number to guess is: " + sup);
            return inf;
        }
        else {
            long m = (inf + sup)/2;
            System.out.println("m = (inf + sup)/2 : " + m);
            if (minorOrEqual(m)) {
                System.out.println("searched is minor or equal to m ; sup = m ; inf: " + inf + ", sup: " + m);
                return binarySearch(inf, m);
            }
            else {
                System.out.println("searched is NOT minor or equal to m; inf = m + 1; inf: " + (m+1) + ", sup:" + sup);
                return binarySearch(m + 1, sup);
            }
        }
    }

    private boolean minorOrEqual(long value) {
        System.out.println("eval -> searched: " + numberToGuess + " is minorOrEqual to: "+ value + ", " + (numberToGuess <= value));
        return numberToGuess <= value;
    }
}
