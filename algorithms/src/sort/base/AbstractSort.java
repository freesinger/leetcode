package src.sort.base;

import java.util.List;

import lombok.Data;

@Data
public abstract class AbstractSort {
    private int[] array;
    private List<Integer> list;
//    private int bucketNumber;
//    private List<Integer> result;

    public AbstractSort() {};

    public AbstractSort(int[] array) {
        this.array = array;
    }

    public AbstractSort(List<Integer> list) {
        this.list = list;
    }

//    public AbstractSort(List<Integer> list, int bucketNumber, List<Integer> result) {
//        this.list = list;
//        this.bucketNumber = bucketNumber;
//        this.result = result;
//    }

    // 抽象类的抽象方法在实现类中必须Override实现
    public abstract void sort();
//    public abstract void sort(int[] array);
//
//    public abstract void sort(List<Integer> list);
}
