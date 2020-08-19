package src.queue;

import java.util.BitSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 字符串中第一个只出现一次的字符
 */
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
    public char firstAppearingOnce() {
        return queue.isEmpty() ? '#' : queue.peek();
    }


    /**
     * 使用bitset
     *
     * @param s
     * @return
     */
    private char firstAppearance(String s) {
        BitSet bs1 = new BitSet(256);
        BitSet bs2 = new BitSet(256);

        for (char c : s.toCharArray()) {
            if (!bs1.get(c) && !bs2.get(c)) {
                bs1.set(c);
            } else if (bs1.get(c) && !bs2.get(c)) {
                bs2.set(c);
            }
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (bs1.get(c) && bs2.get(c)) {
                return c;
            }
        }

        return 0;
    }
}
