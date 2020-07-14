package src.utils.node.absnode;

import lombok.Data;

@Data
public abstract class Node {
    public int value;
    public Node node;

    public Node() {}
}
