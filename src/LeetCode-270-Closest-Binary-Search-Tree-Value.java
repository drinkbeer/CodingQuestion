/*
LeetCode: https://leetcode.com/problems/closest-binary-search-tree-value/
LintCode: 
JiuZhang: 
ProgramCreek: 

Analysis: 

[1], 4.428571   ->  1
1.Preorder traversal
Time O(N)

2.

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
    
    //1.Iterative (Level Order Traversal)
    // public int closestValue(TreeNode root, double target) {
    //     if(root == null) return -1;
        
    //     int val = root.val;
    //     Queue<TreeNode> queue = new LinkedList<TreeNode>();
    //     queue.offer(root);
        
    //     while(!queue.isEmpty()){
    //         TreeNode curr = queue.poll();
    //         if(Math.abs(target - val) > Math.abs(target - curr.val)){
    //             val = curr.val;
    //         }
    //         if(curr.left != null)queue.offer(curr.left);
    //         if(curr.right != null)queue.offer(curr.right);
    //     }
    //     return val;
    // }
    
    // 2.DFS Recursive (Pre-ordder Traversal)
    int val = 0;
    public int closestValue(TreeNode root, double target) {
        if(root == null) return -1;
        
        val = root.val; //init val
        closest(root, target);
        return val;
    }
    
    private void closest(TreeNode root, double target){
        if(root == null) return;
        
        if(Math.abs(target - val) > Math.abs(target - root.val)){
            val = root.val;
        }
        
        closest(root.left, target);
        closest(root.right, target);
    }
    
    // 3.Iterative
    public int closestValue(TreeNode root, double target) {
        int val = root.val;
        while (root != null) {
            if (Math.abs(root.val - target) < Math.abs(val - target)) {
                // find a new cloest value
                val = root.val;
            }
            if (root.val > target) {
                root = root.left;
            } else {
                root = root.right;
            }
        }        
        
        return val;
    }
    
    // 1. BFS (Inorder Traversal)
//     public int closestValue(TreeNode root, double target) {
        
//         Stack<TreeNode> stack = new Stack<>();
//         TreeNode curr = root;
//         double min = Double.MAX_VALUE;
//         int minValue = Integer.MAX_VALUE;
        
//         while (curr != null || !stack.isEmpty()) {
//             if (curr != null) {
//                 stack.push(curr);
//                 curr = curr.left;
//             } else {
//                 curr = stack.pop();
                
//                 if (Math.abs(curr.val - target) < min) {
//                     // find a new smaller node
//                     min = Math.abs(curr.val - target);
//                     minValue = curr.val;
//                 }
                
//                 curr = curr.right;
//             }
//         }
        
//         return minValue;
//     }
    
    // 2.DFS (Inorder Traversal)
    int minValue = Integer.MAX_VALUE;
    double minDiff = Double.MAX_VALUE;
    public int closestValue(TreeNode root, double target) {
        
        if (root.left != null) closestValue(root.left, target);
        if (Math.abs(root.val - target) < minDiff) {
            minDiff = Math.abs(root.val - target);
            minValue = root.val;
        }
        if (root.right != null) closestValue(root.right, target);
        
        return minValue;
    }
}
