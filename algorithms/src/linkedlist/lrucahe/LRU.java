package src.linkedlist.lrucahe;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * 简单value LRU cache实现
 */
public class LRU {
    private Map<Integer, Integer> map;
    // private Set<Map<Integer, Integer>> cache;
    private Queue<Integer> cache;
    private int SIZE;

    public LRU(Map<Integer, Integer> map, int initSize) {
        this.map = map;
        this.SIZE = initSize;
        this.cache = new LinkedList<>();
    }

    public int get(int key) {
        if (!cache.contains(key)) {
            return -1;
        } else {
            cache.remove(key);
            cache.add(key);
            return map.get(key);
        }
    }

    public void put(int key, int value) {
        map.put(key, value);
        if (cache.contains(key)) {
            cache.remove(key);
        } else {
            if (cache.size() == SIZE) {
                cache.poll();
            }
        }
        cache.offer(key);
    }


}
