/*
 * @lc app=leetcode.cn id=82 lang=java
 *
 * [82] 删除排序链表中的重复元素 II
 *
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/description/
 *
 * algorithms
 * Medium (44.34%)
 * Likes:    246
 * Dislikes: 0
 * Total Accepted:    39.4K
 * Total Submissions: 83.9K
 * Testcase Example:  '[1,2,3,3,4,4,5]'
 *
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 *
 *
 * 示例 2:
 *
 * 输入: 1->1->1->2->3
 * 输出: 2->3
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
     * 三指针一次遍历
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        ListNode dummy = new ListNode(-1);
        ListNode pre = new ListNode(-1);
        ListNode last = new ListNode(1);
        dummy.next = head;
        pre = dummy;
        last = head.next;

        // if (last == null) return dummy.next;
        while (last != null) {
            if (head.val != last.val) {
                pre = head;
                head = last;
                last = last.next;
            } else {
                while (last.next != null) {
                    if (last.next.val == last.val) {
                        last = last.next;
                    } else break;
                }
                pre.next = last.next;
                head = last.next;
                // 考虑last.next为null的情况
                last = (last.next == null) ? null : last.next.next;
            }
        }

        return dummy.next;
    }
}
// @lc code=end

