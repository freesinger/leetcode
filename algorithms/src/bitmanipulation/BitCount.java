package src.bitmanipulation;

/**
 * 输入一个整数，输出该数二进制表示中 1 的个数。
 */
public class BitCount {
    public static void main(String[] args) {
        BitCount bitCount = new BitCount();
        int n = 1000121313;
        System.out.println(bitCount.countWithMath(n));
        System.out.println(bitCount.count(n));
        System.out.println(bitCount.countUseLib(n));
    }

    private int countWithMath(int n) {
        int cnt = 0;
        while (n > 0) {
            cnt = n % 2 == 1 ? cnt + 1 : cnt;
            n /= 2;
        }
        return cnt;
    }

    private int count(int n) {
        int cnt = 0;
        while (n != 0) {
            cnt++;
            n &= (n - 1);
        }
        return cnt;
    }

    private int countUseLib(int n) {
        return Integer.bitCount(n);
    }
}
