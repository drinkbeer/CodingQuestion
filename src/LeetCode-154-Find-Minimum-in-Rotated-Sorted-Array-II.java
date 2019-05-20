/*
Analysis:
"154. Find Minimum in Rotated Sorted Array II" is similar to "153. Find Minimum in Rotated Sorted Array".
We can still compare nums[mid] with nums[hi]. The only difference to 153 is the case of nums[mid]==nums[hi], we cannot judge.

nums[mid] > nums[hi]  ->  search nums[mid+1, hi]
nums[mid] < nums[hi] ->  search nums[lo, mid]
nums[mid] == nums[hi], we cannot judge in which side.
[3, 1, 3, 3, 3, 3]
[3, 3, 3, 1, 2, 3]
So in this case, we can only ensure that nums[hi] is not minmum, so we just do hi--
*/
public class Solution {
    // 1.
//     public int findMin(int[] nums) {
//         if(nums == null || nums.length == 0) return -1;
//         if(nums.length == 1) return nums[0];
        
//         int lo = 0, hi = nums.length - 1;
//         while(lo < hi){
//             int mid = lo + (hi - lo) / 2;
            
//             if(nums[mid] > nums[hi]){
//                 lo = mid + 1;
//             }else if(nums[mid] < nums[hi]){
//                 hi = mid;
//             }else{
//                 hi--;
//             }
//         }
        
//         return nums[lo];
//     }
    
    // 2.
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0) return -1;
        if(nums.length == 1) return nums[0];
        
        int lo = 0, hi = nums.length - 1;
        while (lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] > nums[hi]) {
                lo = mid + 1;  // the only case is mid is in the left of the pivot
            } else if (nums[mid] < nums[hi]) {
                hi = mid;  // we are not sure if mid is the smallest or not, what we are sure is smallest is not in (mid, hi]
            } else {
                // we are not sure if mid is the smallest or not, but we are sure that hi is not smallest.
                hi--;
            }
        }
        
        return Math.min(nums[lo], nums[hi]);
    }
    
    // wrong answer
//     public int findMin(int[] nums) {
//         if(nums == null || nums.length == 0) return -1;
//         if(nums.length == 1) return nums[0];
        
//         int lo = 0, hi = nums.length - 1;
//         while (lo + 1 < hi) {
//             int mid = lo + (hi - lo) / 2;
//             if (nums[mid] < nums[lo]) {
//                 hi = mid; // the only case is mid is in the right of pivot, and we are not sure if mid is the smallest or not
//             } else if (nums[mid] > nums[lo]) {
//                 lo = mid;  // we are not sure if mid is the smallest or not
//             } else {
//                 // we are not sure if mid is the smallest or not, but we are sure that hi is not smallest.
//                 lo++;
//             }
//         }
        
//         return Math.min(nums[lo], nums[hi]);
//     }
}
