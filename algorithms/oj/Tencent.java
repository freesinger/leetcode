package oj;

import java.util.*;

public class Tencent {
    // 5


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int q = sc.nextInt();
        while (q > 0) {
            q--;
            int cnt = 0;
            int l = sc.nextInt();
            int r = sc.nextInt();
            System.out.println(maxSplit(s, l, r, cnt));

        }
    }

    private static int maxSplit(String s, int l, int r, int cnt) {
        int c = cnt;
        if (l == r) {
            return 1;
        }
        String str = s.substring(l - 1, r);
        if (l == r - 1) {
            if (str.charAt(0) == str.charAt(1)) return 1;
            else return 2;
        }

        List<Integer> max = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            List<Integer> max1 = getPalindrome(str, i, i);
            List<Integer> max2 = getPalindrome(str, i, i + 1);
            int len1 = max1.get(1) - max1.get(0), len2 = max2.get(1) - max2.get(0);
            max = max.size() > len1 ? max : max1;
            max = max.size() > len2 ? max : max2;
        }
        int maxLeft = max.get(0), maxRight = max.get(1);
        cnt++;
        int a = maxSplit(s, l, maxLeft, cnt);
        int b = maxSplit(s, maxRight, r, cnt);
        return a + b + c;
    }

    private static List<Integer> getPalindrome(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        //return s.substring(l + 1, r);
        return Arrays.asList(l + 1, r);
    }


    // 4
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[] nums = new int[n];
//        for (int i = 0; i < n; i++) nums[i] = sc.nextInt();
//
//
//    }
//
//    private static int minPaint(int[] nums) {
//
//    }


    // 3
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int T = sc.nextInt();
//        while (T > 0) {
//            T--;
//            int n = sc.nextInt();
//            System.out.println(maxValue(n));
//        }
//    }

    private static int maxValue(int n) {
        int max = -1;
        for (int i = 1; i <= n / 2; i++) {
            int j = n - i;
            max = Math.max(max, s(i) + s(j));
        }
        return max;
    }

    private static int s(int n) {
        int val = 0;
        while (n > 0) {
            val += n % 10;
            n /= 10;
        }
        return val;
    }


    // 2
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String s = sc.next();
//        int k = sc.nextInt();
//
//        System.out.println(kMinString(s, k));
//    }

    private static String kMinString(String s, int k) {
        // List<String> list = new ArrayList<>();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
//                if (!list.contains(s.substring(i, j)))
//                    list.add(s.substring(i, j));
                set.add(s.substring(i, j));
            }
        }
        ArrayList<String> list = new ArrayList<>(set);
        list.sort(String::compareTo);
        // System.out.println(list);
        return list.get(k - 1);
    }


    // 1
//    static class ListNode {
//        int value;
//        ListNode next;
//
//        public ListNode(int value) {
//            this.value = value;
//        }
//    }
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
////        int n = sc.nextInt();
////        int k = sc.nextInt();
////        int[] nums = new int[n];
////        for (int i = 0; i < n; i++) nums[i] = sc.nextInt();
//        int[] nums = new int[]{1, 2, 3, 4, 5};
//        ListNode root = constructList(nums);
//        while (root != null) {
//            System.out.println(root.value);
//            root = root.next;
//        }
//        deleteNode(root, 3);
//
//        while (root != null) {
//            System.out.println(root.value);
//            root = root.next;
//        }
//    }
//
//    private static ListNode constructList(int[] nums) {
//        ListNode root = new ListNode(nums[0]);
//        ListNode dummy = root;
//        for (int i = 1; i < nums.length; i++) {
//            root.next = new ListNode(nums[i]);
//            root = root.next;
//        }
//        root.next = null;
//        while (root != null) {
//            System.out.println(root.value);
//            root = root.next;
//        }
//        return dummy;
//    }
//
//    private static ListNode deleteNode(ListNode node, int k) {
//        //int cnt = 1;
//        ListNode toDelete = node, dummy = null, pre = null;
//        dummy.next = node;
//        if (k == 1) {
//            dummy.next = node.next;
//            return dummy;
//        }
//        while (k > 1) {
//            k--;
//            pre = toDelete;
//            toDelete = toDelete.next;
//        }
//
//        if (toDelete.next == null) {
//            pre.next = null;
//        } else {
//            pre.next = toDelete.next;
//        }
//
//        return dummy;
//    }
//
//    private static void delete(int[] nums, int k) {
//        for (int i = 1; i <= nums.length; i++) {
//            if (i == k) continue;
//            System.out.println(nums[i - 1]);
//        }
//    }
}
