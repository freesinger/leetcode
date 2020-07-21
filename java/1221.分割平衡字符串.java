/*
 * @lc app=leetcode.cn id=1221 lang=java
 *
 * [1221] 分割平衡字符串
 *
 * https://leetcode-cn.com/problems/split-a-string-in-balanced-strings/description/
 *
 * algorithms
 * Easy (76.21%)
 * Likes:    15
 * Dislikes: 0
 * Total Accepted:    7.7K
 * Total Submissions: 10.2K
 * Testcase Example:  '"RLRRLLRLRL"'
 *
 * 在一个「平衡字符串」中，'L' 和 'R' 字符的数量是相同的。
 *
 * 给出一个平衡字符串 s，请你将它分割成尽可能多的平衡字符串。
 *
 * 返回可以通过分割得到的平衡字符串的最大数量。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "RLRRLLRLRL"
 * 输出：4
 * 解释：s 可以分割为 "RL", "RRLL", "RL", "RL", 每个子字符串中都包含相同数量的 'L' 和 'R'。
 *
 *
 * 示例 2：
 *
 * 输入：s = "RLLLLRRRLR"
 * 输出：3
 * 解释：s 可以分割为 "RL", "LLLRRR", "LR", 每个子字符串中都包含相同数量的 'L' 和 'R'。
 *
 *
 * 示例 3：
 *
 * 输入：s = "LLLLRRRR"
 * 输出：1
 * 解释：s 只能保持原样 "LLLLRRRR".
 *
 *
 *
 *
 * 提示：
 *
 *
 * 1 <= s.length <= 1000
 * s[i] = 'L' 或 'R'
 *
 *
 */

// @lc code=start
class Solution {
    public int balancedStringSplit(String s) {
        if (s == null) return 0;
        int cntL = 0, cntR = 0, res = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'L') cntL++;
            else cntR++;
            if (cntL == cntR) res++;
        }

        return res;
    }
}
// @lc code=end

