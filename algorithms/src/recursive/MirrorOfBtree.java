package src.recursive;

import src.utils.node.implement.TreeNode;

public class MirrorOfBtree {
    public void Mirror(TreeNode root) {
        if (root == null) return;
        swap(root);
        Mirror(root.left);
        Mirror(root.right);
    }

    private void swap(TreeNode node) {
        TreeNode tmp = node.left;
        node.left = node.right;
        node.right = tmp;
    }
}
