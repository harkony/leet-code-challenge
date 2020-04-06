package harkony.daily;

public class BestTimeToBuyAndSellStock2 {
    public static int maxProfit(int[] prices) {
        int sum = 0;
        int buy = -1;
        if(prices.length<2)
            return 0;

        for (int i = 0; i < prices.length-1; i++) {
            int current=prices[i];
            int future=prices[i+1];
            if(future>current){
                if(buy==-1 || current<=buy) {
                    buy = current;
                }
            }
            if(current>future){
                if(buy!=-1) {
                    sum += (current - buy);
                    buy=-1;
                }
            }

        }
        if(prices[prices.length-1] >= prices[prices.length-2] && buy!=-1)
            sum+=(prices[prices.length-1]-buy);

        return sum;
    }
}
