/*
LeetCode: https://leetcode.com/problems/remove-duplicates-from-sorted-array/
LintCode: http://www.lintcode.com/problem/remove-duplicates-from-sorted-array/
JiuZhang: http://www.jiuzhang.com/solutions/remove-duplicates-from-sorted-array/
ProgramCreek: http://www.programcreek.com/2013/01/leetcode-remove-duplicates-from-sorted-array-java/

Analysis: 

*/
public class Solution {
    // public int removeDuplicates(int[] nums) {
        
    //     int result = 0;
    //     if(nums == null || nums.length == 0) return result;
    //     if(nums.length == 1) return 1;
        
    //     int slow = 0, fast = 1, n = nums.length;
    //     nums[result] = nums[slow];
    //     result++;   // for index 0
    //     while(fast < n){
    //         if(nums[slow] != nums[fast]) {
    //             nums[result] = nums[fast];
    //             result++;
    //             slow = fast;
    //         }
    //         fast++;
    //     }
        
    //     return result;
    // }
    
    
    public int removeDuplicates(int[] A) {
        if (A == null || A.length == 0) return 0;
        
        int size = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] != A[size]) {
                A[++size] = A[i];
            }
        }
        return size + 1;
    }
}