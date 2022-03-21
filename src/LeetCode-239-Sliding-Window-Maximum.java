class Solution {
    // Max PriorityQueue, TLE
    /*
    Time: O((N-K)*log(N-K))
    Space: O(N-K)
    */
//     public int[] maxSlidingWindow(int[] nums, int k) {
//         if (nums == null || nums.length == 0) return new int[0];
//         int[] res = new int[nums.length - k + 1];
        
//         PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
//         for (int i = 0; i < k - 1; i++) {
//             pq.offer(nums[i]);
//         }
        
//         for (int i = 0; i + k - 1 < nums.length; i++) {
//             pq.offer(nums[i + k - 1]);  // add new number in the window to heap
//             res[i] = pq.peek();
//             pq.remove(nums[i]);     // remove first number in the window
//         }
        
//         return res;
//     }

    // Another implementation with Max PQ.
    // public int[] maxSlidingWindow(int[] nums, int k) {
    //     int n = nums.length;
    //     int[] res = new int[n - k + 1];
    //     PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        
        
    //     for (int i = 0; i < k - 1; i++) {
    //         pq.offer(nums[i]);
    //     }
        
    //     for (int i = k - 1; i < nums.length; i++) {
    //         pq.offer(nums[i]);
    //         res[i - k + 1] = pq.peek();
    //         pq.remove(nums[i - k + 1]);
    //     }
        
    //     return res;
    // }
    
    // Descending Monotonic Queue
    /*
    https://leetcode.com/problems/sliding-window-maximum/discuss/65884/Java-O(n)-solution-using-deque-with-explanation
    
    Runtime: 9 ms, faster than 82.32% of Java online submissions for Sliding Window Maximum.
    Memory Usage: 41.2 MB, less than 85.19% of Java online submissions for Sliding Window Maximum.
    O(N) time complexity.
    The Window Range is [i - k + 1, i]
    
    All these operations are to the head:
    dq.peek();
    dq.peekFirst();
    dq.poll();
    dq.pollFirst();
    
    All these operations are to the tail:
    dq.offer();
    dq.add();
    dq.peekLast();
    dq.pollLast();
    */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[0];
        int[] res = new int[nums.length - k + 1];
        
        // Using Deque to store the index in the array
        // using res array to store the result value
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            // the window index range is [i - k + 1, i]
            
            // Remove the element that is out of range k in the window
            if (!dq.isEmpty() && dq.peekFirst() < i - k + 1) {
                dq.pollFirst();
            }
            
            // Remote the smaller elements than nums[i] from right to left in the window
            // This is because if nums[x] <= nums[i], x < i, then nums[x] has no chance to become max
            // in [i - k + 1, i], or any other subsequent window: nums[i] would always be a better candidate
            while(!dq.isEmpty() && nums[i] >= nums[dq.peekLast()]) {
                dq.pollLast();
            }
            
            dq.offer(i);
            if (i - k + 1 >= 0) {
                res[i - k + 1] = nums[dq.peekFirst()];
            }
        }
        
        return res;
    }
}