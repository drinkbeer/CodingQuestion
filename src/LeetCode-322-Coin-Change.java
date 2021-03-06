class Solution {
    // 1. Doesn't work
    /**
    Input:
    [186,419,83,408]
    6249
    
    Output: -1
    
    Expected: 20
    
    Analysis: 
    Based on this approach
    Coin    Num
    419     14      5866    383
    408     0
    186     2       372     11
    83
    
    So the strategy that always select large coins doesn't work in a DP problem.
    */
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        reverse(coins);
        
        int count = 0;
        for (int coin : coins) {
            if (amount < coin) continue;
            count += amount / coin;
            amount = amount % coin;
        }
        
        if (amount != 0) return -1;
        return count;
    }
    
    private void reverse(int[] arr) {
        int lo = 0, hi = arr.length - 1;
        while (lo < hi) {
            int temp = arr[lo];
            arr[lo] = arr[hi];
            arr[hi] = temp;
            lo++;
            hi--;
        }
    }
    
    // 2.DFS
    /**
    Test cases:
    [1]
    0
    Expected: 0
    
    [1,2147483647]
    2
    Expected: 2

    */
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        
        int[] res = new int[1];
        res[0] = Integer.MAX_VALUE;
        
        helper(coins, coins.length - 1, amount, res, 0);
        return res[0] == Integer.MAX_VALUE ? -1 : res[0];
    }
    
    private void helper(int[] coins, int start, int amount, int[] res, int count) {
        if (start < 0) return;
        if (amount % coins[start] == 0) {
            // we get an answer, but not sure if it is the minimum answer
            res[0] = Math.min(res[0], count + amount / coins[start]);
            return;
        }
        
        for (int i = amount / coins[start]; i >= 0; i--) {
            if (count + i >= res[0]) return;
            
            helper(coins, start - 1, amount - coins[start] * i, res, count + i);
        }
    }
    
    
//     public int coinChange(int[] coins, int amount) {
//         if (coins == null || coins.length == 0) return -1;
        
//         Arrays.sort(coins);
//         int[] res = new int[1];
//         res[0] = Integer.MAX_VALUE;
//         DFS(coins, amount, coins.length - 1, 0, res);
//         return res[0] == Integer.MAX_VALUE ? -1 : res[0];
//     }
    
//     private void DFS(int[] coins, int amount, int start, int count, int[] res) {
//         if (start < 0) return;
//         if (amount % coins[start] == 0) {
//             // means the remaining amount could all use coins[i] to fill
//             res[0] = Math.min(res[0], count + amount / coins[start]);
//             return;
//         }
        
//         // amount / coins[start] is number of coins[start] selected. We search from most amount of coins[start] to 0
//         // as we are search from largest coins to smallest, so we search in reverse order in order to get most larger coins to make
//         // we get the smallest number of coins faster
//         for (int i = amount / coins[start]; i >= 0; i--) {
//             if (i + count > res[0]) return;
            
//             DFS(coins, amount - i * coins[start], start - 1, count + i, res);
//         }
//     }
    
    // DFS. recerse order (looks like there is some proble using Arrays.sort, but the approach is viable)
//     public int coinChange(int[] coins, int amount) {
//         if (coins == null || coins.length == 0) return -1;
        
//         // Arrays.sort(coins);
//         Arrays.sort(coins, (a, b) -> (int) b - (int) a);
//         int[] res = new int[1];
//         res[0] = Integer.MAX_VALUE;
//         DFS(coins, amount, 0, 0, res);
//         return res[0] == Integer.MAX_VALUE ? -1 : res[0];
//     }
    
//     private void DFS(int[] coins, int amount, int start, int count, int[] res) {
//         if (amount % coins[start] == 0) {
//             // means the remaining amount could all use coins[i] to fill
//             res[0] = Math.min(res[0], count + amount / coins[start]);
//             return;
//         }
        
//         // amount / coins[start] is number of coins[start] selected. We search from most amount of coins[start] to 0
//         // as we are search from largest coins to smallest, so we search in reverse order in order to get most larger coins to make
//         // we get the smallest number of coins faster
//         for (int i = amount / coins[start]; i >= 0; i--) {
//             if (i + count > res[0]) return;
//             if (start + 1 >= coins.length) return;
            
//             DFS(coins, amount - i * coins[start], start + 1, count + i, res);
//         }
//     }
    
    // dp without optimization: 
    /**
    [1,2,5]
    11
    
    [2]
    3
    
    [1]
    0
    
    dp: 
    [0, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12]
    [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11]
    [0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6]
    [0, 1, 1, 2, 2, 1, 2, 2, 3, 3, 2, 3]
    
    Time Complexity: O(N * amount * k)
    Time: 638 ms
    */
//     public int coinChange(int[] coins, int amount) {
//         int N = coins.length;
        
//         int[][] dp = new int[N + 1][amount + 1];
        
//         for (int i = 0; i <= N; i++) {
//             for (int j = 0; j <= amount; j++) {
//                 dp[i][j] = amount + 1;
//             }
//         }
//         for (int i = 0; i <= N; i++) {
//             dp[i][0] = 0;
//         }
        
//         for (int i = 1; i <= N; i++) {
//             for (int j = 1; j <= amount; j++) {
//                 for (int k = 0; k * coins[i - 1] <= j; k++) {
//                     if (dp[i - 1][j - k * coins[i - 1]] < amount + 1) {
//                         dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - k * coins[i - 1]] + k);
//                     }
//                 }
//             }
//         }
        
        
//         // printArray(dp);
//         return dp[N][amount] == amount + 1 ? -1 : dp[N][amount];
//     }
    
    private void printArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }
    
    // Optimize time
    /**
    
    dp:
    [0, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12]
    [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11]
    [0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6]
    [0, 1, 1, 2, 2, 1, 2, 2, 3, 3, 2, 3]
    
    Time Complexity: O(N * amount)
    Time: 35 ms
    
    */
//     public int coinChange(int[] coins, int amount) {
//         int N = coins.length;
        
//         // sub problem
//         int[][] dp = new int[N + 1][amount + 1];
        
//         // init
//         for (int i = 0; i <= N; i++) {
//             for (int j = 0; j <= amount; j++) {
//                 dp[i][j] = amount + 1;
//             }
//         }
//         // if amount = 0, the result is always 0
//         for (int i = 0; i <= N; i++) {
//             dp[i][0] = 0;
//         }
        
//         for (int i = 1; i <= N; i++) {
//             for (int j = 1; j <= amount; j++) {
//                 dp[i][j] = dp[i - 1][j];
//                 if (j >= coins[i - 1]) dp[i][j] = Math.min(dp[i][j], dp[i][j - coins[i - 1]] + 1);
//             }
//         }
        
//         // printArray(dp);
//         return dp[N][amount] == amount + 1 ? -1 : dp[N][amount];
//     }
    
    // Optimize Space
    /**
    dp:
    [0, 1, 1, 2, 2, 1, 2, 2, 3, 3, 2, 3]
    
    Time Complexity: O(N * amount)
    Time: 10 ms
    */
//     public int coinChange(int[] coins, int amount) {
//         int N = coins.length;
        
//         // sub problem
//         int[] dp = new int[amount + 1];
//         for (int i = 1; i <= amount; i++) dp[i] = amount + 1;
        
//         for (int i = 0; i < N; i++) {
//             for (int j = 1; j <= amount; j++) {
//                 if (j >= coins[i]) dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
//             }
//         }
        
//         // System.out.println(Arrays.toString(dp));
//         return dp[amount] == amount + 1 ? -1 : dp[amount];
//     }
    
    /**
    Follow-up: Could output the list of coins that has minimum coins to make up the amount?
    */
    // Print the list of coins that has minimum coins to make up the amount
    public int coinChange(int[] coins, int amount) {
        int N = coins.length;
        
        int[] coinsPos = new int[amount + 1];
        for (int i = 0; i < N; i++) coinsPos[i] = coins[i];
        
        // sub problem
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) dp[i] = amount + 1;
        
        for (int i = 0; i < N; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j >= coins[i]) {
                    if (dp[j] > dp[j - coins[i]] + 1) {
                        dp[j] = dp[j - coins[i]] + 1;
                        coinsPos[j] = coins[i];
                    }
                }
            }
        }
        
        List<Integer> list = new ArrayList<>();
        int pos = amount;
        while (pos > 0) {
            list.add(0, coinsPos[pos]);
            pos -= coinsPos[pos];
        }
        System.out.println(Arrays.toString(coinsPos));
        System.out.println(list);
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
    
    
    // 3.DP (pull)
    /*
    https://www.cnblogs.com/grandyang/p/5138186.html
    https://leetcode.com/problems/coin-change/discuss/77360/C%2B%2B-O(n*amount)-time-O(amount)-space-DP-solution
    
    subproblem:
    dp[i]    -   the min number of coins to construct amount i
    
    recurrence relation:
    Assuming that dp [0, i - 1] has already been the most optimized number of coins to change
    dp[i] = min(dp[i], dp[i - coins[j]]), i belongs to [1, amount], j belongs to [0, coins.length)
    
    example: for i amount, it could be transit to three amount: from dp[i - 1] plus 1, from dp[i - 2] plus 2, from dp[i - 5] plus 5
    
    init:
    dp[0] = 0;  // amount is 0, so the number of coins is 0
    
    ans:
    dp[amount]
    
    */
//     public int coinChange(int[] coins, int amount) {
//         // subproblem:
//         int[] dp = new int[amount + 1];
        
//         // init
//         Arrays.fill(dp, amount + 1);
//         dp[0] = 0;
        
//         // recurrence relation
//         for (int i = 1; i <= amount; i++) {
//             for (int j = 0; j < coins.length; j++) {
//                 if (i - coins[j] >= 0) {
//                     dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
//                 }
//             }
//         }
        
//         // ans
//         return dp[amount] == amount + 1 ? -1 : dp[amount];
//     }
    
    // 3.DP
    /**
    http://zxi.mytechroad.com/blog/dynamic-programming/leetcode-322-coin-change/
    
    if num of coins is <<<<< amount, then it's better to loop the coin outside.
    */
    public int coinChange(int[] coins, int amount) {
        // subproblem
        int[] dp = new int[amount + 1];
        
        // init
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        
        // ans
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}
