package sort.insertionSort;

import src.utils.Tools;

public class ShellSort {
    /**
     * 变步长插排，适用于数组长度较长，较为无序的数组排序
     * 步长缩小过程中数组逐渐变得有序
     * Time: O(n^1.25)
     * Space: O(1)
     *
     * @param array
     */
    private static void shellSort(int[] array) {
        int n = array.length;

        // 间隔不断缩小，最后一次为gap=1的普通插排
        for (int gap = n / 2; gap > 0; gap /= 2) {
            // 每次从gap处开始将右侧数组元素进行插排
            for (int i = gap; i < n; i++) {
                int curNum = array[i];
                // 间隔为gap的插排
                while (i - gap >= 0 && array[i - gap] > curNum) {
                    array[i] = array[i - gap];
                    i -= gap;
                }
                array[i] = curNum;
            }
            Tools.traceArray(array);

        }

    }


    public static void main(String[] args) {
        int[] arrayToSort = new int[]{72, 66, 39, 92, 68, 29, 88, 46};
        shellSort(arrayToSort);
        return;
    }
}
