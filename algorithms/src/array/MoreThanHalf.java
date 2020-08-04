package src.array;

public class MoreThanHalf {
    public static void main(String[] args) {
        System.out.println(moreThanHalf(new int[]{1, 3, 2, 4, 2, 2, 2, 5, 2}));
    }

    public static int moreThanHalf(int[] nums) {
        if (nums == null || nums.length <= 0) return 0;
        int cnt = 1;
        int majority = nums[0];

        for (int i = 1; i < nums.length; i++) {
            cnt = nums[i] == majority ? cnt + 1 : cnt - 1;
            if (cnt == 0) {
                cnt = 1;
                majority = nums[i];
            }
        }

        cnt = 0;
        for (int num : nums) {
            cnt = num == majority ? cnt + 1 : cnt;
        }

        return cnt > nums.length / 2 ? majority : 0;
    }
}
