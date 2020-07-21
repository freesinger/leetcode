package src.doubleptr;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * https://github.com/CyC2018/CS-Notes/blob/master/notes/57.1%20%E5%92%8C%E4%B8%BA%20S%20%E7%9A%84%E4%B8%A4%E4%B8%AA%E6%95%B0%E5%AD%97.md
 */
public class FindNumbersWithSum {
    public ArrayList<Integer> findNumbersWithSum(int[] array, int sum) {
//        Arrays.sort(array);

        int left = 0, right = array.length-1;
        while (left < right) {
            int curSum = array[left] + array[right];
            if (curSum < sum) {
                left++;
            } else if (curSum > sum) {
                right--;
            } else {
                return new ArrayList<>(Arrays.asList(array[left], array[right]));
            }
        }

        return new ArrayList<>();
    }
}
