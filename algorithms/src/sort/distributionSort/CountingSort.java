package src.sort.distributionSort;

import src.sort.basesort.AbstractSort;
import src.sort.basesort.Sorts;
import src.utils.Tools;

/**
 * 类似HashMap思想
 * 用储出现次数再写入
 */
public class CountingSort extends AbstractSort implements Sorts {
    private int[] arr;

    public CountingSort() {};

    public CountingSort(int[] arr) {
        this.arr = arr;
    }

    @Override
    public void sort() {
        countingSort(arr, 1);
    }

    public void countingSort() {
        int[] result = new int[arr.length];
        int maxVal = Integer.MIN_VALUE;
        for (int num : arr) maxVal = Math.max(maxVal, num);

        int[] bucket = new int[maxVal+1];
        for (int num : arr) bucket[num]++;
        for (int i = 1; i < bucket.length; i++) bucket[i] += bucket[i-1];

        for (int value : arr) {
            result[--bucket[value]] = value;
            // bucket[arr[i]]--;
        }
        System.arraycopy(result, 0, arr, 0, arr.length);
        Tools.traceArray(arr);
    }

    /**
     * 基数排序调用
     *
     * @param array
     * @param placeValue 10^n
     */
    public void countingSort(int[] array, int placeValue) {
        int[] frequencies = new int[TEN];
        int[] result = new int[array.length];

        try {
            for (int num : array) {
                int digit = (num / placeValue) % TEN;
                frequencies[digit]++;
            }

            for (int i = 1; i < frequencies.length; i++) frequencies[i] += frequencies[i-1];
            // 逆序写入保证stable且结果正确
            for (int j = array.length-1; j >= 0; j--) {
            // for (int j = 0; j < array.length; j++) {
                int digit = (array[j] / placeValue) % TEN;
                result[--frequencies[digit]] = array[j];
            }
        } catch (Exception e) {
            // System.out.println(placeValue);
            logger.error("Counting sort failed!");
            e.printStackTrace();
        }
        System.arraycopy(result, 0, array, 0, array.length);
        Tools.traceArray(array);
    }

    public static void main(String[] args) {
        new CountingSort(new int[] {1, 4, 1, 2, 7, 5, 2}).sort();
    }
}
