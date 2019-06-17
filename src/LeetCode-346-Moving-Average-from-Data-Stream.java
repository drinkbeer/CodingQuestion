class MovingAverage {

    // 1. Using Queue
//     int size;
//     double sum;
//     Queue<Integer> queue;
    
//     /** Initialize your data structure here. */
//     public MovingAverage(int size) {
//         this.size = size;
//         this.sum = 0.0;
//         this.queue = new LinkedList<>();
//     }
    
//     public double next(int val) {
//         if (queue.size() >= size) {
//             sum -= queue.poll();
//         }
//         queue.add(val);
//         sum += val;
//         return sum / queue.size();
//     }
    
    // 2. Using an Array
    int n, pointer;
    double sum;
    int[] window;
    
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.n = 0;
        this.pointer = 0;
        this.sum = 0.0;
        this.window = new int[size];
    }
    
    public double next(int val) {
        sum = sum - window[pointer] + val;
        window[pointer] = val;
        pointer = (pointer + 1) % window.length;
        if (n < window.length) n++;
        return sum / n;
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
