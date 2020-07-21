import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=783 lang=java
 *
 * [783] 二叉搜索树结点最小距离
 *
 * https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/description/
 *
 * algorithms
 * Easy (51.03%)
 * Likes:    45
 * Dislikes: 0
 * Total Accepted:    8.9K
 * Total Submissions: 17.2K
 * Testcase Example:  '[4,2,6,1,3,null,null]'
 *
 * 给定一个二叉搜索树的根结点 root, 返回树中任意两节点的差的最小值。
 *
 * 示例：
 *
 *
 * 输入: root = [4,2,6,1,3,null,null]
 * 输出: 1
 * 解释:
 * 注意，root是树结点对象(TreeNode object)，而不是数组。
 *
 * 给定的树 [4,2,6,1,3,null,null] 可表示为下图:
 *
 * ⁠         4
 * ⁠       /   \
 * ⁠     2      6
 * ⁠    / \
 * ⁠   1   3
 *
 * 最小的差值是 1, 它是节点1和节点2的差值, 也是节点3和节点2的差值。
 *
 * 注意：
 *
 *
 * 二叉树的大小范围在 2 到 100。
 * 二叉树总是有效的，每个节点的值都是整数，且不重复。
 *
 *
 */

// @lc code=start

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int min = Integer.MAX_VALUE;
    List<Integer> vals = new ArrayList<>();

    public int minDiffInBST(TreeNode root) {
        helper(root);
        for (int i = 0; i < vals.size() - 1; i++) {
            min = Math.min(min, vals.get(i + 1) - vals.get(i));
        }
        return min;
    }

    private void helper(TreeNode root) {
        if (root != null) {
            if (root.left != null) {
                helper(root.left);
            }
            vals.add(root.val);
            if (root.right != null) {
                helper(root.right);
            }
        }
    }
}
// @lc code=end

