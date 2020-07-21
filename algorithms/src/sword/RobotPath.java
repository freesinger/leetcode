package src.sword;

/**
 * Des: 地上有一个 m 行和 n 列的方格。一个机器人从坐标 (0, 0) 的格子开始移动，每一次只能向左右上下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于 k 的格子。
 * 例如，当 k 为 18 时，机器人能够进入方格 (35,37)，因为 3+5+3+7=18。但是，它不能进入方格 (35,38)，因为 3+5+3+8=19。请问该机器人能够达到多少个格子？
 */
public class RobotPath {
    private static final int[][] pos = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private static int count = 0;

    public static void main(String[] args) {
        RobotPath robotPath = new RobotPath();
        System.out.println(robotPath.movingCount(15, 20, 20));
    }

    public int movingCount(int threshold, int rows, int cols) {
        boolean[][] hasReached = new boolean[rows][cols];
        dfs(hasReached, 0, 0, threshold);
        return count;
    }

    public void dfs(boolean[][] flag, int row, int col, int threshold) {
        if (row < 0 || row >= flag.length || col < 0 || col >= flag[0].length || flag[row][col]) return;
        flag[row][col] = true; // 需要提前对位置锁定
        if (posSum(row, col) <= threshold) {
            count++;
        }
        for (int[] p : pos) {
            dfs(flag, row + p[0], col + p[1], threshold);
        }
    }

    public int posSum(int row, int col) {
        int sum = 0;
        while (row > 0) {
            sum += row % 10;
            row /= 10;
        }

        while (col > 0) {
            sum += col % 10;
            col /= 10;
        }

        return sum;
    }
}
