package src.linkedlist;

import src.utils.Tools;
import src.utils.node.implement.ListNode;

/**
 * 逆序打印链表
 */
public class ReversePrintList {
    public static void main(String[] args) {
        ListNode root = Tools.constructLinkedList(new int[]{1, 2, 3, 4});
        recursivePrint(root);
    }

    private static void recursivePrint(ListNode node) {
        if (node == null) return;
        recursivePrint(node.next);
        System.out.println(node.value);
    }
}
