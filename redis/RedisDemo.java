import redis.clients.jedis.Jedis;

import java.util.LinkedList;
import java.util.Queue;

public class RedisDemo {
    public static void main(String[] args) {
//        Jedis jedis = new Jedis("127.0.0.1");
//        System.out.println("Connect to Redis succeed!");
//        System.out.println("Sever is running: " + jedis.ping());
        Queue<String> queue = new LinkedList<String>();
        queue.offer("string"); // add
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.size());
    }
}
