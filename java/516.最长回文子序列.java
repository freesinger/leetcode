/*
 * @lc app=leetcode.cn id=516 lang=java
 *
 * [516] 最长回文子序列
 *
 * https://leetcode-cn.com/problems/longest-palindromic-subsequence/description/
 *
 * algorithms
 * Medium (46.94%)
 * Likes:    255
 * Dislikes: 0
 * Total Accepted:    23.8K
 * Total Submissions: 42.3K
 * Testcase Example:  '"bbbab"'
 *
 * 给定一个字符串 s ，找到其中最长的回文子序列，并返回该序列的长度。可以假设 s 的最大长度为 1000 。
 * 
 * 
 * 
 * 示例 1:
 * 输入:
 * 
 * "bbbab"
 * 
 * 
 * 输出:
 * 
 * 4
 * 
 * 
 * 一个可能的最长回文子序列为 "bbbb"。
 * 
 * 示例 2:
 * 输入:
 * 
 * "cbbd"
 * 
 * 
 * 输出:
 * 
 * 2
 * 
 * 
 * 一个可能的最长回文子序列为 "bb"。
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= s.length <= 1000
 * s 只包含小写英文字母
 * 
 * 
 */

// @lc code=start
class Solution {
    public String getPalindrome(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return s.substring(l + 1, r);
    }

    public int longestPalindromeSubseq(String s) {
        String result = "";

        for (int i = 0; i < s.length(); i++) {
            String r1 = getPalindrome(s, i, i);
            String r2 = getPalindrome(s, i, i + 1);
            result = r1.length() > result.length() ? r1 : result;
            result = r2.length() > result.length() ? r2 : result;
        }

        return result.length();
    }
}
// @lc code=end

