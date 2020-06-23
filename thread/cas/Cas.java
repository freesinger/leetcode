package cas;

public class Cas {
    public boolean compareAndSwap(int value, int expect, int update) {
        // 如果内存中的值value和期望值expect一样 则将值更新为新值update
        if (value == expect) {
            value = update;
            return true;
        } else return false;
    }
}
