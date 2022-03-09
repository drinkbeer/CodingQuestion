/*
https://discuss.leetcode.com/topic/4939/a-stack-based-solution-for-reference-inspired-by-histogram

Compare:
11. Container With Most Water
42. Trapping Rain Water

1.Use Stack

2.Two way scanning the array

https://www.programcreek.com/2014/06/leetcode-trapping-rain-water-java/


3.Two Pointers.
Cumulative each bar. Use maxLeft to record the max height of left side of current bar, maxRight records max height of right side of curr bar. For curr bar, the water can store in curr bar is maxRight - curr, or maxRight - curr. Accumulate each bar's water.
*/
class Solution {
    // 1.Using Monotonic Stack
    /*
    https://leetcode.com/problems/trapping-rain-water/discuss/435850/Java-Solution-using-monotonic-stack
    There is only one situation that water can be trapped, that is the bar forms (high low high). In this way, we can use a decreasing monotonic stack to represent the first 2 (high low), if we meet a higher height[i] that is bigger than the peek of the stack, it will trigger water trapped. (about monotonic stack, can refer to #84 https://leetcode.com/problems/largest-rectangle-in-histogram/)

    When we find a bigger value than the peek of the stack, we can get the peek as the bottom of the trap, since it is the smallest value by so far (it is the low in "high low high"). And we need to define the height by finding the smaller one of left bound(height[stack.peek()]) and right bound(height[i]) and use the smaller one - the bottom of the trap.

    Finally, we multiply the height with width (i-s.peek()-1) and get the area.

    We need to notice that when we find a bigger value than the peek of the stack, there may be only one element in the stack. In this situation, it means there is no left bound, so it cannot form a water trap, we can skip directly.
    */
    // public int trap(int[] height) {
    //     if(height == null) return 0;
        
    //     Stack<Integer> stack = new Stack<Integer>();
    //     int i = 0, maxWater = 0, maxBotWater = 0;
    //     while(i < height.length){
    //         if(stack.isEmpty() || height[i] <= height[stack.peek()]){
    //             stack.push(i++);
    //         }else{
    //             int bot = stack.pop();
    //             maxBotWater = stack.isEmpty() ? 0 : (Math.min(height[stack.peek()], height[i]) - height[bot]) * (i - stack.peek() - 1);
    //             maxWater += maxBotWater;
    //         }
    //     }
    //     return maxWater;
    // }

    // Monotonic Stack
    // public int trap(int[] height) {
    //     Stack<Integer> stack = new Stack<>();
    //     int i = 0, n = height.length, res = 0;
    //     while (i < n) {
    //         if (stack.isEmpty() || height[i] <= height[stack.peek()]) {
    //             stack.push(i++);
    //         } else {
    //             int t = stack.pop();
    //             if (stack.isEmpty()) continue;
    //             res += (Math.min(height[i], height[stack.peek()]) - height[t]) * (i - stack.peek() - 1);
    //         }
    //     }
    //     return res;
    // }
    
    // 2. Two Way scanning. Scanning from left view and scanning from right view
    // https://www.programcreek.com/2014/06/leetcode-trapping-rain-water-java/
//     public int trap(int[] height) {
//         if (height == null || height.length <= 1) return 0;
        
//         int[] leftView = new int[height.length];
//         int max = Integer.MIN_VALUE;
//         for (int i = 0; i < height.length; i++) {
//             max = Math.max(max, height[i]);
//             leftView[i] = max;
//         }
        
//         int[] rightView = new int[height.length];
//         max = Integer.MIN_VALUE;
//         for (int i = height.length - 1; i >= 0; i--) {
//             max = Math.max(max, height[i]);
//             rightView[i] = max;
//         }
        
//         int sum = 0;
//         for (int i = 0; i < height.length; i++) {
//             sum += Math.min(leftView[i], rightView[i]) - height[i];
//         }
        
//         return sum;
//     }
    
    // 3.Two pointers
    public int trap(int[] height) {
        if (height == null || height.length <= 1) return 0;
        
        int l = 0, r = height.length - 1;
        int maxLeft = Integer.MIN_VALUE, maxRight = Integer.MIN_VALUE;
        
        int sum = 0;
        while (l < r) {
            // "l <= r" or "l < r" doesn't matter here, beceuse last element must be the highest one, and must have already collected before. So I prefer "l < r", because we don't need run in "l == r".
            if (height[l] < height[r]) {
                // this means the pointer lo must have at least one pointer in its right side which is higher than lo
                // then we are safe to collect water in pointer lo
                maxLeft = Math.max(maxLeft, height[l]);
                sum += maxLeft - height[l];
                l++;
            } else {
                // this means the pointer hi must have at least one pointer in its left side which is higher than hi
                // then we are safe to collect water in pointer hi
                maxRight = Math.max(maxRight, height[r]);
                sum += maxRight - height[r];
                r--;
            }
        }
        
        return sum;
    }
    
}
