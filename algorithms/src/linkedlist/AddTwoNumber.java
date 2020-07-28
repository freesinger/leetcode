package src.linkedlist;

import src.utils.node.implement.ListNode;

public class AddTwoNumber {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) return null;
        ListNode cur = new ListNode(-1);
        ListNode dummy = cur;
        boolean flag = false;

        while (l1 != null && l2 != null) {
            int curSum = flag ? 1 : 0;
            curSum += l1.value + l2.value;
            flag = curSum >= 10;

            ListNode tmpSum = new ListNode(curSum % 10);
            cur.next = tmpSum;
            cur = cur.next;

            l1 = l1.next;
            l2 = l2.next;
        }

        if (l1 != null) {
            while (l1 != null) {
                int curSum = flag ? 1 : 0;
                curSum += l1.value;
                flag = curSum >= 10;

                cur.next = new ListNode(curSum % 10);
                cur = cur.next;
                l1 = l1.next;
            }
        } else if (l2 != null) {
            while (l2 != null) {
                int curSum = flag ? 1 : 0;
                curSum += l2.value;
                flag = curSum >= 10;

                cur.next = new ListNode(curSum % 10);
                cur = cur.next;
                l2 = l2.next;
            }
        }
        if (flag) cur.next = new ListNode(1);

        return dummy.next;
    }

    private void getRest(ListNode node, ListNode result) {

    }
}
