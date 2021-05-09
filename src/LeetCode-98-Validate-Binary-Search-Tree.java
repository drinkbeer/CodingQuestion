/*
LeetCode: 
LintCode: http://www.lintcode.com/problem/validate-binary-search-tree/
JiuZhang: http://www.jiuzhang.com/solutions/validate-binary-search-tree/
ProgramCreek: http://www.programcreek.com/2012/12/leetcode-validate-binary-search-tree-java/
Other: http://www.cnblogs.com/yuzhangcmu/p/4177047.html

Analysis: 4 solutions
1.Recursive

2.Iterative

Do inorder Traversal, and compare the order is ascending.
To compare the order is ascending, we need another TreeNode variable to record the previous node, and compare the prev and curr.


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
public class Solution {
    
        // 1. DFS
//     public boolean isValidBST(TreeNode root) {
            // Double.MIN_VALUE: A constant holding the smallest positive nonzero value of type double, 2-1074.
            // Double.MAX_VALUE: A constant holding the largest positive finite value of type double, (2-2-52)·21023.
            // So here we cannot use Double.MIN_VALUE and Double.MAX_VALUE
            // return isValidBST(root, Double.MIN_VALUE, Double.MAX_VALUE);
//         return isValidBST(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
//     }
    
//     private boolean isValidBST(TreeNode root, double min, double max) {
//         if (root == null) return true;
        
//         if (root.val >= max || root.val <= min) return false;
        
//         return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
//     }
    
    // 2.BFS (using Inorder Traversal)
//     public boolean isValidBST(TreeNode root) {
//         if (root == null) return true;
        
//         Stack<TreeNode> stack = new Stack<>();
//         TreeNode curr = root;
//         TreeNode prev = null;  // record the prev node (which is left child of curr), and check if the prev.val < curr.val
        
//         while (curr != null || !stack.isEmpty()) {
//             // Put everything in the left tree into the stack.
//             while (curr != null) {
//                 stack.push(curr);
//                 curr = curr.left;
//             }
            
//             curr = stack.pop();
//             // Prev is the left node, which should prev.val < curr.val
//             if (prev != null && prev.val >= curr.val) return false;
//             prev = curr;
//             curr = curr.right;
//         }
//         return true;
//     }
    
    // 3. BFS (Using another way of Inorder Traversal, easier to understand the approach)
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        TreeNode prev = null; // record the prev node (which is left child of curr), and check if prev.val < curr.val
        
        while (curr != null || !stack.isEmpty()) {
            
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                curr = stack.pop();
                if (prev != null && prev.val >= curr.val) return false;
                prev = curr;
                curr = curr.right;
            }
        }
        
        return true;
    }
}
