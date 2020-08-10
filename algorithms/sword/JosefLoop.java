package sword;

import java.util.LinkedList;

/**
 * 循环报数（约瑟夫环）
 */
public class JosefLoop {
    public static void main(String[] args) {
        System.out.println(lastRemainingInLoop(100, 2));
    }

    // n个人0 ~ m报数，报m出列，继续循环一直到只剩一个人
    private static int lastRemainingInLoop(int n, int m) {
        LinkedList<Integer> loop = new LinkedList<>();
        for (int i = 0; i <= n; i++) loop.add(i);

        int deque = 0;
        while (loop.size() > 1) {
            // 这里m-1可以理解为出队第m个人
            // 不加的话就是出队0号
            // 取余操作为了模拟环
            deque = (deque + m - 1) % loop.size();
            loop.remove(deque);
        }

        return loop.size() == 1 ? loop.get(0) : -1;
    }
}
