package src.binarysearch;

/**
 * 数字在排序数组中出现的次数
 *
 */
public class GetNumberOfK {
    public static void main(String[] args) {
        int[] test = new int[]{1, 2, 3, 3, 3, 4, 6};
        System.out.println(getNumberOfK(test, 3));
    }

    private static int getNumberOfK(int[] nums, int K) {
        int first = getNumberIndex(nums, K);
        int next = getNumberIndex(nums, K + 1);
        return (first == nums.length || nums[first] != K) ? 0 : next - first;
    }


    private static int getNumberIndex(int[] nums, int K) {
        if (nums == null || nums.length == 0) return -1;
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= K) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        // System.out.println(left);
        return left;
    }
}
