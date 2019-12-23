import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=1239 lang=java
 *
 * [1239] 串联字符串的最大长度
 *
 * https://leetcode-cn.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/description/
 *
 * algorithms
 * Medium (34.97%)
 * Likes:    15
 * Dislikes: 0
 * Total Accepted:    3.8K
 * Total Submissions: 10.6K
 * Testcase Example:  '["un","iq","ue"]'
 *
 * 给定一个字符串数组 arr，字符串 s 是将 arr 某一子序列字符串连接所得的字符串，如果 s 中的每一个字符都只出现过一次，那么它就是一个可行解。
 * 
 * 请返回所有可行解 s 中最长长度。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：arr = ["un","iq","ue"]
 * 输出：4
 * 解释：所有可能的串联组合是 "","un","iq","ue","uniq" 和 "ique"，最大长度为 4。
 * 
 * 
 * 示例 2：
 * 
 * 输入：arr = ["cha","r","act","ers"]
 * 输出：6
 * 解释：可能的解答有 "chaers" 和 "acters"。
 * 
 * 
 * 示例 3：
 * 
 * 输入：arr = ["abcdefghijklmnopqrstuvwxyz"]
 * 输出：26
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= arr.length <= 16
 * 1 <= arr[i].length <= 26
 * arr[i] 中只含有小写英文字母
 * 
 * 
 */

// @lc code=start
class Solution {
    public int dfs(List<String> arr,int index, int flag){
        if(index >= arr.size()){
            return 0;
        }
        int max = 0;
        for(int i = index; i < arr.size(); i++){
            int f = 0;
            String str = arr.get(i);
            //检测字符串本身是否有重复字符
            for(char c : str.toCharArray()){
                if((f & 1 <<(c - 'a')) != 0){
                    f = 0;
                    break;
                }
                f |= 1 <<(c - 'a');
            }
            //本身重复或与已经选择的串重复，跳过
            if(f == 0 || (flag & f) != 0) continue;
            //接着dfs
            max = Math.max(max,str.length() + dfs(arr,i + 1,flag | f));
        }
        return max;
    }
    
    public int maxLength(List<String> arr) {
        return dfs(arr,0,0);
    }
}
// @lc code=end

