package src.tree.btree;

import src.utils.node.implement.TreeNode;

public class SerializeTree {
    private int index = -1;

    /**
     * PreOrder
     *
     * @param root
     * @return
     */
    public String serialize(TreeNode root) {
        if (root == null) return "#";
        return root.value + " " + serialize(root.left) + serialize(root.right);
    }


    public TreeNode deserialize(String str) {
        String[] s = str.split(" ");
        index++;
        TreeNode node;
        if (index > str.length() || s[index].equals("#")) return null;
        else {
            node = new TreeNode(Integer.parseInt(s[index]));
            node.left = deserialize(str);
            node.right = deserialize(str);
        }
        return node;
    }
}
