package src.sort.exchangeSort;

import src.utils.Tools;

import java.util.Arrays;

/**
 * Divide-Conquer
 * 每一趟都确定数组末尾数的位置，再分别对该数左右数组递归调用sort
 * 双指针实现每趟partition为线性时间
 *
 * Time：O(nlog^n)
 * Space: O(nlog^n)
 */
public class QuickSort {
    private final int[] array;

    public QuickSort(int[] array) {
        this.array = array;
    }

    public int partition(int low, int high) {
        int cur = low - 1;
        int pivot = array[high];

        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                cur++;
                Tools.swapByIndex(array, cur, j);
            }
        }
        Tools.swapByIndex(array, cur+1, high); // 注意是cur+1

        return cur+1;
    }

    public void sort(int low, int high) {
        if (low < high) {
            int median = partition(low, high);
            Tools.traceArray(array);
            sort(low, median-1);
            sort(median+1, high);
        }
    }

    public static void main(String[] args) {
        final int[] test = new int[] {7, 16, 14, 10, 8, 1, 3, 12};
        new QuickSort(test).sort(0, test.length-1);
        System.out.println(Arrays.toString(test));
    }
}
