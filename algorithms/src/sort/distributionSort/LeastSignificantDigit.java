package src.sort.distributionSort;

import src.sort.base.AbstractSort;
import src.sort.base.Sorts;

import java.util.List;

public class LeastSignificantDigit extends AbstractSort implements Sorts {
    private List<Integer> list;
    private int[] array;

    public LeastSignificantDigit() {};

    public LeastSignificantDigit(List<Integer> list) {
        this.list = list;
    }

    public LeastSignificantDigit(int[] array) {
        this.array = array;
    }




    @Override
    public void sort() {

    }

    public void LSD() {
        int maxValue = findMaxValue(array);
        int maxLen = maxDigitLen(maxValue);
    }

    private int maxDigitLen(int maxValue) {
        int count = 0;
        while (maxValue > 0) {
            maxValue /= 10;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {

    }
}
