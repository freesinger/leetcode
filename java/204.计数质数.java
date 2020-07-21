/*
 * @lc app=leetcode.cn id=204 lang=java
 *
 * [204] 计数质数
 *
 * https://leetcode-cn.com/problems/count-primes/description/
 *
 * algorithms
 * Easy (31.04%)
 * Likes:    240
 * Dislikes: 0
 * Total Accepted:    35.8K
 * Total Submissions: 114.1K
 * Testcase Example:  '10'
 *
 * 统计所有小于非负整数 n 的质数的数量。
 *
 * 示例:
 *
 * 输入: 10
 * 输出: 4
 * 解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 *
 *
 */

// @lc code=start
class Solution {
    public int countPrimes(int n) {
        if (n == 1 || n == 2) return 0;

        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime(i)) {
                count++;
                // System.out.println(i);
            }
        }
        return count;
    }

    private boolean isPrime(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
// @lc code=end

