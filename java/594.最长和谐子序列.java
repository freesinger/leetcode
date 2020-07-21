import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=594 lang=java
 *
 * [594] 最长和谐子序列
 *
 * https://leetcode-cn.com/problems/longest-harmonious-subsequence/description/
 *
 * algorithms
 * Easy (43.63%)
 * Likes:    81
 * Dislikes: 0
 * Total Accepted:    9.6K
 * Total Submissions: 20.8K
 * Testcase Example:  '[1,3,2,2,5,2,3,7]'
 *
 * 和谐数组是指一个数组里元素的最大值和最小值之间的差别正好是1。
 *
 * 现在，给定一个整数数组，你需要在所有可能的子序列中找到最长的和谐子序列的长度。
 *
 * 示例 1:
 *
 *
 * 输入: [1,3,2,2,5,2,3,7]
 * 输出: 5
 * 原因: 最长的和谐数组是：[3,2,2,2,3].
 *
 *
 * 说明: 输入的数组长度最大不超过20,000.
 *
 */

// @lc code=start
class Solution {
    public int findLHS(int[] nums) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        // HashMap<Integer, Integer> sequenceCountMap = new HashMap<>();
        int maxLen = 0;

        for (int i : nums) {
            if (!countMap.containsKey(i)) countMap.put(i, 1);
            else countMap.put(i, countMap.get(i) + 1);
        }

        for (int num : countMap.keySet()) {
            if (countMap.get(num + 1) != null)
                maxLen = Math.max(maxLen, countMap.get(num) + countMap.get(num + 1));
        }

        return maxLen;
    }
}
// @lc code=end

