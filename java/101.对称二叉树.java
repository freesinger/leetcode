import javax.swing.tree.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=101 lang=java
 *
 * [101] 对称二叉树
 *
 * https://leetcode-cn.com/problems/symmetric-tree/description/
 *
 * algorithms
 * Easy (49.05%)
 * Likes:    504
 * Dislikes: 0
 * Total Accepted:    70.6K
 * Total Submissions: 143.8K
 * Testcase Example:  '[1,2,2,3,4,4,3]'
 *
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 * ⁠   1
 * ⁠  / \
 * ⁠ 2   2
 * ⁠/ \ / \
 * 3  4 4  3
 *
 *
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 * ⁠   1
 * ⁠  / \
 * ⁠ 2   2
 * ⁠  \   \
 * ⁠  3    3
 *
 *
 * 说明:
 *
 * 如果你可以运用递归和迭代两种方法解决这个问题，会很加分。
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
    // Recursive
    public boolean isSymmetric(TreeNode root) {
        return siblingIsSymmetric(root, root);
        // if (root == null) return true;
        // return siblingIsSymmetric(root.left, root.right);
    }

    public boolean siblingIsSymmetric(TreeNode left, TreeNode right) {
        // null can be node so return true
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        if (left.val != right.val) return false;
        return siblingIsSymmetric(left.right, right.left) &&
                siblingIsSymmetric(left.left, right.right);
    }

    // Iteration
    public boolean iteration(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode left = q.poll();
            TreeNode right = q.poll();
            // true to continue
            if (left == null && right == null) continue;
            if (left == null || right == null) return false;
            if (left.val != right.val) return false;
            q.offer(left.left);
            q.offer(right.right);
            q.offer(left.right);
            q.offer(right.left);
        }
        return true;
    }
}
// @lc code=end

