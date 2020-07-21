/*
 * @lc app=leetcode.cn id=92 lang=java
 *
 * [92] 反转链表 II
 *
 * https://leetcode-cn.com/problems/reverse-linked-list-ii/description/
 *
 * algorithms
 * Medium (47.90%)
 * Likes:    323
 * Dislikes: 0
 * Total Accepted:    39.9K
 * Total Submissions: 80.6K
 * Testcase Example:  '[1,2,3,4,5]\n2\n4'
 *
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 *
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 *
 */

// @lc code=start

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    /**
     * 三指针
     * 链表反转必须使用三个结点
     * 否则会丢失结点
     *
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode start = dummy;

        // 寻找开始结点
        for (int i = 1; i < m; i++) start = start.next;

        ListNode pre = null;
        ListNode cur = start.next;
        ListNode cur_next = null;
        for (int j = m; j <= n; j++) {
            cur_next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = cur_next;
        }

        // 注意翻转后结点顺序
        start.next.next = cur; // 此时pre.next != cur
        start.next = pre;

        return dummy.next;
    }
}
// @lc code=end

