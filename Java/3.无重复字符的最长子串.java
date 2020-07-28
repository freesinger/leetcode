/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 *
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/description/
 *
 * algorithms
 * Medium (31.99%)
 * Likes:    4054
 * Dislikes: 0
 * Total Accepted:    586.9K
 * Total Submissions: 1.7M
 * Testcase Example:  '"abcabcbb"'
 *
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 
 * 示例 1:
 * 
 * 输入: "abcabcbb"
 * 输出: 3 
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 
 * 
 * 示例 2:
 * 
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 
 * 
 * 示例 3:
 * 
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * 
 * 
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String str) {
        if (str == null || str.length() == 0) return 0;
        if (str.length() == 1) return 1;
        // 用map存储每个字符出现的最后位置，重复则从最后位置开始重新找
        HashMap<Character, Integer> map = new HashMap<>();
        int len = str.length();
        int left = 0;
        int max = 1;

        for (int i = 0; i < len; i++) {
            if (map.containsKey(str.charAt(i))) {
                left = Math.max(left, map.get(str.charAt(i)) + 1);
            }
            map.put(str.charAt(i), i);
            max = Math.max(max, i - left + 1);
        }

        return max;
    }
}
// @lc code=end

