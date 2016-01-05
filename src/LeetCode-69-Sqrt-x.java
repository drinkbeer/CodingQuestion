/*
LeetCode: https://leetcode.com/problems/sqrtx/
LintCode: http://www.lintcode.com/problem/sqrtx/
JiuZhang: http://www.jiuzhang.com/solutions/sqrtx/
ProgramCreek: http://www.programcreek.com/2012/02/java-calculate-square-root-without-using-library-method/
Other: http://www.cnblogs.com/yuzhangcmu/p/4198959.html

Analysis: 
Binary Search
*/
public class Solution {
    public int mySqrt(int x) {
        if(x <= 1)return x;
        
        long lo = 0;
        long hi = x / 2 + 1;      // For a non-positive n, it's sqrt mustn't larger than n/2+1
        
        while(lo <= hi){
            long mid = lo + (hi - lo) / 2;

            if(x == mid * mid){
                return (int)mid;
            }
            if(x > mid * mid){
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        
        return (int)hi;
    }
}