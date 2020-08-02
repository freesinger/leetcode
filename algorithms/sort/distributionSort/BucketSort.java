package sort.distributionSort;


import sort.insertionSort.InsertionSort;
import sort.sortbean.AbstractSort;
import sort.sortbean.Sorts;

import java.util.ArrayList;
import java.util.List;

import static src.utils.Tools.intArrayToList;
import static src.utils.Tools.traceList;

public class BucketSort extends AbstractSort implements Sorts {
    private int[] arrayToSort;
    private List<Integer> list;
    private int bucketNumber;
    private List<Integer> result;

    public BucketSort() {
    }

    // 子类不继承父类构造器，只是显式(super)或隐式调用
    // 每一条隐式调用都省略了super()
    public BucketSort(int[] arrayToSort) {
        super(arrayToSort);
        this.arrayToSort = arrayToSort;
    }

    public BucketSort(List<Integer> list) {
        super(list);
        this.list = list;
    }

    // 调用父类无参constructor
    public BucketSort(List<Integer> list, int bucketNumber, List<Integer> result) {
        // super(list, bucketNumber, result);
        this.list = list;
        this.bucketNumber = bucketNumber;
        this.result = result;
    }

    public static void main(String[] args) {
        List<Integer> arrayToSort = intArrayToList(new int[]{54, 88, 9, 2, 88, 91, 105, 18, 10});
        List<Integer> res = new ArrayList<>();
        new BucketSort(arrayToSort, 5, res).sort();
        traceList(res);
    }

    @Override
    public void sort() {
        // System.out.println(Arrays.toString(super.getArray())); // null
        // traceList(super.getList()); // null
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
        for (List<Integer> bucket : buckets) {
            iS.insertionSort(bucket);
        }

        for (List<Integer> bucket : buckets) {
            result.addAll(bucket);
        }
    }
}
