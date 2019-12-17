/*
 * @lc app=leetcode.cn id=1219 lang=java
 *
 * [1219] 黄金矿工
 *
 * https://leetcode-cn.com/problems/path-with-maximum-gold/description/
 *
 * algorithms
 * Medium (59.53%)
 * Likes:    10
 * Dislikes: 0
 * Total Accepted:    1.8K
 * Total Submissions: 3.1K
 * Testcase Example:  '[[0,6,0],[5,8,7],[0,9,0]]'
 *
 * 你要开发一座金矿，地质勘测学家已经探明了这座金矿中的资源分布，并用大小为 m * n 的网格 grid
 * 进行了标注。每个单元格中的整数就表示这一单元格中的黄金数量；如果该单元格是空的，那么就是 0。
 * 
 * 为了使收益最大化，矿工需要按以下规则来开采黄金：
 * 
 * 
 * 每当矿工进入一个单元，就会收集该单元格中的所有黄金。
 * 矿工每次可以从当前位置向上下左右四个方向走。
 * 每个单元格只能被开采（进入）一次。
 * 不得开采（进入）黄金数目为 0 的单元格。
 * 矿工可以从网格中 任意一个 有黄金的单元格出发或者是停止。
 * 
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：grid = [[0,6,0],[5,8,7],[0,9,0]]
 * 输出：24
 * 解释：
 * [[0,6,0],
 * ⁠[5,8,7],
 * ⁠[0,9,0]]
 * 一种收集最多黄金的路线是：9 -> 8 -> 7。
 * 
 * 
 * 示例 2：
 * 
 * 输入：grid = [[1,0,7],[2,0,6],[3,4,5],[0,3,0],[9,0,20]]
 * 输出：28
 * 解释：
 * [[1,0,7],
 * ⁠[2,0,6],
 * ⁠[3,4,5],
 * ⁠[0,3,0],
 * ⁠[9,0,20]]
 * 一种收集最多黄金的路线是：1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7。
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= grid.length, grid[i].length <= 15
 * 0 <= grid[i][j] <= 100
 * 最多 25 个单元格中有黄金。
 * 
 * 
 */

// @lc code=start
class Solution {
    // not static
    private int max = 0;

    public int getMaximumGold(int[][] grid) {
        if (grid == null) return 0;

        int row = grid.length;
        int col = grid[0].length;
        boolean[][] vis = new boolean[row][col];
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (grid[r][c] != 0) dfs(grid, r, c, 0, vis);
            }
        }

        return max;
    }

    private void dfs(int[][] grid, int x, int y, int gold, boolean[][] vis) {
        if ((x < 0 || x >= grid.length) ||
            (y < 0 || y >= grid[0].length) ||
            (grid[x][y] == 0) ||
            (vis[x][y])) {
                max = Math.max(max, gold);
                return;
            }
        gold += grid[x][y];
        vis[x][y] = true;
        dfs(grid, x-1, y, gold, vis);
        dfs(grid, x+1, y, gold, vis);
        dfs(grid, x, y-1, gold, vis);
        dfs(grid, x, y+1, gold, vis);
        // 挖完矿之后要还原状态给其他起始点做dfs
        vis[x][y] = false;
        
        return;
    }
}
// @lc code=end

