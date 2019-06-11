/*
LeetCode: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
LintCode:  http://www.lintcode.com/problem/best-time-to-buy-and-sell-stock/
JiuZhang:  http://www.jiuzhang.com/solutions/best-time-to-buy-and-sell-stock/
ProgramCreek:  http://www.programcreek.com/2014/02/leetcode-best-time-to-buy-and-sell-stock-java/

Analysis:  
DP
*/
public class Solution {
    
    // 1. DP
//     public int maxProfit(int[] prices) {
//         if (prices == null || prices.length == 0) return 0;
        
//         int[] state = new int[prices.length];
//         int lowest = prices[0];
        
//         for (int i = 1; i < prices.length; i++) {
//             lowest = Math.min(lowest, prices[i]);
//             state[i] = Math.max(state[i - 1], prices[i] - lowest);
//         }
        
//         return state[prices.length - 1];
//     }
    
    // 2.Greedy
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length <= 1) return 0;
        
        int maxValue = 0;
        int min = prices[0];
        
        for(int i = 1; i < prices.length; i++){
            min = Math.min(min, prices[i]);
            maxValue = Math.max(maxValue, prices[i] - min);
        }
        
        return maxValue;
    }
}
