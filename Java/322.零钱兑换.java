import java.util.Arrays;
import java.util.Comparator;

/*
 * @lc app=leetcode.cn id=322 lang=java
 *
 * [322] 零钱兑换
 *
 * https://leetcode-cn.com/problems/coin-change/description/
 *
 * algorithms
 * Medium (36.34%)
 * Likes:    721
 * Dislikes: 0
 * Total Accepted:    110.3K
 * Total Submissions: 271.8K
 * Testcase Example:  '[1,2,5]\n11'
 *
 * 给定不同面额的硬币 coins 和一个总金额
 * amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3 
 * 解释: 11 = 5 + 5 + 1
 * 
 * 示例 2:
 * 
 * 输入: coins = [2], amount = 3
 * 输出: -1
 * 
 * 
 * 
 * 说明:
 * 你可以认为每种硬币的数量是无限的。
 * 
 */

// @lc code=start
class Solution {
    private static final int MAX = Integer.MAX_VALUE - 10000;
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) return -1;
        if (amount == 0) return 0;
        
        int[] dp = new int[amount+1];
        Arrays.fill(dp, MAX);
        dp[0] = 0;
        // for (int coin : coins) dp[coin] = 1;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin < 0) continue;
                dp[i] = Math.min(dp[i], 1+dp[i-coin]);
            }
        }
        for (int n : dp) System.out.println(n);
        return dp[amount] ==MAX ? -1 : dp[amount];
    }
}
// @lc code=end

