package jvm;

import java.util.Scanner;

public class Daemon {
    /**
     * 当线程只剩下守护线程的时候,JVM就会退出；补充一点如果还有其他的任意一个用户线程还在，JVM就不会退出。
     *
     * @param args
     */
    public static void main(String[] args) {
        Thread daemonThread = new Thread(new DaemonRunner());
        daemonThread.setDaemon(true);
        daemonThread.start();
        System.out.println("isDaemon? = " + daemonThread.isDaemon());
        Scanner scanner = new Scanner(System.in);
        scanner.next();
        Runtime.getRuntime().addShutdownHook(new Thread(() -> System.out.println("JVM Exit!")));
    }

    static class DaemonRunner implements Runnable {
        @Override
        public void run() {
            while (true) {
                for (int i = 1; i <= 10; i++) {
                    System.out.println("Current thread:" + Thread.currentThread().getName() + " daemon thread: " + i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}
