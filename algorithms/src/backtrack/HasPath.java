package src.backtrack;

import src.backtrack.basebacktrack.BaseBackTrack;

import java.util.Arrays;

/**
 * 矩阵路径是否存在目标字符串的路径
 */
public class HasPath extends BaseBackTrack {
    private static final int[][] directions = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    private static final String str = "bcdefgf";

    public static void main(String[] args) {
        HasPath test = new HasPath();
        char[] target = str.toCharArray();
        char[][] mat = test.buildMatrix(4, 5);
        System.out.println(Arrays.deepToString(mat));
        System.out.println(test.hasPath(mat, target));
    }

    private boolean hasPath(char[][] matrix, char[] target) {
        if (matrix == null || target == null) return false;
        boolean[][] marked = new boolean[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[0].length; j++)
                if (backTrack(target, matrix, marked, i, j, 0)) return true;

        return false;
    }


    private boolean backTrack(char[] target, char[][] matrix, boolean[][] marked, int r, int c, int curLen) {
        if (curLen == target.length) return true;

        if (r < 0 || r >= matrix.length || c < 0 || c >= matrix[0].length || matrix[r][c] != target[curLen] || marked[r][c])
            return false;

        curLen++;
        marked[r][c] = true;
        for (int[] d : directions)
            if (backTrack(target, matrix, marked, r + d[0], c + d[1], curLen)) return true;
        marked[r][c] = false;

        return false;
    }

    private char[][] buildMatrix(int r, int c) {
        char[][] mat = new char[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                mat[i][j] = (char) (i + j + 'a');
            }
        }
        return mat;
    }

}
