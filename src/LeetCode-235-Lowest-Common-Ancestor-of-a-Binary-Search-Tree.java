/*
LeetCode: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
LintCode: 
JiuZhang: 
ProgramCreek: http://www.programcreek.com/2014/07/leetcode-lowest-common-ancestor-of-a-binary-search-tree-java/

Analysis: 
1.Recursive(not so refinement)

2.Recursive(Using BST property)
This problem can be solved by using BST property, i.e., left < parent < right for each node.
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
    // 1.Recursive(not so refinement)
    // public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    //     if(root == null || p == root || q == root) return root;
        
    //     TreeNode left = lowestCommonAncestor(root.left, p, q);
    //     TreeNode right = lowestCommonAncestor(root.right, p, q);
        
    //     if(left != null && right != null) return root;
    //     if(left != null) return left;
    //     if(right != null) return right;
    //     return null;
    // }
    
    // 2.Recursive(Using BST property)
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || p == root || q == root) return root;
        
        if(root.val < p.val && root.val < q.val) return lowestCommonAncestor(root.right, p, q);
        else if(root.val > p.val && root.val > q.val) return lowestCommonAncestor(root.left, p, q);
        return root;
    }
}