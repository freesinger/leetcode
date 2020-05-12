package insertionSort;

public class insertionSort {
    private static void insertionSort(int[] A) {
        int len = A.length;

        for (int i = 1; i < len; i++) {
            int cur = A[i];
            int j = i-1;
            while (j >= 0 && A[i] > cur) {
                A[j+1] = A[j];
                j--;
            }
            A[j+1] = cur;
            traceArray(A);
        }
    }

    private static void traceArray(int[] A) {
        for (int i : A) {
            System.out.print(i);
            System.out.print(' ');
        }
        System.out.println();
    }

    public static void main(String[] args, int argv) {
        int[] arrayToSort = new int[] {8, 3, 1, 5, 2, 1};
        insertionSort(arrayToSort);
        return;
    }
}
