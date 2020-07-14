package src.sort.basesort;

import java.util.List;

public interface Sorts {
    // 所有方法都是抽象类型
    // public abstract被隐藏，其他声明类型都会报错
    void sort();

    void sort(List<Integer> list);

    void sort(int[] array);

}
