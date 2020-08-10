package sword;

import java.util.Stack;

public class LongestValidParentheses {
    private static int getLongest(String str) {
        if (str == null || str.length() <= 1) return 0;
        int[] nums = new int[str.length()];
        int maxLen = 0, curLen = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(') stack.push(i);
            else {
                if (stack.isEmpty()) nums[i] = 1;
                else stack.pop();
            }
        }

        while (!stack.isEmpty()) nums[stack.pop()] = 1;

        for (int i = 0; i < str.length(); i++) {
            if (nums[i] == 1) {
                curLen = 0;
            } else {
                curLen++;
                maxLen = Math.max(maxLen, curLen);
            }
        }

        return maxLen;
    }
}
