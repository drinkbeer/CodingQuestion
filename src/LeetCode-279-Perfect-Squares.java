class Solution {
    // Wrong Answwer
    /*
    12:
    9+1+1+1 -> 4 is not correct answer
    4+4+4 -> 3 is the correct answer
    
    */
//     public int numSquares(int n) {
//         if (n == 1) return 1;
//         if (n == 2) return 2;
        
//         int i = n / 2, count = 0;
//         while (i >= 1 && n > 0) {
//             if (i <= n / i) {
//                 count += n / (i * i);
//                 System.out.println("n: " + n + "  i: " + i);
//                 n = n % (i * i);
//             }
//             i--;
//         }
        
//         return count;
//     }
    
    // 1. DP (Pull)
    /*
    subproblem:
    dp[i]   - the minimum number of perfect number sum equals to i
    
    recurrence relation:
    dp[i] = min(dp[i], dp[i - perfect^2] + 1), perfect is the perfect number less than i
    
    init:
    dp[0] = 0
    dp[1] = 1
    init dp[i] = n + 1
    
    ans:
    dp[n]
    */
    public int numSquares(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        
        // subproblem
        int[] dp = new int[n + 1];
        
        
        // init
        Arrays.fill(dp, n);
        dp[0] = 0;
        dp[1] = 1;
        
        // recurrence relation
        for (int i = 2; i <= n; i++) {
            for (int j = 1; i - j * j >= 0; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        
        // ans
        return dp[n];
    }
    
}
