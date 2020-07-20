package src.tree.btree;

import src.utils.node.implement.TreeNode;

import java.util.ArrayList;

/**
 * https://www.nowcoder.com/practice/b736e784e3e34731af99065031301bca?tpId=13&tqId=11177&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking&from=cyc_github
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
