/*
LeetCode: https://leetcode.com/problems/reverse-integer/
LintCode: http://www.lintcode.com/problem/reverse-integer/
JiuZhang: http://www.jiuzhang.com/solutions/reverse-integer/
ProgramCreek: http://www.programcreek.com/2012/12/leetcode-reverse-integer/
Other: http://www.cnblogs.com/yuzhangcmu/p/4162196.html

Analysis: 

*/

public class Solution {
    public int reverse(int x) {
        // boolean isPositive = true;
        // if(x < 0) {
        //     isPositive = false;
        //     x = -x;
        // }
        
        // double reverse = 0;
        // int p = x;
        
        // while(p > 0){
        //     reverse = p % 10 + 10 * reverse;
        //     p /= 10;
        // }
        
        // if(reverse > Integer.MAX_VALUE) return 0;
        
        // if(!isPositive){
        //     reverse = -reverse;
        // }
        
        // return (int)reverse;
        
        // A succinct solution
        double reverse = 0;
        while(x != 0){
            reverse = 10 * reverse + x % 10;
            x /= 10;
        }
        
        if(reverse > Integer.MAX_VALUE || reverse < Integer.MIN_VALUE) return 0;

        return (int)reverse;
    }
}