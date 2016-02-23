package problems;

import java.util.Arrays;

/**
 * Leetcode: Coin Change
 * Created by alan on 2/23/2016.
 */
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] count = new int[amount + 1];

        for (int i = 1; i <= amount; i++) {
            int min = -1;
            for (int c : coins) {
                int t = i - c; // previous amount to add coin c
                if (t >= 0 && count[t] >= 0 && (min < 0 || min > count[t] + 1))
                    min = count[t] + 1;
            }
            count[i] = min;
        }
        return count[amount];
    }

    public static void main(String[] args) {
        CoinChange cc = new CoinChange();
        int[] coins = {1, 2, 5};
        int amount = 11;

        System.out.println(Arrays.toString(coins) + " - " + amount + " : " + cc.coinChange(coins, amount));
    }
}
