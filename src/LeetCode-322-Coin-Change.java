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
    
    // 2.DP
    /*
    https://www.cnblogs.com/grandyang/p/5138186.html
    https://leetcode.com/problems/coin-change/discuss/77360/C%2B%2B-O(n*amount)-time-O(amount)-space-DP-solution
    */
//     public int coinChange(int[] coins, int amount) {
//         int[] state = new int[amount + 1];
//         Arrays.fill(state, amount + 1);
//         state[0] = 0;
        
//         for (int i = 1; i <= amount; i++) {
//             for (int j = 0; j < coins.length; j++) {
//                 if (coins[j] <= i) {
//                     state[i] = Math.min(state[i], state[i - coins[j]] + 1);
//                 }
//             }
//         }
        
//         return state[amount] == amount + 1 ? -1 : state[amount];
//     }
    
    // 3.DP
    /**
    http://zxi.mytechroad.com/blog/dynamic-programming/leetcode-322-coin-change/
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
