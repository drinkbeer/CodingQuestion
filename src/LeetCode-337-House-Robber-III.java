/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/*

*/
class Solution {
    // 1.DFS
    public int rob(TreeNode root) {
        if (root == null) return 0;
        return Math.max(robExclude(root), robInclude(root));
    }
    
    // The value of not rob this root.
    // If we don't rob the root, we cound or count not rob left and right, so we should use rob()
    private int robExclude(TreeNode root) {
        if (root == null) return 0;
        return rob(root.left) + rob(root.right);
    }
    
    // The value of rob this root.
    // If we ron the root, we could not rob left and right, so we use robExclude
    private int robInclude(TreeNode root) {
        if (root == null) return 0;
        return robExclude(root.left) + robExclude(root.right) + root.val;
    }
}
