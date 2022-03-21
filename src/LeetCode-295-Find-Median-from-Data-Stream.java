// 1. Two PriorityQueue (My Own Solution)
// class MedianFinder {

//     PriorityQueue<Integer> small;
//     PriorityQueue<Integer> large;
    
//     /** initialize your data structure here. */
//     public MedianFinder() {
//         // small: store the smaller half, sorting from large to small, using Max Heap
//         // large: store the larger half, sorting from small to large, using Min Heap
//         small = new PriorityQueue<>((a, b) -> b - a);
//         large = new PriorityQueue<>();
//     }
    
//     public void addNum(int num) {
//         small.offer(num);
//         balance(small, large);
//     }
    
//     public double findMedian() {
//         if (small.size() > large.size()) {
//             return small.peek();
//         }
//         return ((double) small.peek() + (double) large.peek()) / 2;
//     }
    
//     private void balance(PriorityQueue<Integer> small, PriorityQueue<Integer> large) {
//         while (small.size() > large.size() + 1) {
//             large.offer(small.poll());
//         }
//         while (small.size() < large.size()) {
//             small.offer(large.poll());
//         }
//         if (!small.isEmpty() && !large.isEmpty() && small.peek() > large.peek()) {
//             int s = small.poll();
//             int l = large.poll();
//             small.offer(l);
//             large.offer(s);
//         }
//     }
// }

// 2. Priority Queue
/*
https://leetcode.com/problems/find-median-from-data-stream/discuss/74047/JavaPython-two-heap-solution-O(log-n)-add-O(1)-find
*/
class MedianFinder {
    PriorityQueue<Integer> small;
    PriorityQueue<Integer> large;
    boolean even;

    public MedianFinder() {
        small = new PriorityQueue<>(Collections.reverseOrder());
        large = new PriorityQueue<>();
        even = true;
    }
    
    public void addNum(int num) {
        if (even) {
            large.offer(num);
            small.offer(large.poll());
        } else {
            small.offer(num);
            large.offer(small.poll());
        }
        even = !even;
    }
    
    public double findMedian() {
        if (even) {
            return (small.peek() + large.peek()) / 2.0;
        } else {
            return small.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
