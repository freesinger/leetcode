/*
 * @lc app=leetcode.cn id=86 lang=java
 *
 * [86] 分隔链表
 *
 * https://leetcode-cn.com/problems/partition-list/description/
 *
 * algorithms
 * Medium (53.66%)
 * Likes:    173
 * Dislikes: 0
 * Total Accepted:    29.9K
 * Total Submissions: 52.9K
 * Testcase Example:  '[1,4,3,2,5,2]\n3'
 *
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 *
 * 你应当保留两个分区中每个节点的初始相对位置。
 *
 * 示例:
 *
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
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
     * 双指针 + 拼接链表
     *
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        ListNode lower = new ListNode(-1), largerequal = new ListNode(1);
        ListNode pre = lower, next = largerequal;
        // pre.next = lower;
        // next.next = largerequal;

        while (head != null) {
            if (head.val < x) {
                ListNode cur = new ListNode(head.val);
                lower.next = cur;
                lower = cur;
            } else {
                ListNode cur = new ListNode(head.val);
                largerequal.next = cur;
                largerequal = cur;
            }
            head = head.next;
        }

        lower.next = next.next;

        return pre.next;
    }
}
// @lc code=end

