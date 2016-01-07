/*
LeetCode: https://leetcode.com/problems/maximum-subarray/
LintCode: http://www.lintcode.com/problem/maximum-subarray/
JiuZhang: http://www.jiuzhang.com/solutions/maximum-subarray/
ProgramCreek: http://www.programcreek.com/2013/02/leetcode-maximum-subarray-java/
Other: http://www.cnblogs.com/yuzhangcmu/p/4175817.html

Analysis: 
1.DP

2.Greedy

3.Divide & Conquer

*/

public class Solution {
    // public int maxSubArray(int[] nums) {
    //     // 1.DP
    //     int max = nums[0];
        
    //     // state
    //     int[] sum = new int[nums.length];
    //     sum[0] = nums[0];
        
    //     for(int i = 1; i < nums.length; i++){
    //         sum[i] = Math.max(nums[i], sum[i - 1] + nums[i]);
    //         max = Math.max(max, sum[i]);
    //     }
    //     return max;
    // }
    
    // 2.Greedy
//  public int maxSubArray(int[] nums) {
//      int sum = 0;
//      int max = Integer.MIN_VALUE;
 
//      for (int i = 0; i < nums.length; i++) {
//          sum += nums[i];
//          max = Math.max(max, sum);
 
//          sum = Math.max(sum, 0);
//      }
 
//      return maxSum;
//  }
    
    //3.Greedy
//  public int maxSubArray(int[] nums) {
//      int sum = nums[0];
//      int max = nums[0];
        
//      for(int i = 1; i < nums.length; i++){
//          sum = Math.max(sum + nums[i], nums[i]);
            
//          max = Math.max(max, sum);
//      }
//      return max;
//  }
    
//  4.Greedy(Sliding Windows)
//  public int maxSubArray(int[] nums) {
//         if (nums == null || nums.length == 0) return 0;
        
//         int max = Integer.MIN_VALUE;
//         int sum = 0;
        
//         int len = nums.length;
//         for (int i = 0; i < len; i++) {
//             if (sum < 0) sum = 0;
            
//             sum += nums[i];
//             max = Math.max(max, sum);
//         }
        
//         return max;
//     }
    
    // 5.DP
    // public int maxSubArray(int[] nums) {
    //     if (nums == null || nums.length == 0) return 0;
        
    //     int[] sum = new int[nums.length];
    //     int[] max = new int[nums.length];
    //     sum[0] = nums[0];
    //     max[0] = nums[0];
        
    //     for(int i = 1; i < nums.length; i++){
    //         sum[i] = Math.max(nums[i], nums[i] + sum[i - 1]);
    //         max[i] = Math.max(max[i - 1], sum[i]);
    //     }
    //     return max[nums.length - 1];
    // }
    
    // 6.Prefix Sum(DP)
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        int max = Integer.MIN_VALUE, sum = 0, minSum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            max = Math.max(max, sum - minSum);
            minSum = Math.min(minSum, sum);     //keep a minimum subarray, so maximum subarray = sum of all - minimum subarray
        }
        
        return max;
    }
    
    
}