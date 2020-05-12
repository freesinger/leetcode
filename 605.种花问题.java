import sun.security.util.Length;

/*
 * @lc app=leetcode.cn id=605 lang=java
 *
 * [605] 种花问题
 *
 * https://leetcode-cn.com/problems/can-place-flowers/description/
 *
 * algorithms
 * Easy (30.34%)
 * Likes:    117
 * Dislikes: 0
 * Total Accepted:    19.6K
 * Total Submissions: 62.4K
 * Testcase Example:  '[1,0,0,0,1]\n1'
 *
 * 假设你有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花卉不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
 * 
 * 给定一个花坛（表示为一个数组包含0和1，其中0表示没种植花，1表示种植了花），和一个数 n 。能否在不打破种植规则的情况下种入 n
 * 朵花？能则返回True，不能则返回False。
 * 
 * 示例 1:
 * 
 * 
 * 输入: flowerbed = [1,0,0,0,1], n = 1
 * 输出: True
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入: flowerbed = [1,0,0,0,1], n = 2
 * 输出: False
 * 
 * 
 * 注意:
 * 
 * 
 * 数组内已种好的花不会违反种植规则。
 * 输入的数组长度范围为 [1, 20000]。
 * n 是非负整数，且不会超过输入数组的大小。
 * 
 * 
 */

// @lc code=start
class Solution {
    /**
     * 标记位统计可种植位置
     * @param flowerbed
     * @param n
     * @return
     */
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int[] beds = new int[flowerbed.length+2];
        int[] canPlant = new int[flowerbed.length+2];
        System.arraycopy(flowerbed, 0, beds, 1, flowerbed.length);
        int sum = 0;

        beds[0] = -1;
        beds[beds.length-1] = -1;
        for (int i = 1; i < beds.length-1; i++)
            canPlant[i] = beds[i-1] == 1 || beds[i+1] == 1 || beds[i] == 1 ? -1 : 0;

        int j = 1;
        while (j < canPlant.length-1) {
            if (canPlant[j] == 0) {
                sum++;
                j += 2;
            } else j++;
        }
            
        // System.out.println(zeroSum);
        return sum >= n;
    }
}
// @lc code=end

