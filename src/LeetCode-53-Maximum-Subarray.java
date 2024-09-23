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
    // 1.DP (Pull)
    /*
    subproblem:
    dp[i]   -   the max sum of subarray that ends with i, the range: [any, i]
    
    recurrence relation:
    dp[i] = max{dp[i - 1] + nums[i], nums[i]}
    
    init:
    dp[0] = nums[0]
    
    ans:
    max val
    */
//     public int maxSubArray(int[] nums) {
//         if (nums == null || nums.length == 0) return 0;
    
//         int n = nums.length;
        
//         // recurrence relation
//         int[] dp = new int[n];
        
//         // init
//         dp[0] = nums[0];
//         int max = nums[0];
        
//         // recurrence relation
//         for (int i = 1; i < n; i++) {
//             dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
//             max = Math.max(max, dp[i]);
//         }
        
//         // ans
//         return max;
//     }
    
    // 2.Greedy
//  public int maxSubArray(int[] nums) {
//      int sum = 0;
//      int max = Integer.MIN_VALUE;
 
//      for (int i = 0; i < nums.length; i++) {
//          sum += nums[i];
//          max = Math.max(max, sum);
 
//          sum = Math.max(sum, 0);
//      }
 
//      return max;
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
    
//  4.Greedy(Sliding Windows)  这个和第二种方法是一样的。
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
    
    
        // 7. Divide & Conquer
    /*
    https://www.geeksforgeeks.org/maximum-subarray-sum-using-divide-and-conquer-algorithm/
    
    The Divide-and-Conquer algorithm breaks nums into two halves and find the maximum subarray sum in them recursively. 
    Well, the most tricky part is to handle the case that the maximum subarray spans the two halves. For this case,
    we use a linear algorithm: starting from the middle element and move to both ends (left and right ends), record 
    the maximum sum we have seen. In this case, the maximum sum is finally equal to the middle element plus the maximum 
    sum of moving leftwards and the maximum sum of moving rightwards.
    
    Very slow:
    Runtime: 87 ms, faster than 5.17% of Java online submissions for Maximum Subarray.

    */
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        
        return maxSubArray(nums, 0, nums.length - 1);
    }
    
    private int maxSubArray(int[] nums, int l, int r) {
        if (l == r) return nums[l];
        
        int sum = 0, leftSum = Integer.MIN_VALUE, rightSum = Integer.MIN_VALUE;
        int m = l + (r - l) / 2;
        
        for (int i = m; i >= l; i--) {
            sum += nums[i];
            leftSum = Math.max(leftSum, sum);
        }
        
        sum = 0;
        for (int i = m + 1; i <= r; i++) {
            sum += nums[i];
            rightSum = Math.max(rightSum, sum);
        }
        
        return Math.max(leftSum + rightSum, Math.max(maxSubArray(nums, l, m), maxSubArray(nums, m + 1, r)));
    }
    
    
}
