import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=146 lang=java
 *
 * [146] LRU缓存机制
 *
 * https://leetcode-cn.com/problems/lru-cache/description/
 *
 * algorithms
 * Medium (44.32%)
 * Likes:    416
 * Dislikes: 0
 * Total Accepted:    34K
 * Total Submissions: 74.4K
 * Testcase Example:  '["LRUCache","put","put","get","put","get","put","get","get","get"]\n[[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]'
 *
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 * 
 * 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) -
 * 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间。
 * 
 * 进阶:
 * 
 * 你是否可以在 O(1) 时间复杂度内完成这两种操作？
 * 
 * 示例:
 * 
 * LRUCache cache = new LRUCache( 2 ); // 缓存容量 
 * 
 * cache.put(1, 1);
 * cache.put(2, 2);
 * cache.get(1);       // 返回  1
 * cache.put(3, 3);    // 该操作会使得密钥 2 作废
 * cache.get(2);       // 返回 -1 (未找到)
 * cache.put(4, 4);    // 该操作会使得密钥 1 作废
 * cache.get(1);       // 返回 -1 (未找到)
 * cache.get(3);       // 返回  3
 * cache.get(4);       // 返回  4
 * 
 * 
 */

// @lc code=start
class LRUCache {
    Map<Integer, Integer> map;
    Queue<Integer> queue;
    int capacity;

    public LRUCache(int capacity) {
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
                map.remove(queue.element());
                queue.poll();
                map.put(key, value);
                queue.offer(key);
            }
        }
        // System.out.println(queue);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end

