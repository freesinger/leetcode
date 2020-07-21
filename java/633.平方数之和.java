/*
 * @lc app=leetcode.cn id=633 lang=java
 *
 * [633] 平方数之和
 *
 * https://leetcode-cn.com/problems/sum-of-square-numbers/description/
 *
 * algorithms
 * Easy (31.75%)
 * Likes:    104
 * Dislikes: 0
 * Total Accepted:    17.9K
 * Total Submissions: 54.2K
 * Testcase Example:  '5'
 *
 * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a^2 + b^2 = c。
 *
 * 示例1:
 *
 *
 * 输入: 5
 * 输出: True
 * 解释: 1 * 1 + 2 * 2 = 5
 *
 *
 *
 *
 * 示例2:
 *
 *
 * 输入: 3
 * 输出: False
 *
 *
 */

// @lc code=start
class Solution {
    public boolean judgeSquareSum(int c) {
        int top = (int) Math.sqrt(c);

        for (int i = 0; i <= top; i++) {
            double a = Math.sqrt(c - i * i);
            if ((int) a == a) return true;
        }

        return false;
    }
}
// @lc code=end

