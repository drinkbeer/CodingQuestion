class Solution {
    // DP: no optimization
    /**
    
    dp:
    [1, 0, 0, 0, 0, 0]
    [1, 1, 1, 1, 1, 1]
    [1, 1, 2, 2, 3, 3]
    [1, 1, 2, 2, 3, 4]
    
    Time Complexity: O(N * amount^2)
    Time: 130 ms
    */
//     public int change(int amount, int[] coins) {
//         int N = coins.length;
        
//         // sub problem
//         int[][] dp = new int[N + 1][amount + 1];
//         for (int i = 0; i <= N; i++) dp[i][0] = 1;
        
//         for (int i = 1; i <= N; i++) {
//             for (int j = 1; j <= amount; j++) {
//                 for (int k = 0; k * coins[i - 1] <= j; k++) {
//                     dp[i][j] += dp[i - 1][j - k * coins[i - 1]];
//                 }
//             }
//         }
        
//         // printArray(dp);
//         return dp[N][amount];
//     }
    
    private void printArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }
    
    // DP: optimize time
    /**
    dp:
    [1, 0, 0, 0, 0, 0]
    [1, 1, 1, 1, 1, 1]
    [1, 1, 2, 2, 3, 3]
    [1, 1, 2, 2, 3, 4]
    
    Time Complexity: O(N * amount)
    Time: 17 ms
    */
//     public int change(int amount, int[] coins) {
//         int N = coins.length;
        
//         // sub problem
//         int[][] dp = new int[N + 1][amount + 1];
//         for (int i = 0; i <= N; i++) dp[i][0] = 1;
        
//         for (int i = 1; i <= N; i++) {
//             for (int j = 1; j <= amount; j++) {
//                 dp[i][j] = dp[i - 1][j];
//                 if (j >= coins[i - 1]) dp[i][j] += dp[i][j - coins[i - 1]];
//             }
//         }
        
//         // printArray(dp);
//         return dp[N][amount];
//     }
    
    // DP: optimize space
    /**
    dp:
    [1, 1, 2, 2, 3, 4]
    
    Time Complexity: O(N * amount)
    Time: 5ms
    */
    public int change(int amount, int[] coins) {
        int N = coins.length;
        
        // sub problem
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j >= coins[i - 1]) dp[j] += dp[j - coins[i - 1]];
            }
        }
        
        // System.out.println(Arrays.toString(dp));
        return dp[amount];
    }
}
