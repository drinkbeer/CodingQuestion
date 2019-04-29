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
    // 1.DFS
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        
        return sumNumbers(root, 0);
    }
    
    public int sumNumbers(TreeNode root, int sum) {
        if (root == null) return 0;
        
        sum = 10 * sum + root.val;
        if (root.left == null && root.right == null) return sum;
        
        return sumNumbers(root.left, sum) + sumNumbers(root.right, sum);
    }
    
    // 2.BFS (similar to level order traversal, using a queue or stack)
    // https://leetcode.com/problems/sum-root-to-leaf-numbers/discuss/41367/Non-recursive-preorder-traverse-Java-solution
}
