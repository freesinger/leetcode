/*
 * @lc app=leetcode.cn id=86 lang=java
 *
 * [86] 分隔链表
 *
 * https://leetcode-cn.com/problems/partition-list/description/
 *
 * algorithms
 * Medium (53.66%)
 * Likes:    182
 * Dislikes: 0
 * Total Accepted:    32.6K
 * Total Submissions: 57.3K
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
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode pre = new ListNode(-1);
        ListNode last = new ListNode(1);
        // ListNode dummyPre = new ListNode(0);
        // ListNode dummyLast = new ListNode(1);
        ListNode dummyPre = pre;
        ListNode dummyLast = last;

        while (head != null) {
            if (head.val < x) {
                // pre.next = new ListNode(head.val);
                pre.next = head;
                pre = pre.next;
            } else {
                // last.next = new ListNode(head.val);
                last.next = head;
                last = last.next;
            }
            head = head.next;
        }

        last.next = null; // 不置null会导致循环链表
        pre.next = dummyLast.next;

        return dummyPre.next;
    }
}
// @lc code=end

