package src.tree.btree;

import src.utils.node.implement.TreeNode;

/**
 * https://www.nowcoder.com/questionTerminal/6e196c44c7004d15b1610b9afca8bd88?f=discussion
 */
public class IsSubtree {
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) return false;
        return recursive(root1, root2) || recursive(root1.left, root2) || recursive(root1.right, root2);
    }

    public boolean recursive(TreeNode root1, TreeNode root2) {
        if (root2 == null) return true;
        if (root1 == null) return false;
        if (root1.value != root2.value) return false;
        return recursive(root1.left, root2.left) && recursive(root1.right, root2.right);
    }
}
