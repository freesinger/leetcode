package src.tree.btree;

import src.utils.node.implement.TreeNode;


public class ConstructTree {
    public static void main(String[] args) {
        //buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        buildTree(new int[]{1, 2, 4, 5, 3, 6, 7}, new int[]{4, 5, 2, 6, 7, 3, 1});
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        // return constructFromPreIn(preorder, 0, preorder.length, inorder, 0, inorder.length);
        return constructFromPrePost(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }


    /**
     * 从前序与后序遍历序列构造二叉树
     *
     * @param pre
     * @param preStart
     * @param preEnd
     * @param post
     * @param postStart
     * @param postEnd
     * @return
     */
    private static TreeNode constructFromPrePost(int[] pre, int preStart, int preEnd, int[] post, int postStart, int postEnd) {
        if (preStart >= preEnd || postStart >= postEnd) return null;
        int rootVal = pre[preStart], leftBeginVal = pre[preStart + 1];
        TreeNode root = new TreeNode(rootVal);


//        for (int i = preStart; i < preEnd; i++) {
//            if (pre[i] == rightBeginVal) {
//                preRightBeginPos = i;
//                break;
//            }
//        }

        int postCut = -1, preRightBeginPos = -1, leftSize = -1;
        for (int j = postStart; j < postEnd; j++) {
            if (post[j] == leftBeginVal) {
                postCut = j;
                leftSize = j + 1;
                break;
            }
        }
        preRightBeginPos = preStart + leftSize + 1;

        root.left = constructFromPrePost(pre, preStart + 1, preRightBeginPos, post, postStart, postCut + 1);
        root.right = constructFromPrePost(pre, preRightBeginPos, preEnd, post, postCut + 1, postEnd - 1);

        return root;
    }


    /**
     * 从前序与中序遍历序列构造二叉树
     * preorder = [3, 9, 20, 15, 7]
     * inorder = [9, 3, 15, 20, 7]
     *
     * @param pre
     * @param preStart
     * @param preEnd
     * @param in
     * @param inStart
     * @param inEnd
     * @return
     */
    private static TreeNode constructFromPreIn(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd) {
        if (preStart >= preEnd) return null;
        int rootVal = pre[preStart];
        TreeNode root = new TreeNode(rootVal);

        int leftSize = -1;
        for (int i = inStart; i < inEnd; i++) {
            if (in[i] == rootVal) {
                leftSize = i - inStart;
                break;
            }
        }

        root.left = constructFromPreIn(pre, preStart + 1, preStart + 1 + leftSize, in, inStart, inStart + leftSize);
        root.right = constructFromPreIn(pre, preStart + 1 + leftSize, preEnd, in, inStart + leftSize + 1, inEnd);

        return root;
    }
}
