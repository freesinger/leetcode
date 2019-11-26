/*
 * @lc app=leetcode.cn id=66 lang=java
 *
 * [66] 加一
 *
 * https://leetcode-cn.com/problems/plus-one/description/
 *
 * algorithms
 * Easy (41.81%)
 * Likes:    373
 * Dislikes: 0
 * Total Accepted:    95.7K
 * Total Submissions: 228.3K
 * Testcase Example:  '[1,2,3]'
 *
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * 
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * 
 * 示例 1:
 * 
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 
 * 
 * 示例 2:
 * 
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 * 
 * 
 */

// @lc code=start
class Solution {
    public int[] plusOne(int[] digits) {
        int l = digits.length;

        // digits[l-1] = digits[l-1] < 9 ? digits[l-1]+1 : digits[l-1];
        if (digits[l-1] < 9) {
            digits[l-1] += 1;
            return digits;
        }

        for (int i = l-1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i] += 1;
                return digits;
            }
        }

        if (digits[0] == 0) {
            // List<Integer> list = new ArrayList<>();
            int[] list = new int[l+1];
            list[0] = 1;
            for (int j = 1; j < l+1; j++) {
                list[j] = 0;
            }
            return list;
        } else {
            return digits;
        }
        

    }
}
// @lc code=end

