import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=257 lang=java
 *
 * [257] 二叉树的所有路径
 *
 * https://leetcode-cn.com/problems/binary-tree-paths/description/
 *
 * algorithms
 * Easy (60.69%)
 * Likes:    178
 * Dislikes: 0
 * Total Accepted:    20.6K
 * Total Submissions: 33.6K
 * Testcase Example:  '[1,2,3,null,5]'
 *
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 * 
 * 说明: 叶子节点是指没有子节点的节点。
 * 
 * 示例:
 * 
 * 输入:
 * 
 * ⁠  1
 * ⁠/   \
 * 2     3
 * ⁠\
 * ⁠ 5
 * 
 * 输出: ["1->2->5", "1->3"]
 * 
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 * 
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    List<String> res = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        constrcut_path(root, "", res);

        return res;
    }

    private void constrcut_path(TreeNode root, String path, List<String> res) {
        if (root != null) {
            path += Integer.toString(root.val);
            if (root.left == null && root.right == null) res.add(path);
            else {
                path += "->";
                constrcut_path(root.left, path, res);
                constrcut_path(root.right, path, res);
            }
        }
    }
}
// @lc code=end

