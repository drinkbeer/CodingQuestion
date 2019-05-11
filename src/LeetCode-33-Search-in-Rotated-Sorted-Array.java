/*
LeetCode: https://leetcode.com/problems/search-in-rotated-sorted-array/
LintCode: http://www.lintcode.com/problem/search-in-rotated-sorted-array/
JiuZhang: http://www.jiuzhang.com/solutions/search-in-rotated-sorted-array/
ProgramCreek: http://www.programcreek.com/2014/06/leetcode-search-in-rotated-sorted-array-java/

Analysis: 

*/
public class Solution {
    // 1.Iterative(Similar to JiuZhang's solution)
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1; 
        int lo = 0, hi = nums.length - 1;
        
        while (lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;
            
            if (nums[mid] == target) {
                return mid;
            }
            
            if (nums[mid] > nums[0]) {
                // means mid is in the left side of pivot
                if (nums[lo] <= target && target < nums[mid]) {
                    // means target is between lo and mid
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else {
                // means mid is in the right side of pivot
                if (nums[mid] < target && target <= nums[hi]) {
                    // means target is between mid and hi
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }
        
        if (nums[lo] == target) return lo;
        if (nums[hi] == target) return hi;
        
        return -1;
    }
    
    // 2.Iterative(From myself)
    // public int search(int[] nums, int target) {
    //     if(nums == null || nums.length == 0) return -1;
    //     if(nums.length == 1 && nums[0] == target) return 0;
        
    //     int len = nums.length;
    //     int lo = 0, hi = len - 1;
        
    //     while(lo <= hi){
    //         int mid = lo + (hi - lo) / 2;
            
    //         if(nums[mid] == target) return mid;
    //         if(nums[mid] >= nums[lo]){  // be careful, here it's possible nums[lo]==nums[mid]
    //             if(nums[lo] <= target && target < nums[mid]) hi = mid - 1;
    //             else lo = mid + 1;
    //         }else{
    //             if(nums[mid] < target && target <= nums[hi]) lo = mid + 1;
    //             else hi = mid - 1;
    //         }
    //     }
    //     return -1;
    // }
    
    // 3.Recursive
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;
        if(nums.length == 1 && nums[0] == target) return 0;
        
        return search(nums, target, 0, nums.length - 1);
    }
    
    private int search(int[] nums, int target, int lo, int hi){
        if(nums[lo] == target) return lo;
        if(nums[hi] == target) return hi;
        if(lo + 1 >= hi) return -1;
        
        int mid = lo + (hi - lo) / 2;
        if(nums[mid] == target) return mid;
        if(nums[mid] > nums[lo]){
            if(nums[lo] <= target && target < nums[mid]) return search(nums, target, lo, mid);
            else return search(nums, target, mid, hi);
        }else{
            if(nums[mid] < target && target <= nums[hi]) return search(nums, target, mid, hi);
            else return search(nums, target, lo, mid);
        }
    }
    
    // 4.Recursive
    // public int search(int[] nums, int target) {
    //     if(nums == null || nums.length == 0) return -1;
    //     if(nums.length == 1 && nums[0] == target) return 0;
        
    //     return search(nums, target, 0, nums.length - 1);
    // }
    
    // private int search(int[] nums, int target, int lo, int hi){
    //     if(lo > hi) return -1;
        
    //     int mid = lo + (hi - lo) / 2;
    //     if(nums[mid] == target) return mid;
    //     if(nums[mid] >= nums[lo]){
    //         if(nums[lo] <= target && target < nums[mid]) return search(nums, target, lo, mid - 1);
    //         else return search(nums, target, mid + 1, hi);
    //     }else{
    //         if(nums[mid] < target && target <= nums[hi]) return search(nums, target, mid + 1, hi);
    //         else return search(nums, target, lo, mid - 1);
    //     }
    // }
}
