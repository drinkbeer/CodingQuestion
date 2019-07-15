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
https://leetcode.com/problems/boundary-of-binary-tree/discuss/101280/Java(12ms)-left-boundary-left-leaves-right-leaves-right-boundary

This solution is better than the official one.
Complexity:
O(n) leftBoundary(root.left);
O(n) leaves(root.left);
O(n) leaves(root.right);
O(n) rightBoundary(root.right);

Total: O(n)
*/
class Solution {
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        
        res.add(root.val);
        getLeftBoundary(root.left, res);
        getLeaf(root.left, res);
        getLeaf(root.right, res);
        getRightBoundary(root.right, res);
        return res;
    }
    
    // The path from root to left most leaf (exclude)
    private void getLeftBoundary(TreeNode curr, List<Integer> res) {
        if (curr == null) return;
        if (curr.left == null && curr.right == null) return;
        res.add(curr.val);
        if (curr.left != null) {
            getLeftBoundary(curr.left, res);
        }
        else if (curr.right != null) {
            getLeftBoundary(curr.right, res);
        }
    }
    
    // The Path from root to right most leaf (exclude)
    private void getRightBoundary(TreeNode curr, List<Integer> res) {
        if (curr == null) return;
        if (curr.right == null && curr.left == null) return;
        if (curr.right != null) {
            getRightBoundary(curr.right, res);
        } else if (curr.left != null) {
            getRightBoundary(curr.left, res);
        }
        
        res.add(curr.val);
    }
    
    private void getLeaf(TreeNode root, List<Integer> res) {
        TreeNode curr = root;
        Stack<TreeNode> stack = new Stack<>();
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                curr = stack.pop();
                
                if (curr.left == null && curr.right == null) {
                    // find a leaf
                    res.add(curr.val);
                }
                
                curr = curr.right;
            }
        }
    }
}
