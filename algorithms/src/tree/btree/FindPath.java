package src.tree.btree;

import src.utils.node.implement.TreeNode;

import java.util.ArrayList;

/**
 * 二叉树和为k的路径
 */
public class FindPath {
    ArrayList<ArrayList<Integer>> result = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null) return result;
        recursive(root, 0, target, new ArrayList<>());
        return result;
    }

    public void recursive(TreeNode node, int sum, int target, ArrayList<Integer> curList) {
        sum += node.value;
        curList.add(node.value);
        if (sum == target && node.right == null && node.left == null) {
            result.add(curList);
        }
        if (node.left != null) recursive(node.left, sum, target, new ArrayList<>(curList));
        if (node.right != null) recursive(node.right, sum, target, new ArrayList<>(curList));
    }
}
