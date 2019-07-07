/*
LeetCode: https://leetcode.com/problems/climbing-stairs/
LintCode: http://www.lintcode.com/problem/climbing-stairs/
JiuZhang: http://www.jiuzhang.com/solutions/climbing-stairs/
ProgramCreek: 

Analysis: 

*/
class Solution {
    // 1.DP
    /*
    subproblem:
    dp[i]   -   number of ways to climb to i stair
    
    recurrence relation:
    dp[i] = dp[i - 1] + dp[i - 2]
    
    init:
    dp[0] = 1
    dp[1] = 2
    
    ans:
    dp[n - 1]
    */
//     public int climbStairs(int n) {
//         if (n == 1) return 1;
        
//         // recurrence relation
//         int[] dp = new int[n];
        
//         // init
//         dp[0] = 1;
//         dp[1] = 2;
        
//         // recurrence relation
//         for (int i = 2; i < n; i++) {
//             dp[i] = dp[i - 1] + dp[i - 2];
//         }
        
//         // ans
//         return dp[n - 1];
//     }
    
    // 2. Greedy
    public int climbStairs(int n) {
        if (n == 1) return 1;
    
        int s1 = 1;
        int s2 = 2;
        
        for (int i = 2; i < n; i++) {
            int temp = s1 + s2;
            s1 = s2;
            s2 = temp;
        }
        
        return s2;
    }
}
