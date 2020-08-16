package src.tree.btree;

import src.utils.node.implement.TreeNode;

/**
 * 二叉树中最大路径和
 *
 */
public class MaxPathSum {
    private int max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        // TODO
        System.out.println(new MaxPathSum().maxPathSum(root));
    }

    private int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        dfs(root);
        return max;
    }

    /**
     * 自底向上每个节点都选择当前和为最大的路径，递归
     *
     * @param node
     * @return
     */
    private int dfs(TreeNode node) {
        if (node == null) return 0;

        // 负值路径不选
        int left = Math.max(0, dfs(node.left));
        int right = Math.max(0, dfs(node.right));

        // 注意是node.value，记录当前节点的最大路径和
        // 局部max可能就是最大值
        max = Math.max(max, node.value + left + right);

        // 只能返回左或者右其中一条分支
        return Math.max(left, right) + node.value;
    }
}
