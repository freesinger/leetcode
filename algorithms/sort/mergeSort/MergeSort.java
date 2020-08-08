package sort.mergeSort;

import src.utils.Tools;

import java.util.Arrays;

public class MergeSort {

    private static void merge_sort_recursive(int[] arr, int[] result, int start, int end) {
        if (start >= end)
            return;
        int len = end - start, mid = (len >> 1) + start;
        int start1 = start;
        int start2 = mid + 1;
        merge_sort_recursive(arr, result, start1, mid);
        merge_sort_recursive(arr, result, start2, end);
        int k = start;
        while (start1 <= mid && start2 <= end)
            result[k++] = arr[start1] < arr[start2] ? arr[start1++] : arr[start2++];
        while (start1 <= mid)
            result[k++] = arr[start1++];
        while (start2 <= end)
            result[k++] = arr[start2++];
        for (k = start; k <= end; k++)
            arr[k] = result[k];
        System.out.println(Arrays.toString(arr));
    }


    public static void main(String[] args) {
        int[] test = new int[]{7, 16, 14, 10, 8, 1, 3, 12};
        int[] res = new int[test.length];
        new MergeSort();
        merge_sort_recursive(test, res, 0, test.length - 1);
        Tools.traceArray(test);
    }

}
