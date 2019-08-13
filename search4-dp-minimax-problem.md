

#### 375. Guess Number Higher or Lower II
https://leetcode.com/problems/guess-number-higher-or-lower-ii/

```
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
    
    
    Runtime: 4 ms, faster than 93.30% of Java online submissions for Guess Number Higher or Lower II.
    Memory Usage: 33.2 MB, less than 16.67% of Java online submissions for Guess Number Higher or Lower II.
    
    */
//     public int getMoneyAmount(int n) {
//         if (n == 1) return 0;   // nothing to guess
        
//         int[][] dp = new int[n + 1][n + 1];
        
//         for (int j = 2; j <= n; j++) {
//             for (int i = j - 1; i >= 1; i--) {
//                 int globalMin = Integer.MAX_VALUE;
//                 for (int k = i + 1; k < j; k++) {
//                     int localMax = k + Math.max(dp[i][k - 1], dp[k + 1][j]);
//                     globalMin = Math.min(globalMin, localMax);
//                 }
//                 dp[i][j] = i + 1 == j ? i : globalMin;  // when there are two numbers [1, 2], the above for loop will not go enter, we will select the lower one by default
//             }
//         }
        
//         return dp[1][n];
//     }
    
    // 2. DP (Minimax using another approach)
    /*
    https://leetcode.com/problems/guess-number-higher-or-lower-ii/discuss/84787/Java-DP-solution
    https://leetcode.com/problems/guess-number-higher-or-lower-ii/discuss/84807/Java-commented-DP-solution
    */
    public int getMoneyAmount(int n) {
        if (n == 1) return 0;   // nothing to guess
        
        int[][] dp = new int[n + 1][n + 1];
        
        for (int len = 1; len < n; len++) {
            for (int i = 1; i + len <= n; i++) {
                int j = i + len;
                // range of k: [i, j), [1, len + 1) -> [n - len, n)
                int globalMin = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int localMax = k + Math.max(dp[i][k - 1], dp[k + 1][j]);
                    globalMin = Math.min(globalMin, localMax);
                }
                // dp[i][j] = i + 1 == j ? i : globalMin;
                dp[i][j] = globalMin;
            }
        }
        
        return dp[1][n];
    }
    
    
    // 3. DFS Recursive + Memorized DP
//     public int getMoneyAmount(int n) {
//         int[][] dp = new int[n + 1][n + 1];
//         return recursive(dp, 1, n);
//     }
    
//     // If we do it recursively, we don't need process the case [2,3], as the global min variable will get the lower one
//     private int recursive(int[][] dp, int s, int e) {
//         if (s >= e) return 0;      // if there is only one number, definitely this is the target, and the cost is 0
//         if (dp[s][e] != 0) return dp[s][e];
        
//         int globalMin = Integer.MAX_VALUE;
//         for (int k = s; k <= e; k++) {
//             int localMax = k + Math.max(recursive(dp, s, k - 1), recursive(dp, k + 1, e));
//             globalMin = Math.min(globalMin, localMax);
//         }
//         dp[s][e] = globalMin;
//         return dp[s][e];
//     }
    
}
```


#### 464. Can I Win
https://leetcode.com/problems/can-i-win/

```

```

#### 486. Predict the Winner
https://leetcode.com/problems/predict-the-winner/

```
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
    
    subproblem:
    dp[i][j]    -   the 
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
```


