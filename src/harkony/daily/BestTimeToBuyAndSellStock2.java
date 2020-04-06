package harkony.daily;

public class BestTimeToBuyAndSellStock2 {
    public static int maxProfit(int[] prices) {
        int sum = 0;
        int buy = -1;
        if(prices.length<2)
            return 0;

        for (int i = 0; i < prices.length-1; i++) {
            if(prices[i+1]>prices[i]){
                if(buy==-1 || prices[i]<=buy) {
                    buy = prices[i];
                }
            }
            if(prices[i]>prices[i+1]){
                if(buy!=-1) {
                    sum += (prices[i] - buy);
                    buy=-1;
                }
            }

        }
        if(prices[prices.length-1] >= prices[prices.length-2] && buy!=-1)
            sum+=(prices[prices.length-1]-buy);

        return sum;
    }
}
