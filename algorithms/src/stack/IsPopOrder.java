package src.stack;

import java.util.Stack;

public class IsPopOrder {
    public static void main(String[] args) {
        IsPopOrder test = new IsPopOrder();
        System.out.println(test.isPopOrder(new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 3, 2, 1}));
        System.out.println(test.isPopOrder(new int[]{1, 2, 3, 4, 5}, new int[]{4, 3, 5, 1, 2}));
    }

    public boolean isPopOrder(int[] pushSequence, int[] popSequence) {
        if (pushSequence.length != popSequence.length) return false;
        Stack<Integer> stack = new Stack<>();
        int n = pushSequence.length, pos = 0;

        for (int i = 0; i < n; i++) {
            stack.push(pushSequence[i]);
            while (!stack.isEmpty() && pos < n && stack.peek() == popSequence[pos]) {
                stack.pop();
                pos++;
            }
        }

        return stack.isEmpty();
    }
}
