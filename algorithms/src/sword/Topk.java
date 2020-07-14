package src.sword;

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


    private int findKthMaxNumber(int[] nums, int k) {
        // 最小堆找第k大树
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k);

        for (int num : nums) {
            if (priorityQueue.size() < k) {
                priorityQueue.add(num);
            } else {
                if (priorityQueue.peek() < num) {
                    priorityQueue.poll();
                    priorityQueue.offer(num);
                }
            }
        }

        return priorityQueue.poll();
    }

    // TODO: 快排

    public static void main(String[] args) {
        int[] test =  new int[] {4, 2, 6, 1, -2};
        TopKNumber t = new TopKNumber();

        System.out.println(t.findKthMinNumber(test, 2)); // min
        System.out.println(t.findKthMaxNumber(test, 3)); // max
    }
}
