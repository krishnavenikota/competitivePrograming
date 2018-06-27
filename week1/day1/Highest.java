  
public class Highest{
 
  public static int maximumProduct(int[] nums) {
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE, min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        for (int n : nums) {
            if (n > max1) {
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if (n > max2) {
                max3 = max2;
                max2 = n;
            } else if (n > max3) {
                max3 = n;
            }

            if (n < min1) {
                min2 = min1;
                min1 = n;
            } else if (n < min2) {
                min2 = n;
            }
        }
        return Math.max(max1*max2*max3, max1*min1*min2);
    }


    public static void main(String[] args) {
        Highest h=new Highest();
        int arr[] = {10, 3, 5, 6, 2};
        System.out.println("The product is : ");
        int r1= h.maximumProduct(arr);
        System.out.println(r1);
        int arr1[] = {1, 7, 3, 2};
        System.out.println("\n");
        System.out.println("The product is : ");
        int r2=h.maximumProduct(arr1);
         System.out.println(r2);
    }
}