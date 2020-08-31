package src.dfs;

import src.utils.node.implement.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 树中是否存在根节点到叶子结点的路径满足和为k
 */
public class PathSum {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        dfs(root, 0, sum, new ArrayList<>());
        return res;
    }

    private void dfs(TreeNode node, int curSum, int sum, List<Integer> curList) {
        if (node == null) return;
        curList.add(node.value);
        curSum += node.value;
        if (curSum == sum && node.left == null && node.right == null) res.add(curList);
        if (node.left != null) dfs(node.left, curSum, sum, new ArrayList<>(curList));
        if (node.right != null) dfs(node.right, curSum, sum, new ArrayList<>(curList));
    }
}
