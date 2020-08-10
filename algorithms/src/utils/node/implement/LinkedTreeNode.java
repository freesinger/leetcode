package src.utils.node.implement;

import src.utils.node.basenode.Node;

public class LinkedTreeNode extends Node {
    public int value;
    public LinkedTreeNode left;
    public LinkedTreeNode right;
    public LinkedTreeNode parent;

    public LinkedTreeNode(int value, LinkedTreeNode left, LinkedTreeNode right, LinkedTreeNode parent) {
        this.value = value;
        this.left = left;
        this.right = right;
        this.parent = parent;
    }

    public LinkedTreeNode(int value) {
        this.value = value;
    }
}
