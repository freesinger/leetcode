package reentrantlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用三个线程交替打印ABC
 * ReentrantLock实现
 */
public class ABCPrint {
    private static final Lock lock = new ReentrantLock();
    private static int state = 0;

    public static void main(String[] args) {
        Thread A = new Thread(() -> {
            while (state <= 30) {
                lock.lock();
                try {
                    if (state % 3 == 0) {
                        System.out.printf("State: %d A\n", state);
                        state++;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        });

        Thread B = new Thread(() -> {
            while (state <= 30) {
                lock.lock();
                try {
                    if (state % 3 == 1) {
                        System.out.printf("State: %d B\n", state);
                        state++;
                    }
                } finally {
                    lock.unlock();
                }
            }
        });

        Thread C = new Thread(() -> {
            while (state <= 30) {
                lock.lock();
                try {
                    if (state % 3 == 2) {
                        System.out.printf("State: %d C\n", state);
                        state++;
                    }
                } finally {
                    lock.unlock();
                }
            }
        });

        A.start();
        B.start();
        C.start();
    }
}
