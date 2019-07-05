class Solution {
    // 1. DP. doesn't work
//     public int mincostTickets(int[] days, int[] costs) {
//         if (days == null || costs == null || days.length == 0 || costs.length == 0) return 0;
        
//         int[][] state = new int[costs.length][days.length];
        
//         state[0][0] = costs[0];
//         state[1][0] = costs[1];
//         state[2][0] = costs[2];
        
//         int[] s = new int[costs.length];
        
//         for (int j = 1; j < days.length; j++) {
//             for (int i = 0; i < costs.length; i++) {
                
//                 // update the left boundary if we purchase a costs[i] ticket
//                 int minVal = 0;
//                 if (i == 0) {
//                     minVal = days[j] - 1;
//                 } else if (i == 1) {
//                     minVal = days[j] - 7;
//                 } else if (i == 3) {
//                     minVal = days[j] - 30;
//                 }
                
//                 int k = s[i];
//                 while (days[k] < minVal) {
//                     if (i == 0) {
//                         System.out.println("i: " + i + "  j: " + j + "  " + days[k] + "  " + minVal);
//                     }
//                     k++;
//                 }
//                 s[i] = k;
                
//                 if (k > 0) {
//                     state[i][j] = Math.min(state[0][k - 1], Math.min(state[1][k - 1], state[2][k - 1])) + costs[i];
//                 } else {
//                     state[i][j] = costs[i];
//                 }
//             }
//             System.out.println(Arrays.toString(s));
//         }
        
        
//         System.out.println(Arrays.deepToString(state));
        
//         return Math.min(state[0][days.length - 1], Math.min(state[1][days.length - 1], state[2][days.length - 1]));
//     }
    
    
    /*
    1.DP
    
    https://leetcode.com/problems/minimum-cost-for-tickets/discuss/226659/Two-DP-solutions-with-pictures
    https://leetcode.com/problems/minimum-cost-for-tickets/discuss/226670/Java-DP-Solution-with-explanation-O(n)
    
    Tracking the costs for all calendar days.
    1.Travel day. Minimal cost is min of costs for three tickets.
    2.Non travel day. Minimal cost is same as previous day.
    */
//     public int mincostTickets(int[] days, int[] costs) {
//         if (days == null || costs == null || days.length == 0 || costs.length == 0) return 0;
    
//         int[] state = new int[366];
//         state[0] = 0;
//         int j = 0;
//         for (int i = 1; i <= 365; i++) {
//             if (j < days.length && i == days[j]) {
//                 // find a travel day
//                 int c1 = state[i - 1] + costs[0];
//                 int c7 = state[Math.max(0, i - 7)] + costs[1];
//                 int c30 = state[Math.max(0, i - 30)] + costs[2];
                
//                 state[i] = Math.min(c1, Math.min(c7, c30));
//                 j++;
//             } else {
//                 // a non-travel day
//                 state[i] = state[i - 1];
//             }
//         }
        
//         return state[365];
//     }
    
    /*
    
    subproblem:
    dp[i] - the min cost of tickets til ith day
    
    recurrence relation:
    Assume dp[0, i - 1] has been optimized amount, then ith days's ticket cost cound be transit from i-1 days ticket cost, or i-7, i-30 days ticket cost.
    if ith day has travel:
    dp[i] = min{dp[i - 1] + costs[0], dp[i - 7] + costs[1], dp[i - 30] + costs[2]}
    if ith day doesn't have travel:
    dp[i] = dp[i - 1]
    
    init:
    dp[0] = 0   // if no travel, then ticket cost is 0
    
    ans:
    dp[365]
    
    */
//     public int mincostTickets(int[] days, int[] costs) {
//         if (days == null || costs == null || days.length == 0 || costs.length == 0) return 0;
    
//         // subproblem
//         int[] dp = new int[365 + 1];
        
//         // init
//         dp[0] = 0;
//         HashSet<Integer> set = new HashSet<>();
//         for (int d : days) set.add(d);
        
//         for (int i = 1; i <= 365; i++) {
//             if (set.contains(i)) {
//                 int c1 = dp[Math.max(0, i - 1)] + costs[0];
//                 int c2 = dp[Math.max(0, i - 7)] + costs[1];
//                 int c3 = dp[Math.max(0, i - 30)] + costs[2];
                
//                 dp[i] = Math.min(c1, Math.min(c2, c3));
//             } else {
//                 dp[i] = dp[i - 1];
//             }
//         }
        
//         return dp[365];
//     }
    
    /*
    Optimized version. Since we only look 30 days back, we can just store the past 30 days' ticket cost.
    Time: O(N)
    Space: O(30)
    */
//     public int mincostTickets(int[] days, int[] costs) {
//         if (days == null || costs == null || days.length == 0 || costs.length == 0) return 0;
        
//         int[] state = new int[30];
//         state[0] = 0;
//         int j = 0;
//         for (int i = 1; i <= days[days.length - 1]; i++) {
//             if (j < days.length && i == days[j]) {
//                 // a travel day
//                 int c1 = state[(i - 1) % 30] + costs[0];
//                 int c7 = state[Math.max(0, (i - 7) % 30)] + costs[1];
//                 int c30 = state[Math.max(0, (i - 30) % 30)] + costs[2];
                
//                 state[i % 30] = Math.min(c1, Math.min(c7, c30));
//                 j++;
//             } else {
//                 state[i % 30] = state[(i - 1) % 30];
//             }
//         }
        
//         return state[days[days.length - 1] % 30];
//     }
    
    // 2.
    
    /*
    https://leetcode.com/problems/minimum-cost-for-tickets/solution/
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Minimum Cost For Tickets.
    */
    
//     int[] days, costs;
//     Integer[] memo;
//     int[] durations = new int[]{1, 7, 30};

//     public int mincostTickets(int[] days, int[] costs) {
//         this.days = days;
//         this.costs = costs;
//         memo = new Integer[days.length];

//         return dp(0);
//     }

//     public int dp(int i) {
//         if (i >= days.length)
//             return 0;
//         if (memo[i] != null)
//             return memo[i];

//         int ans = Integer.MAX_VALUE;
//         int j = i;
//         for (int k = 0; k < 3; ++k) {
//             while (j < days.length && days[j] < days[i] + durations[k])
//                 j++;
//             ans = Math.min(ans, dp(j) + costs[k]);
//         }

//         memo[i] = ans;
//         return ans;
//     }
    
    // DP. Loop the days array (best solution)
    /*
    https://leetcode.com/problems/minimum-cost-for-tickets/discuss/326266/Only-loop-'days'-array-with-explanation-O(n)-and-comment
    
    subproblem
    dp[i]   -   the ith days's min cost, assuming the dp[o, i - 1] has the most optimized ticket cost
    
    recurrence relation:
    dp[i] = min (dp[i - 1] + costs[0], dp[j] + costs[1], dp[k] + costs[2]), j is the day that traveled 7 days ago, k is the day that
    traveled 30 days ago
    
    init:
    dp[1] = min(costs[0], costs[1], costs[2])
    
    ans:
    dp[n - 1]
    
    Runtime: 1 ms, faster than 93.51% of Java online submissions for Minimum Cost For Tickets.
    Memory Usage: 34.4 MB, less than 100.00% of Java online submissions for Minimum Cost For Tickets.

    */
    public int mincostTickets(int[] days, int[] costs) {
        if (days == null || days.length == 0) return 0;
        int n = days.length;
        
        // subproblem: dp[i] denotes the min cost travel at the days [0, i]
        int[] dp = new int[n];
        
        // init
        dp[0] = Math.min(costs[0], Math.min(costs[1], costs[2]));      // travel at only one day will only require one day ticket or the cheapest ticket
        
        // days 0 should be calculate again, because it could happen that 
        // costs [7,2,15], as 7 days ticket is much cheaper than 1 day ticket.
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1] + costs[0];  // assume we only travel this day using one day cost
            
            // find the day traveled 7 days ago, so we could purchase a 7-day ticket after it
            int j = i;
            while (j >= 0 && days[i] - days[j] + 1 <= 7) j--;
            dp[i] = Math.min(dp[i], j < 0 ? costs[1] : dp[j] + costs[1]);
            
            // find the day traveled 30 days ago, so we could purchase a 30-day ticket after it
            // j = i;   -> this one is not necessary
            while (j >= 0 && days[i] - days[j] + 1 <= 30) j--;
            dp[i] = Math.min(dp[i], j < 0 ? costs[2] : dp[j] + costs[2]);
        }
        
        return dp[n - 1];
    }
    
}
