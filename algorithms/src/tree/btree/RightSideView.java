package src.tree.btree;

import src.utils.node.implement.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的右视图
 */
public class RightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        res.add(root.value);

        while (!queue.isEmpty()) {
            int nodeNum = queue.size();
            while (nodeNum-- > 0) {
                TreeNode curNode = queue.poll();
                if (curNode.left != null) queue.offer(curNode.left);
                if (curNode.right != null) queue.offer(curNode.right);
                if (nodeNum == 1) res.add(curNode.value);
            }
            //res.add(queue.getLast().value);
        }

        return res;
    }

}
