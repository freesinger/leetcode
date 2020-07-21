import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=387 lang=java
 *
 * [387] 字符串中的第一个唯一字符
 *
 * https://leetcode-cn.com/problems/first-unique-character-in-a-string/description/
 *
 * algorithms
 * Easy (41.50%)
 * Likes:    167
 * Dislikes: 0
 * Total Accepted:    55.3K
 * Total Submissions: 130.2K
 * Testcase Example:  '"leetcode"'
 *
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 *
 * 案例:
 *
 *
 * s = "leetcode"
 * 返回 0.
 *
 * s = "loveleetcode",
 * 返回 2.
 *
 *
 *
 *
 * 注意事项：您可以假定该字符串只包含小写字母。
 *
 */

// @lc code=start
class Solution {
    public int firstUniqChar(String s) {
        // Map<Character, Integer> map = new HashMap<>();

        // for (int i = 0; i < s.length(); i++) {
        //     Character ch = s.charAt(i);
        //     if (!map.containsKey(ch)) map.put(ch, 1);
        //     else map.put(ch, map.get(ch)+1);
        // }

        // for (int j = 0; j < s.length(); j++) {
        //     if (map.get(s.charAt(j)) == 1) return j;
        // }

        // return -1;


        /*
         * @authot Shane
         * @date 2020/01/08
         */
        Map<Character, Integer> map = new HashMap<>();
        boolean[] f = new boolean[26];

        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            map.put(ch, i);
        }
        for (int j = 0; j < s.length(); j++) {
            if (map.get(s.charAt(j)) == j && !f[s.charAt(j) - 'a']) return j;
            f[s.charAt(j) - 'a'] = true;
        }

        return -1;
    }
}
// @lc code=end

