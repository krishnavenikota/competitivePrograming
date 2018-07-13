import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;

public class Solution {

    public static int[] mergeArrays(int[] arr1, int[] arr2) {

      int[] arr3 = new int[arr1.length + arr2.length];
      int i = 0, j = 0, k = 0;
      while (i < arr1.length && j < arr2.length) {
           if (arr1[i] < arr2[j]) {
               arr3[k] = arr1[i];
               i++;
           } else {
               arr3[k] = arr2[j];
               j++;
           }
           k++;
      }
 
      // Copy the remaining elements in array 1 to array 3
      if (i < arr1.length) {
         // arraycopy(source, sourcepos, dest, destpos, numOfElements)
         System.arraycopy(arr1, i, arr3, k, (arr1.length - i));
      }
 
      // Copy the remaining elements in array 2 to array 3
      if (j < arr2.length) {
         // arraycopy(source, sourcepos, dest, destpos, numOfElements)
         System.arraycopy(arr2, j, arr3, k, (arr2.length - j));
      }

        return arr3;
    }



    @Test
    public void bothArraysAreEmptyTest() {
        final int[] myArray = {};
        final int[] alicesArray = {};
        final int[] expected = {};
        final int[] actual = mergeArrays(myArray, alicesArray);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void firstArrayIsEmptyTest() {
        final int[] myArray = {};
        final int[] alicesArray = {1, 2, 3};
        final int[] expected = {1, 2, 3};
        final int[] actual = mergeArrays(myArray, alicesArray);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void secondArrayIsEmptyTest() {
        final int[] myArray = {5, 6, 7};
        final int[] alicesArray = {};
        final int[] expected = {5, 6, 7};
        final int[] actual = mergeArrays(myArray, alicesArray);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void bothArraysHaveSomeNumbersTest() {
        final int[] myArray = {2, 4, 6};
        final int[] alicesArray = {1, 3, 7};
        final int[] expected = {1, 2, 3, 4, 6, 7};
        final int[] actual = mergeArrays(myArray, alicesArray);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void arraysAreDifferentLengthsTest() {
        final int[] myArray = {2, 4, 6, 8};
        final int[] alicesArray = {1, 7};
        final int[] expected = {1, 2, 4, 6, 7, 8};
        final int[] actual = mergeArrays(myArray, alicesArray);
        assertArrayEquals(expected, actual);
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