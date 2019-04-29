/*
LeetCode: https://leetcode.com/problems/balanced-binary-tree/
LintCode: http://www.lintcode.com/problem/balanced-binary-tree/
JiuZhang: http://www.jiuzhang.com/solutions/balanced-binary-tree/
ProgramCreek: http://www.programcreek.com/2013/02/leetcode-balanced-binary-tree-java/

Analysis: 
Balanced Binary Search Tree: (height: maximum # of levels below root)
    An empty tree is height-balanced. A non-empty binary tree T is balanced if:
    1) Left subtree of T is balanced
    2) Right subtree of T is balanced
    3) The difference between heights of left subtree and right subtree is not more than 1.
    
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


class Solution {
    // DFS
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        if (root.left == null && root.right == null) return true;
        
        if (Math.abs(getHeight(root.left) - getHeight(root.right)) > 1) return false;
        
        return isBalanced(root.left) && isBalanced(root.right);
    }
    
    // Helper function to get the height of a tree
    private int getHeight(TreeNode node) {
        if (node == null) return 0;
        
        return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }
}
