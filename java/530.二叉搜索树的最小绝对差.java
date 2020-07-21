import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=530 lang=java
 *
 * [530] 二叉搜索树的最小绝对差
 *
 * https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/description/
 *
 * algorithms
 * Easy (54.63%)
 * Likes:    91
 * Dislikes: 0
 * Total Accepted:    10.6K
 * Total Submissions: 19K
 * Testcase Example:  '[1,null,3,2]'
 *
 * 给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
 *
 *
 *
 * 示例：
 *
 * 输入：
 *
 * ⁠  1
 * ⁠   \
 * ⁠    3
 * ⁠   /
 * ⁠  2
 *
 * 输出：
 * 1
 *
 * 解释：
 * 最小绝对差为 1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
 *
 *
 *
 *
 * 提示：
 *
 *
 * 树中至少有 2 个节点。
 * 本题与 783 https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/
 * 相同
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
    ArrayList<Integer> val = new ArrayList<>();

    /**
     * 二叉搜索树中序遍历后是有序数组
     *
     * @param root
     * @return
     */
    public int getMinimumDifference(TreeNode root) {
        int min = Integer.MAX_VALUE;

        inOrderTraversal(root);
        for (int i = 0; i < val.size() - 1; i++) {
            int gap = val.get(i + 1) - val.get(i);
            min = (min > gap) ? gap : min;
        }

        return min;
    }

    private void inOrderTraversal(TreeNode root) {
        if (root.left != null) inOrderTraversal(root.left);
        val.add(root.val);
        if (root.right != null) inOrderTraversal(root.right);
    }
}
// @lc code=end

