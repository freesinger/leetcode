package src.bitmanipulation.bloomfilter;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 当布隆过滤器说某个值 存在时，这个值 可能不存在，
 * 当它说某个值 不存在时，那就 肯定不存在，并且还有一定的误判率.
 */
public class BloomFilter {
    private static final int SIZE = 2 << 16;
    private static final int[] SEEDS = new int[]{2, 312, 24, 25, 85, 8};
    private BitSet bitSet;
    private HashFunction[] functions;

    public BloomFilter() {
        this.bitSet = new BitSet(SIZE);
        this.functions = new HashFunction[SEEDS.length];
        for (int i = 0; i < SEEDS.length; i++) {
            this.functions[i] = new HashFunction(SIZE, SEEDS[i]);
        }
    }

    public static void main(String[] args) {
        BloomFilter bloomFilter = new BloomFilter();
        Random random = new Random();
        List<Integer> nums = new ArrayList<>();

        for (int i = 0; i < SIZE; i++) {
            int key = random.nextInt();
            nums.add(key);
            bloomFilter.add(key);
        }

        AtomicInteger count = new AtomicInteger();
        nums.forEach(number -> {
            if (bloomFilter.contain(number)) {
                count.incrementAndGet();
            }
        });
        System.out.printf("Number size: %d, bloom size: %d\n", nums.size(), count.get());

        int test = 2 << 8, cnt = 0;
        while (test > 0) {
            int key = random.nextInt();
            boolean inBloom = bloomFilter.contain(key);
            if (!nums.contains(key)) {
                if (inBloom) cnt++;
                // System.out.println(inBloom); // 还是可能误判
                test--;
            } else {
                System.out.print("Key in nums. Check in bloom filter: ");
                System.out.println(bloomFilter.contain(key));
            }
        }
        System.out.printf("Wrong judge counts: %d\n", cnt);
    }


    public void add(Object key) {
        for (HashFunction hashFunction : functions) {
            bitSet.set(hashFunction.hash(key), true);
        }
    }

    public boolean contain(Object key) {
        boolean ret = true;
        for (HashFunction function : functions) {
            ret = ret && bitSet.get(function.hash(key));
        }
        return ret;
    }


    static class HashFunction {
        private int capacity;
        private int seed;

        public HashFunction(int capacity, int seed) {
            this.capacity = capacity;
            this.seed = seed;
        }

        public int hash(Object value) {
            int h;
            return (value == null) ? 0 : Math.abs(seed * (capacity - 1) & (h = value.hashCode()) ^ (h >>> 16));
        }
    }
}
