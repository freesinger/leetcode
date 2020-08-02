package src.string;

import java.util.HashMap;

/**
 * 36进制加法器
 */
public class SumInThirtySix {
    private static final char[] toDecimal = "0123456789abcdefghijklmnopqrstuvwxzy".toCharArray();
    private HashMap<Character, Integer> map = new HashMap<>();
    private boolean flag = false;
    private StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        SumInThirtySix test = new SumInThirtySix();
        test.constructMap(toDecimal);
        System.out.println(test.sum("1b", "2x"));
    }


    private void constructMap(char[] arr) {
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }
    }


    private void getRest(String str, int len) {
        while (len > 0) {
            int curSum = flag ? 1 : 0;
            curSum += map.get(str.charAt(len));
            if (curSum < 36) {
                flag = false;
                sb.insert(0, curSum);
            } else {
                flag = true;
                sb.insert(0, toDecimal[curSum % 36]);
            }
        }
    }


    public String sum(String a, String b) {
        int aLen = a.length() - 1, bLen = b.length() - 1;

        while (aLen >= 0 && bLen >= 0) {
            int curA = map.get(a.charAt(aLen)), curB = map.get(b.charAt(bLen));
            int curSum = flag ? 1 : 0;
            curSum += curA + curB;
            if (curSum < 36) {
                flag = false;
                sb.insert(0, curSum);
            } else {
                flag = true;
                sb.insert(0, toDecimal[curSum % 36]);
            }
            aLen--;
            bLen--;
        }

        if (aLen > 0) {
            getRest(a, aLen);
        } else if (bLen > 0) {
            getRest(b, bLen);
        }

        return sb.toString();
    }
}
