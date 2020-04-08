package harkony.daily;

public class BestTimeToBuyAndSellStock2 {
    public static int maxProfit(int[] prices) {
        int sum = 0;
        for (int i = 0; i < prices.length-1; i++) {
            if(prices[i+1]-prices[i]>0)
                sum+=prices[i+1]-prices[i];
        }
        return sum;
    }
}
