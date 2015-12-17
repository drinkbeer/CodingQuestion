/*
LeetCode: https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
LintCode: http://www.lintcode.com/problem/remove-duplicates-from-sorted-array-ii/
JiuZhang: http://www.jiuzhang.com/solutions/remove-duplicates-from-sorted-array-ii/
ProgramCreek: http://www.programcreek.com/2013/01/leetcode-remove-duplicates-from-sorted-array-ii-java/

Analysis:
Scan from 3rd element. Just to see each curr ele and prev -1, prev
*/
public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums == null) return 0;
        if(nums.length <= 2) return nums.length;
        
        int prev = 1, curr = 2;     //scan from the third element (curr)
        
        while(curr < nums.length){
            if(nums[prev - 1] == nums[curr] && nums[prev] == nums[curr]){
                curr++;
                continue;
            }
            
            prev++;
            nums[prev] = nums[curr];
            curr++;
        }
        
        return prev + 1;
    }
}