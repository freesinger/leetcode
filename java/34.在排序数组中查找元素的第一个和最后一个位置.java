/*
 * @lc app=leetcode.cn id=34 lang=java
 *
 * [34] 在排序数组中查找元素的第一个和最后一个位置
 *
 * https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
 *
 * algorithms
 * Medium (38.16%)
 * Likes:    247
 * Dislikes: 0
 * Total Accepted:    44.7K
 * Total Submissions: 117.1K
 * Testcase Example:  '[5,7,7,8,8,10]\n8'
 *
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * 
 * 如果数组中不存在目标值，返回 [-1, -1]。
 * 
 * 示例 1:
 * 
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 
 * 示例 2:
 * 
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 * 
 */

// @lc code=start
class Solution {
    // public static void main(String[] args) {
    //     Solution s = new Solution();
    //     int[] array = new int[] {5,7,7,8,8,10};
    //     System.out.println(s.searchRange(array, 8));
    // }

    public int[] searchRange(int[] nums, int target) {
        int len = nums.length ;
        if (nums.length == 0 || nums[0]  > target || nums[len-1] < target) return  new int[] {-1, -1};
        int mid = (0 + len) / 2;
        if (nums[mid] == target) {
            int  left = searchLeft(nums, mid, target);
            int right = searchRight(nums, mid, target);
            if (left > -1 && right > -1) {
                return new int[] {left, right};
            } else if (left == -1) {
                return new int[] {mid, right};
            } else if (right == -1) {
                return new int[] {left, mid};
            }
        } else if (nums[mid] > target) {
            int first = searchLeft(nums, mid, target);
            int last = searchLeftLast(nums, mid, target);
            return  new int[] {first, last};
        } else if (nums[mid] < target) {
            int first = searchRightFirst(nums, mid, target);
            int last = searchRight(nums, mid, target);
            return new int[] {first, last};
        }
        return new int[] {-1, -1};
    }

    public int searchLeft(int[] nums, int mid, int target) {
        int left = -1;
        for (int i = mid - 1; i >= 0; i--) {
            if (nums[i] < target) return left;
            left = (nums[i] == target) ? i : -1;
        }
        return left;
    }

    public int searchLeftLast(int[] nums, int mid, int target) {
        int bound = -1;
        for (int i = mid - 1; i >= 0; i--) {
            if (nums[i] == target) {
                bound = i;
                break;
            }
        }
        return bound;
    }

    public int searchRight(int[] nums, int mid, int target) {
        int right = -1;
        for (int i = mid ; i < nums.length; i++) {
            if (nums[i] > target) return right;
            right = (nums[i] == target) ? i : -1;
        }
        return right;
    }

    public int searchRightFirst(int[] nums, int mid, int target) {
        int bound = -1;
        for (int i = mid + 1; i < nums.length; i++) {
            if (nums[i] == target) {
                bound = i;
                break;
            }
        }
        return bound;
    }
}
// @lc code=end

