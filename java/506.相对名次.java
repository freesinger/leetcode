import java.util.Arrays;
import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=506 lang=java
 *
 * [506] 相对名次
 *
 * https://leetcode-cn.com/problems/relative-ranks/description/
 *
 * algorithms
 * Easy (51.87%)
 * Likes:    40
 * Dislikes: 0
 * Total Accepted:    7.8K
 * Total Submissions: 14.5K
 * Testcase Example:  '[5,4,3,2,1]'
 *
 * 给出 N 名运动员的成绩，找出他们的相对名次并授予前三名对应的奖牌。前三名运动员将会被分别授予 “金牌”，“银牌” 和“ 铜牌”（"Gold
 * Medal", "Silver Medal", "Bronze Medal"）。
 *
 * (注：分数越高的选手，排名越靠前。)
 *
 * 示例 1:
 *
 *
 * 输入: [5, 4, 3, 2, 1]
 * 输出: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
 * 解释: 前三名运动员的成绩为前三高的，因此将会分别被授予 “金牌”，“银牌”和“铜牌” ("Gold Medal", "Silver Medal"
 * and "Bronze Medal").
 * 余下的两名运动员，我们只需要通过他们的成绩计算将其相对名次即可。
 *
 * 提示:
 *
 *
 * N 是一个正整数并且不会超过 10000。
 * 所有运动员的成绩都不相同。
 *
 *
 */

// @lc code=start
class Solution {
    public String[] findRelativeRanks(int[] nums) {
        int len = nums.length;
        String[] res = new String[len];
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < len; i++)
            map.put(nums[i], i);
        Arrays.sort(nums);
        if (len >= 1)
            res[map.get(nums[len - 1])] = "Gold Medal";
        if (len >= 2)
            res[map.get(nums[len - 2])] = "Silver Medal";
        if (len >= 3)
            res[map.get(nums[len - 3])] = "Bronze Medal";
        for (int i = len - 4; i >= 0; i--)
            res[map.get(nums[i])] = String.valueOf(len - i);


        return res;
    }
}
// @lc code=end

