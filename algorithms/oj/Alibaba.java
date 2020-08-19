package oj;

import java.util.PriorityQueue;

public class Alibaba {
    // 2
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[] nums = new int[n], ret = new int[n];
//        for (int i = 0; i < n; i++) nums[i] = sc.nextInt();

        int[] ret = new int[5];
        for (int k = 1; k <= ret.length; k++) {
            //ret[k - 1] = maxInWindow(nums, k);
            ret[k - 1] = maxInWindow(new int[]{2, 5, 3, 1, 2}, k);
        }

        for (int p : ret) System.out.printf("%d ", p);
        System.out.println();
    }

    private static int maxInWindow(int[] nums, int size) {
        PriorityQueue<Integer> pQueue = new PriorityQueue<>();
        int maxPower = 0;

        for (int i = 0; i < nums.length; i++) {
            if (pQueue.size() < size) {
                pQueue.offer(nums[i]);
                if (pQueue.size() == size) maxPower = Math.max(maxPower, pQueue.peek());
            } else {
                pQueue.remove(nums[i - size]);
                pQueue.offer(nums[i]);
                maxPower = Math.max(maxPower, pQueue.peek());
            }

        }

        return maxPower;
    }

}


// 1
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int t = sc.nextInt();
//        for (int i = 0; i < t; i++) {
//            int n = sc.nextInt();
//            int m = sc.nextInt();
//            Queue<Integer> a = new LinkedList<>();
//            Queue<Integer> b = new LinkedList<>();
//            int[] c = new int[n + m];
//
//            for (int j = 0; j < n; j++) a.offer(sc.nextInt());
//            for (int k = 0; k < m; k++) b.offer(sc.nextInt());
//            for (int l = 0; l < n + m; l++) c[l] = sc.nextInt();
//
//            if (isPossible(a, b, c)) System.out.println("possible");
//            else System.out.println("not possible");
//        }
//
//    }
//
//    private static boolean isPossible(Queue<Integer> a, Queue<Integer> b, int[] c) {
//        for (int value : c) {
//            if (!a.isEmpty() && a.peek() == value) {
//                a.poll();
//            } else if (!b.isEmpty() && b.peek() == value) {
//                b.poll();
//            } else return false;
//        }
//        return true;
//    }

