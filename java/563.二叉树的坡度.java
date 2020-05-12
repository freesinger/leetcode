import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=563 lang=java
 *
 * [563] 二叉树的坡度
 *
 * https://leetcode-cn.com/problems/binary-tree-tilt/description/
 *
 * algorithms
 * Easy (50.72%)
 * Likes:    57
 * Dislikes: 0
 * Total Accepted:    9.2K
 * Total Submissions: 17.2K
 * Testcase Example:  '[1,2,3]'
 *
 * 给定一个二叉树，计算整个树的坡度。
 * 
 * 一个树的节点的坡度定义即为，该节点左子树的结点之和和右子树结点之和的差的绝对值。空结点的的坡度是0。
 * 
 * 整个树的坡度就是其所有节点的坡度之和。
 * 
 * 示例:
 * 
 * 
 * 输入: 
 * ⁠        1
 * ⁠      /   \
 * ⁠     2     3
 * 输出: 1
 * 解释: 
 * 结点的坡度 2 : 0
 * 结点的坡度 3 : 0
 * 结点的坡度 1 : |2-3| = 1
 * 树的坡度 : 0 + 0 + 1 = 1
 * 
 * 
 * 注意:
 * 
 * 
 * 任何子树的结点的和不会超过32位整数的范围。
 * 坡度的值不会超过32位整数的范围。
 * 
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
    int tiltSum = 0;

    public int findTilt(TreeNode root) {
        traverse(root);
        return tiltSum;
    }

    /**
     * 递归
     * 注意返回值是子树和
     * @param node
     * @return
     */
    private int traverse(TreeNode node) {
        if (node == null) return 0;

        int left = traverse(node.left);
        int right = traverse(node.right);
        tiltSum += Math.abs(left-right);

        return left+right+node.val;
    }


    /**
     * 过分复杂
     */
    List<Integer> tilts = new ArrayList<>();

    @Deprecated
    public int findTilt1(TreeNode root) {
        int tiltSum = 0;

        nodeTilt(root);
        for (int t : tilts) tiltSum += t;

        return tiltSum;
    }

    private void nodeTilt(TreeNode node) {
        if (node == null || (node.left == null && node.right == null)) return;
        if (node.left == null) {
            tilts.add(Math.abs(childSum(node.right)));
            nodeTilt(node.right);
        } else if (node.right == null) {
            tilts.add(Math.abs(childSum(node.left)));
            nodeTilt(node.left);
        } else {
            tilts.add(Math.abs(childSum(node.left)-childSum(node.right)));
            nodeTilt(node.right);
            nodeTilt(node.left);
        }
    }

    private int childSum(TreeNode node) {
        if (node == null) return 0;
        // if (node.left == null && node.right == null) return node.val;
        return childSum(node.left) + childSum(node.right) + node.val; 
    }
}
// @lc code=end

