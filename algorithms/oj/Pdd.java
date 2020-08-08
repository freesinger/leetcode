package oj;

import java.util.Arrays;
import java.util.Scanner;

public class Pdd {

//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        char[][] lines = new char[6][6];
//        for (int i = 0; i < 6; i++) {
//            lines[i] = sc.nextLine().toCharArray();
//            //lines[i] = line;
//        }
//
//        int[][] dp = new int[6 + 1][6 + 1];
//        Arrays.fill(dp, 1000);
//        for (int i = 1; i < 7; i++) {
//            for (int j = 1; j < 7; j++) {
//                if (lines[i][j] == '#') dp[i][j] = 0;
//                else dp[i][j] = 1000;
//            }
//        }
//
//        int toheaptal = 1;
//        for (int i = 1; i < 7; i++) {
//            for (int j = 1; j < 7; j++) {
//                if (dp[i][j - 1] == 1000 && dp[i][j + 1] == 1000 && dp[i - 1][j] == 1000 && dp[i + 1][j] == 1000) {
//                    dp[i][j] = 6;
//                    total *= 6;
//                } else {
//                    dp[i][j] = Math.min(dp[i][j - 1], Math.min(dp[i][j + 1], Math.min(dp[i + 1][j], dp[i - 1][j]))) - 1;
//                    total *= dp[i][j];
//                }
//            }
//        }
//
//        System.out.println(total % 1000000009);
//    }


//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int m = sc.nextInt();
//        int t = sc.nextInt();
//
//        int[][] meals = new int[n + m][2];
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < 2; j++) {
//                meals[i][j] = sc.nextInt();
//                meals[i][j] = sc.nextInt();
//            }
//        }
//
//        int minFat = 1000;
//        TreeMap<Integer, Integer> map = new TreeMap<>((a, b) -> (b - a));
//
//        for (int i = 0; i < n + m; i++) {
//            if (!map.containsKey(meals[i][1])) {
//                map.put(meals[i][1], meals[i][0]);
//            } else if (map.get(meals[i][1]) > meals[i][1]) {
//                map.put(meals[i][1], meals[i][0]);
//            }
//        }
//
//        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//            if (entry.getKey() >= t) {
//                minFat = Math.min(minFat, entry.getValue());
//            } else {
//                // int curFat = entry.getValue();
//                for (Map.Entry<Integer, Integer> entry1: map.entrySet()) {
//                    if (entry1.getKey() < t && entry.getKey() + entry1.getKey() >= t) {
//                        minFat = Math.min(minFat, entry.getValue() + entry1.getValue());
//                    }
//                }
//            }
//        }
//
//
//        System.out.println(minFat);
//    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[][] nums = new int[N][6];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 6; j++) {
                nums[i][j] = sc.nextInt();
            }
        }

        int kind = 0;
        int[] cnt = new int[N];



    }


//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        int k = sc.nextInt();
//        int n = sc.nextInt();
//        int[] nums = new int[n];
//        int pos = 0;
//        while (sc.hasNextInt()) nums[pos++] = sc.nextInt();
//
//        if (k == 0) {
//            System.out.println("paradox");
//            System.exit(0);
//        }
//
//        int sum = 0, backStep = 0;
//        for (int i = 0; i < n; i++) {
//            sum += nums[i];
//            if (sum == k) {
//                System.out.println("paradox");
//                System.exit(0);
//            } else if (sum < k) {
//            } else {
//                backStep += sum - k;
//                sum = k - backStep;
//            }
//        }
//
//        System.out.print(k - sum);
//        System.out.print(" ");
//        System.out.println(backStep);
//
//    }
//        System.out.println("Printing the file passed in:");
//        while(sc.hasNextLine()) System.out.println(sc.nextLine());

}
