package src.dp;

/**
 * 实现sqrt函数
 */
public class Sqrt {
    public static void main(String[] args) {
        System.out.println(sqrt(7));
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
}
