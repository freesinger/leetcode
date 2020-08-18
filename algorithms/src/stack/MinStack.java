package src.stack;

import java.util.Stack;

/**
 * 双栈实现最小栈
 */
public class MinStack {
    private Stack<Integer> data;
    private Stack<Integer> minElems;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        data = new Stack<Integer>();
        minElems = new Stack<Integer>();
    }

    public void push(int x) {
        if (minElems.isEmpty()) {
            minElems.push(x);
        } else {
            if (x <= minElems.peek()) {
                minElems.push(x);
            }
        }
        data.push(x);
    }

    public void pop() {
        int datatop = data.pop();
        if (datatop == minElems.peek()) {
            minElems.pop();
        }
    }

    public int top() {
        return data.peek();
    }

    public int getMin() {
        return minElems.peek();
    }
}
