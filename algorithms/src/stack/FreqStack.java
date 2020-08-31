package src.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 最大频率栈
 */
public class FreqStack {
    Map<Integer, Integer> freq;
    Map<Integer, Stack<Integer>> map;
    int maxFreq;

    public FreqStack() {
        this.maxFreq = 0;
        this.freq = new HashMap<>();
        this.map = new HashMap<>();
    }

    public void push(int x) {
        int f = freq.getOrDefault(x, 0) + 1;
        freq.put(x, f);
        if (f > maxFreq) maxFreq = f;
        map.computeIfAbsent(f, k -> new Stack<>()).push(x);
    }

    public int pop() {
        int x = map.get(maxFreq).pop();
        freq.put(x, freq.get(x) - 1);
        if (map.get(maxFreq).size() == 0) maxFreq--;
        return x;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 */
