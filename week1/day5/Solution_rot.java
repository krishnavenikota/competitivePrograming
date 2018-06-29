import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;

public class Solution_rot {

    public static int findRotationPoint(String[] words) {

       final String firstWord = words[0];

        int floorIndex = 0;
        int ceilingIndex = words.length;

        while (floorIndex < ceilingIndex) {

            int guessIndex = floorIndex + ((ceilingIndex - floorIndex) / 2);
            if (words[guessIndex].compareTo(firstWord) > 0) {

                floorIndex = guessIndex;
            } else {

                ceilingIndex = guessIndex;
            }

            if (floorIndex + 1 == ceilingIndex) {

                break;
            }
        }

        return ceilingIndex;
    }



    // tests

    @Test
    public void smallArrayTest() {
        final int actual = findRotationPoint(new String[] {"cape", "cake"});
        final int expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    public void mediumArrayTest() {
        final int actual = findRotationPoint(new String[] {"grape", "orange", "plum",
            "radish", "apple"});
        final int expected = 4;
        assertEquals(expected, actual);
    }

    @Test
    public void largeArrayTest() {
        final int actual = findRotationPoint(
            new String[] {"ptolemaic", "retrograde", "supplant", "undulate", "xenoepist",
            "asymptote", "babka", "banoffee", "engender", "karpatka", "othellolagkage"});
        final int expected = 5;
        assertEquals(expected, actual);
    }

    @Test
    public void possiblyMissingEdgeCaseTest() {
        // are we missing any edge cases?
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(Solution_rot.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}