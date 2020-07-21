package syntanx;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FastFail {
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
     * ref: https://github.com/Snailclimb/JavaGuide/blob/master/docs/java/collection/Java%E9%9B%86%E5%90%88%E6%A1%86%E6%9E%B6%E5%B8%B8%E8%A7%81%E9%9D%A2%E8%AF%95%E9%A2%98.md#%E4%BB%80%E4%B9%88%E6%98%AF%E5%BF%AB%E9%80%9F%E5%A4%B1%E8%B4%A5fail-fast
     * ref: https://www.geeksforgeeks.org/fail-fast-fail-safe-iterators-java/
     *
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


