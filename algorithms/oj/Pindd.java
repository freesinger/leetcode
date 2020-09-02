package oj;

import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.TreeMap;

public class Pindd {
    // 1
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        //System.out.println(Arrays.deepToString(evenMatrix(6)));
//        print(evenMatrix(n));
//    }

    private static int[][] evenMatrix(int n) {
        int r = 0, c = 0, num = 1, end = (n - 2) / 2, mid = (n - 1) / 2;
        int[][] nums = new int[n][n];
        boolean isEven = n % 2 == 0;
        n--;

        while (r < end && c < end) {
            for (int i = n - 1; i >= c + 1; i--) {
                nums[r][i] = (!isEven && i == mid) ? 0 : num++;
            }

            for (int i = r + 1; i <= n - 1; i++) {
                nums[i][c] = (!isEven && i == mid) ? 0 : num++;
            }

            for (int i = c + 1; i <= n - 1; i++) {
                nums[n][i] = (!isEven && i == mid) ? 0 : num++;
            }

            for (int i = n - 1; i >= r + 1; i--) {
                nums[i][n] = (!isEven && i == mid) ? 0 : num++;
            }

            n--;
            r++;
            c++;
        }

        return nums;
    }

    private static void print(int[][] nums) {
        for (int[] ints : nums) {
            for (int i = 0; i < ints.length; i++) {
                System.out.print(ints[i]);
                if (i != ints.length - 1) System.out.print(" ");
            }
            System.out.println();
        }
    }

    //    // 2
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//    }
//
    // 3
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int[][] bargains = new int[n][2];
        for (int i = 0; i < n; i++) {
            bargains[i][0] = sc.nextInt();
            bargains[i][1] = sc.nextInt();
        }

        recursive(buildMap(bargains), m);
        System.out.println(max);
    }

    private static int max = Integer.MIN_VALUE;

    private static TreeMap<Integer, PriorityQueue<Integer>> buildMap(int[][] n) {
        TreeMap<Integer, PriorityQueue<Integer>> map = new TreeMap<>();

        for (int[] ints : n) {
            for (int j = 0; j < n[0].length; j++) {
                int num = ints[j];
                map.computeIfAbsent(num, k -> new PriorityQueue<>((a, b) -> (b - a)));
                map.get(num).add(ints[j + 1]);
            }
        }

        return map;
    }

    private static void recursive(TreeMap<Integer, PriorityQueue<Integer>> map, int bag) {
        if (bag <= 0) return;
        int tmpValue = 0;

        for (int i : map.keySet()) {
            if (bag == 0) break;
            if (bag >= i) {
                int firstValue = map.get(i).peek() == null ? 0 : map.get(i).poll();
                bag -= i;
                tmpValue += firstValue;
                max = Math.max(max, tmpValue);
                recursive(map, bag);
            }
        }
    }


    // 4
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt(), cnt = sc.nextInt();
//        int[] nums = new int[cnt];
//        while (cnt > 0) {
//            nums[--cnt] = sc.nextInt();
//        }
//        System.out.println(count(nums, n));
//
//    }


    private static int count(int[] nums, int n) {
        int ret = 0;

        for (int i = 1; i <= n; i++) {
            for (int num : nums) {
                if (i % num == 0) {
                    ret++;
                    break;
                }
            }
        }

        return ret;
    }
}
