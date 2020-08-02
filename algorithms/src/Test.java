package src;

import java.util.Map;
import java.util.TreeMap;

public class Test {
    public static void main(String[] args) {
        TreeMap<Integer, Integer> map = new TreeMap<>((a, b) -> (b - a));
        map.put(1, 2);
        map.put(3, 4);

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey());
        }
    }
}
