import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=112 lang=java
 *
 * [112] 路径总和
 *
 * https://leetcode-cn.com/problems/path-sum/description/
 *
 * algorithms
 * Easy (48.25%)
 * Likes:    198
 * Dislikes: 0
 * Total Accepted:    39.6K
 * Total Submissions: 82K
 * Testcase Example:  '[5,4,8,11,null,13,4,7,2,null,null,null,1]\n22'
 *
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 * 
 * 说明: 叶子节点是指没有子节点的节点。
 * 
 * 示例: 
 * 给定如下二叉树，以及目标和 sum = 22，
 * 
 * ⁠             5
 * ⁠            / \
 * ⁠           4   8
 * ⁠          /   / \
 * ⁠         11  13  4
 * ⁠        /  \      \
 * ⁠       7    2      1
 * 
 * 
 * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
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
    // List<Integer> tmp = new ArrayList<>();
    // public boolean hasPathSum(TreeNode root, int sum) {
    //     if (root == null) return false;
    //     sum(root, 0);
    //     for (Integer i : tmp) {
    //         if (i == sum) return true;
    //     }
    //     return false;
    // }

    // private void sum(TreeNode root, int sum) {
    //     // if (root == null) tmp.add(sum);
    //     if (isLeaf(root)) {
    //         sum += root.val;
    //         tmp.add(sum);
    //     } else if (root.left == null && root.right != null) {
    //         sum += root.val;
    //         sum(root.right, sum);
    //     } else if (root.left != null && root.right == null) {
    //         sum += root.val;
    //         sum(root.left, sum);
    //     } else {
    //         sum += root.val;
    //         sum(root.left, sum);
    //         sum(root.right, sum);
    //     }
    // }
    
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;

        sum -= root.val;
        if (isLeaf(root)) return sum == 0;
        else return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }

    private boolean isLeaf(TreeNode node) {
        if (node.left == null && node.right == null) return true;
        else return false; 
    }
}
// @lc code=end

