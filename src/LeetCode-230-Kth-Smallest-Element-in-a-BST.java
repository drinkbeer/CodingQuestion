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
    // 1. Inorder Traversal using Stack
//     public int kthSmallest(TreeNode root, int k) {
        
//         Stack<TreeNode> stack = new Stack<>();
//         TreeNode curr = root;
//         int count = 0;
//         while (curr != null || !stack.isEmpty()) {
//             if (curr != null) {
//                 stack.push(curr);
//                 curr = curr.left;
//             } else {
//                 curr = stack.pop();
                
//                 count++;
//                 if (count == k) {
//                     return curr.val;
//                 }
                
//                 curr = curr.right;
//             }
//         }
        
//         return -1;
//     }
    
    // 2.Inorder Traversal recursively
    /*
    https://leetcode.com/problems/kth-smallest-element-in-a-bst/discuss/63783/Two-Easiest-In-Order-Traverse-(Java)
    */
//     int count = 0, res = Integer.MAX_VALUE;
//     public int kthSmallest(TreeNode root, int k) {
//         recursive(root, k);
//         return res;
//     }
    
//     private void recursive(TreeNode root, int k) {
//         if (root.left != null) recursive(root.left, k);
//         count++;
//         if (count == k) {
//             res = root.val;
//         }
//         if (root.right != null) recursive(root.right, k);
//     }
    
    // 3. Divide and Conquer
    /*
    https://leetcode.com/problems/kth-smallest-element-in-a-bst/discuss/63660/3-ways-implemented-in-JAVA-(Python)%3A-Binary-Search-in-order-iterative-and-recursive
    
    Best: O(N) 
    Worst: O(N^2)
    */
    public int kthSmallest(TreeNode root, int k) {
        
        int left = countNodes(root.left);
        if (left >= k) {
            // kth smallest node is in left tree
            return kthSmallest(root.left, k);
        } else if (left + 1 < k) {
            // kth smallest node is in right tree
            return kthSmallest(root.right, k - 1 - left);   // 1 is counted as current node
        }
        return root.val;
    }
    
    private int countNodes(TreeNode root) {
        if (root == null) return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
