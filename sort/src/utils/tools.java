package utils;

public class tools {
    public static void traceArray(int[] A) {
        for (int i : A)
            System.out.print(i + " "); // ' ' 会导致' '值和相加
        System.out.println();
    }
}
