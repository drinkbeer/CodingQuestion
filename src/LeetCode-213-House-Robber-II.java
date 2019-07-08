/*
https://leetcode.com/discuss/36544/simple-ac-solution-in-java-in-o-n-with-explanation

*/
public class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        
        return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
    }
    
    private int rob(int[] nums, int start, int end){
        int prevNo = 0, prevYes = nums[start];
        
        for(int i = start + 1; i <= end; i++){
            int temp = prevNo;
            prevNo = Math.max(prevNo, prevYes);
            prevYes = temp + nums[i];
        }
        
        return Math.max(prevNo, prevYes);
    }
}
