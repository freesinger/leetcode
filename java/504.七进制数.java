/*
 * @lc app=leetcode.cn id=504 lang=java
 *
 * [504] 七进制数
 *
 * https://leetcode-cn.com/problems/base-7/description/
 *
 * algorithms
 * Easy (46.97%)
 * Likes:    37
 * Dislikes: 0
 * Total Accepted:    10.5K
 * Total Submissions: 21.6K
 * Testcase Example:  '100'
 *
 * 给定一个整数，将其转化为7进制，并以字符串形式输出。
 *
 * 示例 1:
 *
 *
 * 输入: 100
 * 输出: "202"
 *
 *
 * 示例 2:
 *
 *
 * 输入: -7
 * 输出: "-10"
 *
 *
 * 注意: 输入范围是 [-1e7, 1e7] 。
 *
 */

// @lc code=start
class Solution {
    public String convertToBase7(int num) {
        if (num == 0) return "0";
        StringBuilder res = new StringBuilder();
        // res.append(num < 0 ? "-" : "");
        boolean postive = num > 0 ? true : false;

        long n = Math.abs(num);
        while (n != 0) {
            res.insert(0, n % 7);
            n /= 7;
        }
        res.insert(0, postive ? "" : "-");

        return res.toString();
    }
}
// @lc code=end

