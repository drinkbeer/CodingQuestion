/*
LeetCode: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
LintCode: http://www.lintcode.com/problem/lowest-common-ancestor/
JiuZhang: http://www.jiuzhang.com/solutions/lowest-common-ancestor/
ProgramCreek: http://www.programcreek.com/2014/07/leetcode-lowest-common-ancestor-of-a-binary-tree-java/

Analysis: 
1.Divide & Conquer (Recursive)
    Find p and q's Lowest Common Ancestor in tree with root
    1.  If p or q == root, return root.
        else find LCA in left tree and right tree.
    2.  If left and right both not null(means one in left tree, one in right tree), means root is LCA.
        else if right not null, return right; if left not null, return left.
        else if both left and right are null, return null
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
    
    // 1.Divide & Conquer (Recursive)
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;

        if(root == p || root == q) return root;
        
        // Divide
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        // Conquer
        if(left != null && right != null) return root;
        if(left != null) return left;
        if(right != null) return right;
        return null;
    }
}