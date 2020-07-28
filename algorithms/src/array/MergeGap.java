package src.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * 合并区间
 *
 */
public class MergeGap {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0 || intervals[0].length == 0) return intervals;
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        LinkedList<int[]> res = new LinkedList<>();

        for (int i = 0; i < intervals.length; i++) {
            if (res.size() == 0 || res.getLast()[1] < intervals[i][0]) {
                res.add(intervals[i]);
            } else {
                res.getLast()[1] = Math.max(res.getLast()[1], intervals[i][1]);
            }
        }

        return res.toArray(new int[res.size() - 1][]);
    }
}
