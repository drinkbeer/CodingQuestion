/*
LeetCode: https://leetcode.com/problems/sort-colors/
LintCode: http://www.lintcode.com/problem/sort-colors/
JiuZhang: http://www.jiuzhang.com/solutions/sort-colors/
ProgramCreek: http://www.programcreek.com/2014/06/leetcode-sort-colors-java/

Analysis:
Use two pointers, one is the 0 area's right bound+1, another is 1 area's left bound-1.
*/
public class Solution {
    
    // 1. Counting Sort Time O(N)
    public void sortColors(int[] nums) {
        int countZero = 0, countOne = 0, countTwo = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) countZero++;
            if (nums[i] == 1) countOne++;
            if (nums[i] == 2) countTwo++;
        }
        
        for (int i = 0; i < countZero; i++) nums[i] = 0;
        for (int i = 0; i < countOne; i++) nums[i + countZero] = 1;
        for (int i = 0; i < countTwo; i++) nums[i + countZero + countOne] = 2;
    }
    
    // 2. Two Pointers
    public void sortColors(int[] nums) {
        if(nums == null || nums.length <= 1) return;
        // left is the 0's right bound+1, right is 1's left bound-1
        int left = 0, right = nums.length - 1;
        
        int i = 0;
        while(i <= right){
            // When nums[i]==0, we swap with left. As in pos left, we have already checked it's value, so we need i++
            if(nums[i] == 0){
                if(i != left) swap(nums, left, i);
                i++;
                left++;
            }else if(nums[i] == 1){
                i++;
            }else{
                // When nums[i]==2, we swap to right. But in pos right, we haven't checked it's value, so we cannot i++
                swap(nums, i, right);
                right--;
            }
        }
    }
    
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
