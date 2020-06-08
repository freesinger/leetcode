package src.sort.countingSort;

import src.utils.Tools;

/**
 * 类似HashMap思想
 * 用数组存储出现次数再写入
 */
public class CountingSort {
    private int[] arr;

    public CountingSort(int[] arr) {
        this.arr = arr;
    }

    public void countingSort() {
        int maxVal = Integer.MIN_VALUE;
        for (int num : arr) maxVal = maxVal < num ? num : maxVal;

        int[] bucket = new int[maxVal+1];
        for (int num : arr) bucket[num]++;

        int index = 0;
        for (int i = 0; i < bucket.length; i++) {
            while (bucket[i] > 0) {
                arr[index++] = i;
                bucket[i]--;
            }
        }
        Tools.traceArray(arr);
    }

    public static void main(String[] args) {
        new CountingSort(new int[] {1, 4, 1, 2, 7, 5, 2}).countingSort();
    }
}
