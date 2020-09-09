package algos;

public class DivideAndConquer {
    private long numberToGuess = 0;

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
