class Solution {
    /*
    Time O(logN)
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
    
    /*
    https://leetcode.com/problems/sliding-window-maximum/discuss/65884/Java-O(n)-solution-using-deque-with-explanation
    
    Runtime: 9 ms, faster than 82.32% of Java online submissions for Sliding Window Maximum.
    Memory Usage: 41.2 MB, less than 85.19% of Java online submissions for Sliding Window Maximum.
    O(N) time complexity.
    
    All these operations are to the tail:
    dq.peek();
    dq.poll();
    
    All these operations are to the head:
    dq.peekLast();
    dq.pollLast();
    */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[0];
        int[] res = new int[nums.length - k + 1];
        
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            // the window index range is [i - k + 1, i]
            if (!dq.isEmpty() && dq.peek() < i - k + 1) {
                dq.poll();
            }
            
            while(!dq.isEmpty() && nums[i] >= nums[dq.peekLast()]) {
                dq.pollLast();
            }
            
            dq.offer(i);
            if (i - k + 1 >= 0) {
                res[i - k + 1] = nums[dq.peek()];
            }
        }
        
        return res;
    }
}
