/*


*/
class Solution {
//     public int minCost(int[][] costs) {
//         if (costs == null || costs.length == 0) return 0;
        
//         int n = costs.length;
//         int[][] dp = new int[n][3];
//         dp[0][0] = costs[0][0];
//         dp[0][1] = costs[0][1];
//         dp[0][2] = costs[0][2];
        
//         for (int i = 1; i < n; i++) {
//             dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + costs[i][0];
//             dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + costs[i][1];
//             dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + costs[i][2];
//         }
        
//         return Math.min(dp[n - 1][0], Math.min(dp[n - 1][1], dp[n - 1][2]));
        
//     }
    
    
    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0) return 0;
        
        int n = costs.length;
        int c0 = costs[0][0];
        int c1 = costs[0][1];
        int c2 = costs[0][2];
        
        for (int i = 1; i < n; i++) {
            int t0 = Math.min(c1, c2) + costs[i][0];
            int t1 = Math.min(c0, c2) + costs[i][1];
            int t2 = Math.min(c0, c1) + costs[i][2];
            
            c0 = t0;
            c1 = t1;
            c2 = t2;
        }
        
        return Math.min(c0, Math.min(c1, c2));
        
    }
    
}
