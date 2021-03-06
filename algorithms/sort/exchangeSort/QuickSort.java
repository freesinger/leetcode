package sort.exchangeSort;

import src.utils.Tools;

import java.util.Arrays;

/**
 * Divide-Conquer
 * 每一趟都确定数组末尾数的位置，再分别对该数左右数组递归调用sort
 * 双指针实现每趟partition为线性时间
 * <p>
 * Time：O(nlog^n)
 * Space: O(nlog^n)
 */
public class QuickSort {
    private final int[] array;

    public QuickSort(int[] array) {
        this.array = array;
    }

    public static void main(String[] args) {
        final int[] test = new int[]{7, 16, 14, 10, 8, 1, 3, 12};
        new QuickSort(test).sort(0, test.length - 1);
        System.out.println(Arrays.toString(test));
    }

    public int partition(int low, int high) {
        // cur用来标记pivot的位置，找到一个比pivot小的数则cur++
        int cur = low;
        int pivot = array[high];

        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                Tools.swapByIndex(array, cur, j);
                cur++;
            }
        }
        // 把pivot放到正确的位置
        Tools.swapByIndex(array, cur, high);
        return cur;
    }

    public void sort(int low, int high) {
        if (low < high) {
            int median = partition(low, high);
            Tools.traceArray(array);
            sort(low, median - 1);
            sort(median + 1, high);
        }
    }
}
