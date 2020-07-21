import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=166 lang=java
 *
 * [166] 分数到小数
 *
 * https://leetcode-cn.com/problems/fraction-to-recurring-decimal/description/
 *
 * algorithms
 * Medium (25.15%)
 * Likes:    121
 * Dislikes: 0
 * Total Accepted:    9.7K
 * Total Submissions: 37.5K
 * Testcase Example:  '1\n2'
 *
 * 给定两个整数，分别表示分数的分子 numerator 和分母 denominator，以字符串形式返回小数。
 *
 * 如果小数部分为循环小数，则将循环的部分括在括号内。
 *
 * 示例 1:
 *
 * 输入: numerator = 1, denominator = 2
 * 输出: "0.5"
 *
 *
 * 示例 2:
 *
 * 输入: numerator = 2, denominator = 1
 * 输出: "2"
 *
 * 示例 3:
 *
 * 输入: numerator = 2, denominator = 3
 * 输出: "0.(6)"
 *
 *
 */

// @lc code=start
class Solution {
    /**
     * 长除法
     *
     * @param numerator
     * @param denominator
     * @return
     */
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";
        if (denominator == 0) throw new ArithmeticException();

        StringBuilder dec = new StringBuilder();
        // 判断符号
        dec.append(numerator < 0 ^ denominator < 0 ? "-" : "");
        // 转long防止abs(-2147483648)溢出
        long numer = Math.abs((long) numerator);
        long denom = Math.abs((long) denominator);
        Map<Long, Integer> map = new HashMap<>();

        long remainder = numer % denom;
        dec.append(String.valueOf(numer / denom));
        dec.append(remainder == 0 ? "" : ".");
        while (remainder != 0) {
            if (!map.containsKey(remainder)) {
                map.put(remainder, dec.length());
                numer = 10 * remainder;
                dec.append(String.valueOf(numer / denom));
                remainder = numer % denom;
            } else {
                dec.insert(map.get(remainder), "(");
                dec.append(")");
                break;
            }
        }

        return dec.toString();
    }
}
// @lc code=end

