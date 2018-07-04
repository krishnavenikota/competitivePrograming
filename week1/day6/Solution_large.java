import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import java.util.*;

import static org.junit.Assert.*;

public class Solution {

    // fill in the definitions for push(), pop(), and getMax()
    

    public static class MaxStack extends Stack {
        
        
        private Stack maxes ;

    public MaxStack() {
        maxes = new Stack() ;
    }

        public Object push(int item) {
            
             if (maxes.empty()) {
            maxes.push(item);
        } else {
            Object max = maxes.peek();
            if ( item >=(Integer) max)
            maxes.push(item);
        }
        return super.push((Integer)item);
        }

        public Object pop() {
            
            
            Object test = peek() ;
        if (test == maxes.peek()) {
            maxes.pop() ;
        }
        return super.pop();
        }

        public Object getMax() {
           if (maxes.empty()) return null ;
        return maxes.peek() ;
        }
    }


    // tests

    @Test
    public void maxStackTest() {
        final MaxStack s = new MaxStack();
        s.push(5);
        assertEquals("check max after 1st push", 5, s.getMax());
        s.push(4);
        s.push(7);
        s.push(7);
        s.push(8);
        assertEquals("check before 1st pop", 8, s.getMax());
        assertEquals("check pop #1", 8, s.pop());
        assertEquals("check max after 1st pop", 7, s.getMax());
        assertEquals("check pop #2", 7, s.pop());
        assertEquals("check max after 2nd pop", 7, s.getMax());
        assertEquals("check pop #3", 7, s.pop());
        assertEquals("check max after 3rd pop", 5, s.getMax());
        assertEquals("check pop #4", 4, s.pop());
        assertEquals("check max after 4th pop", 5, s.getMax());
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