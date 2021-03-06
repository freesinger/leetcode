import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=581 lang=java
 *
 * [581] 最短无序连续子数组
 *
 * https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray/description/
 *
 * algorithms
 * Easy (33.11%)
 * Likes:    265
 * Dislikes: 0
 * Total Accepted:    22.4K
 * Total Submissions: 65K
 * Testcase Example:  '[2,6,4,8,10,9,15]'
 *
 * 给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 *
 * 你找到的子数组应是最短的，请输出它的长度。
 *
 * 示例 1:
 *
 *
 * 输入: [2, 6, 4, 8, 10, 9, 15]
 * 输出: 5
 * 解释: 你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
 *
 *
 * 说明 :
 *
 *
 * 输入的数组长度范围在 [1, 10,000]。
 * 输入的数组可能包含重复元素 ，所以升序的意思是<=。
 *
 *
 */

// @lc code=start
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int start = 0, end = 1;
        boolean firstAppear = false;
        int[] numsCopy = new int[nums.length];
        System.arraycopy(nums, 0, numsCopy, 0, nums.length);

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (numsCopy[i] != nums[i] && !firstAppear) {
                start = i;
                firstAppear = true;
            }
            nums[i] -= numsCopy[i];
        }
        if (!firstAppear) return 0;

        for (int j = nums.length - 1; j >= 0; j--) {
            if (nums[j] != 0) {
                end = j;
                break;
            }
        }

        return end - start + 1;
    }
}
// @lc code=end

