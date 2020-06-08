package src.sort.base;

import lombok.Data;

import java.util.List;

@Data
public class BaseSortActions {
    private int[] array;
    private List<Integer> list;

    public BaseSortActions(int[] array) {
        this.array = array;
    }

    public BaseSortActions(List<Integer> list) {
        this.list = list;
    }
}
