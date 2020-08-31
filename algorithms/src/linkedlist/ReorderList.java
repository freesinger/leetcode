package src.linkedlist;

import src.utils.node.implement.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 重排链表
 */
public class ReorderList {
    public void reorder(ListNode head) {
        if (head == null) return;
        int index = 0;
        ListNode cur = head;
        Map<Integer, ListNode> map = new HashMap<>();

        while (cur != null) {
            map.put(index, cur);
            index++;
            cur = cur.next;
        }

        index--;
        int exchangeCount = index / 2;
        for (int i = 0; i < exchangeCount; i++) {
            ListNode pre = map.get(i);
            ListNode next = pre.next;
            ListNode last = map.get(index - i);
            pre.next = last;
            last.next = next;
        }
        // 最后一个结点要置空，否则会造成环形链表
        map.get((index + 1) / 2).next = null;

    }
}