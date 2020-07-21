/*
 * @lc app=leetcode.cn id=643 lang=java
 *
 * [643] 子数组最大平均数 I
 *
 * https://leetcode-cn.com/problems/maximum-average-subarray-i/description/
 *
 * algorithms
 * Easy (36.20%)
 * Likes:    80
 * Dislikes: 0
 * Total Accepted:    12.7K
 * Total Submissions: 33.3K
 * Testcase Example:  '[1,12,-5,-6,50,3]\n4'
 *
 * 给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。
 *
 * 示例 1:
 *
 * 输入: [1,12,-5,-6,50,3], k = 4
 * 输出: 12.75
 * 解释: 最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
 *
 *
 *
 *
 * 注意:
 *
 *
 * 1 <= k <= n <= 30,000。
 * 所给数据范围 [-10,000，10,000]。
 *
 *
 */

// @lc code=start
class Solution {
    /**
     * 利用连续K性质
     *
     * @param nums
     * @param k
     * @return
     */
    public double findMaxAverage(int[] nums, int k) {
        // if (nums.length < k) throw new ArithmeticException();

        int start = 0;
        double sum = 0;
        while (start < k) {
            sum += nums[start++];
        }
        double maxAvg = sum / k;

        for (int i = 0; i < nums.length - k; i++) {
            sum = sum - nums[i] + nums[i + k];
            // System.out.println(sum / k);
            maxAvg = Math.max(sum / k, maxAvg);
        }

        return maxAvg;
    }
}
// @lc code=end

