package src.array;

import src.utils.Tools;

import java.util.Arrays;

/**
 * 重排数组，奇前偶后
 */
public class ReorderArray {
    public static void main(String[] args) {
        int[] test = new int[]{1, 2, 3, 4, 5, 6};
        reorder(test);
    }

    /**
     * 冒泡法
     *
     * @param nums
     */
    private static void reorder(int[] nums) {
        if (nums == null || nums.length <= 1) return;
        int l = nums.length - 1;
        for (int i = l; i >= 0; i--) {    // 冒泡次数
            for (int j = 0; j < l; j++) { // 上浮过程
                if (isEven(nums[j]) && !isEven(nums[j + 1])) {
                    Tools.swapByIndex(nums, j, j + 1);
                }
            }
            System.out.println(Arrays.toString(nums));
        }
    }

    private static boolean isEven(int n) {
        return n % 2 == 0;
    }
}
