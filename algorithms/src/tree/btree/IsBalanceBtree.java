package src.tree.btree;

import src.utils.node.implement.TreeNode;

public class IsBalanceBtree {
    private boolean isBalanced = true;

    public static void main(String[] args) {
        IsBalanceBtree test = new IsBalanceBtree();
        TreeNode root = new TreeNode(1);
        System.out.println(test.isBalanceBinaryTree(root));
    }

    public boolean isBalanceBinaryTree(TreeNode root) {
        if (root == null) return false;
        depth(root);
        return isBalanced;
    }

    private int depth(TreeNode node) {
        if (!isBalanced || node == null) return 0;
        int l = depth(node.left);
        int r = depth(node.right);
        if (Math.abs(l - r) > 1) isBalanced = false;
        return 1 + Math.max(l, r);
    }

    private boolean hasChild(TreeNode node) {
        return node.left != null || node.right != null;
    }
}
