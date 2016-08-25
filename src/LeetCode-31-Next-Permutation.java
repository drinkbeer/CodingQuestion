/*
https://discuss.leetcode.com/topic/30212/easiest-java-solution/2

*/
public class Solution {
    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length == 0) return;
        int i = nums.length - 2;
        while(i >= 0 && nums[i] >= nums[i + 1]) i--;    //from right to left, find the first one violate descending
        if(i >= 0){
            int j = nums.length - 1;
            while(nums[i] >= nums[j]) j--;  //from right to left, find the first num > nums[i]
            swap(nums, i, j);
        }
        reverse(nums, i + 1, nums.length - 1);
    }
    
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    private void reverse(int[] nums, int i, int j){
        while(i < j) swap(nums, i++, j--);
    }
}