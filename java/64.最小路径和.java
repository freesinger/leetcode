/*
 * @lc app=leetcode.cn id=64 lang=java
 *
 * [64] 最小路径和
 *
 * https://leetcode-cn.com/problems/minimum-path-sum/description/
 *
 * algorithms
 * Medium (63.05%)
 * Likes:    472
 * Dislikes: 0
 * Total Accepted:    86.7K
 * Total Submissions: 132.3K
 * Testcase Example:  '[[1,3,1],[1,5,1],[4,2,1]]'
 *
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步。
 *
 * 示例:
 *
 * 输入:
 * [
 * [1,3,1],
 * ⁠ [1,5,1],
 * ⁠ [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 *
 *
 */

// @lc code=start
class Solution {
    /**
     * DP
     * 不需要使用额外空间
     * base case直接在原数组上赋值
     */
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        // int[][] dpTable = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i + j == 0) continue;
                if (i == 0) grid[i][j] += grid[i][j - 1];
                if (j == 0) grid[i][j] += grid[i - 1][j];
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }

        return grid[m - 1][n - 1];
        // for (int i = 0; i < m; i++)
        //     Arrays.fill(dpTable[i], Integer.MAX_VALUE);
        // dpTable[0][0] = grid[0][0];

        // for (int i = 0; i < m; i++) {
        //     for (int j = 0; j < n; j++) {
        //         int curNum = dpTable[i][j];
        //         if (j == n-1 && i <= m-2) {
        //             dpTable[i+1][j] = Math.min(curNum+grid[i+1][j], dpTable[i+1][j]);
        //         } else if (i == m-1 && j <= n-2) {
        //             dpTable[i][j+1] = Math.min(curNum+grid[i][j+1], dpTable[i][j+1]);
        //         } else if (i+j < m+n-2) {
        //             dpTable[i][j+1] = Math.min(curNum+grid[i][j+1], dpTable[i][j+1]);
        //             dpTable[i+1][j] = Math.min(curNum+grid[i+1][j], dpTable[i+1][j]);
        //         }
        //     }
        // }

        // return dpTable[m-1][n-1];
    }
}
// @lc code=end

