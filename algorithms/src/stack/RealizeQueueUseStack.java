package src.stack;

import java.util.Stack;

/**
 * 双栈实现队列
 */
public class RealizeQueueUseStack {
    private Stack<Integer> in = new Stack<>();
    private Stack<Integer> out = new Stack<>();


    public static void main(String[] args) {
        RealizeQueueUseStack queue = new RealizeQueueUseStack();
        queue.poll();
        queue.offer(1);
        queue.offer(2);
        System.out.println(queue.poll()); // 1
        queue.offer(3);
        System.out.println(queue.poll()); // 2
    }

    public void offer(int node) {
        in.push(node);
    }

    public int poll() {
        while (!out.isEmpty()) {
            out.pop();
        }

        int res = -1;
        try {
            if (in.isEmpty()) throw new Exception("Queue is empty!");
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
            res = out.pop();

            while (!out.isEmpty()) {
                in.push(out.pop());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return res;
    }
}
