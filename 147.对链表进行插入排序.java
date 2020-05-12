import java.util.List;

/*
 * @lc app=leetcode.cn id=147 lang=java
 *
 * [147] 对链表进行插入排序
 *
 * https://leetcode-cn.com/problems/insertion-sort-list/description/
 *
 * algorithms
 * Medium (61.15%)
 * Likes:    150
 * Dislikes: 0
 * Total Accepted:    26.1K
 * Total Submissions: 40.8K
 * Testcase Example:  '[4,2,1,3]'
 *
 * 对链表进行插入排序。
 * 
 * 
 * 插入排序的动画演示如上。从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。
 * 每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。
 * 
 * 
 * 
 * 插入排序算法：
 * 
 * 
 * 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
 * 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
 * 重复直到所有输入数据插入完为止。
 * 
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 
 * 
 * 示例 2：
 * 
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
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
    /**
     * 插入排序
     * @param head
     * @return
     */
    public ListNode insertionSortList(ListNode head) {
        if (head == null) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = new ListNode(head.val);
        ListNode start = dummy.next;
        ListNode tail = dummy.next;
        head = head.next;

        while (head != null) {
            ListNode tmp = new ListNode(head.val);
            if (head.val <= start.val) {
                // ListNode tmp = new ListNode(head.val);
                tmp.next = dummy.next;
                dummy.next = tmp;
                start = tmp;
            } else if (head.val > tail.val) {    
                tail.next = tmp;
                tail = tail.next;
            } else {
                ListNode cur = start;
                while (cur != tail) {
                    if (cur.next.val >= head.val) {
                        // System.out.println(cur.val);
                        tmp.next = cur.next;
                        cur.next = tmp;
                        break;
                    }
                    cur = cur.next;
                }
            }
            head = head.next;
        }

        // while (start != null) {
        //     System.out.println(start.val);
        //     start = start.next;
        // }
        return dummy.next;
    }
}
// @lc code=end

