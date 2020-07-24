import org.checkerframework.checker.units.qual.Length;

/*
 * @lc app=leetcode.cn id=889 lang=java
 *
 * [889] 根据前序和后序遍历构造二叉树
 *
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/description/
 *
 * algorithms
 * Medium (59.83%)
 * Likes:    98
 * Dislikes: 0
 * Total Accepted:    5.8K
 * Total Submissions: 8.8K
 * Testcase Example:  '[1,2,4,5,3,6,7]\n[4,5,2,6,7,3,1]'
 *
 * 返回与给定的前序和后序遍历匹配的任何二叉树。
 * 
 * pre 和 post 遍历中的值是不同的正整数。
 * 
 * 
 * 
 * 示例：
 * 
 * 输入：pre = [1,2,4,5,3,6,7], post = [4,5,2,6,7,3,1]
 * 输出：[1,2,3,4,5,6,7]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= pre.length == post.length <= 30
 * pre[] 和 post[] 都是 1, 2, ..., pre.length 的排列
 * 每个输入保证至少有一个答案。如果有多个答案，可以返回其中一个。
 * 
 * 
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        return constructFromPrePost(pre, 0, pre.length, post, 0, post.length);
    }


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
}
// @lc code=end

