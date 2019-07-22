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
    // Level order traversal, and get the sum of left leaf
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int res = 0;
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                // curr.left is a left leaf
                if (curr.left != null && curr.left.left == null && curr.left.right == null) res += curr.left.val;
                if (curr.left != null) queue.add(curr.left);
                if (curr.right != null) queue.add(curr.right);
            }
        }
        
        return res;
    }
    
    
    // 1. Recursive (My Solution)
//     public int sumOfLeftLeaves(TreeNode root) {
//         if (root == null) return 0;
//         return sumOfLeftLeavesInclusive(root.left) + sumOfLeftLeaves(root.right);
//     }
    
//     public int sumOfLeftLeavesInclusive(TreeNode root) {
//         if (root == null) return 0;
//         if (root.left == null && root.right == null) return root.val;
//         return sumOfLeftLeavesInclusive(root.left) + sumOfLeftLeaves(root.right);
//     }
    
    
    // 2. Another Recursive Solution
    /*
    https://leetcode.com/problems/sum-of-left-leaves/discuss/88950/Java-iterative-and-recursive-solutions
    */
//     public int sumOfLeftLeaves(TreeNode root) {
//         return helper(root, false);
//     }
    
//     private int helper(TreeNode root, boolean isLeft) {
//         if (root == null) return 0;
//         if (root.left == null && root.right == null && isLeft) {
//             return root.val;
//         }
//         return helper(root.left, true) + helper(root.right, false);
//     }
    
    // 3. Iterative
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) return 0;
        int ans = 0;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);

        while(!stack.empty()) {
            TreeNode node = stack.pop();
            if(node.left != null) {
                if (node.left.left == null && node.left.right == null)
                    ans += node.left.val;
                else
                    stack.push(node.left);
            }
            if(node.right != null) {
                if (node.right.left != null || node.right.right != null)
                    stack.push(node.right);
            }
        }
        return ans;
    }
}
