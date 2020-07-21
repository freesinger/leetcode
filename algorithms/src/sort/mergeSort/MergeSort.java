package src.sort.mergeSort;

import src.utils.Tools;

public class MergeSort {
//    private int[] array;
//    private int[] result;

//    public MergeSort(int[] array, int[] result) {
//        this.array = array;
//        this.result = result;
//    }

//    public void recursive(int[] array, int[] result, int left, int right) {
//        if (left >= right) return;
//        int mid = (right - left) >> 1 + left;
//        recursive(array, result, left, mid);
//        // Tools.traceArray(array);
//        recursive(array, result, mid+1, right);
//        // Tools.traceArray(array);
//
//        int i = left, j = mid, k = mid+1;
//        while (left <= j && k <= right) {
//            result[i++] = array[left] < array[k] ? array[left++] : array[k++];
//        }
//        while (left <= j) result[i++] = array[left++];
//        while (k <= right) result[i++] = array[k++];
//        // 排序完成写会原数组
//        for (int start = left; start <= right; start++) array[start] = result[start];
//    }

    static void merge_sort_recursive(int[] arr, int[] result, int start, int end) {
        if (start >= end)
            return;
        int len = end - start, mid = (len >> 1) + start;
        int start1 = start, end1 = mid;
        int start2 = mid + 1, end2 = end;
        merge_sort_recursive(arr, result, start1, end1);
        merge_sort_recursive(arr, result, start2, end2);
        int k = start;
        while (start1 <= end1 && start2 <= end2)
            result[k++] = arr[start1] < arr[start2] ? arr[start1++] : arr[start2++];
        while (start1 <= end1)
            result[k++] = arr[start1++];
        while (start2 <= end2)
            result[k++] = arr[start2++];
        for (k = start; k <= end; k++)
            arr[k] = result[k];
    }


    public static void main(String[] args) {
        int[] test = new int[]{7, 16, 14, 10, 8, 1, 3, 12};
        int[] res = new int[test.length];
        new MergeSort().merge_sort_recursive(test, res, 0, test.length - 1);
        Tools.traceArray(test);
    }

}
