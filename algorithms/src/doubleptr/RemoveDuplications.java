package src.doubleptr;

import src.utils.Tools;
import src.utils.node.implement.ListNode;

public class RemoveDuplications {

    public static void main(String[] arags) {
        RemoveDuplications test = new RemoveDuplications();
        // Array test
        int[] array = new int[]{0, 0, 1, 2, 2, 2, 3, 4, 5, 5, 5, 6};
        int[] copy = array.clone();
        System.out.println(test.removeArray(array));
        Tools.traceArray(array);

        // List test
        ListNode root = Tools.constructLinkedList(copy);
        Tools.traceListNode(root);
        test.removeList(root);
        Tools.traceListNode(root);
    }


    /**
     * 返回不重复元素的index
     *
     * @param array
     * @return
     */
    public int removeArray(int[] array) {
        if (array.length <= 1) return 0;
        int slow = 0, fast = 1;

//        while (fast < array.length) {
//            if (array[slow] == array[fast]) {
//                fast++;
//            } else {
//                // slow维护不重复的index
//                slow++;
//                array[slow] = array[fast];
//                fast++;
//            }
//        }

        while (fast < array.length) {
            if (array[slow] != array[fast]) {
                // slow维护不重复的index
                slow++;
                array[slow] = array[fast];
            }
            fast++;
        }

        return slow;
    }


    /**
     * 链表去重，保留重复结点
     *
     * @param node
     * @return
     */
    private ListNode removeList(ListNode node) {
        if (node == null || node.next == null) return node;
        ListNode slow = node, fast = node.next;

        while (fast != null) {
            if (slow.value != fast.value) {
                slow.next = fast;
                slow = slow.next;
            }
            fast = fast.next;
        }
        // 尾结点置null
        // slow.next = null;

        return node;
    }
}
