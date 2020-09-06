package src.linkedlist.lfucahe;

import java.util.*;

public class LFUCache {
    private Map<Integer, Integer> map;
    private Map<Integer, Integer> freq;
    private TreeMap<Integer, List<Integer>> pop;
    private int capacity, cnt;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.freq = new HashMap<>();
        this.pop = new TreeMap<>();
    }

    public int get(int key) {
        // TODO
        return 0;
    }

    public void put(int key, int value) {
        for (int i = 0; i < pop.size() && cnt >= capacity; i++) {

        }
        map.put(key, value);
        int keyFreq = freq.getOrDefault(key, 0) + 1;
        freq.put(key, keyFreq);
        pop.computeIfAbsent(keyFreq, k -> new ArrayList<>()).add(key);
        if (keyFreq > 1) pop.get(keyFreq - 1).remove(key);
    }

}
