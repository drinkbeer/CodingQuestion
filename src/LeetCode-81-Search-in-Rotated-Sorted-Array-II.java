/*
LeetCode: https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
LintCode: http://www.lintcode.com/problem/search-in-rotated-sorted-array-ii/
JiuZhang: http://www.jiuzhang.com/solutions/search-in-rotated-sorted-array-ii/
ProgramCreek: http://www.programcreek.com/2014/06/leetcode-search-in-rotated-sorted-array-ii-java/

Analysis: 

*/
public class Solution {
    public boolean search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return false;
        
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == target) return true;
        }
        
        return false;
    }
}