package src.tree.btree;

import src.utils.node.implement.TreeNode;

public class BSTFlattenToList {
    /**
     * 后序遍历
     * 展平两个子树再对父节点拼接
     *
     * @param node
     */
    private void flatten(TreeNode node) {
        if (node == null) return;
        flatten(node.left);
        flatten(node.right);

        TreeNode tmpRight = node.right;
        TreeNode left = node.left;
        node.left = null;
        node.right = left;

        while (node.right != null) node = node.right;
        node.right = tmpRight;
    }
}
