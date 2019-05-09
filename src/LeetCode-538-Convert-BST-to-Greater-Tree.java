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
    // 1.Recursive: do an in-order traversal, but traverse the right tree first
    // int sum = 0;
    // public TreeNode convertBST(TreeNode root) {
    //     if (root == null) return null;
    //     if (root.right != null) convertBST(root.right);
    //     root.val += sum;
    //     sum = root.val;
    //     if (root.left != null) convertBST(root.left);
    //     return root;
    // }
    
    // 2.Iterative: do an in-order traversal, but traversal the right tree first
    // https://leetcode.com/problems/convert-bst-to-greater-tree/discuss/100516/Java-Three-O(n)-Methods%3A-Recursive-Iterative-and-Morris-Traversal
    // Space O(N)
    public TreeNode convertBST(TreeNode root) {
        if (root == null) return null;
        int sum = 0;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.right;
            }
            cur = stack.pop();
            int tmp = cur.val;
            cur.val += sum;
            sum += tmp;
            cur = cur.left;
        }
        return root;
    }

}
