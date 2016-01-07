/*
LeetCode: https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
LintCode: http://www.lintcode.com/problem/convert-sorted-array-to-binary-search-tree/
JiuZhang: http://www.jiuzhang.com/solutions/convert-sorted-array-to-binary-search-tree/
ProgramCreek: http://www.programcreek.com/2013/01/leetcode-convert-sorted-array-to-binary-search-tree-java/

Analysis: 

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
public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length < 1) return null;
        
        return DFS(nums, 0, nums.length - 1);
    }
    
    private TreeNode DFS(int[] nums, int start, int end){
        // end condition
        if(start > end) return null;
        
        int mid = start + (end - start) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        
        node.left = DFS(nums, start, mid - 1);
        node.right = DFS(nums, mid + 1, end);
        
        return node;
    }
}