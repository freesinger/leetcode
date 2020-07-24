/*
 * @lc app=leetcode.cn id=105 lang=java
 *
 * [105] 从前序与中序遍历序列构造二叉树
 *
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
 *
 * algorithms
 * Medium (62.55%)
 * Likes:    580
 * Dislikes: 0
 * Total Accepted:    97.5K
 * Total Submissions: 144.4K
 * Testcase Example:  '[3,9,20,15,7]\n[9,3,15,20,7]'
 *
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * 
 * 注意:
 * 你可以假设树中没有重复的元素。
 * 
 * 例如，给出
 * 
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 
 * 返回如下的二叉树：
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return recursive(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }
    
    /**
     * preorder = [3, 9, 20, 15, 7]
     * inorder = [9, 3, 15, 20, 7]
     *
     * @param pre
     * @param preStart
     * @param preEnd
     * @param in
     * @param inStart
     * @param inEnd
     * @return
     */
    private static TreeNode recursive(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd) {
        if (preStart >= preEnd) return null;
        int root_val = pre[preStart];
        TreeNode root = new TreeNode(root_val);

        int leftSize = -1;
        for (int i = inStart; i < inEnd; i++) {
            if (in[i] == root_val) {
                leftSize = i - inStart;
                break;
            }
        }

        root.left = recursive(pre, preStart + 1, preStart + 1 + leftSize, in, inStart, inStart + leftSize);
        root.right = recursive(pre, preStart + 1 + leftSize, preEnd, in, inStart + leftSize + 1, inEnd);

        return root;
    }
    
}
// @lc code=end

