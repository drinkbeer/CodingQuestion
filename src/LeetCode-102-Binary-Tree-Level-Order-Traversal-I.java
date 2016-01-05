/*
LeetCode: https://leetcode.com/problems/binary-tree-level-order-traversal/
LintCode: http://www.lintcode.com/problem/binary-tree-level-order-traversal/
JiuZhang: http://www.jiuzhang.com/solutions/binary-tree-level-order-traversal/
ProgramCreek: http://www.programcreek.com/2014/04/leetcode-binary-tree-level-order-traversal-java/

Analysis: 
1.BFS

2.DFS


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
    // 1.BFS
    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList result = new ArrayList();
        
        if(root == null) return result;
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        
        while(!queue.isEmpty()){
            ArrayList<Integer> level = new ArrayList<Integer>();
            int size = queue.size();
            
            for(int i = 0; i < size; i++){
                TreeNode head = queue.poll();
                if(head.left != null) queue.add(head.left);
                if(head.right != null) queue.add(head.right);
                level.add(head.val);
            }
            
            result.add(level);
        }
        
        return result;
    }
    
    // 2.DFS
    // public List<List<Integer>> levelOrder(TreeNode root) {
        
    // }
}