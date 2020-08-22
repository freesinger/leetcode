package oj;

import java.util.Scanner;

public class Shopee {
    // 2
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //String s = sc.next();
        String s = "998877665544332211";
        System.out.println(firstSmaller(s));
    }

    private static String firstSmaller(String s) {
        char[] chs = s.toCharArray();
        boolean swap = false;
        int r = s.length() - 1;

        // 301
        for (int i = r; i > 0; i--) {
            int l = i - 1;
            while (l >= 0 && chs[l] == '0') {
                l--;
            }
            if (chs[i] < chs[l]) {
                char c = chs[i];
                chs[i] = chs[l];
                chs[l] = c;
                swap = true;
                break;
            }
        }

        if (!swap || chs[0] == '0') return "0";

        return new String(chs);
    }

//    // 1
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String str = sc.next();
//        //String str = "This is 5th example";
//        System.out.println(toCamel(str));
//    }
//
//    private static String toCamel(String s) {
//        if (s == null || s.length() == 0) return "";
//        StringBuilder sb = new StringBuilder();
//        int l = 0, r = 0, wordCnt = 0;
//
//        while (l <= r && r < s.length()) {
//            if (!checkDigit(s.charAt(r))) {
//                l++;
//                r++;
//            } else {
//                break;
//            }
//        }
//
//        while (l <= r && r <= s.length()) {
//            if (r == s.length() || !checkDigit(s.charAt(r))) {
//                if (wordCnt > 0) {
//                    for (int i = l; i < r; i++) {
//                        if (i == l) sb.append(Character.toUpperCase(s.charAt(i)));
//                        else sb.append(Character.toLowerCase(s.charAt(i)));
//                    }
//                } else {
//                    for (int i = l; i < r; i++) {
//                        sb.append(Character.toLowerCase(s.charAt(i)));
//                    }
//                }
//                wordCnt++;
//                r++;
//                l = r;
//            } else {
//                r++;
//            }
//        }
//
//        return sb.toString();
//    }
//
//
//    public static boolean checkDigit(char c) {
//        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9');
//    }
}


