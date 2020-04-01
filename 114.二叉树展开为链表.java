import javax.swing.tree.TreeNode;

import apple.laf.JRSUIUtils.Tree;

/*
 * @lc app=leetcode.cn id=114 lang=java
 *
 * [114] 二叉树展开为链表
 *
 * https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/description/
 *
 * algorithms
 * Medium (65.92%)
 * Likes:    301
 * Dislikes: 0
 * Total Accepted:    33.7K
 * Total Submissions: 49.4K
 * Testcase Example:  '[1,2,5,3,4,null,6]'
 *
 * 给定一个二叉树，原地将它展开为链表。
 * 
 * 例如，给定二叉树
 * 
 * ⁠   1
 * ⁠  / \
 * ⁠ 2   5
 * ⁠/ \   \
 * 3   4   6
 * 
 * 将其展开为：
 * 
 * 1
 * ⁠\
 * ⁠ 2
 * ⁠  \
 * ⁠   3
 * ⁠    \
 * ⁠     4
 * ⁠      \
 * ⁠       5
 * ⁠        \
 * ⁠         6
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
    public void flatten(TreeNode root) {
        recursive(root);
    }

    /**
     * 后序遍历
     * 先将左右子树处理成链表后拼接
     * @param ancestor
     */
    private void recursive(TreeNode ancestor) {
        if (ancestor == null) return;
        recursive(ancestor.left);
        recursive(ancestor.right);

        TreeNode tmpRight = ancestor.right;
        TreeNode left = ancestor.left;
        ancestor.right = left;
        ancestor.left = null;
        
        while (ancestor.right != null) ancestor = ancestor.right;
        ancestor.right = tmpRight;
    }
}
// @lc code=end

