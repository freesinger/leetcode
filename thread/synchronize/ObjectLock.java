package synchronize;

import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 对象锁：
 * 类声明之后可以new出来很多实例，每个实例在jvm中都有自己的引用地址和堆内存空间
 * 因此使用同一实例的线程才会受锁影响，多个实例调用同一方法则不会
 */
@Data
public class ObjectLock {
    private static final Logger logger = LoggerFactory.getLogger(ObjectLock.class);
    private Object lock = new Object();

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            Thread worker = new Thread(new ObjectLockWorker());
            // worker.setName("thread-" + i);
            worker.start();
        }
    }

    // 锁对象实例里的非静态变量
    public void lockObjectField() {
        try {
            synchronized (lock) {
                System.out.println(Thread.currentThread().getName());
                Thread.sleep(4000);
            }
        } catch (Exception e) {
            logger.error("Lock Object field failed!");
            e.printStackTrace();
        }
    }

    // 锁当前对象实例
    public void lockThis() {
        try {
            synchronized (this) {
                System.out.println(Thread.currentThread().getName());
                Thread.sleep(4000);
            }
        } catch (Exception e) {
            logger.error("Lock Object field failed!");
            e.printStackTrace();
        }
    }

    // 锁非静态方法
    public synchronized void lockMethod() {
        try {
            System.out.println(Thread.currentThread().getName());
            Thread.sleep(4000);
        } catch (Exception e) {
            logger.error("Lock Object field failed!");
            e.printStackTrace();
        }
    }

    public static class ObjectLockWorker implements Runnable {
        @Override
        public void run() {
            try {
                ObjectLock objectLock = new ObjectLock();

                // 1
//                objectLock.lockObjectField();
//                // 2
//                objectLock.lockThis();
                // 3
                objectLock.lockMethod();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
