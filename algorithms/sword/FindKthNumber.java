package sword;

/**
 * 寻找1 ~ n字典序排序第k个数
 */
public class FindKthNumber {
    public static void main(String[] args) {

    }

    public int findKthNumber(int n, int k) {   //13 2
        int cur = 1;
        k = k - 1;
        while (k > 0) {   //2
            int steps = getSteps(n, cur, cur + 1);  //5
            if (steps <= k) {
                cur += 1;
                k -= steps;
            } else {
                cur *= 10;          //10
                k -= 1;             //0
            }
        }
        return cur;
    }

    //1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9
    /*           sum
     * 1  2   1  1
     * 10 20  4  5
     */
    public int getSteps(int n, long n1, long n2) {
        int steps = 0;
        while (n1 <= n) {
            steps += Math.min(n + 1, n2) - n1;
            n1 *= 10;
            n2 *= 10;
        }
        return steps;
    }

}
