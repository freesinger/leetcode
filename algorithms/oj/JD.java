package oj;

import java.util.Scanner;

public class JD {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int res = 0;

        while (N <= M) {
            String num = String.valueOf(N);
            String palindrome = longestPalindrome(String.valueOf(N));
            if (palindrome.length() == num.length()) {
                StringBuilder sb = new StringBuilder(num);
                sb.delete(sb.length() /  2, sb.length() / 2);
                if (isPrime(Integer.parseInt(sb.toString()))) res++;
            } else if (palindrome.length() + 1 == num.length()) {
                if (isPrime(N)) res++;
            }
            N++;
        }

        System.out.println(res);
    }

    public static String getPalindrome(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return s.substring(l + 1, r);
    }

    public static String longestPalindrome(String str) {
        String result = "";

        for (int i = 0; i < str.length(); i++) {
            String r1 = getPalindrome(str, i, i);
            String r2 = getPalindrome(str, i, i + 1);
            result = r1.length() > result.length() ? r1 : result;
            result = r2.length() > result.length() ? r2 : result;
        }

        return result;
    }


    private static boolean isPrime(int n) {
        if (n >= 1 && n <= 9) return true;
        for (int i = 2; i < Math.sqrt(n); i++) {
            if (n % i != 0) return false;
        }
        return true;
    }

    private static boolean isPalindrome(int n) {
        String s = String.valueOf(n);
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else return false;
        }
        return true;
    }



//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        double result = sum(n);
//        System.out.println(String.format("%.4f", result));
//    }
//
//    private static double sum(int n) {
//        double sum = 0.0;
//        for (int i = 0; i <= n; i++) {
//            sum += Math.pow(-1, i) / (5 * (i + 1));
//        }
//        return sum;
//    }
}
