/*
 * @lc app=leetcode.cn id=19 lang=java
 *
 * [19] 删除链表的倒数第N个节点
 *
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/description/
 *
 * algorithms
 * Medium (36.38%)
 * Likes:    723
 * Dislikes: 0
 * Total Accepted:    136.4K
 * Total Submissions: 358.9K
 * Testcase Example:  '[1,2,3,4,5]\n2'
 *
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 *
 *
 * 说明：
 *
 * 给定的 n 保证是有效的。
 *
 * 进阶：
 *
 * 你能尝试使用一趟扫描实现吗？
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;
        int nodeNum = 1;
        ListNode dummy = new ListNode(0), curNode, curFormer;
        dummy.next = head;
        curNode = head;
        curFormer = dummy;

        while (head.next != null) {
            nodeNum++;
            head = head.next;
        }

        int cnt = nodeNum - n;

        // if (cnt == 0) return curFormer.next;

        while (cnt-- > 0) {
            curFormer = curNode;
            curNode = curNode.next;
            //cnt--;
        }

        curFormer.next = curNode.next;

        return dummy.next;


        // if (head == null || head.next == null) return null;
        // ListNode curFormer = null, cur = head, curNext = head.next;
        // ListNode dummy = new ListNode(0);
        // dummy.next = head;

        // while (curNext.next != null) {
        //     curFormer = cur;
        //     cur = cur.next;
        //     curNext = curNext.next;
        // }

        // curFormer.next = curNext;

        // return dummy.next;
    }
}
// @lc code=end

