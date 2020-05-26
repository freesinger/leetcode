import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class fastFail {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>() {{
            add(1);
            add(2);
        }};

        // 使用foreach遍历时删除元素会导致fail-fast
        // 应当使用iterator遍历
        fastFailTest(list);
    }

    /**
     * ref: https://www.geeksforgeeks.org/fail-fast-fail-safe-iterators-java/
     * @param list
     */
    private static void fastFailTest(List<Integer> list) {
        // 1
//        for (int i : list)
//            if (i == 1) list.remove(i);
        // 2
//        for (int i = 0; i < list.size(); i++)
//            if (list.get(i) == 1) list.remove(i);

        // 2
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            //int i = iterator.next();
            if (iterator.next() == 1) {
                // 这里是迭代器调用remove()
                iterator.remove();
                // list.remove(1);
            }
        }
        for (int j : list) System.out.println(j);
    }
}


