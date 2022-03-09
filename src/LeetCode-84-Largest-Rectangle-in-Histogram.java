class Solution {
    // 1. Two Way Scan
    /*
    https://leetcode.com/problems/largest-rectangle-in-histogram/discuss/28902/5ms-O(n)-Java-solution-explained-(beats-96)
    O(N)
    */
//     public int largestRectangleArea(int[] heights) {
//         if (heights == null || heights.length == 0) return 0;
        
//         int n = heights.length;
//         int[] lessLeft = new int[n];
//         lessLeft[0] = -1;
//         int[] lessRight = new int[n];
//         lessRight[n - 1] = n;
        
//         for (int i = 1; i < n; i++) {
//             // if (heights[i] > heights[i - 1]) {
//             //     lessLeft[i] = i - 1;
//             // } else {
//             //     int j = lessLeft[i - 1];
//             //     while(j >= 0 && heights[j] >= heights[i]) j--;
//             //     lessLeft[i] = j;
//             // }
            
//             // The above code could be optimized:
//             int p = i - 1;
//             while(p >= 0 && heights[p] >= heights[i]) {
//                 p = lessLeft[p];
//             }
//             lessLeft[i] = p;
//         }
        
//         for (int i = n - 2; i >= 0; i--) {
//             // if (heights[i] > heights[i + 1]) {
//             //     lessRight[i] = i + 1;
//             // } else {
//             //     int j = lessRight[i + 1];
//             //     while(j <= n - 1 && heights[j] >= heights[i]) j++;
//             //     lessRight[i] = j;
//             // }
            
//             // The above code could be optimized:
//             int p = i + 1;
//             while(p <= n - 1 && heights[p] >= heights[i]) {
//                 p = lessRight[p];
//             }
//             lessRight[i] = p;
//         }
        
//         int maxArea = 0;
//         for (int i = 0; i < n; i++) {
//             maxArea = Math.max(maxArea, (lessRight[i] - lessLeft[i] - 1) * heights[i]);
//         }
        
//         return maxArea;
//     }
    
    // 2. Using a Monotonic Stack
    /*
    https://leetcode.com/problems/largest-rectangle-in-histogram/discuss/28900/O(n)-stack-based-JAVA-solution
    
    Store the index in the stacks to be ascending order. Whenever we detect a bar's height is smaller than the stack.peek() height, we start the backtrack the index in the stacks one by one, and calculate the max area based on the backtracked index in the stack.
    The max area is the 'height_of_left * (current_index - stack.peek())'.
    (stack.peek(), current_index) is the width of the rectangle, both are exclusive.

    Runtime: 207 ms, faster than 23.22% of Java online submissions for Largest Rectangle in Histogram.
    Memory Usage: 90.9 MB, less than 18.03% of Java online submissions for Largest Rectangle in Histogram.
    */
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        
        int n = heights.length, maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i <= n; i++) {
            int h = i == n ? 0 : heights[i];
            while(!stack.isEmpty() && h < heights[stack.peek()]) {
                // means we detected a descend bar, which means the heights[i] < heights[stack.peek()]
                int currHeight = heights[stack.pop()];
                int prevIndex = stack.isEmpty() ? -1 : stack.peek();
                maxArea = Math.max(maxArea, (i - prevIndex - 1) * currHeight);
            }
            stack.push(i);
        }
        return maxArea;
    }
    
    // 3. Divide and Conquer with Segment Tree (Have not finished this solution)
    /*
    https://leetcode.com/problems/largest-rectangle-in-histogram/discuss/28910/Simple-Divide-and-Conquer-AC-solution-without-Segment-Tree
    
    
    */
}
