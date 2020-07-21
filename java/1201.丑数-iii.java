import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1201 lang=java
 *
 * [1201] 丑数 III
 *
 * https://leetcode-cn.com/problems/ugly-number-iii/description/
 *
 * algorithms
 * Medium (16.84%)
 * Likes:    6
 * Dislikes: 0
 * Total Accepted:    1K
 * Total Submissions: 6K
 * Testcase Example:  '3\n2\n3\n5'
 *
 * 请你帮忙设计一个程序，用来找出第 n 个丑数。
 *
 * 丑数是可以被 a 或 b 或 c 整除的 正整数。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 3, a = 2, b = 3, c = 5
 * 输出：4
 * 解释：丑数序列为 2, 3, 4, 5, 6, 8, 9, 10... 其中第 3 个是 4。
 *
 * 示例 2：
 *
 * 输入：n = 4, a = 2, b = 3, c = 4
 * 输出：6
 * 解释：丑数序列为 2, 3, 4, 6, 8, 9, 12... 其中第 4 个是 6。
 *
 *
 * 示例 3：
 *
 * 输入：n = 5, a = 2, b = 11, c = 13
 * 输出：10
 * 解释：丑数序列为 2, 4, 6, 8, 10, 11, 12, 13... 其中第 5 个是 10。
 *
 *
 * 示例 4：
 *
 * 输入：n = 1000000000, a = 2, b = 217983653, c = 336916467
 * 输出：1999999984
 *
 *
 *
 *
 * 提示：
 *
 *
 * 1 <= n, a, b, c <= 10^9
 * 1 <= a * b * c <= 10^18
 * 本题结果在 [1, 2 * 10^9] 的范围内
 *
 *
 */

// @lc code=start
class Solution {
    final static int MAX_VALUE = 2 * 1_000_000_000;


    // public static void main(String[] args) {

    //     int uglyNum = nthUglyNumber(3, 2, 3, 5);
    //     System.out.println(uglyNum);
    // }

    // public static int nthUglyNumber(int n, int a, int b, int c) {
    //     int[] a_res = new int[MAX_VALUE / a];
    //     int[] b_res = new int[MAX_VALUE/b];
    //     int[] c_res = new int[MAX_VALUE/c];

    //     for (int i = 1; i <= a_res.length; i++) {
    //         if (a*i > MAX_VALUE) break;
    //         a_res[i-1] = a*i;
    //     }
    //     for (int i = 1; i <= b_res.length; i++) {
    //         if (b*i > MAX_VALUE) break;
    //         b_res[i-1] = b*i;
    //     }
    //     for (int i = 1; i <= c_res.length; i++) {
    //         if (c*i > MAX_VALUE) break;
    //         c_res[i-1] = c*i;
    //     }

    //     int[] res = mergeArrays(a_res, b_res, c_res);
    //     Arrays.sort(res);
    //     return res[n - 1];
    // }

    private static int[] mergeArrays(int[] a, int[] b, int[] c) {
        int res[] = Arrays.copyOf(a, a.length + b.length + c.length);
        System.arraycopy(b, 0, res, a.length, b.length);
        System.arraycopy(c, 0, res, a.length + b.length, c.length);
        return res;
    }
}
// @lc code=end

