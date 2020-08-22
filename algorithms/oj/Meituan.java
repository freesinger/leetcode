package oj;

import java.util.Scanner;

public class Meituan {
    // 5
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int[] nums = new int[x + y];
        for (int i = 0; i < nums.length; i++) nums[i] = sc.nextInt();
        System.out.println(partition(nums, x, y));

    }

    private static String partition(int[] nums, int x, int y) {
        StringBuilder sb = new StringBuilder();

        if (x == y) {
            while (x-- >= 0) sb.append("A");
            while (y-- >= 0) sb.append("B");
            return sb.toString();
        }

        for (int i = 0; i < nums.length; i++) sb.append("B");
        int larger = Math.max(x, y);
        sort(nums, 0, nums.length - 1, larger, sb);

        return sb.toString();
    }

    public static int findIndex(int[] array, int low, int high) {
        // cur用来标记pivot的位置，找到一个比pivot小的数则cur++
        int cur = low;
        int pivot = array[high];

        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                swapByIndex(array, cur, j);
                cur++;
            }
        }
        // 把pivot放到正确的位置
        swapByIndex(array, cur, high);

        return cur;
    }

    public static void sort(int[] array, int low, int high, int larger, StringBuilder ret) {
        if (low < high) {
            int median = findIndex(array, low, high);
            if (median >= larger) {
                ret.replace(median, median, "A");
            }
            sort(array, low, median - 1, larger, ret);
            sort(array, +1, high, larger, ret);
        }
    }

    public static void swapByIndex(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }


    // 3
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[] weights = new int[n], takes = new int[n];
//        boolean[] hasTaken = new boolean[n];
//        for (int i = 0; i < n; i++) {
//            weights[i] = sc.nextInt();
//        }
//        for (int i = 0; i < n; i++) {
//            takes[i] = sc.nextInt();
//        }
//
//        for (int i = 0; i < n; i++) {
//            int take = takes[i];
//            int preSum = 0, lastSum = 0;
//            hasTaken[take - 1] = true;
//            for (int j = 0; j < take - 1; j++) {
//                if (!hasTaken[j]) preSum += weights[j];
//            }
//            for (int k = take; k < n; k++) {
//                if (!hasTaken[k]) lastSum += weights[k];
//            }
//            System.out.println(Math.max(preSum, lastSum));
//        }
//    }


//    // 2
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int m = sc.nextInt();
//        int[] sums = new int[n];
//        boolean[] hasTaken = new boolean[n];
//        PriorityQueue<Integer> pQueue = new PriorityQueue<>(m);
//        // TreeMap<Integer, Integer> map = new TreeMap<>((a, b) -> (b - a));
//
//        for (int i = 0; i < n; i++) {
//            int value = sc.nextInt();
//            int weight = sc.nextInt();
//            int wage = calculate(value, weight);
//            sums[i] = wage;
//            if (pQueue.size() < m) {
//                pQueue.offer(wage);
//            } else {
//                if (pQueue.peek() < wage) {
//                    pQueue.poll();
//                    pQueue.offer(wage);
//                }
//            }
//        }
//
//        for (int j = 0; j < m; j++) {
//            int topValue = pQueue.poll();
//            for (int k = 0; k < m; k++) {
//                if (topValue == sums[k] && !hasTaken[k]) {
//                    hasTaken[k] = true;
//                    System.out.print(k + 1);
//                    System.out.print(" ");
//                }
//            }
//        }
//
//        System.out.println();
//    }
//
//    private static int calculate(int v, int w) {
//        return v + w * 2;
//    }


//    // 1
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int T = sc.nextInt();
//        for (int i = 0; i < T; i++) {
//            String str = sc.next();
//            if (isValid(str)) System.out.println("Accept");
//            else System.out.println("Wrong");
//        }
//    }
//
//    private static boolean isValid(String s) {
//        if (s == null || s.length() <= 1) return false;
//        boolean hasLetter = false, hasDigit = false;
//
//        for (int i = 0; i < s.length(); i++) {
//            char ch = s.charAt(i);
//            if (!beforeCheck(ch)) return false;
//            if (i == 0 && !checkLetter(ch))  return false;
//            if (!hasLetter && checkLetter(ch)) hasLetter = true;
//            if (!hasDigit && checkDigit(ch)) hasDigit = true;
//        }
//
//        if (hasDigit && hasLetter) return true;
//        return false;
//    }
//
//    private static boolean beforeCheck(char c) {
//        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9');
//    }
//
//    private static boolean checkLetter(char c) {
//        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
//    }
//
//    private static boolean checkDigit(char c) {
//        return c >= '0' && c <= '9';
//    }


}
