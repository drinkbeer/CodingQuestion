/*
LeetCode: https://leetcode.com/problems/balanced-binary-tree/
LintCode: http://www.lintcode.com/problem/balanced-binary-tree/
JiuZhang: http://www.jiuzhang.com/solutions/balanced-binary-tree/
ProgramCreek: http://www.programcreek.com/2013/02/leetcode-balanced-binary-tree-java/

Analysis: 
get height, height = Math.max(left, right), if Math.abs(left - right) > 1, return -1
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
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        
        if(getHeight(root) == -1) return false;
        
        return true;
    }
    
    private int getHeight(TreeNode root){
        if(root == null) return 0;
        
        int l = getHeight(root.left);
        int r = getHeight(root.right);
        
        if(l == -1 || r == -1 || Math.abs(l - r) > 1) return -1;
        
        return Math.max(l, r) + 1;
    }
}