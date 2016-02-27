package problems;

import java.util.Arrays;

/**
 * Leetcode: Best Time to Buy and Sell Stock IV
 * Created by alan on 2/25/2016.
 */
public class BestTimeToBuySellStock4 {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (k == 0)
            return 0;
        if (k >= n / 2)
            return maxSum(prices);

        final int[] profit = new int[k * 2 + 1];
        Arrays.fill(profit, 1, 2 * k, Integer.MIN_VALUE);
        for (int i = 0; i < n; i++) {
            for (int j = Math.min(i + 1, 2 * k); j > 0; j--)
                profit[j] = Math.max(profit[j], profit[j - 1] + (j % 2 == 0 ? prices[i] : - prices[i]));
        }
        System.out.println(Arrays.toString(profit));
        return Arrays.stream(profit).max().getAsInt();
    }

    private int maxSum(int[] prices) {
        int sum = 0;
        for (int i = 0; i < prices.length - 1; i++)
            sum += Math.max(prices[i + 1] - prices[i], 0);
        return sum;
    }

    public static void main(String[] args) {
        BestTimeToBuySellStock4 bt = new BestTimeToBuySellStock4();
        int[] prices = {1, 3, 4, 2, 5, 1};

        System.out.println(bt.maxProfit(2, prices));
    }
}
