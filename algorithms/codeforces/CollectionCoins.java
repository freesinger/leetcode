package codeforces;

import java.util.Scanner;

/**
 * @author Shane
 * @date 2020-10-16 13:29
 */
public class CollectionCoins {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        while (num > 0) {
            int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt(), coins = sc.nextInt();
            // System.out.println(num);
            System.out.println(isPossible(a, b, c, coins) ? "Yes" : "No");
            num--;
        }
    }

    // brutal TLE
    private static boolean isPossible(int a, int b, int c, int coins) {
        for (int i = 0; i < coins; i++) {
            int ac = a;
            ac += i;
            for (int j = 0; j < coins - i; j++) {
                int bc = b, cc = c;
                bc += j;
                cc += (coins - i - j);
                if (ac == bc && bc == cc) return true;
            }
        }
        return false;
    }
}
