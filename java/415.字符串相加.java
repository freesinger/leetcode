/*
 * @lc app=leetcode.cn id=415 lang=java
 *
 * [415] 字符串相加
 *
 * https://leetcode-cn.com/problems/add-strings/description/
 *
 * algorithms
 * Easy (48.17%)
 * Likes:    125
 * Dislikes: 0
 * Total Accepted:    20.7K
 * Total Submissions: 42.4K
 * Testcase Example:  '"0"\n"0"'
 *
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 * 
 * 注意：
 * 
 * 
 * num1 和num2 的长度都小于 5100.
 * num1 和num2 都只包含数字 0-9.
 * num1 和num2 都不包含任何前导零。
 * 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。
 * 
 * 
 */

// @lc code=start
class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0, i = num1.length()-1, j = num2.length()-1;

        while (carry != 0 || i >= 0 || j >= 0) {
            if (i >= 0) carry += (num1.charAt(i--)-'0');
            if (j >= 0) carry += (num2.charAt(j--)-'0');
            sb.append(carry%10);
            carry /= 10;
        }

        return sb.reverse().toString();
    }
}
// @lc code=end

