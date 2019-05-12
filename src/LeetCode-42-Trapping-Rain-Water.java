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
    // 1.Using Stack
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
        while (l <= r) {
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
