package synchronize;

import lombok.Data;

/**
 * 类锁：类信息(静态变量等)存储在jvm方法区，整个jvm有且只有一份，方法区是线程共享的，因此在同一时刻，只能有一个线程再使用加了类锁的方法(体)，不管是不是一个实例
 */
@Data
public class ClassLock {
    private static Object lock = new Object();

    // 锁类中的静态变量
    public void lockStaticObjectField() {
        try {
            synchronized (lock) {
                System.out.println(Thread.currentThread().getName());
                Thread.sleep(3000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 锁静态方法
    public static synchronized void lockMethod() throws InterruptedException {
        System.out.println(Thread.currentThread().getName());
        Thread.sleep(3000);
    }

    // 锁当前类的.class属性
    public void lockClass() {
        try {
            synchronized (ClassLock.class) {
                System.out.println(Thread.currentThread().getName());
                Thread.sleep(3000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static class ClassLockWorker implements Runnable {

        @Override
        public void run() {
            try {
                ClassLock classLock = new ClassLock();
                // 1
//                classLock.lockStaticObjectField();
//                // 2
//                classLock.lockClass();
                // 3
                ClassLock.lockMethod(); // 静态方法通过类调用
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            Thread worker = new Thread(new ClassLockWorker());
            worker.start();
        }
    }
}
