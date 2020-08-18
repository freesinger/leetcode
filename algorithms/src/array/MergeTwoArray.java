package src.array;

import java.util.Arrays;

/**
 * 合并数组
 */
public class MergeTwoArray {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(merge(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3)));
    }

    private static int[] merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1 == null || nums2 == null) return new int[]{};

        int idx = nums1.length - 1;
        m--;
        n--;
        while (m >= 0 && n >= 0 && idx >= 0) {
            nums1[idx] = Math.max(nums1[m], nums2[n]);
            if (nums1[m] < nums2[n]) n--;
            else m--;
            idx--;
        }


        return nums1;
    }
}
