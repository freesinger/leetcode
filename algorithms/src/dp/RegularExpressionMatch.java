package src.dp;

import java.util.Arrays;

/**
 * 实现 . 和 * 的正则表达式匹配
 *
 */
public class RegularExpressionMatch {
    public static void main(String[] args) {
        System.out.println(match("aaa", "a.a"));
    }


    public static boolean match(String str, String pattern) {
        int s = str.length(), p = pattern.length();
        boolean[][] dp = new boolean[s + 1][p + 1];
        dp[0][0] = true;

        for (int i = 1; i <= p; i++) {
            if ((pattern.charAt(i - 1) == '*')) {
                dp[0][i] = dp[0][i - 2];
            }
        }

        for (int i = 1; i <= s; i++) {
            for (int j = 1; j <= p; j++) {
                if (str.charAt(i - 1) == pattern.charAt(j - 1) || pattern.charAt(j - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pattern.charAt(j - 1) == '*') {
                    if (pattern.charAt(j - 2) == str.charAt(i - 1) || pattern.charAt(j - 2) == '.') {
                        dp[i][j] |= dp[i][j - 1]; // a* count as single a
                        dp[i][j] |= dp[i - 1][j]; // a* count as multiple a
                        dp[i][j] |= dp[i][j - 2]; // a* count as empty
                    } else {
                        dp[i][j] = dp[i][j - 2]; //  a* count as empty
                    }
                }
            }
        }
        System.out.println(Arrays.deepToString(dp));

        return dp[s][p];
    }
}
