import jdk.nashorn.internal.ir.ReturnNode;

/*
 * @lc app=leetcode.cn id=23 lang=java
 *
 * [23] 合并K个排序链表
 *
 * https://leetcode-cn.com/problems/merge-k-sorted-lists/description/
 *
 * algorithms
 * Hard (47.88%)
 * Likes:    393
 * Dislikes: 0
 * Total Accepted:    56.3K
 * Total Submissions: 117.6K
 * Testcase Example:  '[[1,4,5],[1,3,4],[2,6]]'
 *
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 * 
 * 示例:
 * 
 * 输入:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 * 
 */

// @lc code=start
/*
 * Definition for singly-linked list.
 *  */
//  public class ListNode {
//     int val;
//     ListNode next;
//     ListNode(int x) { val = x; }
// }

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        // recursive and divide conquer
        if (lists.length == 0) return null;
        return divideConquer(lists, 0, lists.length - 1);
    }

    public ListNode divideConquer(ListNode[] lists, int l, int r) {
        if (l == r) return lists[l];
        int mid = (l + r) >> 1;
        ListNode lNode = divideConquer(lists, l, mid);
        ListNode rNode = divideConquer(lists, mid + 1, r);
        return merge(lNode, rNode);
    }

    public ListNode merge(ListNode l, ListNode r) {
        if (l == null) return r;
        if (r == null) return l;

        if (l.val < r.val) {
            l.next = merge(l.next, r);
            return l;
        } else {
            r.next = merge(l, r.next);
            return r;
        }
    }

    @Deprecated
    public ListNode mergeList(ListNode l, ListNode r) {
        ListNode new_head = new ListNode(-1);
        ListNode tmp = new_head;

        while (l.next  != null && r.next != null) {
            if (l.val < r.val) {
                tmp.next = l;
                l = l.next;
            } else {
                tmp.next = r;
                r = r.next;
            }
            tmp = tmp.next;
        }
        tmp = (l.next != null) ? l : r;
        return new_head.next;
    }
}
// @lc code=end

