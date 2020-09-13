package oj;

import java.util.Scanner;

public class NetEase {
    // 4
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt(), e = sc.nextInt();

        if (s == e) {
            System.out.println(0);
        } else {
            System.out.println(Math.abs(s - e));
        }

        System.out.println(3);
        System.out.println(0);
    }


    // 2
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        NetEase test = new NetEase();
//        System.out.println(test.compress(sc.next()));
////        System.out.println(test.compress("abbbbbbAAAdcdddd"));
////        System.out.println(test.compress("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBeeeeeeeeeeFYHHnjHAPQQc"));
//    }
//
//    public String compress(String rawStr) {
//        if (rawStr == null || rawStr.length() < 4) return rawStr;
//        StringBuilder sb = new StringBuilder();
//        int l = 0, r = 1, len = rawStr.length() - 1, cnt = 0;
//
//        while (r < rawStr.length() && l < r) {
//            char left = rawStr.charAt(l), right = rawStr.charAt(r);
//            if (left != right) {
//                sb.append(left);
//                //sb.append(right);
//                l++;
//                r++;
//            } else {
//                cnt = 2;
//                while (++r <= len && right == rawStr.charAt(r)) {
//                    cnt++;
//                }
//                if (cnt < 4) {
//                    for (int i = l; i < r; i++) sb.append(rawStr.charAt(i));
//                } else {
//                    if (cnt <= 55) {
//                        sb.append(0);
//                        sb.append((char) (cnt - 4 + 'a'));
//                    } else {
//                        while (cnt > 55) {
//                            cnt -= 55;
//                            sb.append(0);
//                            sb.append('Z');
//                            sb.append(left);
//                        }
//                        sb.append((char) (cnt - 4 + 'a'));
//                    }
//                    sb.append(left);
//                }
//                l = r;
//                r++;
//            }
//        }
//        if (sb.charAt(sb.length() - 3) != '0' || rawStr.charAt(len) != rawStr.charAt(len - 2))
//            sb.append(rawStr.charAt(len));
//
//        return sb.toString();
//    }


    // 1
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int N = sc.nextInt(), a = sc.nextInt(), b = sc.nextInt();
//
//        System.out.println(minimal(a, b));
//    }
//
//    private static int minimal(int a, int b) {
//        char[] chs1 = String.valueOf(a).toCharArray(), chs2 = String.valueOf(b).toCharArray();
//        StringBuilder sb = new StringBuilder();
//        Arrays.sort(chs2);
//
//        for (char curA : chs1) {
//            for (int j = 0; j < chs2.length; j++) {
//                if (chs2[j] >= curA) {
//                    sb.append(chs2[j]);
//                    chs2[j] -= 10;
//                    break;
//                }
//            }
//        }
//        if (sb.length() < chs1.length) return -1;
//        int s = Integer.parseInt(sb.toString());
//        // System.out.println(s);
//
//        return s > a ? s : -1;
//    }
}
