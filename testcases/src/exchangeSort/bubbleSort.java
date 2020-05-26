package exchangeSort;

import static utils.tools.traceArray;

public class bubbleSort {
    /**
     * 冒泡排序 （Stable）
     * 每趟确定一个第k大/小数，放到队尾/首
     * Time: O(N^2)
     * Space: O(1)
     *
     * @param A
     */
    public static void bubbleSort(int[] A) {
        for (int i = 0; i < A.length-1; i++) {
            for (int j = 0; j < A.length-i-1; j++)
                if (A[j] > A[j+1]) {
                    int t = A[j];
                    A[j] = A[j+1];
                    A[j+1] = t;
                }
            traceArray(A);
        }
    }

    public static void main(String[] args) {
        int[] arrayToSort = new int[] {8, 3, 1, 5, 2, 1};
        bubbleSort(arrayToSort);
        return;
    }
}
