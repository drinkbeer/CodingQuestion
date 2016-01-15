/*
LeetCode:  https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
LintCode:  http://www.lintcode.com/problem/best-time-to-buy-and-sell-stock-ii/
JiuZhang:  http://www.jiuzhang.com/solutions/best-time-to-buy-and-sell-stock-ii/
ProgramCreek:  http://www.programcreek.com/2014/02/leetcode-best-time-to-buy-and-sell-stock-java/

Analysis:  
1.
This problem can be viewed as finding all ascending sequences. For example, given {5, 1, 2, 3, 4}, buy at 1 & sell at 4 is the same as buy at 1 &sell at 2 & buy at 2& sell at 3 & buy at 3 & sell at 4.

*/
public class Solution {
    public int maxProfit(int[] prices) {
        int sum = 0;
        
        for(int i = 1; i < prices.length; i++){
            if(prices[i] > prices[i - 1]) sum += prices[i] - prices[i - 1];
        }
        return sum;
    }
}