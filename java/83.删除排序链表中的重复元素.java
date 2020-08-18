/*
 * @lc app=leetcode.cn id=83 lang=java
 *
 * [83] 删除排序链表中的重复元素
 *
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/description/
 *
 * algorithms
 * Easy (48.20%)
 * Likes:    229
 * Dislikes: 0
 * Total Accepted:    57.4K
 * Total Submissions: 118.8K
 * Testcase Example:  '[1,1,2]'
 *
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 *
 * 示例 1:
 *
 * 输入: 1->1->2
 * 输出: 1->2
 *
 *
 * 示例 2:
 *
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
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
    public ListNode deleteDuplicates(ListNode head) {
        // if (head == null || head.next == null) return head;

        // ListNode pre_head = head;
        // ListNode cur = head;
        // while (cur.next != null) {
        //     if (head.val == cur.next.val) {
        //         cur = cur.next;
        //     } else {
        //         head.next = cur.next;
        //         head = head.next;
        //         cur = head;
        //     }
        // }
        // head.next = null;

        // return pre_head;
        if (head == null || head.next == null) return head;

        ListNode dummy = head;
        ListNode cur = head;
        while (cur != null) {
            if (head.val == cur.val) {
                cur = cur.next;
            } else {
                head.next = cur;
                head = cur;
            }
        }
        head.next = null;

        return dummy;
    }
}
// @lc code=end

