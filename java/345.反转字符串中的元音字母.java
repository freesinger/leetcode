import java.util.Arrays;
import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=345 lang=java
 *
 * [345] 反转字符串中的元音字母
 *
 * https://leetcode-cn.com/problems/reverse-vowels-of-a-string/description/
 *
 * algorithms
 * Easy (48.26%)
 * Likes:    65
 * Dislikes: 0
 * Total Accepted:    21K
 * Total Submissions: 43.3K
 * Testcase Example:  '"hello"'
 *
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 *
 * 示例 1:
 *
 * 输入: "hello"
 * 输出: "holle"
 *
 *
 * 示例 2:
 *
 * 输入: "leetcode"
 * 输出: "leotcede"
 *
 * 说明:
 * 元音字母不包含字母"y"。
 *
 */

// @lc code=start
class Solution {
    public String reverseVowels(String s) {
        // String vowels = "aeiouAEIOU";
        final HashSet<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        char[] res = new char[s.length()];

        int left = 0, right = s.length() - 1;
        while (left <= right) {
            char l = s.charAt(left);
            char r = s.charAt(right);
            if (!set.contains(l)) {
                res[left++] = l;
            } else if (!set.contains(r)) {
                res[right--] = r;
            } else {
                res[left++] = r;
                res[right--] = l;
            }
        }

        return new String(res);
    }
}
// @lc code=end

