package reentrantlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantlockDemo {
    private ReentrantLock reentrantLock = new ReentrantLock(true);

    public void tryLockAndDoSth() {
        reentrantLock.lock();
        try {
            try {
                // 支持多种加锁方式，比较灵活; 具有可重入特性
                // tryLock判断是否加锁成功
                if (reentrantLock.tryLock(100, TimeUnit.MILLISECONDS)) {
                    Thread.sleep(1000L);
                }
            } finally {
                // 手动释放锁
                reentrantLock.unlock();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }
    }
}
