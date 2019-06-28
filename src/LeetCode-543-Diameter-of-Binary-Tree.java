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
    // 1.
    // longest path = max depth of left child tree + max depth of right child tree + 1
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        
        int[] max = new int[] {Integer.MIN_VALUE};
        longestSinglePathFrom(root, max);
        return max[0] - 1; // if there are 4 elements in the path, then the length is 3
    }
    
    
    // The longest single path which starts from root
    private int longestSinglePathFrom(TreeNode root, int[] max) {
        if (root == null) return 0;
        
        int left = longestSinglePathFrom(root.left, max);  // the longest single path which starts from root.left
        int right = longestSinglePathFrom(root.right, max);  // the longest single path which starts from root.right
        
        // update max
        max[0] = Math.max(max[0], left + right + 1);
        
        return Math.max(left, right) + 1;
    }
    
    // 2.
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        
        int[] max = new int[] {Integer.MIN_VALUE};
        maxDepth(root, max);
        return max[0];
    }
    
    // The depth is also the number of edges 
    public int maxDepth(TreeNode root, int[] max) {
        if (root == null) return 0;
        
        int left = maxDepth(root.left, max);
        int right = maxDepth(root.right, max);
        
        max[0] = Math.max(max[0], left + right);
        
        return Math.max(left, right) + 1;
    }
}
