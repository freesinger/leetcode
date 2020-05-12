import java.util.Stack;

/*
 * @lc app=leetcode.cn id=150 lang=java
 *
 * [150] 逆波兰表达式求值
 *
 * https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/description/
 *
 * algorithms
 * Medium (47.50%)
 * Likes:    127
 * Dislikes: 0
 * Total Accepted:    35K
 * Total Submissions: 70.3K
 * Testcase Example:  '["2","1","+","3","*"]'
 *
 * 根据逆波兰表示法，求表达式的值。
 * 
 * 有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 * 
 * 说明：
 * 
 * 
 * 整数除法只保留整数部分。
 * 给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
 * 
 * 
 * 示例 1：
 * 
 * 输入: ["2", "1", "+", "3", "*"]
 * 输出: 9
 * 解释: ((2 + 1) * 3) = 9
 * 
 * 
 * 示例 2：
 * 
 * 输入: ["4", "13", "5", "/", "+"]
 * 输出: 6
 * 解释: (4 + (13 / 5)) = 6
 * 
 * 
 * 示例 3：
 * 
 * 输入: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
 * 输出: 22
 * 解释: 
 * ⁠ ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 * = ((10 * (6 / (12 * -11))) + 17) + 5
 * = ((10 * (6 / -132)) + 17) + 5
 * = ((10 * 0) + 17) + 5
 * = (0 + 17) + 5
 * = 17 + 5
 * = 22
 * 
 */

// @lc code=start
class Solution {
    /**
     * stack
     * @param tokens
     * @return
     */
    public int evalRPN(String[] tokens) {
        if (tokens.length == 1) return Integer.valueOf(tokens[0]);
        Stack<String> stack = new Stack<>();
        int value = 0, idx = 0;
        int later = 0, former = 0;

        // stack.push(tokens[0]);
        while (idx < tokens.length) {
            String cur = tokens[idx++];
            if (cur.equals("+")) {
                later = Integer.valueOf(stack.pop());
                former = Integer.valueOf(stack.pop());
                value = former + later;
                stack.push(String.valueOf(value));
            } else if (cur.equals("-")) {
                later = Integer.valueOf(stack.pop());
                former = Integer.valueOf(stack.pop());
                value = former - later;
                stack.push(String.valueOf(value));
            } else if (cur.equals("*")) {
                later = Integer.valueOf(stack.pop());
                former = Integer.valueOf(stack.pop());
                value = former * later;
                stack.push(String.valueOf(value));
            } else if (cur.equals("/")) {
                later = Integer.valueOf(stack.pop());
                former = Integer.valueOf(stack.pop());
                value = former / later;
                stack.push(String.valueOf(value));
            } else {
                stack.push(cur);
            }
        }

        return value;
    }
}
// @lc code=end

