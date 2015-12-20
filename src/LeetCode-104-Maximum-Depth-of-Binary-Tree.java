/*
LeetCode: https://leetcode.com/problems/maximum-depth-of-binary-tree/
LintCode: http://www.lintcode.com/problem/maximum-depth-of-binary-tree/
JiuZhang: http://www.jiuzhang.com/solutions/maximum-depth-of-binary-tree/
ProgramCreek: 
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
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}