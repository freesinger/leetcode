import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=728 lang=java
 *
 * [728] 自除数
 *
 * https://leetcode-cn.com/problems/self-dividing-numbers/description/
 *
 * algorithms
 * Easy (71.24%)
 * Likes:    90
 * Dislikes: 0
 * Total Accepted:    19.1K
 * Total Submissions: 26.1K
 * Testcase Example:  '1\n22'
 *
 * 自除数 是指可以被它包含的每一位数除尽的数。
 *
 * 例如，128 是一个自除数，因为 128 % 1 == 0，128 % 2 == 0，128 % 8 == 0。
 *
 * 还有，自除数不允许包含 0 。
 *
 * 给定上边界和下边界数字，输出一个列表，列表的元素是边界（含边界）内所有的自除数。
 *
 * 示例 1：
 *
 *
 * 输入：
 * 上边界left = 1, 下边界right = 22
 * 输出： [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
 *
 *
 * 注意：
 *
 *
 * 每个输入参数的边界满足 1 <= left <= right <= 10000。
 *
 *
 */

// @lc code=start
class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new ArrayList<>();

        for (; left <= right; left++) {
            if (isSelfDivided(left)) res.add(left);
        }

        return res;
    }

    private boolean isSelfDivided(int num) {
        int n = num;
        while (num != 0) {
            if (num % 10 == 0 || n % (num % 10) != 0) return false;
            num /= 10;
        }

        return true;
    }
}
// @lc code=end

