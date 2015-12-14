/*
LeetCode: https://leetcode.com/problems/search-insert-position/
LintCode: http://www.lintcode.com/problem/search-insert-position/
JiuZhang: http://www.jiuzhang.com/solutions/search-insert-position/
ProgramCreek: http://www.programcreek.com/2013/01/leetcode-search-insert-position/

Analysis:
Find the first position >= target
*/
public class Solution {
    // Find the first position >= target
    public int searchInsert(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        
        while(lo + 1 < hi){
            int mid = lo + (hi - lo) / 2;
            if(nums[mid] == target) return mid;
            else if(nums[mid] > target) hi = mid;
            else lo = mid;
        }
        
        // get first position >= target
        if(nums[lo] >= target) return lo;
        else if(nums[hi] >= target) return hi;
        else return hi + 1;
    }
    
    // Find the first position < target, return +1. Doesn't work!!!!!!
    // public int searchInsert(int[] nums, int target) {
    //     int lo = 0, hi = nums.length - 1;
        
    //     while(lo + 1 < hi){
    //         int mid = lo + (hi - lo) / 2;
    //         if(nums[mid] == target) return mid;
    //         else if(nums[mid] > target) hi = mid;
    //         else lo = mid;
    //     }
        
    //     // get first position >= target, should + 1
    //     if(nums[lo] < target) return lo + 1;
    //     else if(nums[hi] < target) return hi + 1;
    //     else return lo + 1;
    // }
    
}