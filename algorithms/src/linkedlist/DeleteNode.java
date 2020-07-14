package src.linkedlist;

import src.utils.node.implement.ListNode;
import src.utils.Tools;

/**
 * 考虑两种情况
 */
public class DeleteNode {
    public ListNode delete(ListNode head, ListNode node) {
        if (node.next != null) {
            node.value = node.next.value;
            node.next = node.next.next;
        } else {
            // 只有一个结点
            if (head == node) return null;
            ListNode cur = head;
            while (cur.next != node) {
                cur = cur.next;
            }
            cur.next = null;
        }
        return head;
    }


    public static void main(String[] args) {
        // TODO: testcase
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2, node1);
        ListNode node3 = new ListNode(3, node2);
        ListNode node4 = new ListNode(4, node3);

        DeleteNode deleteNode = new DeleteNode();
        deleteNode.delete(node4, node1);

        Tools.traceListNode(node4);
    }
}
