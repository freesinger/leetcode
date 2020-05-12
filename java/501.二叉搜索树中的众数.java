import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/*
 * @lc app=leetcode.cn id=501 lang=java
 *
 * [501] 二叉搜索树中的众数
 *
 * https://leetcode-cn.com/problems/find-mode-in-binary-search-tree/description/
 *
 * algorithms
 * Easy (42.72%)
 * Likes:    88
 * Dislikes: 0
 * Total Accepted:    9.9K
 * Total Submissions: 22.4K
 * Testcase Example:  '[1,null,2,2]'
 *
 * 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
 * 
 * 假定 BST 有如下定义：
 * 
 * 
 * 结点左子树中所含结点的值小于等于当前结点的值
 * 结点右子树中所含结点的值大于等于当前结点的值
 * 左子树和右子树都是二叉搜索树
 * 
 * 
 * 例如：
 * 给定 BST [1,null,2,2],
 * 
 * ⁠  1
 * ⁠   \
 * ⁠    2
 * ⁠   /
 * ⁠  2
 * 
 * 
 * 返回[2].
 * 
 * 提示：如果众数超过1个，不需考虑输出顺序
 * 
 * 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内）
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
    Map<Integer, Integer> map = new HashMap<>();

    /**
     * 遍历树用map存储再找满足条件众数
     * @param root
     * @return
     */
    public int[] findMode(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        
        inOrder(root);

        // 若root为null使用Collections.max()会throw noSuchElementException
        try {
            int maxNum = Collections.max(map.values());
            // 遍历字典键值对
            for (Map.Entry<Integer, Integer> entry : map.entrySet())
                if (entry.getValue() == maxNum) res.add(entry.getKey());
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    private void inOrder(TreeNode root) {
        if (root == null) return;
        if (root.left != null) inOrder(root.left);
        if (!map.containsKey(root.val)) map.put(root.val, 1);
        else map.put(root.val, map.get(root.val)+1);
        if (root.right != null) inOrder(root.right);
    }
}
// @lc code=end

