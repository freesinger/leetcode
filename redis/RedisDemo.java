import redis.clients.jedis.Jedis;

public class RedisDemo {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1");
        System.out.println("Connect to Redis succeed!");
        System.out.println("Sever is running: " + jedis.ping());
    }
}
