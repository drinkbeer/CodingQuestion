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
    
    public int removeDuplicates(int[] nums) {
        // The index of curr value that are under duplication testing
        int curr = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[curr] != nums[i]) {
                nums[++curr] = nums[i];
            }
        }
        
        // return the size
        return curr + 1;
    }
    
    
    // 2. One Pointer
    
    /*
    https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/discuss/27976/3-6-easy-lines-C%2B%2B-Java-Python-Ruby
    https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/discuss/27987/Short-and-Simple-Java-solution-(easy-to-understand)
    
    Smart and fast. This could also apply to LeetCode-26-Remove-Duplicates-from-Sorted-Array.java
    80. Remove Duplicates from Sorted Array II
    
    */
    public int removeDuplicates(int[] nums) {
        
        int curr = 0;
        for (int num : nums) {
            if (curr < 1 || num > nums[curr - 1]) {
                nums[curr++] = num;
            }
        }
        
        return curr;
    }    
}
