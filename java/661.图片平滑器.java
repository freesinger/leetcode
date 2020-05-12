/*
 * @lc app=leetcode.cn id=661 lang=java
 *
 * [661] 图片平滑器
 *
 * https://leetcode-cn.com/problems/image-smoother/description/
 *
 * algorithms
 * Easy (50.82%)
 * Likes:    47
 * Dislikes: 0
 * Total Accepted:    7.3K
 * Total Submissions: 13.7K
 * Testcase Example:  '[[1,1,1],[1,0,1],[1,1,1]]'
 *
 * 包含整数的二维矩阵 M 表示一个图片的灰度。你需要设计一个平滑器来让每一个单元的灰度成为平均灰度 (向下舍入)
 * ，平均灰度的计算是周围的8个单元和它本身的值求平均，如果周围的单元格不足八个，则尽可能多的利用它们。
 * 
 * 示例 1:
 * 
 * 
 * 输入:
 * [[1,1,1],
 * ⁠[1,0,1],
 * ⁠[1,1,1]]
 * 输出:
 * [[0, 0, 0],
 * ⁠[0, 0, 0],
 * ⁠[0, 0, 0]]
 * 解释:
 * 对于点 (0,0), (0,2), (2,0), (2,2): 平均(3/4) = 平均(0.75) = 0
 * 对于点 (0,1), (1,0), (1,2), (2,1): 平均(5/6) = 平均(0.83333333) = 0
 * 对于点 (1,1): 平均(8/9) = 平均(0.88888889) = 0
 * 
 * 
 * 注意:
 * 
 * 
 * 给定矩阵中的整数范围为 [0, 255]。
 * 矩阵的长和宽的范围均为 [1, 150]。
 * 
 * 
 */

// @lc code=start
class Solution {
    public int[][] imageSmoother(int[][] M) {
        int[][] res = new int[M.length][M[0].length];
        int[][] posMat = new int[][] {{-1, -1}, {-1, 0}, {-1, 1},
                                      {0, -1}, {0, 0}, {0, 1},
                                      {1, -1}, {1, 0}, {1, 1}};

        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[0].length; j++) {
                int sum = 0;
                int cnt = 0;
                for (int k = 0; k < posMat.length; k++) {
                    if (i+posMat[k][0] >= 0 && i+posMat[k][0] < M.length && j+posMat[k][1] >= 0 && j+posMat[k][1] < M[0].length) {
                        sum += M[i+posMat[k][0]][j+posMat[k][1]];
                        cnt++;
                    }
                }

                res[i][j] = sum / cnt;
            }
        }

        return res;
    }
}
// @lc code=end

