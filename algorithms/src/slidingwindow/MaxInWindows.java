package src.slidingwindow;

import java.util.ArrayList;

public class MaxInWindows {
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> result = new ArrayList<>();
        if (size <= 0 || size > num.length) return result;

        for (int i = 0; i < num.length - size + 1; i++) {
            result.add(findMax(num, i, size));
        }

        return result;
    }

    private int findMax(int[] nums, int start, int size) {
        int max = nums[start];
        for (int i = start; i < start + size; i++) {
            max = Math.max(max, nums[i]);
        }
        return max;
    }

    // TODO: 优先级队列实现
}
