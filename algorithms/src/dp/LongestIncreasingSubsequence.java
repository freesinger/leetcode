package src.dp;

import java.util.Arrays;

/**
 * 求最长递增子序列
 */
public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        int[] test = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(LIS(test));
    }

    private static int LIS(int[] nums) {
        int[] dp = new int[nums.length];

        Arrays.fill(dp, 1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        System.out.println(Arrays.toString(dp));

        return dp[nums.length - 1];
    }
}
