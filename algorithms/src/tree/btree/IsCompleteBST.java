package src.tree.btree;

import src.utils.node.implement.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 判断一棵树是否是完全二叉树
 * 层次遍历如果在一个非null节点之前出现了null节点则说明非完全二叉树
 */
public class IsCompleteBST {
    private boolean isComplete(TreeNode root) {
        if (root == null) return false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean nullHasOccur = false;

        while (!queue.isEmpty()) {
            int size = queue.size();
            // 循环体里声明则每层都会先置false导致错误
            // boolean nullHasOccur = false;
            while (size > 0) {
                size--;
                TreeNode curNode = queue.poll();
                if (curNode != null && nullHasOccur) return false;
                if (curNode != null) {
                    queue.offer(curNode.left);
                    queue.offer(curNode.right);
                } else {
                    nullHasOccur = true;
                }
            }
        }

        return true;
    }
}
