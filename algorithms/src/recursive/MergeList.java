package src.recursive;

import src.utils.node.implement.ListNode;

import java.util.List;

/**
 * 合并K个链表
 * (分治 + )递归
 */
public class MergeList {
    public ListNode mergeLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        // return divideConquer(lists, 0, lists.length);
        ListNode root = lists[0];
        for (int i = 1; i < lists.length; i++) {
            root = merge(root, lists[i]);
        }
        return root;
    }

    public ListNode divideConquer(ListNode[] lists, int left, int right) {
        if (left == right) return lists[left];
        int mid = left + (right - left) / 2;
        ListNode leftNode = divideConquer(lists, left, mid);
        ListNode rightNode = divideConquer(lists, mid + 1, right);
        return merge(leftNode, rightNode);
    }

    public ListNode merge(ListNode pre, ListNode cur) {
        if (pre == null) return cur;
        if (cur == null) return pre;
        if (pre.value < cur.value) {
            pre.next = merge(pre.next, cur);
            return pre;
        } else {
            cur.next = merge(cur.next, pre);
            return cur;
        }
    }
}
