package src.recursive;

/**
 * 数值的整数次方
 */
public class Power {
    public static void main(String[] args) {
        System.out.println(power(2.0, 3));
        System.out.println(power(3.0, -2));
    }

    private static double power(double n, int e) {
        if (e == 0 || n == 1.0) return 1.0;
        if (e == 1) return n;
        boolean isNegative = false;
        if (e < 0) {
            isNegative = true;
            e *= -1;
        }

        double result = power(n * n, e / 2); // 每次递归幂折半
        if (e % 2 == 1) result *= n;

        return isNegative ? 1 / result : result;
    }
}
