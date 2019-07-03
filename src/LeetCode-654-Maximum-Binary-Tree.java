/*
https://github.com/drinkbeer/CodingQuestion/blob/master/cartesian-tree.md

*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    // 1. Recursively. Build Cartesian Tree
    /*
    Avg Time O(NlogN)
    Worst Time O(N^2), when the array is ascending and descending
    
    */
//     public TreeNode constructMaximumBinaryTree(int[] nums) {
//         if (nums == null || nums.length == 0) return null;
//         return build(nums, 0, nums.length - 1);
//     }
    
//     private TreeNode build(int[] nums, int s, int e) {
//         if (s > e) return null;
//         int max = -1, maxVal = Integer.MIN_VALUE;
        
//         for (int i = s; i <= e; i++) {
//             if (nums[i] > maxVal) {
//                 maxVal = nums[i];
//                 max = i;
//             }
//         }
        
//         TreeNode node = new TreeNode(nums[max]);
//         node.left = build(nums, s, max - 1);
//         node.right = build(nums, max + 1, e);
//         return node;
//     }
    
    // 2. Using a Deque based stack
    /*
    https://leetcode.com/problems/maximum-binary-tree/discuss/106156/Java-worst-case-O(N)-solution
    
    Runtime: 8 ms, faster than 14.24% of Java online submissions for Maximum Binary Tree.
    Memory Usage: 39.4 MB, less than 79.45% of Java online submissions for Maximum Binary Tree.
    
    Worst Time O(N)
    
    */
     public TreeNode constructMaximumBinaryTree(int[] nums) {
         if (nums == null || nums.length == 0) return null;
         
         Deque<TreeNode> stack = new ArrayDeque<>();
         for (int i = 0; i < nums.length; i++) {
             TreeNode curr = new TreeNode(nums[i]);
             // traverse the nodes in the stack, and find the max-smaller one than nums[i], make it to be the left node of curr
             while(!stack.isEmpty() &&  stack.peek().val < nums[i]) {
                 curr.left = stack.pop();
             }
             if (!stack.isEmpty() && stack.peek().val > nums[i]) {
                 stack.peek().right = curr;
             }
             stack.push(curr);
         }
         
         return stack.isEmpty() ? null : stack.peekLast();
     }
}
