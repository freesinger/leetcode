package src.hash;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个未排序的整数数组，找出最长连续序列的长度。
 * 要求算法的时间复杂度为 O(n)。
 *
 * 输入: [100, 4, 200, 1, 3, 2]
 * 输出: 4
 * 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4
 *
 */
public class LongestConsecutive {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        Set<Integer> set = new HashSet<>();
        int longest = 0;
        for (int num : nums) set.add(num);

        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i] - 1)) {
                int curNum = nums[i];
                int tempLongest = 1;
                while (set.contains(curNum + 1)) {
                    curNum++;
                    tempLongest++;
                }
                longest = Math.max(longest, tempLongest);
            }
        }

        return ++longest;
    }
}