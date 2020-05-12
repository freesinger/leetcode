import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=73 lang=java
 *
 * [73] 矩阵置零
 *
 * https://leetcode-cn.com/problems/set-matrix-zeroes/description/
 *
 * algorithms
 * Medium (54.54%)
 * Likes:    172
 * Dislikes: 0
 * Total Accepted:    27K
 * Total Submissions: 49.2K
 * Testcase Example:  '[[1,1,1],[1,0,1],[1,1,1]]'
 *
 * 给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。
 * 
 * 示例 1:
 * 
 * 输入: 
 * [
 * [1,1,1],
 * [1,0,1],
 * [1,1,1]
 * ]
 * 输出: 
 * [
 * [1,0,1],
 * [0,0,0],
 * [1,0,1]
 * ]
 * 
 * 
 * 示例 2:
 * 
 * 输入: 
 * [
 * [0,1,2,0],
 * [3,4,5,2],
 * [1,3,1,5]
 * ]
 * 输出: 
 * [
 * [0,0,0,0],
 * [0,4,5,0],
 * [0,3,1,0]
 * ]
 * 
 * 进阶:
 * 
 * 
 * 一个直接的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
 * 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
 * 你能想出一个常数空间的解决方案吗？
 * 
 * 
 */

// @lc code=start
class Solution {
    /**
     * 首行首列做标记位，先处理右下角子矩阵
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {
        int R = matrix.length, C = matrix[0].length;
        boolean firstRowHasZero = false, firstColHasZero = false;

        for (int c = 0; c < C; c++)
            if (matrix[0][c] == 0) {
                firstRowHasZero = true;
                break;
            }
            
        for (int r = 0; r < R; r++)
            if (matrix[r][0] == 0) {
                firstColHasZero = true;
                break;
            }

        for (int r = 0; r < R; r++)
            for (int c = 0; c < C; c++)
                if (matrix[r][c] == 0) {
                    matrix[0][c] = 0;
                    matrix[r][0] = 0;
                }

        for (int c = 1; c < C; c++)
            if (matrix[0][c] == 0)
                for (int r = 1; r < R; r++)
                    matrix[r][c] = 0;

        for (int r = 1; r < R; r++)
            if (matrix[r][0] == 0)
                for (int c = 1; c < C; c++)
                    matrix[r][c] = 0;

        if (firstRowHasZero)
            for (int c = 0; c < C; c++)
                matrix[0][c] = 0;
            
        if (firstColHasZero)
            for (int r = 0; r < R; r++)
                matrix[r][0] = 0;
    }
}
// @lc code=end

