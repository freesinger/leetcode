import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=241 lang=java
 *
 * [241] 为运算表达式设计优先级
 *
 * https://leetcode-cn.com/problems/different-ways-to-add-parentheses/description/
 *
 * algorithms
 * Medium (69.36%)
 * Likes:    165
 * Dislikes: 0
 * Total Accepted:    10.4K
 * Total Submissions: 14.6K
 * Testcase Example:  '"2-1-1"'
 *
 * 给定一个含有数字和运算符的字符串，为表达式添加括号，改变其运算优先级以求出不同的结果。你需要给出所有可能的组合的结果。有效的运算符号包含 +, - 以及
 * * 。
 * 
 * 示例 1:
 * 
 * 输入: "2-1-1"
 * 输出: [0, 2]
 * 解释: 
 * ((2-1)-1) = 0 
 * (2-(1-1)) = 2
 * 
 * 示例 2:
 * 
 * 输入: "2*3-4*5"
 * 输出: [-34, -14, -10, -10, 10]
 * 解释: 
 * (2*(3-(4*5))) = -34 
 * ((2*3)-(4*5)) = -14 
 * ((2*(3-4))*5) = -10 
 * (2*((3-4)*5)) = -10 
 * (((2*3)-4)*5) = 10
 * 
 */

// @lc code=start
class Solution {
    Map<String, List<Integer>> map = new HashMap<>();
    /**
     * 分治 + 递归
     * 使用map减少重复运算
     * @param input
     * @return
     */
    public List<Integer> diffWaysToCompute(String input) {
        if (map.containsKey(input)) return map.get(input);
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch == '+' || ch == '-' || ch == '*') {
                // String left = input.substring(0, i);
                // String right = input.substring(i+1);
                // List<Integer> leftUnion = map.getOrDefault(left, diffWaysToCompute(left));
                // List<Integer> rightUnion = map.getOrDefault(right, diffWaysToCompute(right));
                List<Integer> leftUnion = diffWaysToCompute(input.substring(0, i));
                List<Integer> rightUnion = diffWaysToCompute(input.substring(i+1));
                for (int j : leftUnion) {
                    for (int k : rightUnion) {
                        switch (ch) {
                            case '+':
                                res.add(j+k);
                                break;
                            case '-':
                                res.add(j-k);
                                break;
                            case '*':
                                res.add(j*k);
                                break;
                        }
                    }
                }
            }
        }
        if (res.size() == 0) res.add(Integer.valueOf(input)); // 纯数字字符串
        map.put(input, res);

        return res;
    }
}
// @lc code=end

