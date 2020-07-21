/*
 * @lc app=leetcode.cn id=1143 lang=java
 *
 * [1143] 最长公共子序列
 *
 * https://leetcode-cn.com/problems/longest-common-subsequence/description/
 *
 * algorithms
 * Medium (57.73%)
 * Likes:    111
 * Dislikes: 0
 * Total Accepted:    18.7K
 * Total Submissions: 31.5K
 * Testcase Example:  '"abcde"\n"ace"'
 *
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列的长度。
 *
 * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde"
 * 的子序列。两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。
 *
 * 若这两个字符串没有公共子序列，则返回 0。
 *
 *
 *
 * 示例 1:
 *
 * 输入：text1 = "abcde", text2 = "ace"
 * 输出：3
 * 解释：最长公共子序列是 "ace"，它的长度为 3。
 *
 *
 * 示例 2:
 *
 * 输入：text1 = "abc", text2 = "abc"
 * 输出：3
 * 解释：最长公共子序列是 "abc"，它的长度为 3。
 *
 *
 * 示例 3:
 *
 * 输入：text1 = "abc", text2 = "def"
 * 输出：0
 * 解释：两个字符串没有公共子序列，返回 0。
 *
 *
 *
 *
 * 提示:
 *
 *
 * 1 <= text1.length <= 1000
 * 1 <= text2.length <= 1000
 * 输入的字符串只含有小写英文字符。
 *
 *
 */

// @lc code=start
class Solution {
    /**
     * 使用dp表优化递归
     *
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int t1Len = text1.length();
        int t2Len = text2.length();
        int dpTable[][] = new int[t1Len + 1][t2Len + 1];

        for (int i = 1; i < t1Len + 1; i++) {
            for (int j = 1; j < t2Len + 1; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dpTable[i][j] = 1 + dpTable[i - 1][j - 1];
                } else {
                    dpTable[i][j] = Math.max(dpTable[i - 1][j], dpTable[i][j - 1]);
                }
            }
        }

        return dpTable[t1Len][t2Len];
        // return recursive(text1.length()-1, text2.length()-1, text1, text2);
    }

    /**
     * 递归超时
     */
    private int recursive(int t1, int t2, String txt1, String txt2) {
        if (t1 == -1 || t2 == -1) {
            return 0;
        } else if (txt1.charAt(t1) == txt2.charAt(t2)) {
            return 1 + recursive(t1 - 1, t2 - 1, txt1, txt2);
        } else {
            return Math.max(recursive(t1 - 1, t2, txt1, txt2), recursive(t1, t2 - 1, txt1, txt2));
        }
    }
}
// @lc code=end

