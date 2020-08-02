package sort.insertionSort;

import src.utils.Tools;

import java.util.List;

import static src.utils.Tools.intArrayToList;
import static src.utils.Tools.traceArray;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arrayToSort = new int[]{8, 3, 1, 5, 2, 1};
        // List<Integer> list = Arrays.stream(arrayToSort).boxed().collect(Collectors.toList());
        List<Integer> list = intArrayToList(arrayToSort);
        new InsertionSort().insertionSort(arrayToSort);
        assert list != null;
        new InsertionSort().insertionSort(list);
    }

    /**
     * 直接插入排序（Stable)
     * 数组始终保持结构：有序数组 + 无序数组
     * 遍历数组所有元素，从后向前找插入位置并移动数组元素
     * Time：O(N^2)
     * Space: O(1)
     *
     * @param A
     */
    public void insertionSort(int[] A) {
        if (A == null || A.length <= 1) return;
        for (int i = 1; i < A.length; i++) {
            int cur = A[i];
            int j = i - 1;
            while (j >= 0 && A[j] > cur) {
                A[j + 1] = A[j];
                j--;
            }
            A[j + 1] = cur;
            traceArray(A);
        }
    }

    public void insertionSort(List<Integer> list) {
        for (int i = 1; i < list.size(); i++) {
            int cur = list.get(i);
            int j = i - 1;
            while (j >= 0 && list.get(j) > cur) {
                list.set(j + 1, list.get(j));
                j--;
            }
            list.set(j + 1, cur);
            Tools.traceList(list);
        }
    }
}