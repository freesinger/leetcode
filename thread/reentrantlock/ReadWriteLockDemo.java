package reentrantlock;

import sun.jvm.hotspot.oops.ObjectHeap;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockDemo {
    private Map<String, Object> map = new HashMap<>();
    private ReadWriteLock lock = new ReentrantReadWriteLock();

    /**
     * 单线程读写锁
     *
     * @param key
     * @return
     */
    private Object getValue(String key) {
        System.out.println(Thread.currentThread().getName());
        lock.readLock().lock();
        Object value = null;
        try {
            value = map.get(key);
            if (value == null) {
                lock.readLock().unlock();
                lock.writeLock().lock();
                try {
                    // 判断其他线程有没有写入
                    if (value == null) {
                        value = "shane";
                    }
                } finally {
                    lock.writeLock().unlock();
                }
                lock.readLock().lock();
            }
        } finally {
            lock.readLock().unlock();
        }

        return value;
    }

    /**
     * Get
     *
     * @param key
     * @return
     */
    private Object get(String key) {
        Object value = null;
        lock.readLock().lock();
        try {
            Thread.sleep(50L);
            value = map.get(key);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.readLock().unlock();
        }
        return value;
    }


    /**
     * Set
     *
     * @param key
     * @param value
     */
    private void set(String key, Object value) {
        lock.writeLock().lock();
        try {
            Thread.sleep(50L);
            map.put(key, value);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.writeLock().unlock();
        }
    }

    public static void main(String[] args) {
        final ReadWriteLockDemo test = new ReadWriteLockDemo();
        final String key = "anran";
        final Random seed = new Random();

        // 单线程
//        new Thread(() -> System.out.println(Thread.currentThread().getName() + " get value: " + test.getValue(key))).start();

        // 多线程
        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                for (int j = 0; j < 5; j++) {
                    System.out.println(Thread.currentThread().getName() + " read value: " + test.get(key));
                }
            }).start();

            new Thread(() -> {
                for (int j = 0; j < 6; j++) {
                    int value = seed.nextInt(1000);
                    test.set(key, value);
                    System.out.println(Thread.currentThread().getName() + " write value: " + value);
                }
            }).start();
        }


    }
}
