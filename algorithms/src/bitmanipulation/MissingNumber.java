package src.bitmanipulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 原地法整体思想都是把数组当做hash表来用
 */
public class MissingNumber {
    public static void main(String[] args) {
        MissingNumber test = new MissingNumber();
        int[] nums = new int[]{1, 2, 4, 2};

        System.out.println(test.missingFromN(new int[]{0, 1, 3}));
        System.out.println(test.findDupMiss(nums).toString());
    }


    /**
     * 0~N的排序数组，找0~N谁未出现
     *
     * @param nums 排序数组
     * @return
     */
    public int missingFromN(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res ^= i ^ nums[i];
        }
        return res ^ nums.length;
    }


    /**
     * [1..N] 这 N 个元素，无序，找重复和缺失值
     *
     * @param array
     */
    public List<Integer> findDupMiss(int[] array) {
        List<Integer> list = new ArrayList<>();

        int[] nums = Arrays.copyOf(array, array.length);
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) {
                list.add(Math.abs(nums[i]));
            } else {
                nums[index] *= -1;
            }
        }

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] > 0) {
                list.add(j + 1);
            }
        }

        return list;
    }


    // TODO: 消失的第一个正数
    //  https://leetcode-cn.com/problems/first-missing-positive/solution/tong-pai-xu-python-dai-ma-by-liweiwei1419/
}
