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
    
    // 1.Level order traversal
    /*
    Runtime: 1 ms, faster than 93.57% of Java online submissions for Check Completeness of a Binary Tree.
    Memory Usage: 36.1 MB, less than 100.00% of Java online submissions for Check Completeness of a Binary Tree.
    */
//     public boolean isCompleteTree(TreeNode root) {
//         if (root == null) return true;
        
//         Queue<TreeNode> queue = new LinkedList<>();
//         queue.offer(root);
//         boolean leafLevel = false;
        
//         while(!queue.isEmpty()) {
//             int size = queue.size();
//             // if (leafLevel) return queue.isEmpty();
            
//             for (int i = 0; i < size; i++) {
//                 TreeNode curr = queue.poll();
                
//                 if (leafLevel) {
//                     // after setting leafLevel to be true, all nodes following should have both left and right to be null
//                     if (curr.left != null || curr.right != null) return false;
//                 }

//                 if (curr.left == null && curr.right != null) return false;
                
//                 if (curr.left == null || curr.right == null) {
//                     leafLevel = true;
//                 }
                
//                 if (curr.left != null) queue.offer(curr.left);
//                 if (curr.right != null) queue.offer(curr.right);
//             }
            
//         }
        
//         return true;
//     }
    
    // 2. Level Order Traversal
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) return true;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while(queue.peek() != null) {
            TreeNode curr = queue.poll();
            queue.offer(curr.left);
            queue.offer(curr.right);
        }
        
        while(!queue.isEmpty() && queue.peek() == null) queue.poll();
        return queue.isEmpty();
    }
}
