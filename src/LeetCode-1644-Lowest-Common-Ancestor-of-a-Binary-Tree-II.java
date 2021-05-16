
/*
https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree-ii/discuss/933835/Java.-Difference-from-236-is-you-need-to-search-the-entire-tree.

The major difference between LC236 and LC1644 are:
1. It is NOT guaranteed that both p and q are in the tree.
2. A node can still be a descendant of itself.

So we need
1. We need a way to record if we've seen both p and q
2. We need to traverse the entire tree even after we've found one of them.


Time Complexity: O(N)
Space Complexity: O(H), H is the height of the tree

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
class Solution {
    int count = 0;
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode res = dfs(root, p, q);
        return count == 2 ? res : null;
    }
    
    private TreeNode dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return root;
        
        TreeNode left = dfs(root.left, p, q);
        TreeNode right = dfs(root.right, p, q);
        // must calling left and right to get deeper into tree to continue search
        // cannot directly return
        
        if (root == p || root == q) {
            count++;    // need this for (5,10) and (5,4) case
            return root;
        }
        
        return left != null && right != null ? root : left != null ? left : right;
    }
}
