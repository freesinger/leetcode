package reentrantlock;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 简单存取款机实现
 */
public class ATM {
    private static ReentrantLock lock;
    private volatile static AtomicInteger account;
    private static boolean isDeposit = false;

    public ATM(int account) {
        lock = new ReentrantLock();
        ATM.account = new AtomicInteger(account);
    }

    public static void main(String[] args) {
        //while (true) {
        // get operation code and money
//            int m = 10;
//            if (isDeposit) {
//                deposit(m);
//            } else {
//                withdraw(m);
//            }
        // break;
        new ATM(200);
        withdraw(200);
        deposit(100);
        withdraw(90);
        deposit(10);
        withdraw(30);
        //}
    }

    private static void deposit(int money) {
        new Thread(() -> {
            lock.lock();
            try {
                //if (isDeposit) {
                System.out.printf("Deposit %d\n", money);
                account.getAndAdd(money);
                Thread.sleep(200);
                System.out.printf("Current thread: %s\n", Thread.currentThread().getId());
                System.out.printf("Account: %d\n\n", account.get());
                //}
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }).start();
    }

    private static void withdraw(int money) {
        new Thread(() -> {
            lock.lock();
            try {
                //if (!isDeposit) {
                System.out.printf("Withdraw %d\n", money);
                if (account.get() < money) throw new Exception("Short of money!");
                account.getAndAdd(-money);
                Thread.sleep(1000);
                System.out.printf("Current thread: %s\n", Thread.currentThread().getId());
                System.out.printf("Account: %d\n\n", account.get());
                //}
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }).start();
    }
}
