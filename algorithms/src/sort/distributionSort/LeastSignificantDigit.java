package src.sort.distributionSort;

import src.sort.sortbean.AbstractSort;
import src.sort.sortbean.Sorts;

import java.util.List;

public class LeastSignificantDigit extends AbstractSort implements Sorts {
    private List<Integer> list;
    private int[] array;

    public LeastSignificantDigit() {
    }

    ;

    public LeastSignificantDigit(List<Integer> list) {
        this.list = list;
    }

    public LeastSignificantDigit(int[] array) {
        this.array = array;
    }

    public static void main(String[] args) {
        int[] arr = {5, 10, 0, 3, 8, 5, 1, 10, 990, 168, 254};
        new LeastSignificantDigit(arr).sort();
    }

    // 抽象类中的sort必须被实现类重写
    @Override
    public void sort() {
        LSD();
    }

    public void LSD() {
        int maxValue = findMaxValue(array);
        int maxLen = maxDigitLen(maxValue);
        CountingSort cS = new CountingSort();

        int placeValue = 1;
        while (maxLen-- > 0) {
            cS.countingSort(array, placeValue);
            placeValue *= 10;
        }
    }

    private int maxDigitLen(int maxValue) {
        int count = 0;
        while (maxValue > 0) {
            maxValue /= 10;
            count++;
        }
        return count;
    }
}
