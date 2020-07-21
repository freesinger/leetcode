/*
 * @lc app=leetcode.cn id=14 lang=java
 *
 * [14] 最长公共前缀
 *
 * https://leetcode-cn.com/problems/longest-common-prefix/description/
 *
 * algorithms
 * Easy (35.34%)
 * Likes:    776
 * Dislikes: 0
 * Total Accepted:    151.1K
 * Total Submissions: 427.3K
 * Testcase Example:  '["flower","flow","flight"]'
 *
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 *
 *
 * 示例 2:
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 *
 *
 * 说明:
 *
 * 所有输入只包含小写字母 a-z 。
 *
 */

// @lc code=start
class Solution {
    public String longestCommonPrefix(String[] strs) {
        // int len = Integer.MAX_VALUE;
        // String res = "";
        if (strs.length == 0) return "";
        // for (int i = 0; i < strs.length; i++) {
        //     len = Math.min(strs[i].length(), len);
        // }
        String str = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(str) != 0) {
                str = str.substring(0, str.length() - 1);
                if (str.isEmpty()) return "";
            }
        }
        return str;
    }
}
// @lc code=end

