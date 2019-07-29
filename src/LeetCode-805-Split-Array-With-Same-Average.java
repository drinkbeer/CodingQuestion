class Solution {
    // 1. DP (Similar to Knacpack)
    /*
    https://www.youtube.com/watch?v=VtNHz5gtW8E
    
    subproblem:
    dp[i][j] - the sum of subset in range [0, j], has sum to be i
    
    recurrence relation:
    
    for (int i = 0; i < A.length; i++) {
        for (int sum = 0; sum <= SUM; sum++) {
            for (int num = 1; num <= 30; num++) {
                dp[sum][num] = dp[sum - A[i]][num - 1]
                if (sum / num == targetAvg) {
                    return true;
                }
            }
        }
    }
    return false;
    
    
    init:
    dp[0][0] = 1 - empty set, the sum is 0, so it has 1 possible
    
    
    */
    public boolean splitArraySameAverage(int[] A) {
        int N = A.length;
        int SUM = 0;
        for (int a : A) SUM += a;
        double targetAvg = 1.0 * SUM / N;
        int[] temp = new int[N + 1];
        temp[0] = 0;
        for (int i = 0; i < N; i++) {
            temp[i + 1] = A[i];
        }
        A = temp;
        
        boolean[][] dp = new boolean[SUM / 2 + 1][N + 1];
        
        // init
        dp[0][0] = true;
        
        for (int i = 1; i <= N; i++) {
            for (int sum = SUM / 2; sum >= 0; sum--) {
                for (int num = i; num >= 1; num--) {
                    if (sum - A[i] < 0) continue;
                    if (dp[sum - A[i]][num - 1]) {
                        dp[sum][num] = true;
                        // System.out.println("sum: " + sum + "  num: " + num + "  targetAvg: " + targetAvg + "  1.0 * sum / num: " + 1.0 * sum / num);
                        if (num != N && 1.0 * sum / num == targetAvg) {
                            return true;
                        }
                    }
                }
            }
        }
        
        return false;
    }
}
