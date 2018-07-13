import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;

public class Solution {

    public static Integer findDuplicate(int[] data) {

            int idx = 0 ;
        int val_at_next_idx = 0 ;
        int next_idx = 0 ;
        int store = 0 ;
        while (idx < data.length) {
            next_idx = data[idx] ;

            if (idx == next_idx ) {
                idx++ ;
                continue ;
            }

            val_at_next_idx = data[next_idx] ;

            while ( val_at_next_idx != next_idx ) {
                data[next_idx] = next_idx ;
                next_idx =  val_at_next_idx;
                val_at_next_idx = data[next_idx] ;
            }
            return val_at_next_idx ;
        }
        return null ;
    
    }


    // tests

    @Test
    public void justTheRepeatedNumberTest() {
        final int[] numbers = {1, 1};
        final int expected = 1;
        final int actual = findDuplicate(numbers);
        assertEquals(expected, actual);
    }

    @Test
    public void shortArrayTest() {
        final int[] numbers = {1, 2, 3, 2};
        final int expected = 2;
        final int actual = findDuplicate(numbers);
        assertEquals(expected, actual);
    }

    @Test
    public void mediumArrayTest() {
        final int[] numbers = {1, 2, 5, 5, 5, 5};
        final int expected = 5;
        final int actual = findDuplicate(numbers);
        assertEquals(expected, actual);
    }

    @Test
    public void longArrayTest() {
        final int[] numbers = {4, 1, 4, 8, 3, 2, 7, 6, 5};
        final int expected = 4;
        final int actual = findDuplicate(numbers);
        assertEquals(expected, actual);
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