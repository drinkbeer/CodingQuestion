/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    /*
    Space: O(N)
    Time: O(N)

    https://leetcode.com/problems/recover-binary-search-tree/discuss/32535/No-Fancy-Algorithm-just-Simple-and-Powerful-In-Order-Traversal

    In-order traversal: 6, 3, 4, 5, 2

    first = 6
    second = 2
    swap(first, second)
    */
//     public void recoverTree(TreeNode root) {
//         if (root == null) return;
        
//         TreeNode curr = root;
//         TreeNode firstElement = null, secondElement = null, prev = null;
//         Stack<TreeNode> stack = new Stack<>();
//         while (curr != null || !stack.isEmpty()) {
//             if (curr != null) {
//                 stack.push(curr);
//                 curr = curr.left;
//             } else {
//                 curr = stack.pop();
                
//                 if (prev != null && firstElement == null && prev.val > curr.val) {
//                     firstElement = prev;
//                 }
                
//                 if (prev != null && firstElement != null && prev.val > curr.val) {
//                     secondElement = curr;
//                 }
                
//                 prev = curr;
//                 curr = curr.right;
//             }
//         }
        
//         // swap the value of first and second element
//         int temp = firstElement.val;
//         firstElement.val = secondElement.val;
//         secondElement.val = temp;
//     }
    
    /*
    Morris Traversal
    
    Space: O(1)
    Time: O(N)
    */
    public void recoverTree(TreeNode root) {
        if (root == null) return;
        
        TreeNode curr = root;
        TreeNode prev = null, firstElement = null, secondElement = null;
        while (curr != null) {
            if (curr.left == null) {
                if (prev != null && firstElement == null && prev.val > curr.val) {
                    firstElement = prev;
                }
                if (prev != null && firstElement != null && prev.val > curr.val) {
                    secondElement = curr;
                }
                prev = curr;
                curr = curr.right;
            } else {
                TreeNode predecessor = curr.left;
                while (predecessor.right != null && predecessor.right != curr) {
                    predecessor = predecessor.right;
                }
                
                if (predecessor.right == null) {
                    predecessor.right = curr;
                    curr = curr.left;
                } else {
                    // process curr node
                    if (prev != null && firstElement == null && prev.val > curr.val) {
                        firstElement = prev;
                    }
                    if (prev != null && firstElement != null && prev.val > curr.val) {
                        secondElement = curr;
                    }
                    predecessor.right = null;
                    prev = curr;
                    curr = curr.right;
                }
            }
        }
        
        // swap the value of first and second element
        int temp = firstElement.val;
        firstElement.val = secondElement.val;
        secondElement.val = temp;
    }
    
    
}
