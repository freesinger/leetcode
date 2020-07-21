import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=389 lang=java
 *
 * [389] 找不同
 *
 * https://leetcode-cn.com/problems/find-the-difference/description/
 *
 * algorithms
 * Easy (59.57%)
 * Likes:    101
 * Dislikes: 0
 * Total Accepted:    19.1K
 * Total Submissions: 31.7K
 * Testcase Example:  '"abcd"\n"abcde"'
 *
 * 给定两个字符串 s 和 t，它们只包含小写字母。
 *
 * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 *
 * 请找出在 t 中被添加的字母。
 *
 *
 *
 * 示例:
 *
 * 输入：
 * s = "abcd"
 * t = "abcde"
 *
 * 输出：
 * e
 *
 * 解释：
 * 'e' 是那个被添加的字母。
 *
 *
 */

// @lc code=start
class Solution {
    public char findTheDifference(String s, String t) {
        Map<Character, Integer> smap = new HashMap<>();
        Map<Character, Integer> tmap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            if (!smap.containsKey(ch)) smap.put(ch, 1);
            else smap.put(ch, smap.get(ch) + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            Character ch = t.charAt(i);
            if (!tmap.containsKey(ch)) tmap.put(ch, 1);
            else tmap.put(ch, tmap.get(ch) + 1);
        }

        for (int j = 0; j < t.length(); j++) {
            Character ch = t.charAt(j);
            if (smap.get(ch) == null) return ch;
            if (tmap.get(ch) == smap.get(ch) + 1) return ch;
        }

        return 0;
    }
}
// @lc code=end

