class Solution {
    // 1. Brute Force, just scan the nums, find the peak
    /*
    Time O(N)
    Space O(1)
    */
//     public int findPeakElement(int[] nums) {
//         int result = 0;
//         if (nums == null || nums.length == 0) return 0;
//         if (nums.length == 1) return 0;
//         if (nums.length == 2) {
//             if (nums[0] == nums[1]) return -1;
//             else if (nums[0] < nums[1]) return 1;
//             else return 0;
//         }
//         int n = nums.length;
        
//         if (nums[0] > nums[1]) return 0;
//         if (nums[n - 2] < nums[n - 1]) return n - 1;
        
//         for (int i = 1; i < nums.length - 1; i++) {
//             if (nums[i - 1] < nums[i] && nums[i] > nums[i + 1]) return i;
//         }
        
//         return -1;
//     }
    
    // 2.Binary Search
    /*
    Time O(N)
    Space O(1)
    */
    // public int findPeakElement(int[] nums) {
    //     int lo = 0, hi = nums.length-1;
    //     while(lo < hi){
    //         if(lo + 1 == hi)
    //             return nums[lo] > nums[hi] ? lo : hi;
    //         int mid = lo + (hi - lo) / 2;
    //         if(nums[mid-1] < nums[mid] && nums[mid] > nums[mid+1])
    //             return mid;
    //         else if(nums[mid-1] < nums[mid] && nums[mid] < nums[mid+1])
    //             lo = mid + 1;
    //         else
    //             hi = mid - 1;
    //     }
    //     return lo;
    // }
    
    // 3.Binary Search
    /*
    Time O(N)
    Space O(1)
    */
    public int findPeakElement(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        
        while (lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;
            
            if (nums[mid - 1] < nums[mid] && nums[mid] > nums[mid + 1]) {
                return mid;
            } else if (nums[mid - 1] < nums[mid] && nums[mid] < nums[mid + 1]) {
                lo = mid;
            } else {
                hi = mid;
            }
        }
        
        return nums[lo] > nums[hi] ? lo : hi;
    }
    
    // doesn't work
//     public int findPeakElement(int[] nums) {
//         int lo = 0, hi = nums.length - 1;
        
//         while (lo <= hi) {
//             int mid = lo + (hi - lo) / 2;
            
//             if (nums[mid - 1] < nums[mid] && nums[mid] > nums[mid + 1]) {
//                 return mid;
//             } else if (nums[mid - 1] < nums[mid] && nums[mid] < nums[mid + 1]) {
//                 lo = mid + 1;
//             } else {
//                 hi = mid - 1;
//             }
//         }
        
//         return nums[lo] > nums[hi] ? lo : hi;
//     }
}
