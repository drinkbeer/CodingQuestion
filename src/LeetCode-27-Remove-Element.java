/*
LeetCode: https://leetcode.com/problems/remove-element/
LintCode: http://www.lintcode.com/problem/remove-element/
JiuZhang: http://www.jiuzhang.com/solutions/remove-element/
ProgramCreek: http://www.programcreek.com/2014/04/leetcode-remove-element-java/

Analysis: 
Solution 1.

Case 1:

[3,2,2,1] 3

i=0,curr=0, nums[0] is removable, so  keey curr to be 0, and move forward
i=1,curr=1, nums[1] is not removable, so use nums[1] to replace the nums[curr] which is removable, and move forward the curr.
i=2,curr=2, nums[2] is not removable, so use nums[2] to replace the nums[curr] which is removable, and move curr forward
i=3,curr=2, nums[3] is not removable, so just keep the curr, and move forward


[2,2,3,5] 3
*/
public class Solution {
    // 1.Using one pointer to record the last removable element
//     public int removeElement(int[] nums, int val) {
//         // Curr means the last element which are removable.
//         int curr = 0;
        
//         for (int i = 0; i < nums.length; i++) {
//             if (nums[i] != val) {
//                 nums[curr] = nums[i];
//                 curr++;
//             }
//         }
        
//         return curr;
//     }
    
    // 2.Swap the last removable element with the non-removable one
//     public int removeElement(int[] nums, int val) {
//         // Last removable element
//         int curr = 0;
        
//         for (int i = 0; i < nums.length; i++) {
//             if (nums[i] != val) {
//                 // means we discovered a non-removable element
//                 int temp = nums[curr];
//                 nums[curr] = nums[i];
//                 nums[i] = temp;
//                 curr++;
//             }
//         }
        
//         return curr;
//     }
    
    // 3.This solution process the element equals to val, like a fast-short pointer solution.
    // But we must ask if the order matters? If the order matters, we cannot do this way. Because we are replacing the removable elements with
    // elements in the tail. (The previous two solutions can keep the order.)
    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        
        for (int i = 0; i < len;) {
            if (nums[i] == val) {
                nums[i] = nums[len - 1];
                len--;
            } else {
                 i++;
            }
        }
        return len;
    }
}
