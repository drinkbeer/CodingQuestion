
class Solution {
    // 1. Binary Search + Two Pointers
    /*
    Binary Search: O(logN)
    Scan: O(N)
    
    Overall Time: O(N)
    
    */
//     public int[] sortedSquares(int[] nums) {
        
//         int l = binarySearch(nums), r = l + 1;
        
//         int[] res = new int[nums.length];
//         int cnt = 0;
//         while (l >= 0 || r <= nums.length - 1) {
//             int lv = Integer.MAX_VALUE, lr = Integer.MAX_VALUE;
//             if (l >= 0) {
//                 lv = nums[l] * nums[l];
//             }
            
//             if (r <= nums.length - 1) {
//                 lr = nums[r] * nums[r];
//             }
            
//             if (lv < lr) {
//                 res[cnt++] = lv;
//                 l--;
//             } else {
//                 res[cnt++] = lr;
//                 r++;
//             }
//         }
        
//         return res;
//     }
    
//     // search the right most idx, has nums[idx] < 0
//     private int binarySearch(int[] nums) {
//         int lo = 0, hi = nums.length - 1;
//         while (lo + 1 < hi) {
//             int mid = lo + (hi - lo) / 2;
//             if (nums[mid] >= 0) {
//                 hi = mid;
//             } else {
//                 lo = mid;
//             }
//         }
        
//         if (nums[hi] < 0) return hi;
//         return lo;
//     }
    
    // 2. Two Pointers
    /*
    Scan from two edges to middle.
    Time O(N)
    */
    public int[] sortedSquares(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        
        int[] res = new int[nums.length];
        int cnt = nums.length - 1;
        while (lo <= hi) {
            if (Math.abs(nums[lo]) < Math.abs(nums[hi])) {
                res[cnt--] = nums[hi] * nums[hi];
                hi--;
            } else {
                res[cnt--] = nums[lo] * nums[lo];
                lo++;
            }
        }
        return res;
    }
}
