/*
 * @lc app=leetcode.cn id=541 lang=java
 *
 * [541] 反转字符串 II
 *
 * https://leetcode-cn.com/problems/reverse-string-ii/description/
 *
 * algorithms
 * Easy (50.01%)
 * Likes:    69
 * Dislikes: 0
 * Total Accepted:    13.2K
 * Total Submissions: 24.9K
 * Testcase Example:  '"abcdefg"\n2'
 *
 * 给定一个字符串和一个整数 k，你需要对从字符串开头算起的每个 2k 个字符的前k个字符进行反转。如果剩余少于 k
 * 个字符，则将剩余的所有全部反转。如果有小于 2k 但大于或等于 k 个字符，则反转前 k 个字符，并将剩余的字符保持原样。
 *
 * 示例:
 *
 *
 * 输入: s = "abcdefg", k = 2
 * 输出: "bacdfeg"
 *
 *
 * 要求:
 *
 *
 * 该字符串只包含小写的英文字母。
 * 给定字符串的长度和 k 在[1, 10000]范围内。
 *
 *
 */

// @lc code=start
class Solution {
    /**
     * 对每2k个字符串进行翻转
     *
     * @param s
     * @param k
     * @return
     */
    public String reverseStr(String s, int k) {
        char[] strs = s.toCharArray();

        for (int i = 0; i < s.length(); i += 2 * k) {
            // end确定巧妙
            int start = i, end = Math.min(s.length() - 1, i + k - 1);
            while (start < end) {
                char tmp = strs[end];
                strs[end--] = strs[start];
                strs[start++] = tmp;
            }
        }

        return new String(strs);
    }
}
// @lc code=end

