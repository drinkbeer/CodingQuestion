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
//     public TreeNode deleteNode(TreeNode root, int key) {
//         if (root == null) return null;
        
//         if (root.val > key) {
//             // key is in left tree
//             root.left = deleteNode(root.left, key);
//         } else if (root.val < key) {
//             // key is in the right tree
//             root.right = deleteNode(root.right, key);
//         } else {
//             // this root node is the node we want to delete.
            
//             if (root.left == null && root.right == null) {
//                 // root is a leaf, to delete a leaf, just set it to be null
//                 root = null;
//             } else if (root.right != null) {
//                 // find the successor in the right tree
//                 root.val = successor(root);
//                 root.right = deleteNode(root.right, root.val); // delete the root with new val in the right tree
//             } else {
//                 // find the predecessor in the left tree
//                 root.val = predecessor(root);
//                 root.left = deleteNode(root.left, root.val);
//             }
//         }
//         return root;
//     }
    
//     private int successor(TreeNode root) {
//         root = root.right;
//         while (root.left != null) root = root.left;
//         return root.val;
//     }
    
//     private int predecessor(TreeNode root) {
//         root = root.left;
//         while(root.right != null) root = root.right;
//         return root.val;
//     }
    
    // 2.DFS but a bit simpler
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        
        if (root.val > key) {
            // key is in left tree
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            // key is in right tree
            root.right = deleteNode(root.right, key);
        } else {
            // root.val == key, this root node is the one we want to find
            
            if (root.left == null) {
                // using root.right to replace root node
                root = root.right;
            } else if (root.right == null) {
                // using root.left to replace root node
                root = root.left;
            } else {
                // means root.left != null and root.right != null
                // then find the leftmost node in right tree to replace this root
                TreeNode minNodeInTree = findMinNodeInTree(root.right);
                root.val = minNodeInTree.val;
                root.right = deleteNode(root.right, minNodeInTree.val); // as we already using the minNodeInTree to replace the root, we should delete the minNodeInTree in right tree, and use the node returned to replace the original right node
            }
        }
        return root;
    }
    
    private TreeNode findMinNodeInTree(TreeNode root) {
        if (root.left == null) {
            return root;
        }
        return findMinNodeInTree(root.left);
    }
    
}
   
