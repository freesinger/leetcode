package src.slidingwindow;

import java.util.HashMap;

/**
 * 无重复字符的最长子串
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
            char ch = str.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            while (map.get(ch) > 1) {
                char ch2 = str.charAt(left);
                left++;
                map.put(ch2, map.get(ch2) - 1);
            }
            max = Math.max(max, i - left + 1);
        }

        System.out.println(str.substring(left, left + max));

        return max;
    }
}
