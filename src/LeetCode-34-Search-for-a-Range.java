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
class Solution {
    // 1.Brute Force solution
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
//     public int[] searchRange(int[] nums, int target) {
//         int[] res = new int[] {-1, -1};
//         if (nums == null || nums.length == 0) return res;
        
//         // search the lower boundary
//         int lo = 0, hi = nums.length - 1;
//         while (lo + 1 < hi) {
//             int mid = lo + (hi - lo) / 2;
            
//             if (nums[mid] == target) hi = mid;
//             else if (nums[mid] > target) hi = mid - 1;
//             else lo = mid + 1;
//         }
//         if (nums[lo] == target) res[0] = lo;
//         else if (nums[hi] == target) res[0] = hi;
//         else return res;
        
//         // search the higher boundary
//         lo = 0;
//         hi = nums.length - 1;
//         while (lo + 1 < hi) {
//             int mid = lo + (hi - lo) / 2;
            
//             if (nums[mid] == target) lo = mid;
//             else if (nums[mid] > target) hi = mid - 1;
//             else lo = mid + 1;
//         }
//         if (nums[hi] == target) res[1] = hi;
//         else if (nums[lo] == target) res[1] = lo;
//         else return res;
        
//         return res;
//     }
    
    // Two Binary Search (Best Solution)
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[] {-1, -1};
        if (nums == null || nums.length == 0) return res;
        if (nums.length == 1) {
            if (nums[0] == target) return new int[] {0, 0};
            return res;
        }
    
        // search the lower boundary
        int lo = 0, hi = nums.length - 1;
        while (lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) hi = mid;
            else if (nums[mid] > target) hi = mid;
            else lo = mid;
        }
        if (nums[lo] == target) res[0] = lo;
        else if (nums[hi] == target) res[0] = hi;
        
        // search the higher boundary
        lo = 0;
        hi = nums.length - 1;
        while (lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) lo = mid;
            else if (nums[mid] < target) lo = mid;
            else hi = mid;
        }
        if (nums[hi] == target) res[1] = hi;
        else if (nums[lo] == target) res[1] = lo;
        
        return res;
    }
    
    // wrong answer, difficult to process the boundary value
//     public int[] searchRange(int[] nums, int target) {
//         int[] res = new int[] {-1, -1};
//         if (nums == null || nums.length == 0) return res;
//         if (nums.length == 1) {
//             if (nums[0] == target) return new int[] {0, 0};
//             return res;
//         }
    
//         // search the lower boundary
//         int lo = 0, hi = nums.length - 1;
//         while (lo <= hi) {
//             int mid = lo + (hi - lo) / 2;
//             if (nums[mid] == target) hi = mid - 1;
//             else if (nums[mid] > target) hi = mid - 1;
//             else lo = mid + 1;
//         }
//         if (nums[lo] == target) res[0] = lo;
        
//         // search the higher boundary
//         lo = 0;
//         hi = nums.length - 1;
//         while (lo <= hi) {
//             int mid = lo + (hi - lo) / 2;
//             if (nums[mid] == target) lo = mid + 1;
//             else if (nums[mid] < target) lo = mid + 1;
//             else hi = mid - 1;
//         }
//         if (nums[hi] == target) res[1] = hi;
        
//         return res;
//     }
    
    

}
