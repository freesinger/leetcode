import java.util.Arrays;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=56 lang=java
 *
 * [56] 合并区间
 *
 * https://leetcode-cn.com/problems/merge-intervals/description/
 *
 * algorithms
 * Medium (39.16%)
 * Likes:    332
 * Dislikes: 0
 * Total Accepted:    65.5K
 * Total Submissions: 160.4K
 * Testcase Example:  '[[1,3],[2,6],[8,10],[15,18]]'
 *
 * 给出一个区间的集合，请合并所有重叠的区间。
 *
 * 示例 1:
 *
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 *
 *
 * 示例 2:
 *
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *
 */

// @lc code=start
class Solution {
    /**
     * 排序后考虑右边界情况
     *
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0 || intervals[0].length == 0) return intervals;
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        LinkedList<int[]> res = new LinkedList<>();
        
        for (int i = 0; i < intervals.length; i++) {
            if (res.size() == 0 || res.getLast()[1] < intervals[i][0]) {
                res.add(intervals[i]);
            } else {
                res.getLast()[1] = Math.max(res.getLast()[1], intervals[i][1]);
            }
        }
        
        return res.toArray(new int[res.size()-1][]);
    }
}
// @lc code=end

