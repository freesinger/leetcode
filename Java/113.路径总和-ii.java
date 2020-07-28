import java.util.List;

/*
 * @lc app=leetcode.cn id=113 lang=java
 *
 * [113] 路径总和 II
 *
 * https://leetcode-cn.com/problems/path-sum-ii/description/
 *
 * algorithms
 * Medium (57.55%)
 * Likes:    281
 * Dislikes: 0
 * Total Accepted:    62.2K
 * Total Submissions: 102.8K
 * Testcase Example:  '[5,4,8,11,null,13,4,7,2,null,null,5,1]\n22'
 *
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 * 
 * 说明: 叶子节点是指没有子节点的节点。
 * 
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 * 
 * ⁠             5
 * ⁠            / \
 * ⁠           4   8
 * ⁠          /   / \
 * ⁠         11  13  4
 * ⁠        /  \    / \
 * ⁠       7    2  5   1
 * 
 * 
 * 返回:
 * 
 * [
 * ⁠  [5,4,11,2],
 * ⁠  [5,8,4,5]
 * ]
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
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        dfs(root, 0, sum, new ArrayList<>());
        return res;
    }

    private void dfs(TreeNode node, int curSum, int sum, List<Integer> curList) {
        if (node == null) return;
        curList.add(node.val);
        curSum += node.val;
        if (curSum == sum && node.left == null && node.right == null) {
            res.add(curList);
        }
        if (node.left != null) dfs(node.left, curSum, sum, new ArrayList<>(curList));
        if (node.right != null) dfs(node.right, curSum, sum, new ArrayList<>(curList));
    }
}
// @lc code=end

