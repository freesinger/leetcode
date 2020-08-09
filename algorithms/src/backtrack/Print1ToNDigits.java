package src.backtrack;

import src.backtrack.basebacktrack.BackTrackInterface;

import java.util.ArrayList;
import java.util.List;

/**
 * 打印从1到n的所有n位数
 */
public class Print1ToNDigits implements BackTrackInterface {
    //private static final int[] nums = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 9};

    public static void main(String[] args) {
        backTrack(new ArrayList<>(), 3);
    }


    private static void backTrack(List<Character> curNum, int n) {
        // TODO: 去除重复的个位数及空白列表
        if (curNum.size() == n) {
            printNumber(curNum);
            return;
        } else printNumber(curNum);

        for (int i = 0; i <= 9; i++) {
            curNum.add((char) (i + '0'));
            backTrack(curNum, n);
            curNum.remove(curNum.size() - 1);
        }
    }


    private static void printNumber(List<Character> nums) {
        int index = 0;
        // 去除开头的0
        while (index < nums.size() && nums.get(index) == '0') {
            index++;
        }
        while (index < nums.size()) {
            System.out.print(nums.get(index));
            index++;
        }
        System.out.println();

    }

    @Override
    public void backTrack() {

    }
}
