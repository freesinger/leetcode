package src.linkedlist;

import src.utils.node.implement.ListNode;

public class CycleEntrance {
    /**
     * a: root - entrance
     * b: entrance - meet
     * c: meet - entrance
     * 相遇的时候有等式
     * Step(fast) = a + k(b+c) +  = 2 * Step(Slow), (k>=1)
     * Step(slow) = a + b
     * 化简有 a = (k-1)(b+c) + c, (k>=1)
     * 令 k = 1，有a = c, 从图上看两个节点从root和meet一起走，想遇的时候就是入口点
     *
     * @param root
     * @return
     */
    private ListNode entrance(ListNode root) {
        ListNode slow = root;
        ListNode fast = root;

        if (root == null || fast.next == null) return root;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) break;
        }

        slow = root;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return fast;
    }

}
