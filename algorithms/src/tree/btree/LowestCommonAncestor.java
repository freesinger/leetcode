package src.tree.btree;

import src.utils.node.implement.TreeNode;

/**
 * 二叉树的最近公共祖先
 * ref: https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/solution/236-er-cha-shu-de-zui-jin-gong-gong-zu-xian-hou-xu/
 */
public class LowestCommonAncestor {
    /**
     * 普通二叉树
     */
    private TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) return right;
        if (right == null) return left;
        return root;
    }


    /**
     * 二叉搜索树
     */
    private TreeNode lowestCommonAncestorOfBST(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == q || root == p) return root;
        if (root.value > p.value && root.value > q.value) {
            return lowestCommonAncestorOfBST(root.left, p, q);
        }
        if (root.value < p.value && root.value < q.value) {
            return lowestCommonAncestorOfBST(root.right, p, q);
        }
        return root;
    }
}
