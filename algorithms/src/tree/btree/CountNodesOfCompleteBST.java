package src.tree.btree;

import src.utils.node.implement.TreeNode;

/**
 * 完全二叉树的所有节点数
 */
public class CountNodesOfCompleteBST {
    private static int countNode(TreeNode root) {
        if (root == null) return 0;
        int left = nodeLevel(root.left);
        int right = nodeLevel(root.right);
        // 按照完全树的性质对树高做判断
        if (left == right) {
            return countNode(root.right) + (1 << left);
        } else {
            return countNode(root.left) + (1 << right);
        }
    }

    private static int nodeLevel(TreeNode node) {
        if (node == null) return 0;
        int level = 0;
        while (node.left != null) {
            level++;
            node = node.left;
        }
        return level;
    }
}
