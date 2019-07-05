/*
LeetCode: https://leetcode.com/problems/reverse-integer/
LintCode: http://www.lintcode.com/problem/reverse-integer/
JiuZhang: http://www.jiuzhang.com/solutions/reverse-integer/
ProgramCreek: http://www.programcreek.com/2012/12/leetcode-reverse-integer/
Other: http://www.cnblogs.com/yuzhangcmu/p/4162196.html

Analysis: 
This question focus on reverse may out of Integer range. So we need to set reverse as double, and judge if it is > Integer.MAX_VALUE or < Integer.MIN_VALUE, if so return 0.

Test cases:
"1534236469"    -->     "0"

*/

public class Solution {
    // not good solution
    // public int reverse(int x) {
    //     boolean isPositive = true;
    //     if(x < 0) {
    //         isPositive = false;
    //         x = -x;
    //     }
        
    //     double reverse = 0;
    //     int p = x;
        
    //     while(p > 0){
    //         reverse = p % 10 + 10 * reverse;
    //         p /= 10;
    //     }
        
    //     if(reverse > Integer.MAX_VALUE) return 0;
        
    //     if(!isPositive){
    //         reverse = -reverse;
    //     }
        
    //     return (int)reverse;
    // }
    
    
    // 2.
//     public int reverse(int x) {
//         boolean isPositive = true;
//         if (x < 0) {
//             isPositive = false;
//             x = -1 * x;
//         }
        
//         char[] chars = (x + "").toCharArray();
//         int lo = 0, hi = chars.length - 1;
//         while (lo < hi) {
//             swap(chars, lo, hi);
//             lo++;
//             hi--;
//         }
        
//         long res = 0L;
        
//         for (int i = 0; i < chars.length; i++) {
//             res = 10 * res + chars[i] - '0';
//         }
        
//         if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) return 0;
//         if (!isPositive) return -1 * (int) res;
//         return (int) res;
//     }
    
//     private void swap(char[] chars, int lo, int hi) {
//         char temp = chars[lo];
//         chars[lo] = chars[hi];
//         chars[hi] = temp;
//     }
    
    
    
    // Wrong solution, as it's possible for reverse out of integer size
    // public int reverse(int x) {
    //     int reverse = 0;
    //     while(x != 0){
    //         reverse = 10 * reverse + x % 10;
    //         x /= 10;
    //     }
    //     return reverse;
    // }
    
    // Correct solution, succinct solution
    public int reverse(int x) {
        double reverse = 0;
        while(x != 0){
            reverse = 10 * reverse + x % 10;
            x /= 10;
        }
        
        // If reverse out of Integer range, return 0
        if(reverse > Integer.MAX_VALUE || reverse < Integer.MIN_VALUE) return 0;
        
        return (int)reverse;
    }
    
    

}
