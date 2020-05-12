import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 * @lc app=leetcode.cn id=179 lang=java
 *
 * [179] 最大数
 *
 * https://leetcode-cn.com/problems/largest-number/description/
 *
 * algorithms
 * Medium (34.48%)
 * Likes:    255
 * Dislikes: 0
 * Total Accepted:    26K
 * Total Submissions: 72.6K
 * Testcase Example:  '[10,2]'
 *
 * 给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。
 * 
 * 示例 1:
 * 
 * 输入: [10,2]
 * 输出: 210
 * 
 * 示例 2:
 * 
 * 输入: [3,30,34,5,9]
 * 输出: 9534330
 * 
 * 说明: 输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 * 
 */

// @lc code=start
class Solution {
    public String largestNumber(int[] nums) {
        List<String> numbers = new ArrayList<>();
        StringBuilder res = new StringBuilder();

        for (int n : nums) numbers.add(String.valueOf(n));

        // 重写1
        // Collections.sort(numbers, new stringCompare());

        // 重写比较规则2
        // Collections.sort(numbers, new Comparator<String>() {
        //     @Override
        //     public int compare(String a, String b) {
        //         return (b+a).compareTo((a+b));
        //     }
        // });
        
        // lambda表达式
        Collections.sort(numbers, (a, b) -> (b+a).compareTo(a+b));
        for (String s : numbers) res.append(s);
        
        return numbers.get(0).equals("0") ? "0" : res.toString();
    }

    /**
     * 字符串比较降序排列
     */
    private class stringCompare implements Comparator<String> {
        @Override
        public int compare(String a, String b) {
            return (b+a).compareTo(a+b);
        }
    }
}
// @lc code=end

