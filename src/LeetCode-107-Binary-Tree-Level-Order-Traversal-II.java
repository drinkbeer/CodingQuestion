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