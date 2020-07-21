import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=961 lang=java
 *
 * [961] 重复 N 次的元素
 *
 * https://leetcode-cn.com/problems/n-repeated-element-in-size-2n-array/description/
 *
 * algorithms
 * Easy (65.93%)
 * Likes:    67
 * Dislikes: 0
 * Total Accepted:    21.6K
 * Total Submissions: 32.5K
 * Testcase Example:  '[1,2,3,3]'
 *
 * 在大小为 2N 的数组 A 中有 N+1 个不同的元素，其中有一个元素重复了 N 次。
 *
 * 返回重复了 N 次的那个元素。
 *
 *
 *
 *
 *
 *
 * 示例 1：
 *
 * 输入：[1,2,3,3]
 * 输出：3
 *
 *
 * 示例 2：
 *
 * 输入：[2,1,2,5,3,2]
 * 输出：2
 *
 *
 * 示例 3：
 *
 * 输入：[5,1,5,2,5,3,5,4]
 * 输出：5
 *
 *
 *
 *
 * 提示：
 *
 *
 * 4 <= A.length <= 10000
 * 0 <= A[i] < 10000
 * A.length 为偶数
 *
 *
 */

// @lc code=start
class Solution {
    public int repeatedNTimes(int[] A) {
        Set<Integer> set = new HashSet<>();

        for (int i : A) {
            if (set.contains(i)) return i;
            else set.add(i);
        }

        return -1;
    }
}
// @lc code=end

