package sword;

import java.util.ArrayList;
import java.util.List;

/**
 * 顺时针打印二维数组
 */
public class PrintMatrix {
    public static void main(String[] args) {
        int[][] matrix = new int[3][4];
        int val = 1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                matrix[i][j] = val++;
            }
        }

        printMatrix(matrix);
        printMatrix(new int[][]{{1, 2, 3}, {4, 5, 6}});
    }

    public static void printMatrix(int[][] m) {
        int r = m.length - 1, c = m[0].length - 1;
        List<Integer> res = new ArrayList<>();
        int r1 = 0, c1 = 0;

        // 注意边界条件
        while (r1 <= r && c1 <= c) {
            for (int i = c1; i <= c; i++) {
                res.add(m[r1][i]);
            }

            for (int j = r1 + 1; j <= r; j++) {
                res.add(m[j][c]);
            }

            // 考虑只有一行的时候不能重复打印
            if (r1 < r) {
                for (int k = c - 1; k >= c1; k--) {
                    res.add(m[r][k]);
                }
            }

            // 考虑只有一列的时候
            if (c1 < c) {
                for (int l = r - 1; l > r1; l--) {
                    res.add(m[l][c1]);
                }
            }

            r1++;
            r--;
            c1++;
            c--;
        }
        System.out.println(res.toString());
    }
}
