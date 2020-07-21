/*
 * @lc app=leetcode.cn id=24 lang=java
 *
 * [24] 两两交换链表中的节点
 *
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/description/
 *
 * algorithms
 * Medium (62.92%)
 * Likes:    440
 * Dislikes: 0
 * Total Accepted:    84.1K
 * Total Submissions: 129.6K
 * Testcase Example:  '[1,2,3,4]'
 *
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 *
 *
 * 示例:
 *
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 *
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
     * 交换每一对都有三步，涉及三个结点
     *
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode pre = new ListNode(-2);
        dummy.next = head;
        pre = dummy;

        while (head != null && head.next != null) {
            ListNode tmp = new ListNode(0);
            tmp = head.next;

            head.next = head.next.next;
            tmp.next = head;
            pre.next = tmp;

            pre = head;
            head = head.next;
        }

        return dummy.next;
    }
}
// @lc code=end

