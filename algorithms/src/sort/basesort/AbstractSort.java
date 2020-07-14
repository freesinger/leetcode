package src.sort.basesort;

import java.util.List;

public abstract class AbstractSort extends BaseSortActions {
    private int[] array;
    private List<Integer> list;

    // 有带参的构造函数时必须显式声明默认构造函数
    public AbstractSort() {};

    public AbstractSort(int[] array) {
        this.array = array;
    }

    public AbstractSort(List<Integer> list) {
        this.list = list;
    }

    // 抽象类的抽象方法在实现类中必须Override实现
    public abstract void sort();
//
//    public abstract void sort(int[] array);
//
//    public abstract void sort(List<Integer> list);
}
