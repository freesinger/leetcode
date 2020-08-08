package oj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class WY {
    //   public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt(), m = sc.nextInt();
//        List<Integer> T = new ArrayList<>();
//        boolean[] hasTaken = new boolean[n + 1];
//
//        for (int i = 0; i < m; i++) {
//            int num = sc.nextInt();
//            T.add(num);
//            hasTaken[num] = true;
//        }


    //2
//        List<Integer> T = new ArrayList<>(Arrays.asList(2,1,5));
//        boolean[] hasTaken = new boolean[5+1];
//        for (int i :  T) hasTaken[i] = true;
//        sequence(T, 2, hasTaken);
//        for (int i = 0; i < T.size(); i++) {
//            System.out.print(T.get(i));
//            if (i != T.size() - 1) System.out.print(" ");
//        }


    // 1
//        int n = sc.nextInt();
//        int cnt = 0;
//
//        while (sc.hasNextInt()) {
//            int num = sc.nextInt();
//            cnt += primeSplit(num, 0);
//        }

// 1
//        int cnt = 0;
//        int[] t = new int[]{5, 3, 7, 11, 10};
//        for (int i : t) {
//            System.out.println(primeSplit(i, 0));
//            cnt += primeSplit(i, 0);
//        }
//        System.out.println(cnt);
    //}

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T > 0) {
            T--;

            int n = sc.nextInt();
            List<Integer> nums = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                nums.add(sc.nextInt());
            }
            System.out.println(minValue(nums));
        }
    }

    // 3
    private static int minValue(List<Integer> nums) {
        if (nums.size() == 1) return nums.get(0);
        Collections.sort(nums);
        List<Integer> copy = new ArrayList<>(nums);
        int largest = copy.get(copy.size() - 1);
        int target = largest;
        copy.remove(copy.size() - 1);
        int h = copy.size() - 1;
        while (h >= 0 && largest > 0) {
            largest -= copy.get(h);
            if (largest >= copy.get(h)) copy.remove(h);
            h--;
        }
        if (largest == 0) return minValue(copy) + target;
        else {
            nums.remove(nums.remove(nums.size() - 2));
            return minValue(nums);
        }
    }


    // 2
    private static void sequence(List<Integer> nums, int gap, boolean hasTaken[]) {
        // List<Integer> res = new ArrayList<>();
        nums.add(0, Integer.MIN_VALUE);
        nums.add(Integer.MAX_VALUE);

        while (gap > 0) {
            for (int j = 1; j < hasTaken.length; j++) {
                if (hasTaken[j] == true) {
                    continue;
                } else {
                    // System.out.println(j);
                    for (int k = 0; k < nums.size() - 1; k++) {
                        if (j > nums.get(k) && j < nums.get(k + 1)) {
                            nums.add(k + 1, j);
                            hasTaken[j] = true;
                            break;
                        }
                    }
                }
            }
            gap--;
        }

        nums.remove(0);
        nums.remove(nums.size() - 1);
        //return nums;
    }

    // 1
    private static int primeSplit(int n, int count) {
        if (n <= 3) return count + 1;
        int c1 = primeSplit(n - 2, count + 1);
        // nt c2 = primeSplit(n - 3, count + 1);
        return c1;
    }
}
