/*
LeetCode: https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
LintCode: http://www.lintcode.com/problem/search-in-rotated-sorted-array-ii/
JiuZhang: http://www.jiuzhang.com/solutions/search-in-rotated-sorted-array-ii/
ProgramCreek: http://www.programcreek.com/2014/06/leetcode-search-in-rotated-sorted-array-ii-java/

Analysis: 

*/
public class Solution {
    
    public boolean search(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
     
        while(left<=right){
            int mid = (left+right)/2;
            if(nums[mid]==target)
                return true;
     
            if(nums[left]<nums[mid]){
                if(nums[left]<=target&& target<nums[mid]){
                    right=mid-1;
                }else{
                    left=mid+1;
                }
            }else if(nums[left]>nums[mid]){
                if(nums[mid]<target&&target<=nums[right]){
                    left=mid+1;
                }else{
                    right=mid-1;
                }
            }else{
                left++;
            }    
        }
     
        return false;
    }
    
    // https://leetcode.com/problems/search-in-rotated-sorted-array-ii/discuss/28216/Java-1ms-binary-search-solution-with-comments
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return false;
        
        int lo = 0, hi = nums.length - 1;
        while (lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) return true;
            
            if (nums[mid] > nums[lo]) {
                // which means mid is in the left side of pivot
                if (nums[lo] <= target && target < nums[mid]) {
                    // target is between [lo, mid)
                    hi = mid - 1;   
                } else {
                    lo = mid + 1;
                }
            } else if (nums[mid] < nums[lo]) {
                // which means mid is in the right side of pivot
                if (nums[mid] < target && target <= nums[hi]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            } else {
                // when nums[lo] == nums[mid], we just move the lo pointer to right
                // // have no idea about the array, but we can exclude nums[start] because nums[start] == nums[mid]
                lo++;
            }
        }
        
        if (nums[lo] == target) return true;
        if (nums[hi] == target) return true;
        
        return false;
    }
}
