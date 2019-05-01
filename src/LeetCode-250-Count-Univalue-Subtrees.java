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
    public int countUnivalSubtrees(TreeNode root) {
        if (root == null) return 0;
        
        int[] count = new int[1];
        countUnivalSubtrees(root, root.val, count);
        return count[0];
    }
    
    private boolean countUnivalSubtrees(TreeNode root, int val, int[] count) {
        if (root == null) return true;
        
        boolean l = countUnivalSubtrees(root.left, val, count);
        boolean r = countUnivalSubtrees(root.right, val, count);
        
        /*
        The requirements for a tree to be a Univ Tree:
            1.Left subtree is Univ Tree
            2.Right subtree is Univ Tree
            3.left child is null or left node val is equal to root val
            4.right child is null or right node val is equal to root val
        */
        if (l && r 
            && (root.left == null || root.val == root.left.val) 
            && (root.right == null || root.val == root.right.val)) {
            count[0]++;
            return true;
        }
        return false;
    }
}
