import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import java.util.*;
import java.math.*;
import static org.junit.Assert.*;

public class Solution_fib {

/* If n is even then k = n/2:
F(n) = [2*F(k-1) + F(k)]*F(k)

If n is odd then k = (n + 1)/2
F(n) = F(k)*F(k) + F(k-1)*F(k-1) */
    static int[] f= new int[999];
    public static int fib(int n) {

       if (n == 0)
            return 0;
             
        if (n == 1 || n == 2)
            return (f[n] = 1);
      
        // If fib(n) is already computed
        if (f[n] != 0)
            return f[n];
      
        int k = (n & 1) == 1? (n + 1) / 2
                            : n / 2;
      
        // Applyting above formula [Note value
        // n&1 is 1 if n is odd, else 0.
        f[n] = (n & 1) == 1? (fib(k) * fib(k) + 
                        fib(k - 1) * fib(k - 1))
                       : (2 * fib(k - 1) + fib(k)) 
                       * fib(k);
      
        return f[n];
    }



    // tests

    @Test
    public void zerothFibonacciTest() {
        final int actual = fib(0);
        final int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    public void firstFibonacciTest() {
        final int actual = fib(1);
        final int expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    public void secondFibonacciTest() {
        final int actual = fib(2);
        final int expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    public void thirdFibonacciTest() {
        final int actual = fib(3);
        final int expected = 2;
        assertEquals(expected, actual);
    }

    @Test
    public void fifthFibonacciTest() {
        final int actual = fib(5);
        final int expected = 5;
        assertEquals(expected, actual);
    }

    @Test
    public void tenthFibonacciTest() {
        final int actual = fib(10);
        final int expected = 55;
        assertEquals(expected, actual);
    }

    @Test(expected = Exception.class)
    public void negativeFibonacciTest() {
        fib(-1);
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(Solution_fib.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}