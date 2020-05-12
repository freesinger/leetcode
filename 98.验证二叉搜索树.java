import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=98 lang=java
 *
 * [98] 验证二叉搜索树
 *
 * https://leetcode-cn.com/problems/validate-binary-search-tree/description/
 *
 * algorithms
 * Medium (27.81%)
 * Likes:    506
 * Dislikes: 0
 * Total Accepted:    90.5K
 * Total Submissions: 304.4K
 * Testcase Example:  '[2,1,3]'
 *
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * 
 * 假设一个二叉搜索树具有如下特征：
 * 
 * 
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 
 * 
 * 示例 1:
 * 
 * 输入:
 * ⁠   2
 * ⁠  / \
 * ⁠ 1   3
 * 输出: true
 * 
 * 
 * 示例 2:
 * 
 * 输入:
 * ⁠   5
 * ⁠  / \
 * ⁠ 1   4
 * / \
 * 3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 * 根节点的值为 5 ，但是其右子节点值为 4 。
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
    List<Integer> nums = new ArrayList<>();
    public boolean isValidBST(TreeNode root) {
        inOrderParse(root);
        for (int i = 0; i < nums.size()-1; i++) {
            if (nums.get(i+1) <= nums.get(i)) return false;
        }
        return true;
    }

    private void inOrderParse(TreeNode node) {
        if (node == null) return;
        inOrderParse(node.left);
        nums.add(node.val);
        inOrderParse(node.right);
    }
    // private boolean isValid = true;
    // public boolean isValidBST(TreeNode root) {
    //     // if ((root.right != null && root.val > root.right.val) || (root.left != null && root.val < root.left.val)) return false;
    //     nodeVal(root);
    //     return isValid;
    // }

    // private void nodeVal(TreeNode node) {
    //     if (node == null) return;
    //     if ((node.right != null && node.val >= node.right.val) || (node.left != null && node.val <= node.left.val)) isValid = false;
    //     nodeVal(node.left);
    //     nodeVal(node.right);
    // }
}
// @lc code=end

