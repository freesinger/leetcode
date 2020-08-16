package src.array;

/**
 * 汽车能否跑完全程
 */
public class CanComplete {
    public static void main(String[] args) {
        System.out.println(canCompleteTrip(new int[]{1,2,3,4,5}, new int[]{3,4,5,1,2}));
    }

    private static int canCompleteTrip(int[] gas, int[] cost) {
        int len = gas.length;
        int curTank = 0, sumTank = 0, start = 0;

        for (int i = 0; i < len; i++) {
            int gap = gas[i] - cost[i];
            sumTank += gap; // 全程记录
            curTank += gap; // 从起点开始记录
            if (curTank < 0) {
                start = i + 1;
                curTank = 0;
            }
        }

        return sumTank >= 0 ? start : -1;
    }
}
