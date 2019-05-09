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
    // 1.BFS. Level order traversal
//     public List<Integer> largestValues(TreeNode root) {
//         List<Integer> result = new ArrayList<>();
//         if (root == null) return result;
        
//         Queue<TreeNode> queue = new LinkedList<>();
//         queue.add(root);
        
//         while(!queue.isEmpty()) {
//             // proceed each level
//             int size = queue.size();
//             int largest = Integer.MIN_VALUE;
            
//             for (int i = 0; i < size; i++) {
//                 TreeNode node = queue.poll();
//                 if (node.val > largest) largest = node.val;
                
//                 if (node.left != null) queue.add(node.left);
//                 if (node.right != null) queue.add(node.right);
//             }
            
//             result.add(largest);
//         }
        
//         return result;
//     }
    
    // 2.DFS. Add a level as the index in the result list.
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        
        dfs(root, 0, result);
        return result;
    }
    
    private void dfs(TreeNode root, int level, List<Integer> result) {
        // root should not be null
        if (level == result.size()) {
            // the first node in this level, just add the root.val
            result.add(root.val);
        } else {
            // not the first node in this level, update the root.val, if it's larger than the curr value in the result in this level
            if (root.val > result.get(level)) {
                result.set(level, root.val);
            }
        }
        
        // continue traversal
        if (root.left != null) dfs(root.left, level + 1, result);
        if (root.right != null) dfs(root.right, level + 1, result);
    }
}
