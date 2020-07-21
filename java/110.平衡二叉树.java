/*
 * @lc app=leetcode.cn id=110 lang=java
 *
 * [110] 平衡二叉树
 *
 * https://leetcode-cn.com/problems/balanced-binary-tree/description/
 *
 * algorithms
 * Easy (49.11%)
 * Likes:    183
 * Dislikes: 0
 * Total Accepted:    38.3K
 * Total Submissions: 78K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * 
 * 本题中，一棵高度平衡二叉树定义为：
 * 
 * 
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 * 
 * 
 * 示例 1:
 * 
 * 给定二叉树 [3,9,20,null,null,15,7]
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * 返回 true 。
 * 
 * 示例 2:
 * 
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 * 
 * ⁠      1
 * ⁠     / \
 * ⁠    2   2
 * ⁠   / \
 * ⁠  3   3
 * ⁠ / \
 * ⁠4   4
 * 
 * 
 * 返回 false 。
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
    // public boolean isBalanced(TreeNode root) {
    //     // Bottom-up DFS
    //     return depth(root) != -1;
    // }

    // private int depth(TreeNode root) {
    //     if (root == null) return 0;
    //     int left = depth(root.left);
    //     if (left == -1) return -1;
    //     int right = depth(root.right);
    //     if (right == -1) return -1;
    //     // return level number
    //     return Math.abs(left-right) < 2 ? Math.max(left, right) + 1 : -1;
    // }

    private boolean isBalance = true;
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        depth(root);
        return isBalance;
    }

    private int depth(TreeNode root) {
        if (!isBalance || root == null) return 0;
        int l = depth(root.left);
        int r = depth(root.right);
        if (Math.abs(l- r)>1) isBalance = false;
        return 1+Math.max(l, r);
    }
}
// @lc code=end

