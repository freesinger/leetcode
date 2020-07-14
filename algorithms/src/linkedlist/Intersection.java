package src.linkedlist;

import src.utils.node.implement.ListNode;


/**
 * 求两个相交链表的交点
 */
public class Intersection {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        ListNode n1 = headA;
        ListNode n2 = headB;

        // 互相走对方的路 a + c + b = b + c + a 成立就一定会相遇，否则都是null跳出循环
        while (n1 != n2) {
            n1 = n1 == null ? headB : n1.next;
            n2 = n2 == null ? headA : n2.next;
        }

        return n1;
    }
}
