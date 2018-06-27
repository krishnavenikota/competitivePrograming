public class AppleStock{

    public static int getMaxProfit(int[] stockPricesYesterday) {

      
        if (stockPricesYesterday.length < 2) {
            throw new IllegalArgumentException("Getting a profit requires at least 2 prices");
        }
        int minPrice = stockPricesYesterday[0];
        int maxProfit = stockPricesYesterday[1] - stockPricesYesterday[0];   
        for (int i = 1; i < stockPricesYesterday.length; i++) {
            int currentPrice = stockPricesYesterday[i];           
            int potentialProfit = currentPrice - minPrice;
            maxProfit = Math.max(maxProfit, potentialProfit);
            minPrice = Math.min(minPrice, currentPrice);
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int[] test = new int[] {1, 2, 3, 4, 5};
        System.out.println(getMaxProfit(test));
        int[] test2 = new int[] {5, 4, 2};
        System.out.println(getMaxProfit(test2));
        int[] test3 = new int[] {10, 9, 19, 5, 8, 7, 13};
        System.out.println(getMaxProfit(test3));

    }
}