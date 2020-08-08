package src.array;

/**
 * 连续子数组的最大和
 *
 */
public class FindGreatestSumOfSubArray {
    public static void main(String[] args) {
        System.out.println(finMaxSum(new int[] {6, -3, -2, 7, -15, 1, 2, 2}));
    }

    private static int finMaxSum(int[] array) {
        if (array == null || array.length == 0) return 0;
        int sum = 0, max = Integer.MIN_VALUE;
        for (int num : array) {
            sum = sum < 0 ? num : sum + num;
            max = Math.max(max, sum);
        }

        return max;
    }
}
