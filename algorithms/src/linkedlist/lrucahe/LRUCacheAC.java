package src.linkedlist.lrucahe;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class LRUCacheAC {
    private Map<Integer, Integer> map;
    private Queue<Integer> queue;
    private int capacity;

    public LRUCacheAC(int capacity) {
        queue = new LinkedList<>();
        map = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        else {
            queue.remove(key);
            queue.offer(key);
            return map.get(key);
        }
    }

    public void put(int key, int value) {
        if (queue.size() < this.capacity) {
            if (map.containsKey(key)) {
                map.put(key, value);
                // Time Limit Exceeded
                queue.remove(key);
                queue.offer(key);
            } else {
                queue.offer(key);
                map.put(key, value);
            }
        } else {
            if (map.containsKey(key)) {
                map.put(key, value);
                queue.remove(key);
                queue.offer(key);
            } else {
                map.remove(queue.poll());
                map.put(key, value);
                queue.offer(key);
            }
        }
        // System.out.println(queue);
    }
}
