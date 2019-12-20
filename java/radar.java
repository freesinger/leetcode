package Java;

import java.util.Scanner;

class Radar {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        //final int n = Integer.parseInt(args[0]);
        //System.out.println(n);
        //final int m = Integer.parseInt(args[1]);
        int n = 0, m = 0;
        n = sc.nextInt();
        m = sc.nextInt();
        int[][] mat = getMat(n);
        double res = Double.MIN_VALUE;

        for (int row = 0; row < n-m+1; row++) {
            for (int col = 0; col < n-m+1; col++) {
                res = Math.max(res, meanSubMat(m, mat, row, col));
            }
        }
        System.out.println(res);
    }

    public static int[][] getMat(int n) {
        int[][] mat = new int[n][n];
    
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = sc.nextInt();
            }
        }

        return mat;
    }

    public static double meanSubMat(int m, int[][] mat, int row, int col) {
        int sum = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                sum += mat[row+i][col+j];
            }
        }
        System.out.println(sum);
        //System.out.println(Math.ceil((double)sum / (double)(m*m)));
        return Math.ceil((double)sum / (double)(m*m));
    }
}