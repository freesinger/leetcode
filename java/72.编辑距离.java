/*
 * @lc app=leetcode.cn id=72 lang=java
 *
 * [72] 编辑距离
 *
 * https://leetcode-cn.com/problems/edit-distance/description/
 *
 * algorithms
 * Hard (55.01%)
 * Likes:    839
 * Dislikes: 0
 * Total Accepted:    56.2K
 * Total Submissions: 94.9K
 * Testcase Example:  '"horse"\n"ros"'
 *
 * 给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
 * 
 * 你可以对一个单词进行如下三种操作：
 * 
 * 
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 * 
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：word1 = "horse", word2 = "ros"
 * 输出：3
 * 解释：
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 * 
 * 
 * 示例 2：
 * 
 * 输入：word1 = "intention", word2 = "execution"
 * 输出：5
 * 解释：
 * intention -> inention (删除 't')
 * inention -> enention (将 'i' 替换为 'e')
 * enention -> exention (将 'n' 替换为 'x')
 * exention -> exection (将 'n' 替换为 'c')
 * exection -> execution (插入 'u')
 * 
 * 
 */

// @lc code=start
class Solution {
    /**
     * dp
     * dp table增加的padding行列赋值重要
     * 联系第1143最长公共子序列
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        int w1 = word1.length(), w2 = word2.length();
        int dp[][] = new int[w1+1][w2+1];

        for (int i = 1; i < w1+1; i++) dp[i][0] = dp[i-1][0] + 1;
        for (int j = 1; j < w2+1; j++) dp[0][j] = dp[0][j-1] + 1;

        for (int i = 1; i < w1+1; i++) {
            for (int j = 1; j < w2+1; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = 1 + Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]);
                }
            }
        }

        return dp[w1][w2];
    }
}
// @lc code=end

