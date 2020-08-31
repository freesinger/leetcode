package src.binarysearch;

/**
 * 实现sqrt函数
 */
public class Sqrt {
    private static final double EPSILON = 1e-10;
    public static void main(String[] args) {
        System.out.println(sqrt(7));
        System.out.println(sqrt(4.109, EPSILON));
        System.out.println(Math.sqrt(4.109));
    }

    private static int sqrt(int n) {
        if (n <= 1) return n;
        int l = 0, r = n, mid, ans = -1;

        while (l <= r) {
            mid = l + (r - l) / 2;
            // 向下取整的，因此在<=的时候更新ans
            if (mid * mid <= n) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return ans > 0 ? ans : -1;
    }

    /**
     * 写一个函数，求平方根，函数参数为目标数字和精度，
     * 测试案例 fn(4.1,0.001) fn(501.1,0.001) fn(0.045,0.001)
     *
     * @return
     * @param n
     * @param e
     */
    private static double sqrt(double n, double e) {
        if (n <= 0.0) return 0.0;
        double l = 0, r = n, mid = 0, ans = -1;

        while (l < r) {
            mid = l + (r - l) / 2;
            if (mid * mid > e + n) {
                r = mid;
            } else if (mid * mid < n - e) {
                l = mid;
            } else {
                ans = mid;
                break;
            }
        }

        return ans;
    }
}
