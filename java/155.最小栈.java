import java.util.Stack;

/*
 * @lc app=leetcode.cn id=155 lang=java
 *
 * [155] 最小栈
 *
 * https://leetcode-cn.com/problems/min-stack/description/
 *
 * algorithms
 * Easy (50.43%)
 * Likes:    331
 * Dislikes: 0
 * Total Accepted:    58.5K
 * Total Submissions: 115.7K
 * Testcase Example:  '["MinStack","push","push","push","getMin","pop","top","getMin"]\n[[],[-2],[0],[-3],[],[],[],[]]'
 *
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 *
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 *
 *
 * 示例:
 *
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 *
 *
 */

// @lc code=start

class MinStack {
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


/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
// @lc code=end

