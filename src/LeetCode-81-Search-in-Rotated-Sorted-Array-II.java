/*
LeetCode: https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
LintCode: http://www.lintcode.com/problem/search-in-rotated-sorted-array-ii/
JiuZhang: http://www.jiuzhang.com/solutions/search-in-rotated-sorted-array-ii/
ProgramCreek: http://www.programcreek.com/2014/06/leetcode-search-in-rotated-sorted-array-ii-java/

Analysis: 

*/
public class Solution {
    // public boolean search(int[] nums, int target) {
    //     if(nums == null || nums.length == 0) return false;
        
    //     for(int i = 0; i < nums.length; i++){
    //         if(nums[i] == target) return true;
    //     }
        
    //     return false;
    // }
    
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
}
