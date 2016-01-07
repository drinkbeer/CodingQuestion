/*
LeetCode: https://leetcode.com/problems/search-in-rotated-sorted-array/
LintCode: http://www.lintcode.com/problem/search-in-rotated-sorted-array/
JiuZhang: http://www.jiuzhang.com/solutions/search-in-rotated-sorted-array/
ProgramCreek: http://www.programcreek.com/2014/06/leetcode-search-in-rotated-sorted-array-java/

Analysis: 

*/
public class Solution {
    // 1.Iterative
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;
        if(nums.length == 1 && nums[0] == target) return 0;
        
        int len = nums.length;
        int lo = 0, hi = len - 1;
        while(lo + 1 < hi){
            int mid = lo + (hi - lo) / 2;
            
            if(nums[mid] == target) return mid;
            if(nums[mid] > nums[lo]){
                if(nums[lo] <= target && target < nums[mid]) hi = mid;
                else lo = mid;
            }else{
                if(nums[mid] < target && target <= nums[hi]) lo = mid;
                else hi = mid;
            }
        }
        
        if(nums[lo] == target) return lo;
        if(nums[hi] == target) return hi;
        return -1;
    }
    
    // 2.Recursive
}