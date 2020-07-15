package src.sword;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

class TopKNumber {
    private int findKthMinNumber(int[] nums, int k) {
        // 最大堆找第k小数
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k, (o1, o2) -> o2 - o1);

        for (int num : nums) {
            if (priorityQueue.size() < k) {
                priorityQueue.add(num);
            } else {
                if (priorityQueue.peek() > num) {
                    priorityQueue.poll();
                    priorityQueue.offer(num);
                }
            }
        }

        return priorityQueue.peek();
    }


    /**
     * 前k个数为前k大数
     *
     * @param nums
     * @param k
     * @return
     */
    private List<Integer> findKthMaxNumber(int[] nums, int k) {
        // 最小堆找第k大树
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k);
        List<Integer> result = new LinkedList<>();

        for (int num : nums) {
            if (priorityQueue.size() < k) {
                priorityQueue.add(num);
            } else {
                if (priorityQueue.peek() < num) {
                    result.add(priorityQueue.poll());
                    priorityQueue.offer(num);
                } else {
                    result.add(num);
                }
            }
        }

        while (priorityQueue.size() > 0) {
            int top = priorityQueue.poll();
            result.add(0, top);
        }

        return result;
    }

    // TODO: 快排

    public static void main(String[] args) {
        int[] test =  new int[] {4, 2, 6, 1, -2, 9, -10, 22, 7};
        TopKNumber t = new TopKNumber();

        System.out.println(t.findKthMinNumber(test, 2)); // min
        System.out.println(t.findKthMaxNumber(test, 3).toString()); // max
    }
}
