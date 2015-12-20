/*
LeetCode: https://leetcode.com/problems/same-tree/
LintCode: 
JiuZhang: 
ProgramCreek: http://www.programcreek.com/2012/12/check-if-two-trees-are-same-or-not/

Analysis:
Tooooo easy.
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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        
        if(p == null && q == null) return true;
        
        if((p != null && q == null) || (p == null && q != null)) return false;
        
        if(p.val != q.val) return false;
        
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}