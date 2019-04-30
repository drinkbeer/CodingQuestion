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
//     public TreeNode upsideDownBinaryTree(TreeNode root) {
//         if(root == null || root.left == null) {
//             return root;
//         }

//         TreeNode newRoot = upsideDownBinaryTree(root.left);
//         root.left.left = root.right;   // node 2 left children
//         root.left.right = root;         // node 2 right children
//         root.left = null;
//         root.right = null;
//         return newRoot;
//     }
    
    // 2.BFS
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        TreeNode curr = root;
        TreeNode next = null;
        TreeNode temp = null;
        TreeNode prev = null;

        while(curr != null) {
            next = curr.left;

            // swapping nodes now, need temp to keep the previous right child
            curr.left = temp;
            temp = curr.right;
            curr.right = prev;

            prev = curr;
            curr = next;
        }
        return prev;
    }  
}
