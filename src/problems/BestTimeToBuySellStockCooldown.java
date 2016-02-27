package problems;

/**
 * Leetcode: Best Time to Buy and Sell Stock with Cooldown
 * Created by alan on 2/25/2016.
 */
public class BestTimeToBuySellStockCooldown {
    public int maxProfit(int[] prices) {
        if (prices.length < 2)
            return 0;
        int[] buy = new int[prices.length];
        int[] sell = new int[prices.length];

        buy[0] = -prices[0];
        buy[1] = -Math.min(prices[0], prices[1]);
        sell[1] = Math.max(prices[1] - prices[0], 0);
        for (int i = 2; i < prices.length; i++) {
            buy[i] = Math.max(sell[i - 2] - prices[i], buy[i - 1]);
            sell[i] = Math.max(buy[i - 1] + prices[i], sell[i - 1]);
        }
        return sell[prices.length - 1];
    }

    public static void main(String[] args) {
        BestTimeToBuySellStockCooldown bt = new BestTimeToBuySellStockCooldown();
        int[] prices = {1, 2, 3, 0, 2};

        System.out.println(bt.maxProfit(prices));
    }
}
