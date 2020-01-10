import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=414 lang=java
 *
 * [414] 第三大的数
 *
 * https://leetcode-cn.com/problems/third-maximum-number/description/
 *
 * algorithms
 * Easy (33.27%)
 * Likes:    91
 * Dislikes: 0
 * Total Accepted:    16.9K
 * Total Submissions: 49.8K
 * Testcase Example:  '[3,2,1]'
 *
 * 给定一个非空数组，返回此数组中第三大的数。如果不存在，则返回数组中最大的数。要求算法时间复杂度必须是O(n)。
 * 
 * 示例 1:
 * 
 * 
 * 输入: [3, 2, 1]
 * 
 * 输出: 1
 * 
 * 解释: 第三大的数是 1.
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入: [1, 2]
 * 
 * 输出: 2
 * 
 * 解释: 第三大的数不存在, 所以返回最大的数 2 .
 * 
 * 
 * 示例 3:
 * 
 * 
 * 输入: [2, 2, 3, 1]
 * 
 * 输出: 1
 * 
 * 解释: 注意，要求返回第三大的数，是指第三大且唯一出现的数。
 * 存在两个值为2的数，它们都排第二。
 * 
 * 
 */

// @lc code=start
class Solution {
    public int thirdMax(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);

        int first = Math.max(nums[0], nums[1]), second = Math.min(nums[0], nums[1]), third = Integer.MIN_VALUE;
        // int first, second, third = Integer.MIN_VALUE;
        int start = 0;

        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] != nums[i+1]) {
                first = Math.max(nums[i], nums[i+1]);
                second = Math.min(nums[i], nums[i+1]);
            } else start++;
        }
        System.out.println(first);
        System.out.println(second);
        System.out.println(start);
        
        for (int i = start; i < nums.length; i++) {
            if (nums[i] > first) {
                int tmp = second;
                second = first;
                first = nums[i];
                third = tmp;
            } else if (nums[i] > second && nums[i] < first) {
                third = second;
                second = nums[i];
            } else if (nums[i] > third) {
                third = nums[i];
            } else continue;
        }

        return third;
        // Arrays.sort(nums);
        // int cnt = 1, max = nums[0], id = 1;
        // while (cnt != 3 && id < nums.length) {
        //     if (nums[id] < max) {
        //         max = nums[id];
        //         cnt++;
        //     }
        // }
        // return max;
    }
}
// @lc code=end

