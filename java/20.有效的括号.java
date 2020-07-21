import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=20 lang=java
 *
 * [20] 有效的括号
 *
 * https://leetcode-cn.com/problems/valid-parentheses/description/
 *
 * algorithms
 * Easy (40.07%)
 * Likes:    1204
 * Dislikes: 0
 * Total Accepted:    158.1K
 * Total Submissions: 394.3K
 * Testcase Example:  '"()"'
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *
 *
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 *
 *
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 *
 *
 * 示例 3:
 *
 * 输入: "(]"
 * 输出: false
 *
 *
 * 示例 4:
 *
 * 输入: "([)]"
 * 输出: false
 *
 *
 * 示例 5:
 *
 * 输入: "{[]}"
 * 输出: true
 *
 */

// @lc code=start
class Solution {
    public boolean isValid(String s) {
        if (s.length() == 0) return true;
        if (s.length() % 2 != 0) return false;
        Map<Character, Character> map = new HashMap<Character, Character>() {{
            put('(', ')');
            put('{', '}');
            put('[', ']');
        }};
        // char[] s_char = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                stack.add(ch);
            } else {
                if (stack.isEmpty()) return false;
                if (map.get(stack.peek()) == ch) stack.pop();
            }
        }

        return stack.isEmpty();
    }
}
// @lc code=end

