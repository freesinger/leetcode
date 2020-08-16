package src.bitmanipulation.bloomfilter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 当布隆过滤器说某个值 存在时，这个值 可能不存在，
 * 当它说某个值 不存在时，那就 肯定不存在，并且还有一定的误判率.
 */
public class BloomFilterImplement {
    private byte[] data;

    public BloomFilterImplement(int initSize) {
        data = new byte[initSize];
    }

    public static void main(String[] args) {
        Random random = new Random();

        int size = 100_000;
        List<Integer> existNumbers = new ArrayList<>();
        BloomFilterImplement bloomFilterImplement = new BloomFilterImplement(size);

        for (int i = 0; i < size; i++) {
            int randomKey = random.nextInt();
            bloomFilterImplement.add(randomKey);
            existNumbers.add(randomKey);
        }

        AtomicInteger count = new AtomicInteger();
        existNumbers.forEach(number -> {
            if (bloomFilterImplement.contain(number)) {
                count.incrementAndGet();
            }
        });
        System.out.printf("Actual size: %d, stored size: %d\n", size, count.get());

        AtomicInteger count1 = new AtomicInteger();
        while (count1.get() < 10) {
            int key = random.nextInt();
            if (!existNumbers.contains(key)) {
                System.out.println(bloomFilterImplement.contain(key));
                count1.incrementAndGet();
            }
        }
    }

    private void add(int key) {
        int loc1 = Math.abs(hash1(key) % data.length);
        int loc2 = Math.abs(hash2(key) % data.length);
        int loc3 = Math.abs(hash3(key) % data.length);

        data[loc1] = data[loc2] = data[loc3] = 1;
    }


    private boolean contain(Integer key) {
        int loc1 = Math.abs(hash1(key) % data.length);
        int loc2 = Math.abs(hash2(key) % data.length);
        int loc3 = Math.abs(hash3(key) % data.length);

        return data[loc1] * data[loc2] * data[loc3] == 1;
    }

    private int hash1(Integer s) {
        return s.hashCode();
    }

    private int hash2(Integer s) {
        int hashcode = s.hashCode();
        return hashcode ^ (hashcode >>> 3);
    }

    private int hash3(Integer s) {
        int hashcode = s.hashCode();
        return hashcode ^ (hashcode >>> 16);
    }
}
