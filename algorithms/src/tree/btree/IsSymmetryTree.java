package src.tree.btree;

import src.utils.node.implement.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class IsSymmetryTree {
    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) return false;
        return isSiblingsSymmetry(pRoot.left, pRoot.right);
    }

    // 递归
    boolean isSiblingsSymmetry(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        if (left.value != right.value) return false;
        return isSiblingsSymmetry(left.right, right.left);
    }

    // 迭代
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
            if (left.value != right.value) return false;
            q.offer(left.left);
            q.offer(right.right);
            q.offer(left.right);
            q.offer(right.left);
        }
        return true;
    }
}
