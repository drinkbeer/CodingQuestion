/*
LeetCode: https://leetcode.com/problems/first-bad-version/
LintCode: http://www.lintcode.com/problem/first-bad-version/
JiuZhang: http://www.jiuzhang.com/solutions/first-bad-version/
ProgramCreek: not find
Other: http://www.cnblogs.com/yuzhangcmu/p/4161837.html

Analysis: 
Binary Search 
Time O(logN)
*/
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    // // 1.Binary Search
    // public int firstBadVersion(int n) {
    //     if(n == 0) return 0;
    //     if(n == 1) if(isBadVersion(n)) return n;
        
    //     int lo = 1, hi = n;
    //     while(lo + 1 < hi){
    //         int mid = lo + (hi - lo) / 2;
    //         if(isBadVersion(mid)) hi = mid;
    //         else lo = mid;
    //     }
        
    //     if(isBadVersion(lo)) return lo;
    //     return hi;
    // }
    
    // 2.Binary Search(simpler)
    public int firstBadVersion(int n) {
        if(n == 0) return 0;
        if(n == 1) if(isBadVersion(n)) return n;
        
        int lo = 1, hi = n;
        while(lo < hi){
            int mid = lo + (hi - lo) / 2;
            if(isBadVersion(mid)) hi = mid;
            else lo = mid + 1;      //here lo = mid + 1
        }
        
        return hi;
    }
    
}