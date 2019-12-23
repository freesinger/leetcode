import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=234 lang=java
 *
 * [234] 回文链表
 *
 * https://leetcode-cn.com/problems/palindrome-linked-list/description/
 *
 * algorithms
 * Easy (39.15%)
 * Likes:    347
 * Dislikes: 0
 * Total Accepted:    52.4K
 * Total Submissions: 132.9K
 * Testcase Example:  '[1,2]'
 *
 * 请判断一个链表是否为回文链表。
 * 
 * 示例 1:
 * 
 * 输入: 1->2
 * 输出: false
 * 
 * 示例 2:
 * 
 * 输入: 1->2->2->1
 * 输出: true
 * 
 * 
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 * 
 * 
 * ref: https://leetcode-cn.com/problems/palindrome-linked-list/solution/javagua-yong-kuai-man-zhi-zhen-shi-xian-by-codersp/
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

 /**
  * reference: https://leetcode-cn.com/problems/palindrome-linked-list/solution/javagua-yong-kuai-man-zhi-zhen-shi-xian-by-codersp/
  * @comment: 快慢指针，快指针走到末尾满指针刚好到中点
  */
class Solution {
    public boolean isPalindrome(ListNode head) {
        // if (head == null) return true;
        List<Integer> nums = new ArrayList<>();
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        while (dummy.next != null) {
            nums.add(dummy.next.val);
            dummy = dummy.next;
        }
        
        int left = 0;
        int right = nums.size()-1;
        while (left <= right) {
            if (nums.get(left).intValue() != nums.get(right).intValue()) return false;
            left++;
            right--;
        }
        return true;


    }
}
// @lc code=end

