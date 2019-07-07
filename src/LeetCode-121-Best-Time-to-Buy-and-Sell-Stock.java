/*
LeetCode: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
LintCode:  http://www.lintcode.com/problem/best-time-to-buy-and-sell-stock/
JiuZhang:  http://www.jiuzhang.com/solutions/best-time-to-buy-and-sell-stock/
ProgramCreek:  http://www.programcreek.com/2014/02/leetcode-best-time-to-buy-and-sell-stock-java/

Analysis:  
DP
*/
class Solution {

    // 1. Two Way Scan
    /*
    first array: left min view
    second array: right max view
    
    Time O(N)
    Space O(N)
    */
//     public int maxProfit(int[] prices) {
//         if (prices == null || prices.length == 0) return 0;
        
//         int n = prices.length;
        
//         int[] left = new int[n];
//         int leftMin = Integer.MAX_VALUE;
//         for (int i = 0; i < n; i++) {
//             leftMin = Math.min(leftMin, prices[i]);
//             left[i] = leftMin;
//         }
        
//         int[] right = new int[n];
//         int rightMax = Integer.MIN_VALUE;
//         for (int i = n - 1; i >= 0; i--) {
//             rightMax = Math.max(rightMax, prices[i]);
//             right[i] = rightMax;
//         }
        
//         int max = Integer.MIN_VALUE;
//         for (int i = 0; i < n; i++) {
//             if (left[i] < right[i]) {
//                 max = Math.max(max, right[i] - left[i]);
//             }
//         }
        
//         return max == Integer.MIN_VALUE ? 0 : max;
//     }
    
    // 2. DP (Pull)
    /*
    subproblem:
    dp[i]   -   the highest prices by ith day
    
    recurrence:
    dp[i] = max(dp[i - 1], prices[i] - min);
    
    init:
    dp[0] = 0
    
    ans:
    dp[n - 1]
    */
//     public int maxProfit(int[] prices) {
//         if (prices == null || prices.length == 0) return 0;

//         int n = prices.length;

//         // subproblem
//         int[] dp = new int[n];

//         // init
//         dp[0] = 0;
//         int min = prices[0];
        
//         // recurrence relation
//         for (int i = 1; i < n; i++) {
//             min = Math.min(min, prices[i]);
//             dp[i] = Math.max(dp[i - 1], prices[i] - min);
//         }
        
//         // ans
//         return dp[n - 1];
//     }
    
    // 3. Greedy
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        int n = prices.length;
    
        int min = prices[0], maxProfit = 0;
        
        for (int i = 1; i < n; i++) {
            min = Math.min(min, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - min);
        }
        
        return maxProfit;
    }
}
