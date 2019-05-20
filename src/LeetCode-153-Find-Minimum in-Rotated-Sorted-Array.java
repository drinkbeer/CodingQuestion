/*
Corner cases:
[1]
[1, 2]
[2, 1]
[3, 1, 2]
[1, 2, 3]
[5, 1, 2, 3, 4]
[2, 3, 4, 5, 1]


2.
https://leetcode.com/discuss/13389/compact-and-clean-c-solution

Analysis:
this problem should be careful about the corner case.
nums[lo] < nums[hi]  ->  nums[lo] is lowest
nums[mid] > nums[hi] ->  search in nums[mid + 1 : hi]
nums[mid] < nums[hi] ->  search in nums[lo : mid]
(It's impossible of nums[mid]==nums[hi])
*/
public class Solution {
    // 1.My own solution, Binary Search
    // public int findMin(int[] nums) {
    //     if(nums == null || nums.length == 0) return -1;
    //     if(nums.length == 1) return nums[0];
        
    //     int lo = 0, hi = nums.length - 1;
    //     while(lo <= hi){
    //         int mid = lo + (hi - lo) / 2;
    //         // [1]
    //         if(mid == lo && mid == hi) return nums[mid];
    //         // [1, 2]
    //         // if(mid == lo && hi == mid + 1 && nums[mid] < nums[hi]) return nums[mid];
    //         // [2, 1]
    //         // if(mid == lo && hi == mid + 1 && nums[mid] > nums[hi]) return nums[hi];
    //         // [3, 1, 2]
    //         if(lo < mid && mid < hi &&  nums[mid - 1] > nums[mid] && nums[mid] < nums[mid + 1]) return nums[mid];
            
    //         // if(lo < mid && mid < hi &&  nums[mid - 1] < nums[mid] && nums[mid] < nums[mid + 1]) return nums[mid];
            
    //         // [2, 3, 4, 5, 1]
    //         if(nums[mid] > nums[hi]){
    //             lo = mid + 1;
    //         // }else if(nums[mid] < nums[lo]){
    //         //     hi = mid - 1;
    //         }else{
    //             // [1, 2, 3] or [5, 1, 2, 3, 4]
    //             hi = mid - 1;
    //         }
            
    //     }
    //     return nums[lo];
    // }
    
    // 2.Binary Search (best)
//     public int findMin(int[] nums) {
//         if(nums == null || nums.length == 0) return -1;
//         if(nums.length == 1) return nums[0];
        
//         int lo = 0, hi = nums.length - 1;
//         while(lo < hi){
//             // We don't need this line, as it is included in case of "nums[mid] < nums[hi]" 
//             // if(nums[lo] < nums[hi]) return nums[lo];
            
//             int mid = lo + (hi - lo) / 2;
//             if(nums[mid] > nums[hi]){
//                 lo = mid + 1;
//             }else{
//                 hi = mid;
//             }
//         }
        
//         return nums[lo];
//     }
    
    // 3.Binary Search
    // public int findMin(int[] nums) {
    //     if(nums == null || nums.length == 0) return -1;
    //     if(nums.length == 1) return nums[0];
        
    //     int lo = 0, hi = nums.length - 1;
    //     while(lo < hi){
    //         int mid = lo + (hi - lo) / 2;
    //         if(mid > 0 && nums[mid - 1] > nums[mid]) return nums[mid];
    //         if(nums[mid] > nums[hi]){
    //             lo = mid + 1;
    //         }else{
    //             hi = mid - 1;
    //         }
    //     }
        
    //     return nums[lo];
    // }
    
    // 4.
    /*
    https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/discuss/48484/A-concise-solution-with-proof-in-the-comment
    
    
    */
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        if (nums.length == 1) return nums[0];
        
        int lo = 0, hi = nums.length - 1;
        while (lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] > nums[hi]) {
                lo = mid;
            } else {
                hi = mid;
            }
        }
        
        return Math.min(nums[lo], nums[hi]);
    }
}
