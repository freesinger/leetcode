import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=557 lang=java
 *
 * [557] 反转字符串中的单词 III
 *
 * https://leetcode-cn.com/problems/reverse-words-in-a-string-iii/description/
 *
 * algorithms
 * Easy (68.25%)
 * Likes:    165
 * Dislikes: 0
 * Total Accepted:    49K
 * Total Submissions: 69.9K
 * Testcase Example:  '"Let\'s take LeetCode contest"'
 *
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 *
 * 示例 1:
 *
 *
 * 输入: "Let's take LeetCode contest"
 * 输出: "s'teL ekat edoCteeL tsetnoc" 
 *
 *
 * 注意：在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 *
 */

// @lc code=start
class Solution {
    /**
     * join函数组合字符串列表
     *
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        String[] strs = s.split(" ");
        // for (String str : strs) reverseString(str);
        for (int i = 0; i < strs.length; i++) {
            strs[i] = reverseString(strs[i]);
        }
        List<String> list = Arrays.asList(strs);
        return String.join(" ", list);
    }

    private String reverseString(String s) {
        StringBuilder sb = new StringBuilder();
        int l = s.length() - 1;
        while (l >= 0) { // l-- >= 0 error
            sb.append(s.charAt(l));
            l--;
        }
        return sb.toString();
        // System.out.println(s);
    }
}
// @lc code=end

