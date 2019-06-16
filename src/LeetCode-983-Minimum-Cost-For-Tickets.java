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
    Optimized version. Since we only look 30 days back, we can just store the past 30 days' ticket cost.
    Time: O(N)
    Space: O(30)
    */
    public int mincostTickets(int[] days, int[] costs) {
        if (days == null || costs == null || days.length == 0 || costs.length == 0) return 0;
        
        int[] state = new int[30];
        state[0] = 0;
        int j = 0;
        for (int i = 1; i <= days[days.length - 1]; i++) {
            if (j < days.length && i == days[j]) {
                // a travel day
                int c1 = state[(i - 1) % 30] + costs[0];
                int c7 = state[Math.max(0, (i - 7) % 30)] + costs[1];
                int c30 = state[Math.max(0, (i - 30) % 30)] + costs[2];
                
                state[i % 30] = Math.min(c1, Math.min(c7, c30));
                j++;
            } else {
                state[i % 30] = state[(i - 1) % 30];
            }
        }
        
        return state[days[days.length - 1] % 30];
    }
    
    
}
