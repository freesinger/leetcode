package src.tree.btree;

import src.utils.node.implement.LinkedTreeNode;

/**
 * 查找二叉树中序遍历模式下的下一个结点
 */
public class NextNodeInOrder {
    private LinkedTreeNode nextNode(LinkedTreeNode node) {
        if (node == null) return null;
        if (node.right != null) {
            // 如果右子树不为空，则下一个结点是右子树的最左结点
            LinkedTreeNode cur = node.right;
            while (cur.left != null) {
                cur = cur.left;
            }
            return cur;
        } else {
            // 右子树为空的时候需要向上查找父节点
            // 按照中序遍历性质可以知道下一个结点满足这样的性质：
            // node在该节点的左子树上且该节点是第一个满足条件的
            while (node.parent != null) {
                LinkedTreeNode parent = node.parent;
                if (parent.left == node) {
                    return parent;
                } else {
                    node = parent;
                }
            }
        }
        return null;
    }
}
