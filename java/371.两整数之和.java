/*
 * @lc app=leetcode.cn id=371 lang=java
 *
 * [371] 两整数之和
 *
 * https://leetcode-cn.com/problems/sum-of-two-integers/description/
 *
 * algorithms
 * Easy (52.56%)
 * Likes:    178
 * Dislikes: 0
 * Total Accepted:    20.1K
 * Total Submissions: 37.8K
 * Testcase Example:  '1\n2'
 *
 * 不使用运算符 + 和 - ​​​​​​​，计算两整数 ​​​​​​​a 、b ​​​​​​​之和。
 *
 * 示例 1:
 *
 * 输入: a = 1, b = 2
 * 输出: 3
 *
 *
 * 示例 2:
 *
 * 输入: a = -2, b = 3
 * 输出: 1
 *
 */

// @lc code=start
class Solution {
    public int getSum(int a, int b) {
        while (b != 0) {
            int tmp = a ^ b;
            b = (a & b) << 1;
            a = tmp;
        }
        return a;
    }
}
// @lc code=end

