/*
 * @lc app=leetcode.cn id=203 lang=java
 *
 * [203] 移除链表元素
 *
 * https://leetcode-cn.com/problems/remove-linked-list-elements/description/
 *
 * algorithms
 * Easy (42.84%)
 * Likes:    317
 * Dislikes: 0
 * Total Accepted:    49.7K
 * Total Submissions: 115.5K
 * Testcase Example:  '[1,2,6,3,4,5,6]\n6'
 *
 * 删除链表中等于给定值 val 的所有节点。
 *
 * 示例:
 *
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
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
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode node = dummy;


        while (node.next != null) {
            if (node.next.val == val) {
                node.next = node.next.next;
            } else node = node.next;
        }

        return dummy.next;
    }
}
// @lc code=end

