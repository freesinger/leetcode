import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=242 lang=java
 *
 * [242] 有效的字母异位词
 *
 * https://leetcode-cn.com/problems/valid-anagram/description/
 *
 * algorithms
 * Easy (56.87%)
 * Likes:    135
 * Dislikes: 0
 * Total Accepted:    61.9K
 * Total Submissions: 108.1K
 * Testcase Example:  '"anagram"\n"nagaram"'
 *
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 *
 *
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 *
 * 说明:
 * 你可以假设字符串只包含小写字母。
 *
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 *
 */

// @lc code=start
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        Map<Character, Integer> smap = new HashMap<>();
        Map<Character, Integer> tmap = new HashMap<>();
        for (char ch : s.toCharArray()) {
            if (!smap.containsKey(ch)) smap.put(ch, 1);
            else smap.put(ch, smap.get(ch) + 1);
        }

        for (char ch : t.toCharArray()) {
            if (!tmap.containsKey(ch)) tmap.put(ch, 1);
            else tmap.put(ch, tmap.get(ch) + 1);
        }

        for (char ch : smap.keySet()) {
            if (tmap.get(ch) == null) return false;
            if (smap.get(ch).intValue() != tmap.get(ch).intValue()) return false;
        }
        return true;
    }
}
// @lc code=end

