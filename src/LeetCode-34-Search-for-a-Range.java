/*
LeetCode: https://leetcode.com/problems/search-for-a-range/
LintCode: http://www.lintcode.com/problem/search-for-a-range/
JiuZhang: http://www.jiuzhang.com/solutions/search-for-a-range/
ProgramCreek: http://www.programcreek.com/2014/04/leetcode-search-for-a-range-java/
Other: http://www.cnblogs.com/yuzhangcmu/p/4048001.html

Analysis: 
Binary Search
Time O(logN)
*/

public class Solution {

    
    
    // 1.Brute Force solution
    // O(N)
//     public int[] searchRange(int[] nums, int target) {
//         int[] res = new int[] {-1, -1};
//         if (nums == null || nums.length == 0) return res;
        
//         for (int i = 0; i < nums.length; i++) {
//             if (nums[i] == target) {
//                 if (res[0] == -1) {
//                     res[0] = i;
//                     res[1] = i;
//                 } else {
//                     res[1] = i;
//                 }
//             }
//         }
        
//         return res;
//     }
    
    // 2. Do two binary search
    // O(logN)
    public int[] searchRange(int[] nums, int target) {
        
        int[] result = {-1, -1};
        if(nums == null || nums.length == 0) return result;
        
        // search for low boundary
        int lo = 0, hi = nums.length - 1, mid = 0;
        while(lo + 1 < hi){
            mid = lo + (hi - lo) / 2;
            if(nums[mid] == target) hi = mid;
            else if(nums[mid] < target) lo = mid;
            else hi = mid;
        }
        if(nums[lo] == target) result[0] = lo;
        else if(nums[hi] == target) result[0] = hi;
        else return result;
        
        // search for high boundary
        lo = 0;
        hi = nums.length - 1;
        while(lo + 1 < hi){
            mid = lo + (hi - lo) / 2;
            if(nums[mid] == target) lo = mid;
            else if(nums[mid] > target) hi = mid;
            else lo = mid;
        }
        if(nums[hi] == target) result[1] = hi;
        else if(nums[lo] == target) result[1] = lo;
        else return result;
        
        return result;
    }

}
