package threadspool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CatchException {
    public static final Logger logger = LoggerFactory.getLogger(CatchException.class);

    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            threadPool.submit(() -> {
                System.out.println("Current thread ID: " + Thread.currentThread().getName());
                try {
                    Object object = null;
                    System.out.println("Result: " + object.toString());
                } catch (Exception e) {
                    logger.info("Exception occurred!");
                    e.printStackTrace();
                }
            });
        }
    }
}
