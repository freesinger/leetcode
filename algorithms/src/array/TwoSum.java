package src.array;

public class TwoSum {
    private static int res;
    //public int res;

    public static void main(String[] args) {
        TwoSum main = new TwoSum();
        main.sum(new int[]{1, 1, 2, 3, 4, 5, 6, 7, 7, 8, 9}, 8);
        System.out.println(res);
    }


    public void sum(int[] nums, int target) {
        if (nums == null || nums.length == 0) return;
        int left = 0, right = nums.length - 1;

        while (left < right) {
            //int mid = left + (right - left) >> 1;
            while (left < right && left < nums.length) {
                if (nums[left] == nums[left + 1]) {
                    left++;
                } else {
                    break;
                }
            }

            while (right > left && right >= 0) {
                if (nums[right] == nums[right - 1]) {
                    right--;
                } else {
                    break;
                }

            }
            if (nums[left] + nums[right] > target) {
                right--;
            } else if (nums[left] + nums[right] < target) {
                left++;
            } else {
                res++;
                left++;
                right--;
            }
        }
    }
}
