package src.tree.btree;

/**
 * 判断一个数组是否是一棵树的后序遍历数组
 * 从后序遍历的性质入手
 * [<,<,<,>,>,root]
 */
public class VerifySequenceOfBST {
    public boolean verifySequenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0) return false;
        if (sequence.length == 1) return true;
        return recursive(sequence, 0, sequence.length - 1);
    }

    public boolean recursive(int[] seq, int start, int end) {
        // 递归首先要写跳出条件，注意边界
        if (start >= end) return true;
        int cutIndex = start;
        while (cutIndex <= end && seq[cutIndex] < seq[end]) {
            cutIndex++;
        }
        for (int i = cutIndex; i < end; i++) {
            if (seq[i] < seq[end]) return false;
        }
        return recursive(seq, start, cutIndex - 1) && recursive(seq, cutIndex, end - 1);
    }
}
