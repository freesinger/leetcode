package sort.base;

import java.util.List;

import lombok.Data;

@Data
public abstract class AbstractSort {
    private int[] array;
    private List<Integer> list;

    public AbstractSort(int[] array) {
        this.array = array;
    }

    public AbstractSort(List<Integer> list) {
        this.list = list;
    }

    public abstract void sort(int[] array);

    public abstract void sort(List<Integer> list);
}
