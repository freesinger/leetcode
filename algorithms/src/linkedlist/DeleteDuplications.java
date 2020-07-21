package src.linkedlist;

import src.utils.Tools;
import src.utils.node.implement.ListNode;

/**
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
public class DeleteDuplications {
    public static void main(String[] args) {
        // TODO: testcase
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2, node1);
        ListNode node3 = new ListNode(2, node2);
        ListNode node4 = new ListNode(4, node3);

        DeleteDuplications deleteNode = new DeleteDuplications();
        deleteNode.deleteDuplication(node4);

        Tools.traceListNode(node4);
        //System.out.println("abcde".substring(0, 5));
    }

    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) return pHead;

        ListNode dummy = new ListNode(-1);
        dummy.next = pHead;
        ListNode pre = dummy;
        ListNode last = dummy.next;

        while (last != null) {
            if (last.next != null && last.next.value == last.value) {
                while (last.next != null && last.value == last.next.value) { // 找到最后一个重复结点
                    last = last.next;
                }
                pre.next = last.next;
                last = last.next;
            } else {
                pre = pre.next;
                last = last.next;
            }
        }

        return dummy.next;
    }

}
