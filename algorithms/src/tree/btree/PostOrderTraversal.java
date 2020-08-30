package src.tree.btree;

import src.utils.node.implement.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 后序遍历二叉树
 */
public class PostOrderTraversal {
    // 递归
    private static void recursive(TreeNode root) {
        if (root == null) return;

        recursive(root.left);
        recursive(root.right);
        // root do something
    }

    // 迭代
    private static List<Integer> iterate(TreeNode root) {
        LinkedList<Integer> ret = new LinkedList<>();
        if (root == null) return ret;
        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                ret.addFirst(root.value);
                stack.push(root);
                root = root.right;
            } else {
                root = stack.pop();
                root = root.left;
            }
        }

        return ret;
    }
}
