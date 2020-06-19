package src.tree.base;

import lombok.Data;

@Data
public class Node {
    public static final String RED = "red";
    public static final String BlACK = "black";

    public Integer value;
    public String color;
    public Node left;
    public Node right;

    /**
     * 通用rbtree node
     *
     * @param value
     * @param color
     * @param left
     * @param right
     */
    public Node(Integer value, String color, Node left, Node right) {
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
    public Node(Integer value, String color) {
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
    public Node(Integer value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}
