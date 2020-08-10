package src.dp;

/**
 * 最大正方形
 */
public class MaxSquare {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) return 0;

        int max = 0;
        int height = matrix.length, length = matrix[0].length;
        int[][] dp = new int[height + 1][length + 1];

        for (int i = 1; i <= height; i++) {
            for (int j = 1; j <= length; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    // 求出满足条件的最小正方形边长即可，因此是min
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max * max;
    }
}
