package oj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> res = new ArrayList<>();

//        while (sc.hasNextInt()) {
//            int m = sc.nextInt();
//            int n = sc.nextInt();
//            if (hasFlower(m, n)) {
//                Collections.sort(list);
//                for (int i : list) {
//                    System.out.print(i);
//                    System.out.print(" ");
//                }
//                System.out.println();
//            } else {
//                System.out.println("no");
//            }
//        }

        // for (String s : res) System.out.println(s);

        if (hasFlower(300, 380)) {
            Collections.sort(list);
            for (int i : list) {
                System.out.print(i);
                System.out.print(" ");
            }
            System.out.println();
        } else {
            System.out.println("no");
        }
    }


    private static int calculateSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += Math.pow((num % 10), 3);
            num /= 10;
        }
        return sum;
    }

    private static boolean hasFlower(int m, int n) {
        boolean f = false;
        for (int i = m; i <= n; i++) {
            if (i == calculateSum(i)) {
                list.add(i);
                f = true;
            }
        }
        return f;
    }

    private static String sum(int n, int m) {
        double num = (double) n;
        double sum = num;

        while (--m > 0) {
            num = Math.pow(num, 0.5);
            sum += num;
        }

        return String.format("%.2f", sum);
    }
}
