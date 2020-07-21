import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=653 lang=java
 *
 * [653] 两数之和 IV - 输入 BST
 *
 * https://leetcode-cn.com/problems/two-sum-iv-input-is-a-bst/description/
 *
 * algorithms
 * Easy (52.69%)
 * Likes:    125
 * Dislikes: 0
 * Total Accepted:    14.2K
 * Total Submissions: 25.8K
 * Testcase Example:  '[5,3,6,2,4,null,7]\n9'
 *
 * 给定一个二叉搜索树和一个目标结果，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。
 *
 * 案例 1:
 *
 *
 * 输入:
 * ⁠   5
 * ⁠  / \
 * ⁠ 3   6
 * ⁠/ \   \
 * 2   4   7
 *
 * Target = 9
 *
 * 输出: True
 *
 *
 *
 *
 * 案例 2:
 *
 *
 * 输入:
 * ⁠   5
 * ⁠  / \
 * ⁠ 3   6
 * ⁠/ \   \
 * 2   4   7
 *
 * Target = 28
 *
 * 输出: False
 *
 *
 *
 *
 */

// @lc code=start

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private List<Integer> nums = new ArrayList<>();

    public boolean findTarget(TreeNode root, int k) {
        inOrderParse(root);
        for (int i = 0; i < nums.size() - 1; i++) {
            for (int j = i + 1; j < nums.size(); j++) {
                if (k == nums.get(i) + nums.get(j)) return true;
            }
        }
        return false;
    }

    private void inOrderParse(TreeNode node) {
        if (node == null) return;
        inOrderParse(node.left);
        nums.add(node.val);
        inOrderParse(node.right);
    }
    // private boolean flag = false;
    // public boolean findTarget(TreeNode root, int k) {
    //     recursiveParse(root, k);
    //     return flag;
    // }

    // private void recursiveParse(TreeNode root, int k) {
    //     if (root == null) return;
    //     findRemainder(root, k-root.val);
    //     if (root.left != null) recursiveParse(root.left, k);
    //     if (root.right != null) recursiveParse(root.right, k);
    // }

    // private void findRemainder(TreeNode node, int remainder) {
    //     if (node == null) return;
    //     if (node.left != null && remainder == node.left.val || node.right != null && remainder == node.right.val) {
    //         flag = true;
    //         return;
    //     }
    //     // int remainder = k - node.val;
    //     if (node.left != null && remainder < node.val) findRemainder(node.left, remainder);
    //     if (node.right != null && remainder > node.val) findRemainder(node.right, remainder);
    // }
}
// @lc code=end

