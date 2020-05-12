/*
 * @lc app=leetcode.cn id=74 lang=java
 *
 * [74] 搜索二维矩阵
 *
 * https://leetcode-cn.com/problems/search-a-2d-matrix/description/
 *
 * algorithms
 * Medium (36.35%)
 * Likes:    147
 * Dislikes: 0
 * Total Accepted:    36.1K
 * Total Submissions: 96K
 * Testcase Example:  '[[1,3,5,7],[10,11,16,20],[23,30,34,50]]\n3'
 *
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * 
 * 
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * 
 * 
 * 示例 1:
 * 
 * 输入:
 * matrix = [
 * ⁠ [1,   3,  5,  7],
 * ⁠ [10, 11, 16, 20],
 * ⁠ [23, 30, 34, 50]
 * ]
 * target = 3
 * 输出: true
 * 
 * 
 * 示例 2:
 * 
 * 输入:
 * matrix = [
 * ⁠ [1,   3,  5,  7],
 * ⁠ [10, 11, 16, 20],
 * ⁠ [23, 30, 34, 50]
 * ]
 * target = 13
 * 输出: false
 * 
 */

// @lc code=start
class Solution {
    /**
     * 找到区间进行二分查找
     * 注意二维数组为空的情况
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) return false;
        int R = matrix.length, C = matrix[0].length;
        // if (target < matrix[0][0] || target > matrix[R-1][C-1]) return false;

        for (int r = 0; r < R; r++) {
            if (matrix[r].length == 0) continue;
            if (matrix[r][0] <= target && matrix[r][C-1] >= target) {
                boolean exist = binarySearch(matrix[r], target);
                if (exist) return true;
            }
        }

        return false;
    }

    private boolean binarySearch(int[] nums, int target) {
        if (nums.length == 0) return false;
        int left = 0, right = nums.length-1;

        while (left <= right) {
            int mid = (left + (right - left) / 2);
            if (nums[left] == target || nums[right] == target || nums[mid] == target) return true;
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return false;
    }
}
// @lc code=end

