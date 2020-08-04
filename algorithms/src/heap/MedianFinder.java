package src.heap;

import java.util.PriorityQueue;

class MedianFinder {
    private int count;
    private PriorityQueue<Integer> minHeap;
    private PriorityQueue<Integer> maxHeap;
    // private List<Integer> nums;

    /**
     * initialize your data structure here.
     *
     * maxHeap + minHeap
     */
    public MedianFinder() {
        count = 0;
        // 最小堆找后半部分最小值
        minHeap = new PriorityQueue<>();
        // 最大堆找前半部最大值
        maxHeap = new PriorityQueue<>((x, y) -> (y - x));
    }

    public void addNum(int num) {
        if (count % 2 == 0) {
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
        } else {
            minHeap.offer(num);
            maxHeap.offer(minHeap.poll());
        }
        // 最后更新size
        count++;
    }

    public double findMedian() {
        //return (double) (maxHeap.size() > minHeap.size() ? maxHeap.peek() : ((minHeap.peek() + maxHeap.peek()) / 2));

        //return (double) count % 2 == 1 ? minHeap.peek() : (minHeap.peek() + maxHeap.peek()) / 2;
        if (count % 2 == 0) {
            return (double) ((minHeap.peek() + maxHeap.peek()) / 2);
        } else return minHeap.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
