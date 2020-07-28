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

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < length; col++) {
                if (matrix[row][col] == '1') {
                    dp[row + 1][col + 1] = 1 + Math.min(dp[row][col], Math.min(dp[row + 1][col], dp[row][col + 1]));
                    max = Math.max(max, dp[row + 1][col + 1]);
                }
            }
        }

        return max * max;
    }
}
