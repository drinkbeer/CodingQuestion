/*
LeetCode: https://leetcode.com/problems/remove-element/
LintCode: http://www.lintcode.com/problem/remove-element/
JiuZhang: http://www.jiuzhang.com/solutions/remove-element/
ProgramCreek: http://www.programcreek.com/2014/04/leetcode-remove-element-java/

Analysis: 

*/
public class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0;      //pointer to the element before removing
        int j = 0;      //pointer to the element after removing
        
        while(i != nums.length){
            if(nums[i] != val){
                nums[j] = nums[i];
                j++;
            }
            i++;
        }
        
        return j;
    }
}