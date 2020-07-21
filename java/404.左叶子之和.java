import javax.swing.tree.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=404 lang=java
 *
 * [404] 左叶子之和
 *
 * https://leetcode-cn.com/problems/sum-of-left-leaves/description/
 *
 * algorithms
 * Easy (52.63%)
 * Likes:    108
 * Dislikes: 0
 * Total Accepted:    13.9K
 * Total Submissions: 26.3K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * 计算给定二叉树的所有左叶子之和。
 *
 * 示例：
 *
 *
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 *
 * 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 *
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
    public int sumOfLeftLeaves(TreeNode root) {
        int sum = 0;
        Queue<TreeNode> nodes = new LinkedList<>();
        if (root != null) nodes.offer(root);

        // 二叉树层次遍历
        while (!nodes.isEmpty()) {
            for (int i = 0; i < nodes.size(); i++) {
                TreeNode top = nodes.poll();
                if (top.left != null) {
                    if (top.left.left == null && top.left.right == null) {
                        sum += top.left.val;
                    }
                    nodes.offer(top.left);
                }
                if (top.right != null) {
                    nodes.offer(top.right);
                }
            }
        }

        return sum;
    }
}
// @lc code=end

