package sword;

import java.util.Arrays;

/**
 * 判断五张牌能否组成顺子
 */
public class PokerGame {
    public static void main(String[] args) {
        System.out.println(isFlush(new int[]{1, 0, 3, 4, 5}));
    }

    private static boolean isFlush(int[] nums) {
        int jokerCnt = 0;
        Arrays.sort(nums);
        for (int num : nums) {
            jokerCnt = num == 0 ? jokerCnt + 1 : jokerCnt;
        }

        for (int i = jokerCnt; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) return false;
            jokerCnt -= nums[i + 1] - nums[i] - 1;
        }

        return jokerCnt >= 0;
    }
}
