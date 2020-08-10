package src.doubleptr;

import java.util.ArrayList;
import java.util.List;


/**
 * 和为S的连续正整数序列
 */
public class FindContinuousSequence {
    public static void main(String[] args) {
        List<List<Integer>> r = findSequence(100);
        for (List<Integer> l : r) System.out.println(l.toString());
    }

    private static List<List<Integer>> findSequence(int targetSum) {
        int start = 1, end = 2, curSum = 3;
        List<List<Integer>> result = new ArrayList<>();

        while (end < targetSum) {
            if (curSum < targetSum) {
                end++;
                curSum += end;
            } else if (curSum > targetSum) {
                curSum -= start;
                start++;

            } else {
                List<Integer> curList = new ArrayList<>();
                for (int i = start; i <= end; i++) {
                    curList.add(i);
                }
                result.add(curList);

                curSum -= start;
                start++;
            }
        }

        return result;
    }
}
