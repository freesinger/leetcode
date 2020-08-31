package synchronize;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * SynchronousQueue不会保存任何数据，因此必须满足一个线程取数据，一个线程添加该数据才会正常工作
 * ref: https://stackoverflow.com/questions/8591610/when-should-i-use-synchronousqueue
 */
public class SynchronousQueueQuiz {
    public static void main(String[] args) throws Exception {
        BlockingQueue<Integer> queue = new SynchronousQueue<>();
        // false, false, false, (blocking)
        System.out.print(queue.offer(1) + " ");
        System.out.print(queue.offer(2) + " ");
        System.out.print(queue.offer(3) + " ");
        System.out.print(queue.take() + " ");
        System.out.println(queue.size());
    }
}
