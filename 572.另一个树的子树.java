import java.util.ArrayList;
import java.util.List;

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
    List<TreeNode> childs = new ArrayList<>();

    public boolean isSubtree(TreeNode s, TreeNode t) {
        List<Integer> tElements = new ArrayList<>();
        
        inOrderParse(t, tElements);
        findChild(s, t.val);
        for (TreeNode node : childs) {
            List<Integer> list = new ArrayList<>();
            boolean isSubtree = true;
            inOrderParse(node, list);
            if (list.size() != tElements.size()) continue;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) != tElements.get(i)) {
                    isSubtree = false;
                    break;
                }
            }
            if (isSubtree) return true;
        }

        return false;
    }

    private void findChild(TreeNode n, int num) {
        if (n == null) return;
        findChild(n.left, num);
        if (n.val == num) childs.add(n);
        findChild(n.right, num);
    }

    private void inOrderParse(TreeNode n, List<Integer> l) {
        if (n == null) return;
        inOrderParse(n.left, l);
        l.add(n.val);
        inOrderParse(n.right, l);
    }
}
// @lc code=end

