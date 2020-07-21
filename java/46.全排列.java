import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 *
 * https://leetcode-cn.com/problems/permutations/description/
 *
 * algorithms
 * Medium (72.63%)
 * Likes:    565
 * Dislikes: 0
 * Total Accepted:    88.8K
 * Total Submissions: 119.3K
 * Testcase Example:  '[1,2,3]'
 *
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 * ⁠ [1,2,3],
 * ⁠ [1,3,2],
 * ⁠ [2,1,3],
 * ⁠ [2,3,1],
 * ⁠ [3,1,2],
 * ⁠ [3,2,1]
 * ]
 *
 */

// @lc code=start
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] exist = new boolean[nums.length];

        backTrack(res, new ArrayList<>(), exist, nums);

        return res;
    }

    /**
     * 回溯法
     *
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
                if (exist[i]) continue;
                exist[i] = true;
                perm.add(nums[i]);
                backTrack(list, perm, exist, nums);
                // 还原状态
                exist[i] = false;
                perm.remove(perm.size() - 1);
            }
        }
    }
}
// @lc code=end

