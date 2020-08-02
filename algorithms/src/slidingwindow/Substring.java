package src.slidingwindow;

import java.util.HashMap;

/**
 * 最小覆盖子串
 * TODO: Debug
 */
public class Substring {
    public static void main(String[] args) {
        System.out.println(getShortestSubString("ADOBECODEBANC", "ABC"));
    }

    private static String getShortestSubString(String str, String target) {
        int left = 0, right = 0;
        int len = str.length();
        int min = Integer.MAX_VALUE;
        int match = 0, start = 0;

        HashMap<Character, Integer> strMap = new HashMap<>();
        HashMap<Character, Integer> targetMap = new HashMap<>();

        for (int i = 0; i < target.length(); i++) {
//            if (!targetMap.containsKey(target.charAt(i))) {
//                targetMap.put(target.charAt(i), 1);
//            } else {
//                targetMap.put(target.charAt(i), targetMap.get(target.charAt(i)) + 1);
//            }
            char ch = target.charAt(i);
            targetMap.put(ch, targetMap.getOrDefault(ch, 0) + 1);
        }

        while (left <= right && right < len) {
            char ch = str.charAt(right);
            if (targetMap.getOrDefault(ch, 0) > 0) {
                strMap.put(ch, strMap.getOrDefault(ch, 0) + 1);
                if (strMap.get(ch) == targetMap.get(ch)) match++;
            }
            right++;

            while (match == targetMap.size()) {
                if (right - left < min) {
                    min = right - left;
                    start = left;
                }
                char c = str.charAt(left);
                if (targetMap.getOrDefault(c, 0) > 0) {
                    strMap.put(ch, strMap.get(ch) - 1);
                    if (strMap.get(c) < targetMap.get(c)) match--;
                }
                left++;
            }
        }

        System.out.println(left);
        System.out.println(right);
        System.out.println(min);

        return min == Integer.MAX_VALUE ? "" : str.substring(start, start + min);

    }
}
