package src.string;

import java.util.Arrays;

/**
 * 整数数组组合出的最小整数
 *
 */
public class PrintMinNumber {
    public static void main(String[] args) {
        System.out.println(printMin(new int[]{89, 21, 32, 122, 422}));
    }

    private static String printMin(int[] nums) {
        if (nums == null || nums.length == 0) return "";

        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) strs[i] = String.valueOf(nums[i]);

        // 升序组合，两两有序则整个数组有序
        // eg: a = 32, b = 3
        // a + b = 323 < b + a = 332
        // 则排序后位置 ..., a, ..., b, ...
        Arrays.sort(strs, (a, b) -> (a + b).compareTo(b + a));
        StringBuilder sb = new StringBuilder();
        for (String str : strs) sb.append(str);

        return sb.toString();
    }
}
