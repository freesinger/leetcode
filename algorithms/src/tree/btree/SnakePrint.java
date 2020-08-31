package src.tree.btree;

import src.utils.node.implement.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 之字打印
 */
public class SnakePrint {
    public static void main(String[] args) {
        SnakePrint test = new SnakePrint();
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        root.left = node1;
        root.right = node2;
        node2.left = node3;

        System.out.println(test.Print(root));
    }

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        if (pRoot == null) return new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        boolean leftToRight = true;

        queue.offer(pRoot);
        while (!queue.isEmpty()) {
            ArrayList<Integer> line = new ArrayList<>();
            int levelNumber = queue.size();
            while (levelNumber-- > 0) {
                TreeNode currentNode = queue.poll();
                assert currentNode != null;
                if (currentNode.left != null) queue.offer(currentNode.left);
                if (currentNode.right != null) queue.offer(currentNode.right);
                line.add(currentNode.value);
            }
            if (!leftToRight) Collections.reverse(line);
            leftToRight = !leftToRight;
            result.add(line);
        }

        return result;
    }
}
