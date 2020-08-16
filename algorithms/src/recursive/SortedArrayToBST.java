package src.recursive;

import src.utils.node.implement.TreeNode;

/**
 * 有序数组转换为BST
 * 递归
 */
public class SortedArrayToBST {
    private static TreeNode arrayToBST(int[] nums, int left, int right) {
        if (left > right) return null;
        int mid = left + (right - left) / 2;
        TreeNode curNode = new TreeNode(nums[mid]);

        curNode.left = arrayToBST(nums, left, mid - 1);
        curNode.right = arrayToBST(nums, mid + 1, right);

        return curNode;
    }
}
