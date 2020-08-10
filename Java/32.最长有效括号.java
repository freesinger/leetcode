import java.util.Stack;

/*
 * @lc app=leetcode.cn id=32 lang=java
 *
 * [32] 最长有效括号
 *
 * https://leetcode-cn.com/problems/longest-valid-parentheses/description/
 *
 * algorithms
 * Hard (28.70%)
 * Likes:    891
 * Dislikes: 0
 * Total Accepted:    92.6K
 * Total Submissions: 277K
 * Testcase Example:  '"(()"'
 *
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 * 
 * 示例 1:
 * 
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 * 
 * 
 * 示例 2:
 * 
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 * 
 * 
 */

// @lc code=start
class Solution {
    public int longestValidParentheses(String str) {
        if (str == null || str.length() <= 1) return 0;
        int[] nums = new int[str.length()];
        int maxLen = 0, curLen = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(') stack.push(i);
            else {
                if (stack.isEmpty()) nums[i] = 1; // 多余的)无法匹配直接置1
                else stack.pop(); // 否则能匹配一对括号出栈
            }
        }

        while (!stack.isEmpty()) nums[stack.pop()] = 1; // 多余的(也置1

        // 转化为求最长连续0子串问题
        for (int i = 0; i < str.length(); i++) {
            if (nums[i] == 1) {
                curLen = 0;
            } else {
                curLen++;
                maxLen = Math.max(maxLen, curLen);
            }
        }

        return maxLen;
    }
}
// @lc code=end

