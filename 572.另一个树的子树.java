import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=572 lang=java
 *
 * [572] 另一个树的子树
 *
 * https://leetcode-cn.com/problems/subtree-of-another-tree/description/
 *
 * algorithms
 * Easy (41.97%)
 * Likes:    167
 * Dislikes: 0
 * Total Accepted:    15.8K
 * Total Submissions: 36K
 * Testcase Example:  '[3,4,5,1,2]\n[4,1,2]'
 *
 * 给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s
 * 也可以看做它自身的一棵子树。
 * 
 * 示例 1:
 * 给定的树 s:
 * 
 * 
 * ⁠    3
 * ⁠   / \
 * ⁠  4   5
 * ⁠ / \
 * ⁠1   2
 * 
 * 
 * 给定的树 t：
 * 
 * 
 * ⁠  4 
 * ⁠ / \
 * ⁠1   2
 * 
 * 
 * 返回 true，因为 t 与 s 的一个子树拥有相同的结构和节点值。
 * 
 * 示例 2:
 * 给定的树 s：
 * 
 * 
 * ⁠    3
 * ⁠   / \
 * ⁠  4   5
 * ⁠ / \
 * ⁠1   2
 * ⁠   /
 * ⁠  0
 * 
 * 
 * 给定的树 t：
 * 
 * 
 * ⁠  4
 * ⁠ / \
 * ⁠1   2
 * 
 * 
 * 返回 false。
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
    /**
     * 遍历检查子串
     * 注意写入规则特殊
     * @param s
     * @param t
     * @return
     */
    public boolean isSubtree(TreeNode s, TreeNode t) {
        StringBuilder sString = new StringBuilder();
        StringBuilder tString = new StringBuilder();
        inOrderParse(s, sString);
        inOrderParse(t, tString);
        return sString.toString().indexOf(tString.toString()) >= 0;
    }

    private void inOrderParse(TreeNode n, StringBuilder str){
        if (n == null) return;
        inOrderParse(n.left, str);
        if (n.left == null) str.append("lnull");
        // "#"处理数字防止 数字相连导致检测子数组出错
        // 形式 s:[23, 4, 5] 和 t:[3, 4, 5] 的树也将给出一个 true 的结果
        // 因为 t 的先序遍历字符串 (“23 4 lnull rnull 5 lnull rnull”) 将是 s 的先序遍历字符串 (“3 4 lnull rull 5 lnull rnull”) 的子字符串。
        // 在节点值之前添加一个 “#” 可以解决这个问题。
        str.append("#" + n.val);
        if (n.right == null) str.append("rnull");
        inOrderParse(n.right, str);
    }
    // List<TreeNode> childs = new ArrayList<>();

    // public boolean isSubtree(TreeNode s, TreeNode t) {
    //     List<Integer> tElements = new ArrayList<>();
        
    //     inOrderParse(t, tElements);
    //     findChild(s, t.val);
    //     // for (TreeNode n : childs) System.out.println(n.val);
    //     for (TreeNode node : childs) {
    //         List<Integer> list = new ArrayList<>();
    //         boolean isSubtree = true;
    //         inOrderParse(node, list);
    //         if (list.size() != tElements.size()) continue;
    //         for (int i = 0; i < list.size(); i++) {
    //             if (list.get(i) != tElements.get(i)) {
    //                 isSubtree = false;
    //                 break;
    //             }
    //         }
    //         if (isSubtree) return true;
    //     }

    //     return false;
    // }

    // private void findChild(TreeNode n, int num) {
    //     if (n == null) return;
    //     findChild(n.left, num);
    //     if (n.val == num) childs.add(n);
    //     findChild(n.right, num);
    // }
}
// @lc code=end

