/*
 * @lc app=leetcode.cn id=15 lang=java
 *
 * [15] 三数之和
 *
 * https://leetcode-cn.com/problems/3sum/description/
 *
 * algorithms
 * Medium (24.46%)
 * Likes:    2422
 * Dislikes: 0
 * Total Accepted:    286.9K
 * Total Submissions: 997.1K
 * Testcase Example:  '[-1,0,1,2,-1,-4]'
 *
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0
 * ？请你找出所有满足条件且不重复的三元组。
 * 
 * 注意：答案中不可以包含重复的三元组。
 * 
 * 
 * 
 * 示例：
 * 
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * 
 * 满足要求的三元组集合为：
 * [
 * ⁠ [-1, 0, 1],
 * ⁠ [-1, -1, 2]
 * ]
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        if (nums == null || nums.length < 3) return res;
        Arrays.sort(nums);
        if (nums[0] > 0) return res;
        // List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        // Set<Integer> set = new HashSet<>(l);

        for (int i = 0; i < nums.length; i++) {
            // 去重
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int cur = nums[i];
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int curSum = nums[left] + nums[right] + cur;
                if (curSum > 0) {
                    right--;
                } else if (curSum < 0) {
                    left++;
                } else {
                    res.add(Arrays.asList(cur, nums[left], nums[right]));
                    // 去重
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (right > left && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                }
            }
        }

        return res;
    }
}
// @lc code=end

