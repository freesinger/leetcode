/*
 * @lc app=leetcode.cn id=447 lang=java
 *
 * [447] 回旋镖的数量
 *
 * https://leetcode-cn.com/problems/number-of-boomerangs/description/
 *
 * algorithms
 * Easy (55.47%)
 * Likes:    76
 * Dislikes: 0
 * Total Accepted:    9.4K
 * Total Submissions: 16.5K
 * Testcase Example:  '[[0,0],[1,0],[2,0]]'
 *
 * 给定平面上 n 对不同的点，“回旋镖” 是由点表示的元组 (i, j, k) ，其中 i 和 j 之间的距离和 i 和 k
 * 之间的距离相等（需要考虑元组的顺序）。
 *
 * 找到所有回旋镖的数量。你可以假设 n 最大为 500，所有点的坐标在闭区间 [-10000, 10000] 中。
 *
 * 示例:
 *
 *
 * 输入:
 * [[0,0],[1,0],[2,0]]
 *
 * 输出:
 * 2
 *
 * 解释:
 * 两个回旋镖为 [[1,0],[0,0],[2,0]] 和 [[1,0],[2,0],[0,0]]
 *
 *
 */

// @lc code=start
class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int res = 0;

        for (int i = 0; i < points.length - 2; i++) {
            for (int j = i + 1; j < points.length - 1; j++) {
                int ij = distanceOfPair(points[i], points[j]);
                for (int k = j + 1; k < points.length; k++) {
                    int ik = distanceOfPair(points[i], points[k]);
                    int jk = distanceOfPair(points[j], points[k]);
                    if (ij == ik) res += 2;
                    if (ij == jk) res += 2;
                    if (ik == jk) res += 2;
                }
            }
        }

        return res;
    }

    private int distanceOfPair(int[] x, int[] y) {
        return (int) (Math.pow(x[0] - y[0], 2) + Math.pow(x[1] - y[1], 2));
    }
}
// @lc code=end

