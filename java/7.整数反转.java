/*
 * @lc app=leetcode.cn id=7 lang=java
 *
 * [7] 整数反转
 *
 * https://leetcode-cn.com/problems/reverse-integer/description/
 *
 * algorithms
 * Easy (33.20%)
 * Likes:    1473
 * Dislikes: 0
 * Total Accepted:    224.4K
 * Total Submissions: 675.6K
 * Testcase Example:  '123'
 *
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * 
 * 示例 1:
 * 
 * 输入: 123
 * 输出: 321
 * 
 * 
 * 示例 2:
 * 
 * 输入: -123
 * 输出: -321
 * 
 * 
 * 示例 3:
 * 
 * 输入: 120
 * 输出: 21
 * 
 * 
 * 注意:
 * 
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。请根据这个假设，如果反转后整数溢出那么就返回
 * 0。
 * 
 */

// @lc code=start
class Solution {
    public int reverse(int x) {
        
        int  res = 0;
        
        while (Math.abs(x) > 0) {
            int rest = x % 10;
            
            if (Math.abs(res) > Integer.MAX_VALUE /10) return 0;
            if (res == Integer.MAX_VALUE/10 && rest > Integer.MAX_VALUE % 10) return 0;
            if (res == Integer.MIN_VALUE/10 && rest < Integer.MIN_VALUE % 10) return 0; 

            res = res * 10 + rest;
            // try {
            //     res = res * 10 + rest;
            // } catch (Exception e) {
            //     return 0;
            // }

            x /= 10;
        }

        return res;
    }
}
// @lc code=end

