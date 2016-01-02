/*
LeetCode: https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
LintCode: 
JiuZhang: 
ProgramCreek: http://www.programcreek.com/2014/03/two-sum-ii-input-array-is-sorted-java/

Analysis: 
*/
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        if(numbers == null || numbers.length <2) return result;
        
        int lo = 0, hi = numbers.length - 1;
        while(lo < hi){
            int sum = numbers[lo] + numbers[hi];
            if(sum == target){
                result[0] = lo + 1;
                result[1] = hi + 1;
                break;
            }
            
            if(sum > target) hi--;
            if(sum < target) lo++;
        }
        
        return result;
    }
}