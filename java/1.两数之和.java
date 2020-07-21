import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 *
 * https://leetcode-cn.com/problems/two-sum/description/
 *
 * algorithms
 * Easy (47.00%)
 * Likes:    6945
 * Dislikes: 0
 * Total Accepted:    685.9K
 * Total Submissions: 1.5M
 * Testcase Example:  '[2,7,11,15]\n9'
 *
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 *
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        if (nums.length == 1 && nums[0] == target) return new int[]{nums[0]};
        Map<Integer, Integer> map = new HashMap<>();
        //int[] rest = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            //int rest = target - nums[i];
            map.put(nums[i], i);
        }

        for (int j = 0; j < nums.length; j++) {
            if (map.get(target - nums[j]) == null) continue;
            if (map.get(target - nums[j]) != j) {
                res[0] = j;
                res[1] = map.get(target - nums[j]);
                return res;
            }
        }
        return res;
    }
}
// @lc code=end

