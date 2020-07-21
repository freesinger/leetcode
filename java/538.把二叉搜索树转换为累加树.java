/*
 * @lc app=leetcode.cn id=538 lang=java
 *
 * [538] 把二叉搜索树转换为累加树
 *
 * https://leetcode-cn.com/problems/convert-bst-to-greater-tree/description/
 *
 * algorithms
 * Easy (57.33%)
 * Likes:    225
 * Dislikes: 0
 * Total Accepted:    20.5K
 * Total Submissions: 34.2K
 * Testcase Example:  '[5,2,13]'
 *
 * 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater
 * Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
 *
 *
 *
 * 例如：
 *
 * 输入: 原始二叉搜索树:
 * ⁠             5
 * ⁠           /   \
 * ⁠          2     13
 *
 * 输出: 转换为累加树:
 * ⁠            18
 * ⁠           /   \
 * ⁠         20     13
 *
 *
 *
 *
 * 注意：本题和 1038:
 *
 * https://leetcode-cn.com/problems/binary-search-tree-to-greater-sum-tree/ 相同
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
    /**
     * 使用辅助全局变量
     * 先遍历右子树
     */
    private int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        nodeSum(root);
        return root;
    }

    private void nodeSum(TreeNode node) {
        if (node == null) return;
        nodeSum(node.right);
        node.val += sum;
        sum = node.val;
        nodeSum(node.left);
    }
}
// @lc code=end

