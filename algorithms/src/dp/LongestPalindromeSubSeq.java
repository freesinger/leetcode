package src.dp;

import java.util.Arrays;

/**
 * 最长回文子序列
 * ref：https://github.com/labuladong/fucking-algorithm/blob/master/%E5%8A%A8%E6%80%81%E8%A7%84%E5%88%92%E7%B3%BB%E5%88%97/%E5%AD%90%E5%BA%8F%E5%88%97%E9%97%AE%E9%A2%98%E6%A8%A1%E6%9D%BF.md
 *
 */
public class LongestPalindromeSubSeq {
    public static void main(String[] args) {
        System.out.println(LPS(new int[]{3, 2, 1, 5, 2, 6, 8, 3}));
    }

    private static int LPS(int[] nums) {
        int len = nums.length;
        int[][] dp = new int[len][len];

        for (int i = 0; i < len; i++) {
            Arrays.fill(dp[i], 0);
        }
        for (int i = 0; i < len; i++) {
            dp[i][i] = 1;
        }

        // 自底向上遍历
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                if (nums[i] == nums[j]) {
                    dp[i][j] = 2 + dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                }
            }
        }

        return dp[0][len - 1];
    }
}
