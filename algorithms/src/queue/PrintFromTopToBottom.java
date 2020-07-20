package src.queue;

import src.utils.node.implement.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PrintFromTopToBottom {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) return list;
        queue.offer(root);

        while (!queue.isEmpty()) {
            // 记录当前层数结点个数
            int size = queue.size();
            while (size-- > 0) {
                TreeNode currentNode = queue.poll();
                assert currentNode != null;
                list.add(currentNode.value);
                if (currentNode.left != null) queue.offer(currentNode.left);
                if (currentNode.right != null) queue.offer(currentNode.right);
            }
        }

        return list;
    }
}
