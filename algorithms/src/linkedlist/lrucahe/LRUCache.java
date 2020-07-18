package src.linkedlist.lrucahe;

import src.utils.node.implement.LinkedListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO: debug
 */
public class LRUCache {
    private Map<Integer, LinkedListNode> map;
    public LinkedListNode head, tail;
    private int capacity;


    public LRUCache(int capacity) {
        map = new HashMap<>(capacity);
        head = new LinkedListNode();
        tail = new LinkedListNode();
        this.capacity = capacity;

        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            LinkedListNode node = map.get(key);
            int value = map.get(key).value;
            remove(node);
            insert(node);
            return value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (map.size() == capacity) {
            if (map.get(key) == null) {
                removeLast();
            } else {
                remove(map.get(key));
            }
        }
        insert(new LinkedListNode(key, value));
    }

    private void remove(LinkedListNode node) {
        LinkedListNode prevNode = node.pre;
        LinkedListNode nextNode = node.next;

        prevNode.next = nextNode;
        nextNode.pre = prevNode;
        map.remove(node.key);
    }

    private void removeLast() {
        LinkedListNode last = tail.pre;

        tail.pre = last.pre;
        last.pre.next = tail;
        map.remove(last.key);
    }

    private void insert(LinkedListNode node) {
        addToFirst(node);
        map.put(node.key, node);
    }


    /**
     * 头插法更新链表
     *
     * @param node
     */
    private void addToFirst(LinkedListNode node) {
        LinkedListNode first = head.next;
        first.pre = node;
        node.next = first;

        node.pre = head;
        head.next = node;
    }


    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2 /* 缓存容量 */);

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // 返回  1
        cache.put(3, 3);    // 该操作会使得关键字 2 作废
        System.out.println(cache.get(2));       // 返回 -1 (未找到)
        cache.put(4, 4);    // 该操作会使得关键字 1 作废
        System.out.println(cache.get(1));       // 返回 -1 (未找到)
        System.out.println(cache.get(3));      // 返回  3
        System.out.println(cache.get(4));     // 返回  4
    }
}
