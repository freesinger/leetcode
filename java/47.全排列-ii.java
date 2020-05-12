import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=47 lang=java
 *
 * [47] 全排列 II
 *
 * https://leetcode-cn.com/problems/permutations-ii/description/
 *
 * algorithms
 * Medium (55.39%)
 * Likes:    244
 * Dislikes: 0
 * Total Accepted:    44.4K
 * Total Submissions: 77.2K
 * Testcase Example:  '[1,1,2]'
 *
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 * 
 * 示例:
 * 
 * 输入: [1,1,2]
 * 输出:
 * [
 * ⁠ [1,1,2],
 * ⁠ [1,2,1],
 * ⁠ [2,1,1]
 * ]
 * 
 */

// @lc code=start
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] exist = new boolean[nums.length];
        
        Arrays.sort(nums);
        backTrack(res, new ArrayList<>(), exist, nums);

        return res;
    }

    /**
     * 回溯法
     * @param list
     * @param perm
     * @param exist
     * @param nums
     */
    private void backTrack(List<List<Integer>> list, List<Integer> perm, boolean[] exist, int[] nums) {
        if (perm.size() == nums.length) {
            // 直接add list是空指针
            list.add(new ArrayList<>(perm));
        } else {
            for (int i = 0; i < nums.length; i++) {
                // 去重条件
                if (exist[i] || i > 0 && nums[i] == nums[i-1] && exist[i-1]) continue;
                exist[i] = true;
                perm.add(nums[i]);
                backTrack(list, perm, exist, nums);
                // 还原状态
                exist[i] = false;
                perm.remove(perm.size()-1);
            }
        }
    }
}
// @lc code=end

