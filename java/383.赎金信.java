import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=383 lang=java
 *
 * [383] 赎金信
 *
 * https://leetcode-cn.com/problems/ransom-note/description/
 *
 * algorithms
 * Easy (50.61%)
 * Likes:    63
 * Dislikes: 0
 * Total Accepted:    14.4K
 * Total Submissions: 28K
 * Testcase Example:  '"a"\n"b"'
 *
 * 给定一个赎金信 (ransom)
 * 字符串和一个杂志(magazine)字符串，判断第一个字符串ransom能不能由第二个字符串magazines里面的字符构成。如果可以构成，返回
 * true ；否则返回 false。
 *
 * (题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。)
 *
 * 注意：
 *
 * 你可以假设两个字符串均只含有小写字母。
 *
 *
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 *
 *
 */

// @lc code=start
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (magazine.contains(ransomNote)) return true;
        Map<Character, Integer> rmap = new HashMap<>();
        Map<Character, Integer> mmap = new HashMap<>();

        for (int i = 0; i < ransomNote.length(); i++) {
            Character ch = ransomNote.charAt(i);
            if (!rmap.containsKey(ch)) {
                rmap.put(ch, 1);
            } else {
                rmap.put(ch, rmap.get(ch) + 1);
            }
        }

        for (int j = 0; j < magazine.length(); j++) {
            Character ch = magazine.charAt(j);
            if (!mmap.containsKey(ch)) {
                mmap.put(ch, 1);
            } else {
                mmap.put(ch, mmap.get(ch) + 1);
            }
        }

        for (Character ch : rmap.keySet()) {
            if (mmap.get(ch) == null) return false;
            if (rmap.get(ch) > mmap.get(ch)) return false;
        }

        return true;
    }
}
// @lc code=end

