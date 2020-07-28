/*
 * @lc app=leetcode.cn id=2 lang=java
 *
 * [2] 两数相加
 *
 * https://leetcode-cn.com/problems/add-two-numbers/description/
 *
 * algorithms
 * Medium (36.03%)
 * Likes:    4662
 * Dislikes: 0
 * Total Accepted:    494.1K
 * Total Submissions: 1.3M
 * Testcase Example:  '[2,4,3]\n[5,6,4]'
 *
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 
 * 示例：
 * 
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) return null;
        ListNode cur = new ListNode(-1);
        ListNode dummy = cur;
        boolean flag = false;

        while (l1 != null && l2 != null) {
            int curSum = flag ? 1 : 0;
            curSum += l1.val + l2.val;
            flag = curSum >= 10;

            ListNode tmpSum = new ListNode(curSum % 10);
            cur.next = tmpSum;
            cur = cur.next;

            l1 = l1.next;
            l2 = l2.next;
        }

        if (l1 != null) {
            while (l1 != null) {
                int curSum = flag ? 1 : 0;
                curSum += l1.val;
                flag = curSum >= 10;

                cur.next = new ListNode(curSum % 10);
                cur = cur.next;
                l1 = l1.next;
            }
        } else if (l2 != null) {
            while (l2 != null) {
                int curSum = flag ? 1 : 0;
                curSum += l2.val;
                flag = curSum >= 10;
                
                cur.next = new ListNode(curSum % 10);
                cur = cur.next;
                l2 = l2.next;
            }
        }
        if (flag) cur.next = new ListNode(1);

        return dummy.next;
    }
}
// @lc code=end

