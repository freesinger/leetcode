/*
 * @lc app=leetcode.cn id=283 lang=java
 *
 * [283] 移动零
 *
 * https://leetcode-cn.com/problems/move-zeroes/description/
 *
 * algorithms
 * Easy (57.77%)
 * Likes:    457
 * Dislikes: 0
 * Total Accepted:    93.2K
 * Total Submissions: 159.5K
 * Testcase Example:  '[0,1,0,3,12]'
 *
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 
 * 示例:
 * 
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 
 * 说明:
 * 
 * 
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 * 
 * 
 */

// @lc code=start
class Solution {
    public void moveZeroes(int[] nums) {
        // int lastFound = 0;
        // for (int i = 0; i < nums.length; i++) {
        //     if (nums[i] != 0) {
        //         nums[lastFound++] = nums[i];
        //     }
        // }

        // while (lastFound < nums.length) {
        //     nums[lastFound++] = 0;
        // }
        // 用lastFound来记录0出现的位置，依次和后续元素交换位置
        for (int lastFound = 0, i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                swap(nums, i, lastFound++);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
// @lc code=end

