package problems;

public class BestTimeToBuySellStock3 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1)
            return 0;

        int n = prices.length;
        int min1 = prices[0], max1 = min1, min2 = prices[n - 1], max2 = min2;
        int[][] profit = new int[n][2];
        for (int i = 0; i < n; i++) {
            if (prices[i] > max1)
                max1 = prices[i];
            profit[i][0] = max1 - min1;
            
            if (prices[i] < min1)
                min1 = max1 = prices[i];
        }
        for (int i = n - 1; i >= 0; i--) {
            if (prices[i] < min2)
                min2 = prices[i];
            profit[i][1] = max2 - min2;
            
            if (prices[i] > max2)
                min2 = max2 = prices[i];
        }
        
        int maxProfit = 0;
        for (int i = 0; i < n; i++)
            maxProfit = Math.max(maxProfit, profit[i][0] + profit[i][1]);
        return maxProfit;
    }
    
    public static void main(String[] args) {
        BestTimeToBuySellStock3 bt = new BestTimeToBuySellStock3();
        
        int[] prices = { 0, -1, 2, 1, 5, 3 };
        System.out.println(bt.maxProfit(prices));
    }
}
