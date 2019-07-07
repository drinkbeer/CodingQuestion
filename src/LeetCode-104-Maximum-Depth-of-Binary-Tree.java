/*
LeetCode: https://leetcode.com/problems/maximum-depth-of-binary-tree/
LintCode: http://www.lintcode.com/problem/maximum-depth-of-binary-tree/
JiuZhang: http://www.jiuzhang.com/solutions/maximum-depth-of-binary-tree/
ProgramCreek: 
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
    // 1.DFS
    // public int maxDepth(TreeNode root) {
    //     if(root == null) return 0;
        
    //     return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    // }
    
    // 2.BFS (level order traversal - Queue)
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int depth = 0;
        while(!queue.isEmpty()){
            depth++;
            int size = queue.size();
            
            for(int i = 0; i < size; i++){
                TreeNode curr = queue.poll();
                if(curr.left != null) queue.offer(curr.left);
                if(curr.right != null) queue.offer(curr.right);
            }
        }
        
        return depth;
    }
}
