package oj;

import java.io.IOException;
import java.util.Scanner;

public class DIDI {

    // 2
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int T = sc.nextInt();
//
//        while (T-- > 0) {
//            int n = sc.nextInt(), m = sc.nextInt(), k = sc.nextInt();
//            Set<Integer> set = new HashSet<>();
//            while (m-- > 0) {
//                int c1 = sc.nextInt(), c2 = sc.nextInt(), cost = sc.nextInt();
//                if (cost <= k) {
//                    set.add(c1);
//                    set.add(c2);
//                } else {
//                    if (set.contains(c1) && set.contains(c2)) {
//                        set.add(c1);
//                        set.add(c2);
//                    }
//                }
//            }
//            System.out.println(n == set.size() ? "Yes" : "No");
//        }
//    }


    // 1
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String K = sc.nextLine();
        //BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        String s = sc.nextLine();
        char[] chs = s.toCharArray();
//        int k = 3;
//        char[] chs = "hsak asofjh 123 21!#@#!23 2112hj l".toCharArray();
        int k = Integer.parseInt(K);
        int l = 0, r = l + k;

        while (l < chs.length) {
            reverseInK(chs, l, r - 1);
            l += k;
            r += k;
        }

        System.out.println(new String(chs));

    }

    private static void reverseInK(char[] chs, int l, int r) {
        int len = chs.length;
        if (r >= len) r = len - 1;

        while (l < r) {
            char c = chs[l];
            chs[l] = chs[r];
            chs[r] = c;
            l++;
            r--;
        }
    }

}
