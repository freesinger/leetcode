package oj;

import java.util.Scanner;
import java.util.Stack;

public class Aiqiyi {
    // 3
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        if (isValid(s)) System.out.println("True");
        else System.out.println("False");
    }

    private static boolean isValid(String s) {
        if (s == null || s.length() == 0) return true;
        if (s.length() % 2 != 0) return false;

        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            char cur = s.charAt(i);
            if ((stack.peek() == '(' && cur == ')') || (stack.peek() == '{' && cur == '}') || (stack.peek() == '[' && cur == ']')) {
                stack.pop();
            } else {
                stack.push(cur);
            }
        }

        return stack.isEmpty();
    }

//    // 2
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        //String path = sc.next();
//        System.out.println(robotPath("ESSWNEE"));
//    }
//
//    private static String robotPath(String path) {
//        if (path == null || path.length() <= 1) return "False";
//        int l = path.length();
//        boolean[][] record = new boolean[l][l];
//        int[][] d = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // W, E, N, S
//        int x = 0, y = 0;
//        record[x][y] = true;
//
//        for (int i = 0; i < l; i++) {
//            char c = path.charAt(i);
//            if (c == 'W') {
//                x += d[0][0];
//                y += d[0][1];
//            } else if (c == 'E') {
//                x += d[1][0];
//                y += d[1][1];
//            } else if (c == 'N') {
//                x += d[2][0];
//                y += d[2][1];
//            } else {
//                x += d[3][0];
//                y += d[3][1];
//            }
//            if (record[x][y]) return "True";
//            record[x][y] = true;
//        }
//        // System.out.println(Arrays.deepToString(record));
//
//        return "False";
//    }

//    // 1
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        //int num = sc.nextInt();
//        System.out.println(CountZero(31));
//    }
//
//    private static int CountZero(int n) {
//        if (n <= 0) return 0;
//        int cnt = 0;
//
//        while (n > 1) {
//            int cur = n;
//            if (cur % 5 == 0) {
//                while (cur % 5 == 0) {
//                    cnt++;
//                    cur /= 5;
//                }
//            }
//            n--;
//        }
//
//        return cnt;
//    }
}
