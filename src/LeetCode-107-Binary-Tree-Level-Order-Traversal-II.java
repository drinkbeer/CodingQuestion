/*
LeetCode: https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
LintCode: http://www.lintcode.com/problem/binary-tree-level-order-traversal-ii/
JiuZhang: http://www.jiuzhang.com/solutions/binary-tree-level-order-traversal-ii/
ProgramCreek: http://www.programcreek.com/2014/04/leetcode-binary-tree-level-order-traversal-ii-java/

Analysis:
Just the same as Binary Tree Level Order Traversal, both use BFS.
Finaly, need to reverse the result.
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null) return result;
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        
        queue.offer(root);
        
        while(!queue.isEmpty()){
            List<Integer> level = new ArrayList<Integer>();
            int size = queue.size();
            
            for(int i = 0; i < size; i++){
                TreeNode curr = queue.poll();
                level.add(curr.val);
            
                if(curr.left != null) queue.offer(curr.left);
                if(curr.right != null) queue.offer(curr.right);
            }
            result.add(level);
        }
        
        List<List<Integer>> reverseResult = new ArrayList<List<Integer>>();
        for(int i = result.size() - 1; i >=0; i--){
            reverseResult.add(result.remove(i));
        }
        
        return reverseResult;
        
    }
}

class Solution {
    // 1. BFS (by reversing the order of result)
//     public List<List<Integer>> levelOrderBottom(TreeNode root) {
//         List<List<Integer>> result = new ArrayList<List<Integer>>();
//         if (root == null) return result;
        
//         Queue<TreeNode> queue = new LinkedList<>();
//         queue.add(root);
        
//         while(!queue.isEmpty()) {
//             // Process one level
//             int size = queue.size();
//             List<Integer> level = new ArrayList<>();
            
//             for (int i = 0; i < size; i++) {
//                 TreeNode curr = queue.poll();
//                 if (curr.left != null) queue.add(curr.left);
//                 if (curr.right != null) queue.add(curr.right);
//                 level.add(curr.val);
//             }
            
//             result.add(level);
//         }
        
//         // reverse the result
//         int resultSize = result.size();
//         for (int i = resultSize - 1; i >= 0; i--) { 
//             result.add(result.remove(i));
//         }
        
//         return result;
//     }
    
        // 2. BFS (by adding level to the beginning of the result)
//     public List<List<Integer>> levelOrderBottom(TreeNode root) {
//         List<List<Integer>> result = new ArrayList<List<Integer>>();
//         if (root == null) return result;
        
//         Queue<TreeNode> queue = new LinkedList<>();
//         queue.add(root);
        
//         while(!queue.isEmpty()) {
//             // Process one level
//             int size = queue.size();
//             List<Integer> level = new ArrayList<>();
            
//             for (int i = 0; i < size; i++) {
//                 TreeNode curr = queue.poll();
//                 if (curr.left != null) queue.add(curr.left);
//                 if (curr.right != null) queue.add(curr.right);
//                 level.add(curr.val);
//             }
            
//             result.add(0, level);
//         }
        
//         return result;
//     }
    
    // 3. DFS (get the normal order, and reverse it)
//     public List<List<Integer>> levelOrderBottom(TreeNode root) {
//         List<List<Integer>> result = new ArrayList<List<Integer>>();
//         if (root == null) return result;
        
//         levelOrderBottom(root, 0, result);
        
//         // reverse the order of the result
//         int resultSize = result.size();
//         for (int i = resultSize - 1; i >= 0; i--) {
//             result.add(result.remove(i));
//         }
        
//         return result;
//     }
    
//     // level starts from 0
//     private void levelOrderBottom(TreeNode node, int level, List<List<Integer>> result) {
//         if (result.size() == level) {
//             result.add(new ArrayList<Integer>());
//         }
        
//         result.get(level).add(node.val);
//         if (node.left != null) levelOrderBottom(node.left, level + 1, result);
//         if (node.right != null) levelOrderBottom(node.right, level + 1, result);
        
//         // the recursive loop ends when left and right are both null
//     }
    
        // 4. DFS (by adding level to the beginning of the result)
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) return result;
        
        levelOrderBottom(root, 0, result);
        
        return result;
    }
    
    // level starts from 0
    private void levelOrderBottom(TreeNode node, int level, List<List<Integer>> result) {
        if (result.size() == level) {
            result.add(0, new ArrayList<Integer>());
        }
        
        
        // for instance, a two level result.
        // [[1,2],[0]]
        result.get(result.size() - level - 1).add(node.val);
        if (node.left != null) levelOrderBottom(node.left, level + 1, result);
        if (node.right != null) levelOrderBottom(node.right, level + 1, result);
        
        // the recursive loop ends when left and right are both null
    }
}
