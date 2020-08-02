package sort.selectionSort;

import src.utils.Tools;

public class SelectionSort {
    /**
     * 直接选择排序 (Unstable)
     * 每次遍历确定最小值，和无序数组首位交换
     * Time: O(n^2)
     * Space: O(1)
     *
     * @param A Array to sort
     */
    public static void selectionSort(int[] A) {
        for (int i = 0; i < A.length - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < A.length; j++) {
                minIdx = A[j] < A[minIdx] ? j : minIdx;
            }
            Tools.swapByIndex(A, minIdx, i);
            Tools.traceArray(A);
        }

    }

    public static void main(String[] args) {
        int[] arrayToSort = new int[]{8, 3, 1, 5, 2, 1};
        selectionSort(arrayToSort);
    }
}
