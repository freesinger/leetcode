package oj;

public class BIGOoj {
    public static void main(String[] args) {
        System.out.println(findElement(new int[]{3, 4, 5, 6, 7, 0, 1, 2}, 5));
    }

    private static int findElement(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;

        int r = nums.length - 1, l = 0, mid = 0;

        while (l <= r) {
            mid = l + (r - l) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] > nums[l]) {
                if (nums[l] < target && nums[r] > target) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (nums[mid] < target && nums[r] > target) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }

        return -1;
    }

}
