package src.queue;

import java.util.LinkedList;
import java.util.Queue;

public class FirstAppearingOnce {
    private int[] cnts = new int[256];
    private Queue<Character> queue = new LinkedList<>();

    //Insert one char from stringstream
    public void Insert(char ch) {
        cnts[ch]++;
        queue.offer(ch);
        // TODO: 顺序相反为什么会NullPointerException?
        // while (cnts[queue.peek()] > 1 && !queue.isEmpty()) {
        while (!queue.isEmpty() && cnts[queue.peek()] > 1) {
            queue.poll();
        }
    }

    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        return queue.isEmpty() ? '#' : queue.peek();
    }
}
