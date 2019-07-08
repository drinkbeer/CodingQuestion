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

    // 1. Recursive
//     public TreeNode upsideDownBinaryTree(TreeNode root) {
//         if (root == null || root.left == null) return root;
        
//         TreeNode newRoot = upsideDownBinaryTree(root.left);
//         root.left.left = root.right;
//         root.left.right = root;
//         root.left = null;
//         root.right = null;
        
//         return newRoot;
//     }
    
    // 2.Iterative
    /*
    The idea is the move the tree down to its left child.
    Record prev node, and prev node's right child.
    
    curr.left = prev node's right child
    curr.right = prev
    */
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root, prev = null, prevRight = null;
        
        while(curr != null) {
            TreeNode nextLeft = curr.left;
            
            // swapping nodes now
            curr.left = prevRight;
            prevRight = curr.right;
            curr.right = prev;
            
            // move to next left node
            prev = curr;
            curr = nextLeft;
        }
        
        return prev;
    }
}
