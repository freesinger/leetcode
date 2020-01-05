import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=637 lang=java
 *
 * [637] 二叉树的层平均值
 *
 * https://leetcode-cn.com/problems/average-of-levels-in-binary-tree/description/
 *
 * algorithms
 * Easy (61.54%)
 * Likes:    85
 * Dislikes: 0
 * Total Accepted:    11.1K
 * Total Submissions: 17.9K
 * Testcase Example:  '[3,9,20,15,7]'
 *
 * 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组.
 * 
 * 示例 1:
 * 
 * 输入:
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 输出: [3, 14.5, 11]
 * 解释:
 * 第0层的平均值是 3,  第1层是 14.5, 第2层是 11. 因此返回 [3, 14.5, 11].
 * 
 * 
 * 注意：
 * 
 * 
 * 节点值的范围在32位有符号整数范围内。
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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        Queue<TreeNode> nodeStack = new LinkedList<>();
        if (root != null) nodeStack.offer(root);

        // 二叉树的层次遍历
        while (!nodeStack.isEmpty()) {
            int size = nodeStack.size();
            double sum = 0;

            for (int i = 0; i < size; i++) {
                TreeNode top = nodeStack.poll();
                sum += top.val;
                if (top.left != null) {
                    nodeStack.offer(top.left);
                }
                if (top.right != null) {
                    nodeStack.offer(top.right);
                }
            }

            res.add(sum/size);
        }

        return res;
    }
}
// @lc code=end

