package src.doubleptr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public static void main(String[] args) {
        System.out.println(new ThreeSum().threeSum(new int[]{-4, -1, -1, 0, 1, 2}));
    }

    private List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        if (nums == null || nums.length < 3) return res;
        Arrays.sort(nums);
        if (nums[0] > 0) return res;
        // List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        // Set<Integer> set = new HashSet<>(l);

        for (int i = 0; i < nums.length; i++) {
            // 去重
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int cur = nums[i];
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int curSum = nums[left] + nums[right] + cur;
                if (curSum > 0) {
                    right--;
                } else if (curSum < 0) {
                    left++;
                } else {
                    res.add(Arrays.asList(cur, nums[left], nums[right]));
                    // 去重
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (right > left && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                }
            }
        }

        return res;
    }
}
