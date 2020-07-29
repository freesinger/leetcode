package src.recursive;

import src.utils.Tools;
import src.utils.node.implement.ListNode;

/**
 * 每k个一组翻转链表
 */
public class ReverseKGroup {

    /**
     * nxt保存结点不断链
     * 逐个翻转链表
     *
     * @param node
     * @return
     */
    public ListNode reverse(ListNode node) {
        ListNode cur = node, pre = null, nxt = null;
        while (cur != null) {
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }


    /**
     * 翻转指定区间的链表结点
     *
     * @param start
     * @param end
     * @return
     */
    public ListNode reverse(ListNode start, ListNode end) {
        ListNode cur = start, pre = null, nxt = null;
        while (cur != end) {
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }


    /**
     * 翻转链表中每K个结点
     *
     * @param root
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode root, int k) {
        if (root == null) return null;
        ListNode cur = root;
        int cnt = k;

        while (cur != null && cnt > 0) {
            cnt--;
            cur = cur.next;
        }

        if (cnt > 0) return root;

        ListNode newHead = reverse(root, cur);
        // System.out.println(cur.next.value);
        root.next = reverseKGroup(cur, k); // 注意起点是cur

        return newHead;
    }

    public static void main(String[] args) {
        ListNode root = Tools.constructLinkedList(new int[]{1, 2, 3, 4, 5, 6});
        //Tools.traceListNode(new ReverseKGroup().reverse(root));
        //Tools.traceListNode(new ReverseKGroup().reverseKGroup(root, 2));
        Tools.traceListNode(new ReverseKGroup().reverseKGroup(root, 4));
    }
}
