class Solution {
    // 1. MiniMax problem solved by DP
    /*
    https://www.cnblogs.com/grandyang/p/5677550.html
    https://univasity.iteye.com/blog/1170216
    https://www.youtube.com/watch?v=VfJPDNG0nYM
    https://leetcode.com/problems/guess-number-higher-or-lower-ii/discuss/84787/Java-DP-solution
    
    if only 1 element:
    [4] -> then the cost is 0, as only one element. Cost is 0.
    
    2 elements:
    [3, 4], we will definitely guess 3, as based on the response of guess 3, we could always get the final target: if the target is 3, we get it, if target is not 3, we also get the final target is 4. Cost is the smaller number.
    
    3 elements;
    [2, 3, 4], we will guess from 3, and based on the answer, we could always get the answer. Cost is 3.
    
    [1, 2, 3, 4, 5]
    
    We could first guess 3, based on the response, "My Number is Higher", then we guess 4, no matter what's the next response, we could get the final number. So the cost is 3+4=7.
    If the response of guess 3 is "My number if lower", then we guess 1, no matter what's the next response, we could get the final number. So cost is 3 + 1 = 4. But we are asked the money guarantee to win, so we could choose max(4, 7), final answer is 7.
    
    subproblem:
    dp[i][j] - the minimum money to guarantee win for subproblem [i, j]
    
    recurrence relation:
    dp[i][j] = min {k + max{dp[i][k - 1], dp[k + 1][j]}}, i <= k <= j
    We choose k (i <= k <= j) as our guess, and pay price k. After our guess, the problem is divided into two subproblmes. Notice we don't need to pay money for both subproblems. We only need to pay the worst case (because the system will tell us which side we should go). So dp[i][j] = min {k + max{dp[i][k - 1], dp[k + 1][j]}}, i <= k <= j
    
    init:
    dp[0][x] = 0
    dp[1][x] = 0
    dp[i][i] = 0, because the only element must be correct
    
    ans:
    dp[1][n]
    
    */
    
//     public int getMoneyAmount(int n) {
//         if (n == 1) return 0;   // nothing to guess
        
//         int[][] dp = new int[n + 1][n + 1];
        
//         for (int j = 2; j <= n; j++) {
//             for (int i = j - 1; i >= 0; i--) {
//                 int globalMin = Integer.MAX_VALUE;
//                 for (int k = i + 1; k < j; k++) {
//                     int localMax = k + Math.max(dp[i][k - 1], dp[k + 1][j]);
//                     globalMin = Math.min(globalMin, localMax);
//                 }
//                 dp[i][j] = i + 1 == j ? i : globalMin;
//             }
//         }
        
//         return dp[1][n];
//     }
    
    /*
    https://leetcode.com/problems/guess-number-higher-or-lower-ii/discuss/84787/Java-DP-solution
    */
    public int getMoneyAmount(int n) {
        if (n == 1) return 0;   // nothing to guess
        
        int[][] dp = new int[n + 1][n + 1];
        
        for (int len = 1; len < n; len ++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len;
                // range of k: (i, j), [0, len] -> [n - len, n]
                int globalMin = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; k++) {
                    int localMax = k + Math.max(dp[i][k - 1], dp[k + 1][j]);
                    globalMin = Math.min(globalMin, localMax);
                }
                dp[i][j] = i + 1 == j ? i : globalMin;
            }
        }
        
        return dp[1][n];
    }
}
