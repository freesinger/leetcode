package innerclass;

import java.util.Arrays;
import java.util.Comparator;

public class AnonymousInnerClass {
    public static void main(String[] args) {
        int[][] array = new int[][]{{2, 3}, {7, 1}, {99, 12}, {8, 21}};


        Arrays.sort(array, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });

        // Arrays.sort(array, (o1, o2) -> o2[1] - o1[1]);

        System.out.println(Arrays.deepToString(array));
    }
}
