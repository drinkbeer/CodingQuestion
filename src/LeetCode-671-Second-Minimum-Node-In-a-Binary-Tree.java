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
    
    // 1. Divide & Conquer
    /*
    https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/discuss/107158/Java-divide-and-conquer-solution
    */
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) return -1;    // null node doesn't have any value, so the second minimum value is -1
        if (root.left == null && root.right == null) return -1; // the leaf only has one value, so the second minimum value is -1
        
        int left = root.left.val, right = root.right.val;
        
        if (left == root.val) {
            left = findSecondMinimumValue(root.left);
        }
        
        if (right == root.val) {
            right = findSecondMinimumValue(root.right);
        }
        
        if (left != -1 && right != -1) {
            return Math.min(left, right);
        } else if (left != -1) {
            return left;
        } else {
            return right;
        }
    }
}
