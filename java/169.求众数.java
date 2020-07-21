import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=169 lang=java
 *
 * [169] 求众数
 *
 * https://leetcode-cn.com/problems/majority-element/description/
 *
 * algorithms
 * Easy (60.58%)
 * Likes:    383
 * Dislikes: 0
 * Total Accepted:    90.5K
 * Total Submissions: 149.1K
 * Testcase Example:  '[3,2,3]'
 *
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * 示例 1:
 *
 * 输入: [3,2,3]
 * 输出: 3
 *
 * 示例 2:
 *
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 *
 *
 */

// @lc code=start
class Solution {
    public int majorityElement(int[] nums) {
        if (nums.length == 0) return Integer.valueOf(null);
        if (nums.length == 1) return nums[0];
        int res = 0;

        Map<Integer, Integer> numCount = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!numCount.containsKey(nums[i])) numCount.put(nums[i], 1);
            else numCount.put(nums[i], numCount.get(nums[i]) + 1);
            if (numCount.get(nums[i]) > (nums.length >> 1)) {
                res = nums[i];
                break;
            }
        }

        return res;
    }
}
// @lc code=end

