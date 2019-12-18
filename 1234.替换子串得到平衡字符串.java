import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=1234 lang=java
 *
 * [1234] 替换子串得到平衡字符串
 *
 * https://leetcode-cn.com/problems/replace-the-substring-for-balanced-string/description/
 *
 * algorithms
 * Medium (25.92%)
 * Likes:    18
 * Dislikes: 0
 * Total Accepted:    1.5K
 * Total Submissions: 5.9K
 * Testcase Example:  '"QWER"'
 *
 * 有一个只含有 'Q', 'W', 'E', 'R' 四种字符，且长度为 n 的字符串。
 * 
 * 假如在该字符串中，这四个字符都恰好出现 n/4 次，那么它就是一个「平衡字符串」。
 * 
 * 
 * 
 * 给你一个这样的字符串 s，请通过「替换一个子串」的方式，使原字符串 s 变成一个「平衡字符串」。
 * 
 * 你可以用和「待替换子串」长度相同的 任何 其他字符串来完成替换。
 * 
 * 请返回待替换子串的最小可能长度。
 * 
 * 如果原字符串自身就是一个平衡字符串，则返回 0。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：s = "QWER"
 * 输出：0
 * 解释：s 已经是平衡的了。
 * 
 * 示例 2：
 * 
 * 输入：s = "QQWE"
 * 输出：1
 * 解释：我们需要把一个 'Q' 替换成 'R'，这样得到的 "RQWE" (或 "QRWE") 是平衡的。
 * 
 * 
 * 示例 3：
 * 
 * 输入：s = "QQQW"
 * 输出：2
 * 解释：我们可以把前面的 "QQ" 替换成 "ER"。 
 * 
 * 
 * 示例 4：
 * 
 * 输入：s = "QQQQ"
 * 输出：3
 * 解释：我们可以替换后 3 个 'Q'，使 s = "QWER"。
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= s.length <= 10^5
 * s.length 是 4 的倍数
 * s 中只含有 'Q', 'W', 'E', 'R' 四种字符
 * 
 * 
 */

// @lc code=start
class Solution {
    public int balancedString(String s) {
        if (s == null) return 0;
        int len = s.length();
        int balance = len / 4;

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (!map.containsKey(ch)) map.put(ch, 1);
            else map.put(ch, map.get(ch)+1);
        }

        boolean isBalance = true;
        for (int v : map.values()) {
            if (v != balance) {
                isBalance = false;
                break;
            }
        }
        if (isBalance) return 0;

        // Sliding window
        int left = 0, right = 0;
        int min_replace = len;


        while (right < len) {
            map.put(s.charAt(right), map.get(s.charAt(right))-1);
            // 如果未先判断isBalance，则需要改成 left < len
            while (getMapMaximum(map) <= balance && left <= right) {
                min_replace = Math.min(min_replace, right-left+1);
                map.put(s.charAt(left), map.get(s.charAt(left))+1);
                left++;
            }
            right++;
        }

        return min_replace;
    }

    private int getMapMaximum(Map<Character, Integer> map) {
        Object[] sort_map = map.values().toArray();
        Arrays.sort(sort_map);
        // System.out.println(((Integer) sort_map[map.size() - 1]).intValue());
        return ((Integer) sort_map[map.size() - 1]).intValue();
    }
}
// @lc code=end

