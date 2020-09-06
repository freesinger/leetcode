package oj;

import java.util.*;

public class TencentOj {
    // 1
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[] first = new int[n];
//        for (int i = 0; i < n; i++) first[i] = sc.nextInt();
//        int m = sc.nextInt();
//        int[] second = new int[m];
//        for (int i = 0; i < m; i++) second[i] = sc.nextInt();
//
//        commonSequence(first, second);
//    }
//
//    private static void commonSequence(int[] f, int[] s) {
//        int p1 = 0, p2 = 0;
//        while (p1 < f.length && p2 < s.length) {
//            if (f[p1] == s[p2]) {
//                System.out.print(f[p1]);
//                System.out.print(" ");
//                p1++;
//                p2++;
//            } else if (f[p1] > s[p2]) {
//                p1++;
//            } else {
//                p2++;
//            }
//        }
//    }


    // 2
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt(), m = sc.nextInt();
//        List<List<Integer>> list = new ArrayList<>();
//        for (int i = 0; i < m; i++) {
//            List<Integer> p = new ArrayList<>();
//            int x = sc.nextInt();
//            while (x-- > 0) p.add(sc.nextInt());
//            list.add(p);
//        }
//
//        System.out.println(messageFlow(list));
//    }
//
//    private static int messageFlow(List<List<Integer>> nums) {
//        Set<Integer> set = new HashSet<>();
//        for (List<Integer> l : nums) {
//            if (l.contains(0)) {
//                set.addAll(l);
//            }
//        }
//
//        int size = nums.size();
//        while (size > 0) {
//            for (List<Integer> l : nums) {
//                for (int n : l) {
//                    if (set.contains(n)) {
//                        set.addAll(l);
//                        break;
//                    }
//                }
//            }
//            size--;
//        }
//
//        return set.size();
//    }


    // 3
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();

        TreeMap<String, Integer> treeMap = new TreeMap<>();
        while (n-- > 0) {
            String s = sc.next();
            treeMap.put(s, treeMap.getOrDefault(s, 0) + 1);
        }

        LinkedList<Integer> values = new LinkedList<>(new HashSet<>(treeMap.values()));
        Collections.sort(values);
        //LinkedList<Integer> values2 = new LinkedList<>(values);

        int topK = k, lastK = k, topIdx = values.size() - 1, lastIdx = 0;
        while (topK > 0) {
            int top = values.get(topIdx);
            for (Map.Entry<String, Integer> entry : treeMap.entrySet()) {
                if (entry.getValue() == top && topK > 0) {
                    System.out.print(entry.getKey());
                    System.out.print(" ");
                    System.out.print(top);
                    topK--;
                    if (topK > 0) System.out.println();
                }
            }
            topIdx = Math.max(topIdx - 1, 0);
        }

        System.out.println();
        //System.out.println(values);
        while (lastK > 0) {
            int last = values.get(lastIdx);
            // System.out.println(last);
            for (Map.Entry<String, Integer> entry : treeMap.entrySet()) {
                if (entry.getValue() == last && lastK > 0) {
                    System.out.print(entry.getKey());
                    System.out.print(" ");
                    System.out.print(last);
                    lastK--;
                    if (lastK > 0) System.out.println();
                }
            }
            lastIdx = lastIdx + 1 < values.size() ? lastIdx + 1 : lastIdx;
        }

    }

    // 4
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[] nums = new int[n];
//        for (int i = 0; i < n; i++) nums[i] = sc.nextInt();
//        int[] copy = new int[n];
//        System.arraycopy(nums, 0, copy, 0, n);
//
//        Arrays.sort(nums);
//
//        int l = nums[n / 2 - 1], r = nums[n / 2];
//        for (int i = 0; i < n; i++) {
//            int num = copy[i];
//            if (num <= l) System.out.println(r);
//            else System.out.println(l);
//        }
//
//    }

    // 5
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        String s = sc.next();
//        int[] idx = new int[2 * n];
//        for (int i = 0; i < 2 * n; i++) idx[i] = sc.nextInt();
//
//        System.out.println(1);
//
//    }
}
