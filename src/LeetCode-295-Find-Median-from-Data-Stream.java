class MedianFinder {

    PriorityQueue<Integer> small;
    PriorityQueue<Integer> large;
    
    /** initialize your data structure here. */
    public MedianFinder() {
        // small: store the smaller half, sorting from large to small, using Max Heap
        // large: store the larger half, sorting from small to large, using Min Heap
        small = new PriorityQueue<>((a, b) -> b - a);
        large = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        small.offer(num);
        balance(small, large);
    }
    
    public double findMedian() {
        if (small.size() > large.size()) {
            return small.peek();
        }
        return ((double) small.peek() + (double) large.peek()) / 2;
    }
    
    private void balance(PriorityQueue<Integer> small, PriorityQueue<Integer> large) {
        while (small.size() > large.size() + 1) {
            large.offer(small.poll());
        }
        while (small.size() < large.size()) {
            small.offer(large.poll());
        }
        if (!small.isEmpty() && !large.isEmpty() && small.peek() > large.peek()) {
            int s = small.poll();
            int l = large.poll();
            small.offer(l);
            large.offer(s);
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
