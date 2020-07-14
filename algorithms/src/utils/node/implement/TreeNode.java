package src.utils.node.implement;

import src.utils.node.absnode.Node;


public class TreeNode extends Node {
    public static final String RED = "red";
    public static final String BlACK = "black";
    
    public int value;
    public String color;
    public TreeNode left = null;
    public TreeNode right = null;

    /**
     * 通用rbtree node
     *
     * @param value
     * @param color
     * @param left
     * @param right
     */
    public TreeNode(int value, String color, TreeNode left, TreeNode right) {
        this.value = value;
        this.color = color;
        this.left = left;
        this.right = right;
    }

    /**
     * 单个node
     *
     * @param value
     * @param color
     */
    public TreeNode(int value, String color) {
        this.value = value;
        this.color = color;
    }

    /**
     * 通用tree node
     *
     * @param value
     * @param left
     * @param right
     */
    public TreeNode(int value, TreeNode left, TreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}
