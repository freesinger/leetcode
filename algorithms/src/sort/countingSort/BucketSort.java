package sort.countingSort;


import sort.base.AbstractSort;
import sort.base.BaseSortActions;

import java.util.List;

public class BucketSort extends AbstractSort {
    private int[] arrayToSort;
    private List<Integer> list;

    public BucketSort(int[] arrayToSort) {
        super(arrayToSort);
    }

    public BucketSort(List<Integer> list) {
        super(list);
    }

    @Override
    public void sort(int[] arrayToSort) {
        return;
    }

    @Override
    public void sort(List<Integer> list) {

    }
}
