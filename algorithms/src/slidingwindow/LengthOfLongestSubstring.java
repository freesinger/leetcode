package src.slidingwindow;

import java.util.HashMap;

/**
 * 无重复字符的最长子串
 *
 */
public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        System.out.println(LLS("pwwkew"));
    }

    public static int LLS(String str) {
        if (str == null || str.length() == 0) return 0;
        if (str.length() == 1) return 1;
        // 用map存储每个字符出现的最后位置，重复则从最后位置开始重新找
        HashMap<Character, Integer> map = new HashMap<>();
        int len = str.length();
        int left = 0;
        int max = 1;

        for (int i = 0; i < len; i++) {
            if (map.containsKey(str.charAt(i))) {
                left = Math.max(left, map.get(str.charAt(i)) + 1);
            }
            map.put(str.charAt(i), i);
            max = Math.max(max, i - left + 1);
        }

        return max;
    }
}
