import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=437 lang=java
 *
 * [437] 路径总和 III
 *
 * https://leetcode-cn.com/problems/path-sum-iii/description/
 *
 * algorithms
 * Easy (52.75%)
 * Likes:    263
 * Dislikes: 0
 * Total Accepted:    17.6K
 * Total Submissions: 33K
 * Testcase Example:  '[10,5,-3,3,2,null,11,3,-2,null,1]\n8'
 *
 * 给定一个二叉树，它的每个结点都存放着一个整数值。
 * 
 * 找出路径和等于给定数值的路径总数。
 * 
 * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 * 
 * 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
 * 
 * 示例：
 * 
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 * 
 * ⁠     10
 * ⁠    /  \
 * ⁠   5   -3
 * ⁠  / \    \
 * ⁠ 3   2   11
 * ⁠/ \   \
 * 3  -2   1
 * 
 * 返回 3。和等于 8 的路径有:
 * 
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3.  -3 -> 11
 * 
 * 
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    public int pathSum(TreeNode root, int sum) {
        final int static_number = sum;
        int cnt = 0;
        if (root == null) return 0;
        if (root.val == sum) {
            // System.out.println(root.val);
            // if (root.left != null) System.out.println(root.left.val);
            // else System.out.println("null");
            // if (root.right != null) System.out.println(root.right.val);
            // else System.out.println("null");
            cnt++;
            
        }
        if (root.left != null) {
            cnt += pathSum(root.left, sum-root.val);
            cnt += pathSum(root.left, static_number);
        }
        if (root.right != null) {
            cnt += pathSum(root.right, sum-root.val);
            cnt += pathSum(root.right, static_number);
        }

        return cnt;
    }

    // private int nodeSum(TreeNode root, int sum, int rawSum) {
    //     int cnt = 0;
    //     if (root == null) return 0;
    //     if (root.val == sum) cnt++;
    //     if (root.left != null) {
    //         cnt += nodeSum(root.left, sum-root.val, rawSum);
    //         cnt += nodeSum(root.left, rawSum);
    //     }
    //     if (root.right != null) {
    //         cnt += nodeSum(root.right, sum-root.val, rawSum);
    //         cnt += nodeSum(root.right, sum, rawSum)
    //     }
    // }
}
// @lc code=end

