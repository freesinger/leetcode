import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=409 lang=java
 *
 * [409] 最长回文串
 *
 * https://leetcode-cn.com/problems/longest-palindrome/description/
 *
 * algorithms
 * Easy (50.74%)
 * Likes:    88
 * Dislikes: 0
 * Total Accepted:    13.7K
 * Total Submissions: 26.8K
 * Testcase Example:  '"abccccdd"'
 *
 * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 * 
 * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 * 
 * 注意:
 * 假设字符串的长度不会超过 1010。
 * 
 * 示例 1: 
 * 
 * 
 * 输入:
 * "abccccdd"
 * 
 * 输出:
 * 7
 * 
 * 解释:
 * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 * 
 * 
 */

// @lc code=start
class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            if (!map.containsKey(ch)) map.put(ch, 1);
            else map.put(ch, map.get(ch)+1);
        }

        int length = 0;
        boolean flag = false;
        for (Character ch: map.keySet()) {
            if (map.get(ch) % 2 != 0) {
                length += map.get(ch) / 2 * 2;
                flag = true;
            } else {
                length += map.get(ch);
            }
        }

        return flag ? length + 1 : length;
    }
}
// @lc code=end

