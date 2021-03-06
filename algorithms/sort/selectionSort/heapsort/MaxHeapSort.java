package sort.selectionSort.heapsort;

import src.utils.Tools;

import java.util.Arrays;

/**
 * 建立大顶堆，不断迭代将当前最大元素与堆尾元素交换
 * Time: O(nLog^n)
 * Space: O(1)
 *
 * @author: Shane
 * @date: 2020/5/29
 */
public class MaxHeapSort {
    private int[] array;

    public MaxHeapSort(int[] array) {
        this.array = array;
    }

    public static void main(String[] args) {
        final int[] test = new int[]{7, 16, 14, 10, 8, 1, 3, 12};
        new MaxHeapSort(test).heapSort();
        System.out.println(Arrays.toString(test));
    }

    private void buildMaxHeap() {
        for (int i = array.length / 2; i >= 0; i--) heapify(array.length, i);
    }

    private void heapify(int heapSize, int curId) {
        int largest = curId;
        int left = 2 * curId + 1;
        int right = 2 * curId + 2;

        largest = (left < heapSize && array[left] > array[largest]) ? left : largest;
        largest = (right < heapSize && array[right] > array[largest]) ? right : largest;
        if (largest != curId) {
            Tools.swapByIndex(array, largest, curId);
            // 每次交换元素后都需要对改变的结点递归
            heapify(heapSize, largest);
        }
    }

    private void heapSort() {
        Tools.traceArray(array);
        buildMaxHeap();
        Tools.traceArray(array);
        int heapSize = array.length;
        for (int i = heapSize - 1; i >= 0; i--) {
            Tools.swapByIndex(array, i, 0);
            Tools.traceArray(array);
            //heapSize--;
            heapify(i, 0);
            Tools.traceArray(array);
        }
    }
}
