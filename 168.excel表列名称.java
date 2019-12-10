import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=168 lang=java
 *
 * [168] Excel表列名称
 *
 * https://leetcode-cn.com/problems/excel-sheet-column-title/description/
 *
 * algorithms
 * Easy (35.54%)
 * Likes:    150
 * Dislikes: 0
 * Total Accepted:    16.1K
 * Total Submissions: 44.9K
 * Testcase Example:  '1'
 *
 * 给定一个正整数，返回它在 Excel 表中相对应的列名称。
 * 
 * 例如，
 * 
 * ⁠   1 -> A
 * ⁠   2 -> B
 * ⁠   3 -> C
 * ⁠   ...
 * ⁠   26 -> Z
 * ⁠   27 -> AA
 * ⁠   28 -> AB 
 * ⁠   ...
 * 
 * 
 * 示例 1:
 * 
 * 输入: 1
 * 输出: "A"
 * 
 * 
 * 示例 2:
 * 
 * 输入: 28
 * 输出: "AB"
 * 
 * 
 * 示例 3:
 * 
 * 输入: 701
 * 输出: "ZY"
 * 
 * 
 */

// @lc code=start
class Solution {
    public String convertToTitle(int n) {
        // if (n <= 0) return null;

        // String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        // HashMap<Integer, Character> alphabetMap = new HashMap<>();
        // for (int i = 0; i < alphabet.length(); i++) {
        //     alphabetMap.put(i+1, alphabet.charAt(i));
        // }
        
        // // System.out.println(alphabetMap);
        
        // if (n >= 1 && n <= 26) return String.valueOf(alphabetMap.get(n));

        // StringBuilder res = new StringBuilder();
        // while (n > 0) {
        //     // n--转化为26进制问题
        //     n--;
        //     res.append(alphabetMap.get(n % 26 + 1));
        //     n /= 26;
        // }
        
        // return res.reverse().toString();
        if (n <= 0) return null;

        if (n >= 1 && n <= 26) return String.valueOf((char)(n-1+'A'));

        StringBuilder res = new StringBuilder();
        while (n > 0) {
            // n--转化为26进制问题
            n--;
            res.append((char)(n%26+'A'));
            n /= 26;
        }

        return res.reverse().toString();
    }

    // public static void main(String[] args) {
    //     Solution s = new Solution();

    //     System.out.println(s.convertToTitle(27));

    //     return;
    // }
}
// @lc code=end

