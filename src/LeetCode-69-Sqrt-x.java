/*
LeetCode: https://leetcode.com/problems/sqrtx/
LintCode: http://www.lintcode.com/problem/sqrtx/
JiuZhang: http://www.jiuzhang.com/solutions/sqrtx/
ProgramCreek: http://www.programcreek.com/2012/02/java-calculate-square-root-without-using-library-method/
Other: http://www.cnblogs.com/yuzhangcmu/p/4198959.html

Analysis: 
Binary Search: search the largest mid value that has mid * mid <= x
*/
class Solution {
    
    // 1. Binary Search (allow overlapping)
    public int mySqrt(int x) {
        if (x <= 1) return x;
        
        long lo = 1, hi = x / 2;
        while (lo <= hi) {
            long mid = lo + (hi - lo) / 2;
            
            if (mid * mid == x) return (int) mid;
            if (mid * mid < x) {
                lo = mid + 1;
            }
            else {
                hi = mid - 1;
            }
        }
        
        return (int) hi;
    }
    
    // 2.Binary Search (don't allow overlapping)
//     public int mySqrt(int x) {
//         if (x == 1) return 1;
        
//         long lo = 1, hi = x / 2;
//         while (lo + 1 < hi) {
//             long mid = lo + (hi - lo) / 2;
            
//             if (mid * mid == x) return (int) mid;
//             if (mid * mid < x) {
//                 lo = mid;
//             } else {
//                 hi = mid;
//             }
//         }
        
//         if (hi * hi <= x) return (int) hi;
//         return (int) lo;
//     }
}
