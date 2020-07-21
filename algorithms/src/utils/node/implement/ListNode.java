package src.utils.node.implement;

import lombok.Data;
import src.utils.node.basenode.Node;

@Data
public
class ListNode extends Node {
    public int value;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int value) {
        this.value = value;
        this.next = null;
    }

    public ListNode(int value, ListNode next) {
        this.value = value;
        this.next = next;
    }


}
