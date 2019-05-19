/*
LeetCode: https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
LintCode: http://www.lintcode.com/problem/remove-duplicates-from-sorted-array-ii/
JiuZhang: http://www.jiuzhang.com/solutions/remove-duplicates-from-sorted-array-ii/
ProgramCreek: http://www.programcreek.com/2013/01/leetcode-remove-duplicates-from-sorted-array-ii-java/

Analysis:
Scan from 3rd element. Just to see each curr ele and prev -1, prev
*/
public class Solution {
    // 1. Two Pointers
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
    
    // 2. One Pointer
    
    /*
    https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/discuss/27976/3-6-easy-lines-C%2B%2B-Java-Python-Ruby
    https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/discuss/27987/Short-and-Simple-Java-solution-(easy-to-understand)
    
    Smart and fast. This could also apply to LeetCode-26-Remove-Duplicates-from-Sorted-Array.java
    
    */
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) return nums.length;
        
        int curr = 0;  // the index of leftest duplicate element.
        for (int num : nums) {
            if (curr < 2 || num > nums[curr - 2]) {
                // find a non-duplicate num
                nums[curr++] = num;
            }
        }
        return curr;
    }
}
