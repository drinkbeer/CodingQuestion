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
    /*
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Insert into a Binary Search Tree.
    Memory Usage: 38.9 MB, less than 100.00% of Java online submissions for Insert into a Binary Search Tree.
    */
//     public TreeNode insertIntoBST(TreeNode root, int val) {
//         if (root == null) return new TreeNode(val);

//         if (val < root.val) {
//             root.left = insertIntoBST(root.left, val);
//         } else {
//             root.right = insertIntoBST(root.right, val);
//         }
//         return root;
//     }
    
    // 2. Iterative
    /*
    https://leetcode.com/problems/insert-into-a-binary-search-tree/discuss/357791/Java-Non-Recursive-Solution-beats-100-time-and-memory
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Insert into a Binary Search Tree.
    Memory Usage: 38.2 MB, less than 100.00% of Java online submissions for Insert into a Binary Search Tree.
    */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        
        TreeNode dummy = new TreeNode(Integer.MAX_VALUE);
        dummy.left = root;
        TreeNode parent = dummy, curr = root;
        while (curr != null) {
            parent = curr;
            curr = parent.val > val ? parent.left : parent.right;
            
            if (curr == null) {
                if (parent.val > val) {
                    parent.left = new TreeNode(val);
                } else {
                    parent.right = new TreeNode(val);
                }
                break;
            }
        }
        
        return dummy.left;
    }
}
