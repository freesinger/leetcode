package src.tree.btree;

import src.utils.Const;
import src.utils.Tools;
import src.utils.node.implement.TreeNode;

/**
 * BST中序遍历第k个结点
 */
public class KthNodeOfBST {
    public static void main(String[] args) {
        TreeNode root = Tools.constructBST(Const.BST);
        Tools.traceTree(root);
        int r = find(root, 4).value;
        System.out.println(ret == null ? null : r);
    }

    private static TreeNode find(TreeNode root, int k) {
        recursive(root, k);
        return ret;
    }

    private static int cnt = 0;
    private static TreeNode ret;

    private static void recursive(TreeNode node, int k) {
        if (node == null) return;
        recursive(node.left, k);
        ++cnt;
        if (k == cnt) {
            ret = node;
            return;
        }
        recursive(node.right, k);
    }
}
