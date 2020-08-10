package src.dp;

public class Fibonacci {
    public static void main(String[] args) {
        for (int i = 0; i <= 6; i++) {
            System.out.println(fibonacci(i));
        }
    }

    private static int fibonacci(int n) {
        int i = 0, j = 1;

        if (n <= 1) return n;
        while (n > 1) {
            int tmp = j;
            j += i;
            i = tmp;
            n--;
        }

        return j;
    }
}
