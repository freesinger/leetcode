import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=78 lang=java
 *
 * [78] 子集
 *
 * https://leetcode-cn.com/problems/subsets/description/
 *
 * algorithms
 * Medium (75.30%)
 * Likes:    574
 * Dislikes: 0
 * Total Accepted:    90.9K
 * Total Submissions: 117.5K
 * Testcase Example:  '[1,2,3]'
 *
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 * ⁠ [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 *
 */

// @lc code=start
class Solution {
    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {
        if (nums.length == 0 || nums == null) return null;
        // LinkedList<Integer> tmp = new LinkedList<>();
        backTrack(nums, 0, new LinkedList<>());
        return res;
    }

    private void backTrack(int[] nums, int start, LinkedList<Integer> track) {
        res.add(new LinkedList<>(track)); // res.add(track); 全为[]
        for (int i = start; i < nums.length; i++) {
            track.add(nums[i]);
            backTrack(nums, i + 1, track);
            track.removeLast();
        }
    }
}
// @lc code=end

