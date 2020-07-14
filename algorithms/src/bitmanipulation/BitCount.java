package src.bitmanipulation;

/**
 * 输入一个整数，输出该数二进制表示中 1 的个数。
 */
public class BitCount {
    private int count(int n) {
        int sum = 0;
        while (n != 0) {
            sum++;
            n &= (n - 1);
        }
        return sum;
    }

    private int countUseLib(int n) {
        return Integer.bitCount(n);
    }
}
