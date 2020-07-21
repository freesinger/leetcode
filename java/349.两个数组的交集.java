import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/*
 * @lc app=leetcode.cn id=349 lang=java
 *
 * [349] 两个数组的交集
 *
 * https://leetcode-cn.com/problems/intersection-of-two-arrays/description/
 *
 * algorithms
 * Easy (66.94%)
 * Likes:    148
 * Dislikes: 0
 * Total Accepted:    45.4K
 * Total Submissions: 67.2K
 * Testcase Example:  '[1,2,2,1]\n[2,2]'
 *
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 示例 1:
 *
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2]
 *
 *
 * 示例 2:
 *
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [9,4]
 *
 * 说明:
 *
 *
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 *
 *
 */

// @lc code=start
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> res = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums1) set.add(num);
        for (int num : nums2) {
            if (set.contains(num)) {
                res.add(num);
                set.remove(num);
            }
        }

        return listToArray(res);
    }

    private int[] listToArray(List<Integer> list) {
        int[] res = new int[list.size()];
        Iterator<Integer> iter = list.iterator();

        for (int i = 0; iter.hasNext(); i++) {
            res[i] = iter.next();
        }

        return res;
    }
}
// @lc code=end

