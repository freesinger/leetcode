package src.binarysearch;

/**
 * 寻找峰值元素
 */
public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        int len = nums.length;
        int left = 0, right = len - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1]) {
                // 可能mid位置就是峰值 不是mid-1
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

}
