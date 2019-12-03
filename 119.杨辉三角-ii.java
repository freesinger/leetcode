import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=119 lang=java
 *
 * [119] 杨辉三角 II
 *
 * https://leetcode-cn.com/problems/pascals-triangle-ii/description/
 *
 * algorithms
 * Easy (59.04%)
 * Likes:    95
 * Dislikes: 0
 * Total Accepted:    30.9K
 * Total Submissions: 52.3K
 * Testcase Example:  '3'
 *
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 * 
 * 
 * 
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * 
 * 示例:
 * 
 * 输入: 3
 * 输出: [1,3,3,1]
 * 
 * 
 * 进阶：
 * 
 * 你可以优化你的算法到 O(k) 空间复杂度吗？
 * 
 */

// @lc code=start
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        // if (rowIndex == 0) return res;
        res.add(1);
        if (rowIndex == 0) return res;

        List<List<Integer>> tmp = new ArrayList<>();
        tmp.add(res);
        for (int row = 1; row < rowIndex+1; row++) {
            tmp.add(new ArrayList<>());
            tmp.get(row).add(1);
            for (int pos = 1; pos < row; pos++) {
                tmp.get(row).add(tmp.get(row-1).get(pos-1)+tmp.get(row-1).get(pos));
            }
            tmp.get(row).add(1);
        }
        
        return tmp.get(tmp.size()-1);
    }
}
// @lc code=end

