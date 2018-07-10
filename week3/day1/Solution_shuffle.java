import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;

public class Solution {

    public static boolean isSingleRiffle(int[] half1, int[] half2, int[] deck) {

       int h1 = 0 ;
        int h2 = 0 ;
        int half1max=half1.length-1;
        int half2max=half2.length-1;
        for (int card:deck) {
            if (h1<=half1max && card==half1[h1]  ) {
                h1++ ;

            }
            else if (h2<=half2max&& card==half2[h2] ) {
                h2++ ;
            }
            else{
            return false;
        }
    }
        return true ;

}

    @Test
    public void bothHalvesAreTheSameLengthTest() {
        final int[] half1 = {1, 4, 5};
        final int[] half2 = {2, 3, 6};
        final int[] shuffledDeck = {1, 2, 3, 4, 5, 6};
        final boolean result = isSingleRiffle(half1, half2, shuffledDeck);
        assertTrue(result);
    }

    @Test
    public void halvesAreDifferentLengthsTest() {
        final int[] half1 = {1, 5};
        final int[] half2 = {2, 3, 6};
        final int[] shuffledDeck = {1, 2, 6, 3, 5};
        final boolean result = isSingleRiffle(half1, half2, shuffledDeck);
        assertFalse(result);
    }

    @Test
    public void oneHalfIsEmptyTest() {
        final int[] half1 = {};
        final int[] half2 = {2, 3, 6};
        final int[] shuffledDeck = {2, 3, 6};
        final boolean result = isSingleRiffle(half1, half2, shuffledDeck);
        assertTrue(result);
    }

    @Test
    public void shuffledDeckIsMissingCardsTest() {
        final int[] half1 = {1, 5};
        final int[] half2 = {2, 3, 6};
        final int[] shuffledDeck = {1, 6, 3, 5};
        final boolean result = isSingleRiffle(half1, half2, shuffledDeck);
        assertFalse(result);
    }

    @Test
    public void shuffledDeckHasExtraCards() {
        final int[] half1 = {1, 5};
        final int[] half2 = {2, 3, 6};
        final int[] shuffledDeck = {1, 2, 3, 5, 6, 8};
        final boolean result = isSingleRiffle(half1, half2, shuffledDeck);
        assertFalse(result);
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(Solution.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}