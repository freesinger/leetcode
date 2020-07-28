/*
 * @lc app=leetcode.cn id=143 lang=java
 *
 * [143] 重排链表
 *
 * https://leetcode-cn.com/problems/reorder-list/description/
 *
 * algorithms
 * Medium (52.79%)
 * Likes:    260
 * Dislikes: 0
 * Total Accepted:    32.2K
 * Total Submissions: 57.4K
 * Testcase Example:  '[1,2,3,4]'
 *
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 * 
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * 
 * 示例 1:
 * 
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 * 
 * 示例 2:
 * 
 * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 * 
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if (head == null) return;
        int index = 0;
        ListNode cur = head;
        Map<Integer, ListNode> map = new HashMap<>();
        
        while (cur != null) {
            map.put(index, cur);
            index++;
            cur = cur.next;
        }
        
        index--;
        int exchangeCount = index / 2;
        for (int i = 0; i < exchangeCount; i++) {
            ListNode pre = map.get(i);
            ListNode next = pre.next;
            ListNode last = map.get(index - i);
            pre.next = last;
            last.next = next;
        }
        map.get((index+1)/2).next = null;
    }
}
// @lc code=end

