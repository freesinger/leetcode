package sort.selectionSort.heapsort;

import src.utils.Tools;

import java.util.Arrays;

public class MinHeapSort {
    private int[] nums;

    public MinHeapSort(int[] nums) {
        this.nums = nums;
    }

    public static void main(String[] args) {
        final int[] nums = new int[]{7, 16, 14, 10, 8, 1, 3, 12};
        MinHeapSort test = new MinHeapSort(nums);
        test.heapSort();
        System.out.println(Arrays.toString(nums));
    }

    private void buildHeap() {
        for (int i = nums.length / 2; i >= 0; i--) {
            heapify(i, nums.length);
        }
    }

    private void heapify(int curRoot, int heapSize) {
        int min = curRoot;
        int left = min * 2 + 1;
        int right = min * 2 + 2;

        min = (left < heapSize && nums[left] < nums[min]) ? left : min;
        min = (right < heapSize && nums[right] < nums[min]) ? right : min;
        if (min != curRoot) {
            Tools.swapByIndex(nums, min, curRoot);
            heapify(min, heapSize);
        }
    }

    private void heapSort() {
        //Tools.traceArray(nums);
        buildHeap();
        //Tools.traceArray(nums);
        int headSize = nums.length;
        for (int i = headSize - 1; i >= 0; i--) {
            Tools.swapByIndex(nums, i, 0);
            // 和堆顶元素交换之后需要减小堆的大小
            heapify(0, i);
            //Tools.traceArray(nums);
        }
    }
}
