package src.string;

import java.util.Arrays;

/**
 * 最长无重复子字符串
 */
public class LongestSubStringWithoutDuplication {
    public int longestSubStringWithoutDuplication(String str) {
        int len = str.length();
        int curLen = 0, maxLen = 0;
        int[] preIndex = new int[26];

        Arrays.fill(preIndex, -1);
        for (int i = 0; i < len; i++) {
            int c = str.charAt(i) - 'a';
            int preI = preIndex[c];
            if (preI == -1 || i - preI > curLen) {
                curLen++;
            } else {
                maxLen = Math.max(curLen, maxLen);
                curLen = i - preI;
            }
            preIndex[c] = i;
        }

        maxLen = Math.max(maxLen, curLen);
        return maxLen;
    }
}
