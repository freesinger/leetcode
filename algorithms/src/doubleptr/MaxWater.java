package src.doubleptr;

/**
 * 最大装水容器
 */
public class MaxWater {
    public int maxWater(int[] buckets) {
        int left = 0, right = buckets.length - 1;
        int max = -1;

        while (left < right) {
            int curWater = Math.min(buckets[left], buckets[right]) * (right - left);
            max = Math.max(max, curWater);
            if (buckets[left] < buckets[right]) left++;
            else right--;
        }

        return max;
    }
}
