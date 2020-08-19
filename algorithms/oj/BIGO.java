package oj;

public class BIGO {
    private static int[] squareSort(int[] nums) {
        int pivot = 0, left = 0, right = 0;
        int[] ret = new int[nums.length];

        // 全为负数
        if (nums[nums.length - 1] < 0) {
            for (int i = nums.length - 1; i >= 0; i--) {
                ret[i] = nums[i] * nums[i];
            }
            return ret;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                pivot = i;
                ret[0] = nums[i] * nums[i];
                break;
            }
        }

        left = pivot - 1;
        right = pivot + 1;
        int pos = 1;
        while (left >= 0 && right <= nums.length - 1) {
            ret[pos++] = Math.min(nums[left] * nums[left], nums[right] * nums[right]);
            if (Math.abs(nums[left]) < Math.abs(nums[right])) left--;
            else right++;
        }

        return ret;
    }
}
