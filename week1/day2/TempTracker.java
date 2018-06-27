
public class TempTracker {

    
    static int[] occurrences = new int[111]; 
    static int maxOccurrences = 0;
    static Integer mode;

  
    static int totalNumbers = 0;
    static double totalSum = 0.0;
    static Double mean;


    static Integer minTemp;
    static Integer maxTemp;

    public static void insert(int temperature) {


        occurrences[temperature]++;
        if (occurrences[temperature] > maxOccurrences) {
            mode = temperature;
            maxOccurrences = occurrences[temperature];
        }


        totalNumbers++;
        totalSum += temperature;
        mean = totalSum / totalNumbers;
        if (maxTemp == null || temperature > maxTemp) {
            maxTemp = temperature;
        }
        if (minTemp == null || temperature < minTemp) {
            minTemp = temperature;
        }
    }

    public static Integer getMax() {
        return maxTemp;
    }

    public static Integer getMin() {
        return minTemp;
    }

    public static Double getMean() {
        return mean;
    }

    public static Integer getMode() {
        return mode;
    }

    public static void main(String[] args) {
    	

    	insert(50);
    	System.out.println("max "+getMax()+" min"+getMin()+" mean "+getMean()+" mode "+getMode());
    	insert(80);
    	System.out.println("max "+getMax()+" min"+getMin()+" mean "+getMean()+" mode "+getMode());
    	insert(80);
    	System.out.println("max "+getMax()+" min"+getMin()+" mean "+getMean()+" mode "+getMode());
    	insert(30);
    	System.out.println("max "+getMax()+" min"+getMin()+" mean "+getMean()+" mode "+getMode());
    }
}