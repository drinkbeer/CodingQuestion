/*
LeetCode: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
LintCode:  http://www.lintcode.com/problem/best-time-to-buy-and-sell-stock/
JiuZhang:  http://www.jiuzhang.com/solutions/best-time-to-buy-and-sell-stock/
ProgramCreek:  http://www.programcreek.com/2014/02/leetcode-best-time-to-buy-and-sell-stock-java/

Analysis:  
DP
*/
public class Solution {
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