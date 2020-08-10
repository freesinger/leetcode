package src.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * 最长有效括号
 */
public class LongestValidParentheses {
    public static void main(String[] args) {
        System.out.println(getLongest(")())"));
    }


    private static int getLongest(String str) {
        if (str == null || str.length() <= 1) return 0;
        int[] nums = new int[str.length()];
        int maxLen = 0, curLen = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(') stack.push(i);
            else {
                if (stack.isEmpty()) nums[i] = 1; // 多余的)无法匹配直接置1  eg: )())
                else stack.pop(); // 否则能匹配一对括号出栈
            }
        }

        while (!stack.isEmpty()) nums[stack.pop()] = 1; // 多余的(也置1  eg: )()((())

        System.out.println(Arrays.toString(nums));
        // 转化为求最长连续0子串问题
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
