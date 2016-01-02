/*
LeetCode: https://leetcode.com/problems/rotate-array/
LintCode: http://www.lintcode.com/problem/rotate-array/
JiuZhang: http://www.jiuzhang.com/solutions/rotate-array/
ProgramCreek: http://www.programcreek.com/2015/03/rotate-array-in-java/

*/
public class Solution {
    public void rotate(int[] nums, int k) {
        if(nums == null || nums.length <= 1 || k < 1)return;
        
        k = k % nums.length;    // must ensure k <= length
        
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }
    
    private void reverse(int[] nums, int lo, int hi){
        while(lo < hi){
            int temp = nums[lo];
            nums[lo] = nums[hi];
            nums[hi] = temp;
            lo++;
            hi--;
        }
    }
}