package src.linkedlist;

import src.utils.node.implement.ListNode;

class KthNodeFromEnd {
    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null) return head;
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && k-- > 0) { // 判断指针是否为空
            fast = fast.next;
        }
        if (k > 0) return null; // 指针为空了k是否还未到0

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }

}
