/*
 * @lc app=leetcode.cn id=812 lang=java
 *
 * [812] 最大三角形面积
 *
 * https://leetcode-cn.com/problems/largest-triangle-area/description/
 *
 * algorithms
 * Easy (58.19%)
 * Likes:    37
 * Dislikes: 0
 * Total Accepted:    4.9K
 * Total Submissions: 8.3K
 * Testcase Example:  '[[0,0],[0,1],[1,0],[0,2],[2,0]]'
 *
 * 给定包含多个点的集合，从其中取三个点组成三角形，返回能组成的最大三角形的面积。
 * 
 * 
 * 示例:
 * 输入: points = [[0,0],[0,1],[1,0],[0,2],[2,0]]
 * 输出: 2
 * 解释: 
 * 这五个点如下图所示。组成的橙色三角形是最大的，面积为2。
 * 
 * 
 * 
 * 
 * 注意: 
 * 
 * 
 * 3 <= points.length <= 50.
 * 不存在重复的点。
 * -50 <= points[i][j] <= 50.
 * 结果误差值在 10^-6 以内都认为是正确答案。
 * 
 * 
 */

// @lc code=start
class Solution {
    public double largestTriangleArea(int[][] points) {
        double S = 0;

        for (int i = 0; i < points.length; i++)
            for (int j = i+1; j < points.length; j++)
                for (int k = j+1; k < points.length; k++)
                    // S = Math.max(getSquare(points[i], points[j], points[k]), S);
                    S = Math.max(S, area(points[i], points[j], points[k]));

        return S;
    }

    private double getSquare(int[] a, int[] b, int[] c) {
        double x, y, z;
        x = getLength(a, b);
        y = getLength(a, c);
        z = getLength(c, b);

        // 使用Helen公式求面积
        double p = (x + y + z) / 2;
        
        // return Math.sqrt(p * (p - x) * (p - y) * (p - z));
        // 三点一线需要取绝对值
        return Math.sqrt(Math.abs(p * (p - x) * (p - y) * (p - z)));
    }

    private double getLength(int[] a, int[] b) {
        return Math.sqrt(Math.pow((a[0] - b[0]), 2) + Math.pow((a[1] - b[1]), 2));
        //return Math.sqrt((a[0] - b[0])*(a[0] - b[0]) + (a[1] - b[1])*(a[1] - b[1]));
    }

    /**
     * 鞋带公式
     * @reference: https://blog.csdn.net/stereohomology/article/details/46942889?utm_source=distribute.pc_relevant.none-task
     */
    public double area(int[] P, int[] Q, int[] R) {
        return 0.5 * Math.abs(P[0]*Q[1] + Q[0]*R[1] + R[0]*P[1]
                             -P[1]*Q[0] - Q[1]*R[0] - R[1]*P[0]);
    }

}
// @lc code=end

