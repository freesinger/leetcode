import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=107 lang=java
 *
 * [107] 二叉树的层次遍历 II
 *
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/description/
 *
 * algorithms
 * Easy (63.04%)
 * Likes:    157
 * Dislikes: 0
 * Total Accepted:    32K
 * Total Submissions: 50.7K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 * 
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * 
 * 返回其自底向上的层次遍历为：
 * 
 * [
 * ⁠ [15,7],
 * ⁠ [9,20],
 * ⁠ [3]
 * ]
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
    List<List<Integer>> res = new ArrayList<>();
    Queue<TreeNode> queue = new LinkedList<TreeNode>();

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) return res;

        /**
         * BFS using queue
         */
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelNum = queue.size();
            List<Integer> node = new ArrayList<>();
            
            for (int i = 0; i < levelNum; i++) {
                TreeNode curNode = queue.poll();
                if (curNode != null) {
                    node.add(curNode.val);
                    queue.offer(curNode.left);
                    queue.offer(curNode.right);
                }
            }
            if (node.size() > 0) res.add(0, node);
        }

        return res;
    }
}
// @lc code=end

