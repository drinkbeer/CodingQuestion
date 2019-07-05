class Solution {
    // 1. Doesn't work
//     public int coinChange(int[] coins, int amount) {
//         Arrays.sort(coins);
//         reverse(coins);
        
//         int count = 0;
//         for (int coin : coins) {
//             count += amount / coin;
//             amount = amount % coin;
//         }
        
//         if (amount != 0) return -1;
//         return count;
//     }
    
//     private void reverse(int[] arr) {
//         int lo = 0, hi = arr.length - 1;
//         while (lo < hi) {
//             int temp = arr[lo];
//             arr[lo] = arr[hi];
//             arr[hi] = temp;
//             lo++;
//             hi--;
//         }
//     }
    
    // 1.DFS
//     public int coinChange(int[] coins, int amount) {
//         Arrays.sort(coins);
        
//         int[] res = new int[1];
//         res[0] = Integer.MAX_VALUE;
        
//         helper(coins, coins.length - 1, amount, res, 0);
//         return res[0] == Integer.MAX_VALUE ? -1 : res[0];
//     }
    
//     private void helper(int[] coins, int start, int amount, int[] res, int count) {
//         if (start < 0) return;
//         if (amount % coins[start] == 0) {
//             // we get an answer, but not sure if it's the minumum answer
//             res[0] = Math.min(res[0], count + amount / coins[start]);
//             return;
//         }
        
//         for (int i = amount / coins[start]; i >= 0; i--) {
//             if (count + i >= res[0]) return;
            
//             helper(coins, start - 1, amount - coins[start] * i, res, count + i);
//         }
//     }
    
    
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
    
    
    // 2.DP (pull)
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
        int[] state = new int[amount + 1];
        Arrays.fill(state, amount + 1);
        state[0] = 0;
     
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                state[i] = Math.min(state[i], state[i - coin] + 1);
            }
        }
        
        return state[amount] == amount + 1 ? -1 : state[amount];
    }
}
