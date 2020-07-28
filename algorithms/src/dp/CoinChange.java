package src.dp;

import java.util.Arrays;

/**
 * 找零
 */
public class CoinChange {
    private static final int MAX = Integer.MAX_VALUE - 10000;

    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) return -1;
        if (amount == 0) return 0;

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, MAX);
        dp[0] = 0;
        // for (int coin : coins) dp[coin] = 1;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin < 0) continue;
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }
        for (int n : dp) System.out.println(n);
        return dp[amount] == MAX ? -1 : dp[amount];
    }
}
