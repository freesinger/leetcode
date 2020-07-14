package src.tree.redblacktree;

import src.utils.node.implement.TreeNode;

public class RedBlackTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(38, TreeNode.BlACK);
        // TODO: Initial tree
    }

    /**
     * 在叶子结点的黑色父节点处进行插入
     *
     * @param node
     * @param newTreeNodeVal
     */
    public void commonInsert(TreeNode node, Integer newTreeNodeVal) {
        if (node == null) node = new TreeNode(newTreeNodeVal, TreeNode.BlACK);

        while (true) {
            if (node.value > newTreeNodeVal) {
                if (node.left == null) {
                    if (node.color == TreeNode.BlACK) {
                        node.left = new TreeNode(newTreeNodeVal, TreeNode.RED);
                        break;
                    }
                }
                node = node.left;
            } else {
                if (node.value < newTreeNodeVal) {
                    if (node.right == null) {
                        if (node.color == TreeNode.BlACK) {
                            node.right = new TreeNode(newTreeNodeVal, TreeNode.RED);
                            break;
                        }
                    }
                    node = node.right;
                }
            }
        }
    }
}
