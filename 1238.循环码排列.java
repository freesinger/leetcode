import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=1238 lang=java
 *
 * [1238] 循环码排列
 *
 * https://leetcode-cn.com/problems/circular-permutation-in-binary-representation/description/
 *
 * algorithms
 * Medium (57.06%)
 * Likes:    5
 * Dislikes: 0
 * Total Accepted:    1.2K
 * Total Submissions: 2K
 * Testcase Example:  '2\n3'
 *
 * 给你两个整数 n 和 start。你的任务是返回任意 (0,1,2,,...,2^n-1) 的排列 p，并且满足：
 * 
 * 
 * p[0] = start
 * p[i] 和 p[i+1] 的二进制表示形式只有一位不同
 * p[0] 和 p[2^n -1] 的二进制表示形式也只有一位不同
 * 
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：n = 2, start = 3
 * 输出：[3,2,0,1]
 * 解释：这个排列的二进制表示是 (11,10,00,01)
 * ⁠    所有的相邻元素都有一位是不同的，另一个有效的排列是 [3,1,0,2]
 * 
 * 
 * 示例 2：
 * 
 * 输出：n = 3, start = 2
 * 输出：[2,6,7,5,4,0,1,3]
 * 解释：这个排列的二进制表示是 (010,110,111,101,100,000,001,011)
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= n <= 16
 * 0 <= start < 2^n
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<Integer> circularPermutation(int n, int start) {
        List<Integer> ans = new ArrayList<Integer>();
        boolean[] vis = new boolean[1 << n];
        ans.add(start);
        vis[start] = true;

        for (int i = 1; i < (1 << n); i++) {
            for (int j = 0; j < n; j++) {
                // 1 << j实现从低位向高位依次翻转，默认为0开始
                // start ^ 转化为当前满足的数（相当给了offset）
                int t = start ^ (1 << j);
                // 若未在结果中出现则写入
                if (!vis[t]) {
                    start = t;
                    break;
                }
            }
            vis[start] = true;
            ans.add(start);
        }

        return ans;
    }
}
// @lc code=end

