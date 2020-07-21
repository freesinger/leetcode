/*
 * @lc app=leetcode.cn id=28 lang=java
 *
 * [28] 实现 strStr()
 *
 * https://leetcode-cn.com/problems/implement-strstr/description/
 *
 * algorithms
 * Easy (39.02%)
 * Likes:    304
 * Dislikes: 0
 * Total Accepted:    102.7K
 * Total Submissions: 262.9K
 * Testcase Example:  '"hello"\n"ll"'
 *
 * 实现 strStr() 函数。
 *
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置
 * (从0开始)。如果不存在，则返回  -1。
 *
 * 示例 1:
 *
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 *
 *
 * 示例 2:
 *
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 *
 *
 * 说明:
 *
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 *
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 *
 */

// @lc code=start
class Solution {
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);

        /**
         * KMP
         * @reference: https://leetcode-cn.com/problems/implement-strstr/solution/shen-ru-qian-chu-kmp-suan-fa-yu-ping-jie-by-zohary/
         */
        // int strLen = haystack.length(), subLen = needle.length();
        // if (subLen == 0) return 0;
        // if (strLen == 0) return -1;
        // // 构建状态机
        // int[][] FSM = new int[subLen][256];
        // int X = 0, match = 0;
        // for (int i = 0; i < subLen; i++) {
        //     match = (int) needle.charAt(i);
        //     for (int j = 0; j < 256; j++) {
        //         // 当前状态 + 匹配失败字符 = 孪生词缀状态 + 匹配字符
        //         FSM[i][j] = FSM[X][j]; 
        //     }
        //     FSM[i][match] = i + 1;
        //     if (i > 0) {
        //         // 下一孪生前缀状态 = X + match
        //         X = FSM[X][match];
        //     }
        // }
        // // 匹配子串
        // int state = 0;
        // for (int i = 0; i < strLen; i++) {
        //     state = FSM[state][haystack.charAt(i)];
        //     if (state == subLen) {
        //         return i - subLen + 1;
        //     }
        // }
        // return -1;

    }
}
// @lc code=end

