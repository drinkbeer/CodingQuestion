
/*
LeetCode:  https://leetcode.com/problems/move-zeroes/
LintCode:  not
JiuZhang:  not
ProgramCreek: not
GFG: http://www.geeksforgeeks.org/move-zeroes-end-array/

Analysis:  

*/
public class Solution {
    // public void moveZeroes(int[] nums) {
    //     if(nums == null || nums.length == 0) return;
        
    //     int zero = 0;
    //     int nonZero = 0;
    //     while(zero < nums.length && nonZero < nums.length){
    //         while(zero < nums.length && nums[zero] != 0) zero++;
    //         nonZero = zero;
    //         while(nonZero < nums.length && nums[nonZero] == 0) nonZero++;
    //         if(zero > nonZero || zero >= nums.length || nonZero >= nums.length) break;
            
    //         int temp = nums[zero];
    //         nums[zero] = nums[nonZero];
    //         nums[nonZero] = temp;
    //         zero++;
    //         nonZero++;
    //     }
    // }
    
     public void moveZeroes(int[] nums) {
         if(nums == null || nums.length == 0) return;
         
         int count = 0; // index of non-zero element
         
         for(int i = 0; i < nums.length; i++){
             if(nums[i] != 0) nums[count++] = nums[i];
         }
         
         while(count < nums.length) nums[count++] = 0;
     }
}