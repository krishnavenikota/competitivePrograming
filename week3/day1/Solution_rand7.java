import java.util.Random;

class Solution {

    private static final Random rnd = new Random();

    private static int rand5() {
        return rnd.nextInt(5) + 1;
    }

    public static int rand7() {

        // implement rand7() using rand5()
      int total = 0 ;

        for (int i=0; i<7; i++){
            total = total + rand5();
        }

        return total / 7;

    }

    public static void main(String[] args) {
        for (int i = 0; i < 14; i++) {
            System.out.printf("%d ", rand7());
        }
        System.out.println();
    }
}