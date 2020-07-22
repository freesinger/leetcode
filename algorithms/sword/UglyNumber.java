package sword;

public class UglyNumber {
    public int GetUglyNumber_Solution(int N) {
        if (N <= 6) return N;
        int i2 = 0, i3 = 0, i5 = 0;
        int[] nums = new int[N];
        nums[0] = 1;

        for (int i = 1; i < N; i++) {
            int next2 = nums[i2] * 2, next3 = nums[i3] * 3, next5 = nums[i5] * 5;
            int min = Math.min(Math.min(next2, next3), next5);
            nums[i] = min;

            if (min == next2) i2++;
            if (min == next3) i3++;
            if (min == next5) i5++;
        }

        return nums[N - 1];
    }
}
