package src.sort.sortbean;

import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;

@Data
public class SortActions {
    public static final int TEN = 10;
    protected static Logger logger = LoggerFactory.getLogger(SortActions.class);
    private int[] array;
    private List<Integer> list;

    public SortActions() {
    }

    ;

    public SortActions(int[] array) {
        this.array = array;
    }

    public SortActions(List<Integer> list) {
        this.list = list;
    }

    protected int findMaxValue(List<Integer> list) {
        int max = Integer.MIN_VALUE;

        try {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) > max) {
                    max = list.get(i);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Find max value failed!");
        }

        return max;
    }

    protected int findMaxValue(int[] array) {
        int max = Integer.MIN_VALUE;

        try {
            for (int i = 0; i < array.length; i++) {
                max = Math.max(max, array[i]);
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Find max value failed!");
        }

        return max;
    }

    protected HashMap<Integer, Integer> findMaxWithIndex(List<Integer> list) {
        int max = Integer.MIN_VALUE, maxID = -1;
        HashMap<Integer, Integer> map = new HashMap<>(1);

        try {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) > max) {
                    max = list.get(i);
                    maxID = i;
                }
            }
            map.put(max, maxID);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Find max value failed!");
        }

        return map;
    }


    public void sort(List<Integer> list) {
    }

    public void sort(int[] array) {
    }

    public void sort() {
    }
}
