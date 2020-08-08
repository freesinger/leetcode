package src.tree.btree;

import src.utils.node.implement.TreeNode;

public class DepthOfTree {
    private int depth(TreeNode node) {
        return node == null ? 0 : 1 + Math.max(depth(node.left), depth(node.right));
    }
}
