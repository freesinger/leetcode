package src.sort.countingSort;


import src.sort.base.AbstractSort;
import src.sort.insertionSort.InsertionSort;

import java.util.ArrayList;
import java.util.List;

import static src.utils.Tools.intArrayToList;
import static src.utils.Tools.traceList;

public class BucketSort extends AbstractSort {
    private int[] arrayToSort;
    private List<Integer> list;
    private int bucketNumber;
    private List<Integer> result;


    // 子类不继承父类构造器，只是显式(super)或隐式调用
    // 每一条隐式调用都省略了super()
    public BucketSort(int[] arrayToSort) {
        super(arrayToSort);
    }

    public BucketSort(List<Integer> list) {
        super(list);
    }

    // 调用父类无参constructor
    public BucketSort(List<Integer> list, int bucketNumber, List<Integer> result) {
        this.list = list;
        this.bucketNumber = bucketNumber;
        this.result = result;
    }

    @Override
    public void sort() {
        bucketSort();
    }

    public void bucketSort() {
        List<List<Integer>> buckets = new ArrayList<>();
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int i : list) {
            max = Math.max(i, max);
            min = Math.min(i, min);
        }
        for (int n = 0; n < bucketNumber; n++) buckets.add(new ArrayList<>());
        // int bucketSize = (max - min) / (10 * bucketNumber);
        for (int i : list) {
            buckets.get((int) Math.floor((bucketNumber - 1) * i / max)).add(i);
        }

        InsertionSort iS = new InsertionSort();
        for (int i = 0; i < buckets.size(); i++) {
            iS.insertionSort(buckets.get(i));
        }

        for (int j = 0; j < buckets.size(); j++) {
            for (int k : buckets.get(j)) {
                result.add(k);
            }
        }
    }

    public static void main(String[] args) {
        List<Integer> arrayToSort = intArrayToList(new int[]{54, 88, 9, 2, 88, 91, 105, 18, 10});
        List<Integer> res = new ArrayList<>();
        new BucketSort(arrayToSort, 5, res).sort();
        traceList(res);
    }
}
