/*
 * @lc app=leetcode.cn id=485 lang=java
 *
 * [485] 最大连续1的个数
 *
 * https://leetcode-cn.com/problems/max-consecutive-ones/description/
 *
 * algorithms
 * Easy (54.73%)
 * Likes:    84
 * Dislikes: 0
 * Total Accepted:    30.2K
 * Total Submissions: 54K
 * Testcase Example:  '[1,0,1,1,0,1]'
 *
 * 给定一个二进制数组， 计算其中最大连续1的个数。
 * 
 * 示例 1:
 * 
 * 
 * 输入: [1,1,0,1,1,1]
 * 输出: 3
 * 解释: 开头的两位和最后的三位都是连续1，所以最大连续1的个数是 3.
 * 
 * 
 * 注意：
 * 
 * 
 * 输入的数组只包含 0 和1。
 * 输入数组的长度是正整数，且不超过 10,000。
 * 
 * 
 */

// @lc code=start
class Solution {
    /**
     * 顺序遍历一遍
     * @param nums
     * @return
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        int cnt = 0, max = 0;

        for (int i = 0; i < nums.length; i++) {
            cnt = (nums[i] != 0) ? cnt+1 : 0;
            max = Math.max(max, cnt);
        }

        return max;
    }
}
// @lc code=end

