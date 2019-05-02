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
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null || p == null) return null;
        
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        boolean getIt = false;
        
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                // proceed to the left tree, push left child to stack
                stack.push(curr);
                curr = curr.left;
            } else {
                // curr == null, means we are reaching to the left most node
                // we should start backtracking
                curr = stack.pop();
                if (getIt) return curr;
                if (curr.val == p.val) getIt = true;
                curr = curr.right;
            }
        }
        
        return null;
    }
}
