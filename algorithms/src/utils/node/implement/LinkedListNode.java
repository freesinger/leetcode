package src.utils.node.implement;

import src.utils.node.basenode.Node;


public class LinkedListNode extends Node {
    public int key, value;
    public LinkedListNode pre, next;

    public LinkedListNode() {
    }

    public LinkedListNode(int key, int value) {
        this.key = key;
        this.value = value;
    }

    public LinkedListNode(int key, int value, LinkedListNode pre, LinkedListNode next) {
        this.key = key;
        this.value = value;
        this.pre = pre;
        this.next = next;
    }


}
