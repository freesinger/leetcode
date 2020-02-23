/*
 * @lc app=leetcode.cn id=441 lang=java
 *
 * [441] 排列硬币
 *
 * https://leetcode-cn.com/problems/arranging-coins/description/
 *
 * algorithms
 * Easy (39.44%)
 * Likes:    45
 * Dislikes: 0
 * Total Accepted:    14.6K
 * Total Submissions: 36.6K
 * Testcase Example:  '5'
 *
 * 你总共有 n 枚硬币，你需要将它们摆成一个阶梯形状，第 k 行就必须正好有 k 枚硬币。
 * 
 * 给定一个数字 n，找出可形成完整阶梯行的总行数。
 * 
 * n 是一个非负整数，并且在32位有符号整型的范围内。
 * 
 * 示例 1:
 * 
 * 
 * n = 5
 * 
 * 硬币可排列成以下几行:
 * ¤
 * ¤ ¤
 * ¤ ¤
 * 
 * 因为第三行不完整，所以返回2.
 * 
 * 
 * 示例 2:
 * 
 * 
 * n = 8
 * 
 * 硬币可排列成以下几行:
 * ¤
 * ¤ ¤
 * ¤ ¤ ¤
 * ¤ ¤
 * 
 * 因为第四行不完整，所以返回3.
 * 
 * 
 */

// @lc code=start
class Solution {
    public int arrangeCoins(int n) {
        // 越界处理
        return (int)(Math.sqrt(2) * Math.sqrt(n + 0.125) - 0.5);
        // if (n == 1 || n == 0) return n;
        // for (int i = 2; i <= Integer.MAX_VALUE / 3; i++) {
        //     // System.out.println("WTF");
        //     if ((2 * n) == (i * (i + 1))) return i;
        //     if ((2 * n) < (i * (i + 1)) && (2 * n) > ((i - 1) * i)) return i - 1;
        // }
        // return 0;
    }
}
// @lc code=end

