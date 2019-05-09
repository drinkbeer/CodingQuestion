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
    // 1.BFS. Do a level order traversal.
//     public int findBottomLeftValue(TreeNode root) {
//         TreeNode leftMost = root;
        
//         Queue<TreeNode> queue = new LinkedList<>();
//         queue.add(root);
        
//         while(!queue.isEmpty()) {
//             // Proceed to a new level
//             int size = queue.size();
//             leftMost = queue.peek();
//             for (int i = 0; i < size; i++) {
//                 TreeNode node = queue.poll();
//                 if (node.left != null) queue.add(node.left);
//                 if (node.right != null) queue.add(node.right);
//             }
//         }
        
//         return leftMost.val;
//     }
    
    // 2.DFS
    // https://leetcode.com/problems/find-bottom-left-tree-value/discuss/285316/Java-BFS-and-DFS
    private int maxDepth = -1;
    private int value;
    
    public int findBottomLeftValue(TreeNode root) {
        dfs(root, 0);
        return value;
    }
    
    private void dfs(TreeNode node, int depth) {
        if (node == null) return;
        if (depth > maxDepth) {
            value = node.val;
            maxDepth = depth;
        }
        dfs(node.left, depth + 1);
        dfs(node.right, depth + 1);
    }
}
