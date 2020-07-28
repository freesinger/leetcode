/*
 * @lc app=leetcode.cn id=221 lang=java
 *
 * [221] 最大正方形
 *
 * https://leetcode-cn.com/problems/maximal-square/description/
 *
 * algorithms
 * Medium (38.54%)
 * Likes:    490
 * Dislikes: 0
 * Total Accepted:    63.4K
 * Total Submissions: 148.9K
 * Testcase Example:  '[["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]'
 *
 * 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
 * 
 * 示例:
 * 
 * 输入: 
 * 
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 * 
 * 输出: 4
 * 
 */

// @lc code=start
class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) return 0;

        int max = 0;
        int height = matrix.length, length = matrix[0].length;
        int[][] dp = new int[height + 1][length + 1];

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < length; col++) {
                if (matrix[row][col] == '1') {
                    dp[row+1][col+1] = 1 + Math.min(dp[row][col], Math.min(dp[row+1][col], dp[row][col+1]));
                    max = Math.max(max, dp[row+1][col+1]);
                }
            }
        }
        
        return max * max;
    }
}
// @lc code=end

