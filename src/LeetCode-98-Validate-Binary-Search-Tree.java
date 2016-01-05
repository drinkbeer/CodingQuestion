/*
LeetCode: 
LintCode: http://www.lintcode.com/problem/validate-binary-search-tree/
JiuZhang: http://www.jiuzhang.com/solutions/validate-binary-search-tree/
ProgramCreek: http://www.programcreek.com/2012/12/leetcode-validate-binary-search-tree-java/
Other: http://www.cnblogs.com/yuzhangcmu/p/4177047.html

Analysis: 4 solutions
1.Recursive

2.Iterative(not finish)


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
    public boolean isValidBST(TreeNode root) {
        // Double.MIN_VALUE: A constant holding the smallest positive nonzero value of type double, 2-1074.
        // Double.MAX_VALUE: A constant holding the largest positive finite value of type double, (2-2-52)·21023.
        // So here we cannot use Double.MIN_VALUE and Double.MAX_VALUE
        // return isValidBST(root, Double.MIN_VALUE, Double.MAX_VALUE);
        return isValidBST(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
    }
    
    private boolean isValidBST(TreeNode root, double min, double max){
        if(root == null) return true;
        
        if(root.val >= max || root.val <= min) return false;
        
        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }
}