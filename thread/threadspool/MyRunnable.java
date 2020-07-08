package threadspool;

import java.util.Date;

public class MyRunnable implements Runnable {
    private String command;

    public MyRunnable() {}

    public MyRunnable(String s) {
        this.command = s;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Start time: " + new Date());
        processCommand();
        System.out.println(Thread.currentThread().getName() + " End time: " + new Date());
    }

    private void processCommand() {
        try {
            Thread.sleep(4000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return this.command;
    }
}
