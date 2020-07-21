import com.sun.org.apache.xalan.internal.xsltc.runtime.Node;

/*
 * @lc app=leetcode.cn id=559 lang=java
 *
 * [559] N叉树的最大深度
 *
 * https://leetcode-cn.com/problems/maximum-depth-of-n-ary-tree/description/
 *
 * algorithms
 * Easy (67.23%)
 * Likes:    78
 * Dislikes: 0
 * Total Accepted:    19.1K
 * Total Submissions: 27.8K
 * Testcase Example:  '[1,null,3,2,4,null,5,6]'
 *
 * 给定一个 N 叉树，找到其最大深度。
 *
 * 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
 *
 * 例如，给定一个 3叉树 :
 *
 *
 *
 *
 *
 *
 *
 * 我们应返回其最大深度，3。
 *
 * 说明:
 *
 *
 * 树的深度不会超过 1000。
 * 树的节点总不会超过 5000。
 *
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    private int depth = 1;

    public int maxDepth(Node root) {
        if (root == null) return 0;
        nodeDepth(root, 1);
        return depth;
    }

    private void nodeDepth(Node node, int dep) {
        if (node == null) return;
        for (Node n : node.children) {
            // dep++错误，会导致同一层结点深度不一致
            depth = Math.max(dep + 1, depth);
            nodeDepth(n, dep + 1);
        }
    }
}
// @lc code=end

