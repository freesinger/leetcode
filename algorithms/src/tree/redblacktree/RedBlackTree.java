package src.tree.redblacktree;

import src.tree.base.Node;

public class RedBlackTree {
    public static void main(String[] args) {
        Node root = new Node(38, Node.BlACK);
        // TODO: Initial tree
    }

    /**
     * 在叶子结点的黑色父节点处进行插入
     *
     * @param node
     * @param newNodeVal
     */
    public void commonInsert(Node node, Integer newNodeVal) {
        if (node == null) node = new Node(newNodeVal, Node.BlACK);

        while (true) {
            if (node.value > newNodeVal) {
                if (node.left == null) {
                    if (node.color == Node.BlACK) {
                        node.left = new Node(newNodeVal, Node.RED);
                        break;
                    }
                }
                node = node.left;
            } else {
                if (node.value < newNodeVal) {
                    if (node.right == null) {
                        if (node.color == Node.BlACK) {
                            node.right = new Node(newNodeVal, Node.RED);
                            break;
                        }
                    }
                    node = node.right;
                }
            }
        }
    }
}
