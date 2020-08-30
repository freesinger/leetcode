package src.dp;

/**
 * 最短编辑距离
 */
public class MinEditDistance {

    public static void main(String[] args) {
        System.out.println(new MinEditDistance().minDistance("rad", "apple"));
    }

    public int minDistance(String a, String b) {
        return dp(a, b);
    }

    private int dp(String a, String b) {
        int m = a.length(), n = b.length();
        int[][] dpTable = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            dpTable[i][0] = i;
        }
        for (int j = 1; j <= n; j++) {
            dpTable[0][j] = j;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char ch1 = a.charAt(i - 1), ch2 = b.charAt(j - 1);
                if (ch1 == ch2) {
                    dpTable[i][j] = dpTable[i - 1][j - 1];
                } else {
                    dpTable[i][j] = Math.min(Math.min(dpTable[i - 1][j], dpTable[i][j - 1]), dpTable[i - 1][j - 1]) + 1;
                }
            }
        }

        return dpTable[m][n];
    }
}
