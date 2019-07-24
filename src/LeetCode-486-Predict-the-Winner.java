class Solution {
    // 1. Recursive (without memorization)
    /*
    Time: O(2^N)
    Space: O(N)
    */
    // getScore method is used to get the max score diff of player 1 to player 2 (player 1 - player 2)
//     public boolean PredictTheWinner(int[] nums) {
//         return getScore(nums, 0, nums.length - 1) >= 0;
//     }
    
//     private int getScore(int[] nums, int i, int j) {
//         if (i == j) return nums[i];
//         return Math.max(nums[i] - getScore(nums, i + 1, j), nums[j] - getScore(nums, i, j - 1));
//     }
    
    // 2. Recursive (with memorization)
    /*
    Time: O(N^2) as we only calculate each [i, i] pair once
    Space: O(N^2)
    
    https://www.youtube.com/watch?v=g5wLHFTodm0
    */
//     public boolean PredictTheWinner(int[] nums) {
//         int[][] dp = new int[nums.length][nums.length];
//         getScore(nums, 0, nums.length - 1, dp);
//         return dp[0][nums.length - 1] >= 0;
//     }
    
//     private void getScore(int[] nums, int i, int j, int[][] dp) {
//         if (dp[i][j] != 0) return;
//         if (i == j) {
//             dp[i][j] = nums[i];
//             return;
//         }
//         getScore(nums, i + 1, j, dp);
//         getScore(nums, i, j - 1, dp);
//         dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
//     }
    
    // 3. DP
    /*
    https://leetcode.com/problems/predict-the-winner/discuss/96828/JAVA-9-lines-DP-solution-easy-to-understand-with-improvement-to-O(N)-space-complexity.
    Time: O(N^2)
    Space: O(N^2)
    */
//     public boolean PredictTheWinner(int[] nums) {
//         int n = nums.length;
//         int[][] dp = new int[n][n];
        
//         for (int i = 0; i < n; i++) {
//             dp[i][i] = nums[i];
//         }
        
//         for (int len = 1; len <= n - 1; len++) {
//             // range of [i, j], begin: [0, 0 + len], end: [n - len - 1, n - 1]
//             for (int i = 0; i < n - len; i++) {
//                 int j = i + len;
//                 dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
//             }
//         }
        
//         return dp[0][n - 1] >= 0;
//     }
    
    // Improvement: O(N) Space
    /*
    However, if you are interviewing with a good company, they may challenge you to further improve your code, probably in the aspect of space complexity. So far, we are using a n x n matrix so the space complexity is O(n^2). It actually can be improved to O(n). That can be done by changing our way of filling the table. We may use only one dimensional dp[i] and we start to fill the table at the bottom right corner where dp[4] = nums[4]. On the next step, we start to fill the second to the last line, where it starts from dp[3] = nums[3]. Then dp[4] = Math.max(nums[4] - dp[3], nums[3] - dp[4]). Then we fill the third to the last line where dp[2] = nums[2] and so on... Eventually after we fill the first line and after the filling, dp[4] will be the answer.

    */
    public boolean PredictTheWinner(int[] nums) {
        if (nums == null) { return true; }
        int n = nums.length;
        if ((n & 1) == 0) { return true; } // Improved with hot13399's comment.
        int[] dp = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (i == j) {
                    dp[i] = nums[i];
                } else {
                    dp[j] = Math.max(nums[i] - dp[j], nums[j] - dp[j - 1]);
                }
            }
        }
        return dp[n - 1] >= 0;
    }
    
}
