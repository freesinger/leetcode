/*
 * @lc app=leetcode.cn id=67 lang=java
 *
 * [67] 二进制求和
 *
 * https://leetcode-cn.com/problems/add-binary/description/
 *
 * algorithms
 * Easy (51.31%)
 * Likes:    266
 * Dislikes: 0
 * Total Accepted:    49.9K
 * Total Submissions: 97K
 * Testcase Example:  '"11"\n"1"'
 *
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 *
 * 输入为非空字符串且只包含数字 1 和 0。
 *
 * 示例 1:
 *
 * 输入: a = "11", b = "1"
 * 输出: "100"
 *
 * 示例 2:
 *
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 *
 */

// @lc code=start
class Solution {
    public String addBinary(String a, String b) {
        int la = a.length() - 1;
        int lb = b.length() - 1;
        boolean carry = false;
        StringBuilder sb = new StringBuilder((la > lb ? la : lb) + 1);

        while (la >= 0 || lb >= 0) {
            char ca = (la >= 0) ? a.charAt(la--) : '0';
            char cb = (lb >= 0) ? b.charAt(lb--) : '0';

            if (ca == '1' && cb == '1') {
                sb.append((carry) ? '1' : '0');
                carry = true;
            } else if (ca == '0' && cb == '0') {
                sb.append((carry) ? '1' : '0');
                carry = false;
            } else {
                // carry stays the same here
                sb.append((carry) ? '0' : '1');
            }
        }
        if (carry) sb.append('1');
        return sb.reverse().toString();
    }
}
// @lc code=end

