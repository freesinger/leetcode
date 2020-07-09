package atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerDemo {
    private AtomicInteger count = new AtomicInteger(1);

    public int getAndIncrement() {
        // 不加锁也可以实现线程安全
        return count.getAndIncrement();
    }


    public static void main(String[] args) {
        final AtomicIntegerDemo test = new AtomicIntegerDemo();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " get count: " + test.getAndIncrement());
            }).start();
        }
    }
}
