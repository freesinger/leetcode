import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=290 lang=java
 *
 * [290] 单词规律
 *
 * https://leetcode-cn.com/problems/word-pattern/description/
 *
 * algorithms
 * Easy (40.92%)
 * Likes:    117
 * Dislikes: 0
 * Total Accepted:    15.2K
 * Total Submissions: 36.6K
 * Testcase Example:  '"abba"\n"dog cat cat dog"'
 *
 * 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
 *
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
 *
 * 示例1:
 *
 * 输入: pattern = "abba", str = "dog cat cat dog"
 * 输出: true
 *
 * 示例 2:
 *
 * 输入:pattern = "abba", str = "dog cat cat fish"
 * 输出: false
 *
 * 示例 3:
 *
 * 输入: pattern = "aaaa", str = "dog cat cat dog"
 * 输出: false
 *
 * 示例 4:
 *
 * 输入: pattern = "abba", str = "dog dog dog dog"
 * 输出: false
 *
 * 说明:
 * 你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。    
 *
 */

// @lc code=start
class Solution {
    public boolean wordPattern(String pattern, String str) {
        Map<Character, String> map = new HashMap<>();
        String[] strs = str.split(" ");
        if (strs.length != pattern.length()) return false;

        for (int i = 0; i < pattern.length(); i++) {
            // 键值对必须一一对应
            if (!map.containsKey(pattern.charAt(i))) {
                if (map.containsValue(strs[i])) return false;
                else map.put(pattern.charAt(i), strs[i]);
            } else {
                // 检查字符串值想等用equals()
                // ==检查地址
                if (!map.get(pattern.charAt(i)).equals(strs[i])) {
                    return false;
                }
            }
        }

        return true;
    }
}
// @lc code=end

