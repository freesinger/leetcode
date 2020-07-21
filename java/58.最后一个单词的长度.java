/*
 * @lc app=leetcode.cn id=58 lang=java
 *
 * [58] 最后一个单词的长度
 *
 * https://leetcode-cn.com/problems/length-of-last-word/description/
 *
 * algorithms
 * Easy (31.50%)
 * Likes:    145
 * Dislikes: 0
 * Total Accepted:    53.4K
 * Total Submissions: 169.1K
 * Testcase Example:  '"Hello World"'
 *
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
 *
 * 如果不存在最后一个单词，请返回 0 。
 *
 * 说明：一个单词是指由字母组成，但不包含任何空格的字符串。
 *
 * 示例:
 *
 * 输入: "Hello World"
 * 输出: 5
 *
 *
 */

// @lc code=start
class Solution {
    public int lengthOfLastWord(String s) {
        if (s.length() == 0 || s == null) return 0;
        String[] words = s.split(" ");
        if (words.length == 0 || words == null) return 0;
        return words[words.length - 1].length();
    }
}
// @lc code=end

