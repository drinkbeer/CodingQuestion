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
    
    /*
    https://leetcode.com/problems/binary-tree-maximum-path-sum/discuss/39775/Accepted-short-solution-in-Java
    */
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        fromRootToLeaf(root);
        return max;
    }
    
    private int fromRootToLeaf(TreeNode root) {
        if (root == null) return 0;
        
        int left = Math.max(0, fromRootToLeaf(root.left));
        int right = Math.max(0, fromRootToLeaf(root.right));
        
        max = Math.max(max, left + right + root.val);
        return Math.max(left, right) + root.val;
    }
}
