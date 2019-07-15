/*


O(N)  template for Minimum Size Subarray Sum & Minimum Window Substring & Longest Substring Without Repeating Characters:


https://leetcode.com/problems/minimum-size-subarray-sum/discuss/59110/O(N)-template-for-Minimum-Size-Subarray-Sum-and-Minimum-Window-Substring-and-Longest-Substring-Without-Repeating-Characters

Time O(N)

*/

class Solution {
    // 1. Two Pointers (Sliding Window Template)
//     public int minSubArrayLen(int s, int[] nums) {
//         int left = 0, right = 0, sum = 0, n = nums.length, res = Integer.MAX_VALUE;
//         while (right < n) {
//             sum += nums[right];
            
//             // find a subarray which has sum >= s
//             while (sum >= s && left <= right) {
//                 res = Math.min(res, right - left + 1);
//                 sum -= nums[left];
//                 left++;
//             }
//             right++;
//         }
        
//         return res == Integer.MAX_VALUE ? 0 : res;
//     }
    
    // 2. Binary Search
    /*
    
    https://leetcode.com/problems/minimum-size-subarray-sum/discuss/59103/Two-AC-solutions-in-Java-with-time-complexity-of-N-and-NLogN-with-explanation
    
    As the order of subarray matters, so we cannot sort the array. To get O(NlogN) Time Complexity, we have to get the 
    culmulative sum array.
    
    Time O(NlogN)
    */
    public int minSubArrayLen(int s, int[] nums) {
        int n = nums.length;
        int[] sum = new int[n + 1];
        for (int i = 1; i < n + 1; i++) sum[i] = sum[i - 1] + nums[i - 1];  // build culmulative sum array
        
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n + 1; i++) {
            int right = searchRight(sum, sum[i] + s, i + 1, n);  // search the right boundary between [i + 1, n]
            if (right == n + 1) break;
            min = Math.min(min, right - i);  // be careful, here is not "right - i + 1" as it's culmulative sum, not the original value, so length should not include the ith element.
        }
        
        return min == Integer.MAX_VALUE ? 0 : min;
    }
    
    /*
    Search the left-most S1 in sum array that having S1 >= target.
    */
    private int searchRight(int[] sum, int target, int lo, int hi) {
        
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (sum[mid] == target) return mid;
            else if (sum[mid] > target) hi = mid - 1;
            else lo = mid + 1;
        }
        
        return lo;
    }

}
