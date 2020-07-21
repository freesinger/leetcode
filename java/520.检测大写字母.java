/*
 * @lc app=leetcode.cn id=520 lang=java
 *
 * [520] 检测大写字母
 *
 * https://leetcode-cn.com/problems/detect-capital/description/
 *
 * algorithms
 * Easy (53.79%)
 * Likes:    77
 * Dislikes: 0
 * Total Accepted:    16.1K
 * Total Submissions: 29.4K
 * Testcase Example:  '"USA"'
 *
 * 给定一个单词，你需要判断单词的大写使用是否正确。
 *
 * 我们定义，在以下情况时，单词的大写用法是正确的：
 *
 *
 * 全部字母都是大写，比如"USA"。
 * 单词中所有字母都不是大写，比如"leetcode"。
 * 如果单词不只含有一个字母，只有首字母大写， 比如 "Google"。
 *
 *
 * 否则，我们定义这个单词没有正确使用大写字母。
 *
 * 示例 1:
 *
 *
 * 输入: "USA"
 * 输出: True
 *
 *
 * 示例 2:
 *
 *
 * 输入: "FlaG"
 * 输出: False
 *
 *
 * 注意: 输入是由大写和小写拉丁字母组成的非空单词。
 *
 */

// @lc code=start
class Solution {
    public boolean detectCapitalUse(String word) {
        // char[] words = word.toCharArray();
        int upper = 0, lower = 0;
        // int[] wordNum = new int[2];
        // Arrays.fill(wordNum, 0);

        for (char ch : word.toCharArray()) {
            if (Character.isUpperCase(ch)) upper++;
            if (Character.isLowerCase(ch)) lower++;
        }

        if (word.length() != upper + lower) return false;
        if (lower == word.length() || upper == word.length()) return true;
        if (upper == 1 && Character.isUpperCase(word.charAt(0))) return true;

        return false;
    }
}
// @lc code=end

