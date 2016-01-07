/*
LeetCode: not find
LintCode: http://www.lintcode.com/en/problem/maximum-subarray-ii/
JiuZhang: http://www.jiuzhang.com/solutions/maximum-subarray-ii/
ProgramCreek: not find
Other: 

Analysis: 
1.DP (Like Sliding Window, Use two left and two right, scan one time)
We need two non-overlapping subarrays, so there must be some point X, so that 
maximum subarray before X + maximum subarray after X is max.

So we must calculate the maximum subarray end to each point from left to right,
and from right to left.

Then, we account the maximum subarray before and after each point.

2.DP(Use one left and one right, scan two times)

*/
public class Solution {
    // 1.DP(Like Sliding Window, Use two left and two right, scan one time)
    // public int maxTwoSubArrays(ArrayList<Integer> nums) {
    //     if(nums == null || nums.size() == 0) return 0;
        
    //     int[] left = new int[nums.size()];
    //     int[] maxLeft = new int[nums.size()];
    //     left[0] = nums.get(0);
    //     maxLeft[0] = nums.get(0);
    //     for(int i = 1; i < nums.size(); i++){
    //         left[i] = Math.max(nums.get(i), nums.get(i) + left[i - 1]);
    //         maxLeft[i] = Math.max(maxLeft[i - 1], left[i]);
    //     }
        
    //     int[] right = new int[nums.size()];
    //     int[] maxRight = new int[nums.size()];
    //     right[nums.size() - 1] = nums.get(nums.size() - 1);
    //     maxRight[nums.size() - 1] = nums.get(nums.size() - 1);
    //     for(int i = nums.size() - 2; i >=0; i--){
    //         right[i] = Math.max(nums.get(i), nums.get(i) + right[i + 1]);
    //         maxRight[i] = Math.max(maxRight[i + 1], right[i]);
    //     }
        
    //     int max = Integer.MIN_VALUE;
    //     for(int i = 0; i < nums.size() - 1; i++){
    //         max = Math.max(max, maxLeft[i] + maxRight[i + 1]);
    //     }
    //     return max;
    // }
    
    // 2.DP(Use one left and one right, scan two times)
    public int maxTwoSubArrays(ArrayList<Integer> nums) {
        if(nums == null || nums.size() == 0) return 0;
        
        int[] left = new int[nums.size()];
        left[0] = nums.get(0);
        for(int i = 1; i < nums.size(); i++){
            left[i] = Math.max(nums.get(i), nums.get(i) + left[i - 1]);
        }
        int currMax = left[0];
        for(int i = 1; i < nums.size(); i++){
            if(left[i] < currMax) left[i] = currMax;
            else currMax = left[i];
        }
        
        int[] right = new int[nums.size()];
        right[nums.size() - 1] = nums.get(nums.size() - 1);
        for(int i = nums.size() - 2; i >= 0; i--){
            right[i] = Math.max(nums.get(i), nums.get(i) + right[i + 1]);
        }
        currMax = right[nums.size() - 1];
        for(int i = nums.size() - 2; i >= 0; i--){
            if(right[i] < currMax) right[i] = currMax;
            else currMax = right[i];
        }
        
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.size() - 1; i++){
            max = Math.max(max, left[i] + right[i + 1]);
        }
        return max;
    }
    
}

