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
    // 1. Recursive
    /*
    https://leetcode.com/problems/binary-tree-maximum-path-sum/discuss/39775/Accepted-short-solution-in-Java
    
    The reason that it compares with 0 is simple: if its less than 0, that means we should not connect current node with that branch, 
    since it will decrease the value of the path that goes through current node anyway. In other words, if both branch have negative 
    values, then it's better just not to connect current node with any of the branch (simply take current node's value alone).

    */
//     int max = Integer.MIN_VALUE;
//     public int maxPathSum(TreeNode root) {
//         fromRootToLeaf(root);
//         return max;
//     }
    
//     private int fromRootToLeaf(TreeNode root) {
//         if (root == null) return 0;
        
//         int left = Math.max(0, fromRootToLeaf(root.left));
//         int right = Math.max(0, fromRootToLeaf(root.right));
        
//         max = Math.max(max, left + right + root.val);   // update the max path passing through root
//         return Math.max(left, right) + root.val;
//     }
    
    // 2. Iterative
    /*
    https://leetcode.com/problems/binary-tree-maximum-path-sum/discuss/39927/Iterative-Java-solution
    
    */
     public int maxPathSum(TreeNode root) {
         int max = Integer.MIN_VALUE;
         // List<TreeNode> list = reversePreOrder(root);
         List<TreeNode> list = postOrder(root);
         HashMap<TreeNode, Integer> map = new HashMap<>();
         map.put(null, 0);
         for (TreeNode curr : list) {
             int left = Math.max(0, map.get(curr.left));
             int right = Math.max(0, map.get(curr.right));
             max = Math.max(max, left + right + curr.val);
             map.put(curr, Math.max(left, right) + curr.val);
         }
         
         return max;
     }
    
    private List<TreeNode> reversePreOrder(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();
        if (root == null) return result;
        
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            result.add(0, curr);
            if (curr.right != null) stack.push(curr.right);
            if (curr.left != null) stack.push(curr.left);
        }
        return result;
    }
    
    private List<TreeNode> postOrder(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();
        if (root == null) return result;
        
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> out = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            out.push(curr);
            if (curr.left != null) stack.push(curr.left);
            if (curr.right != null) stack.push(curr.right);
        }
        
        while (!out.isEmpty()) {
            result.add(out.pop());
        }
        return result;
    }
    
}
