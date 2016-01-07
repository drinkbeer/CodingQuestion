/*
LeetCode: https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
LintCode: http://www.lintcode.com/problem/flatten-binary-tree-to-linked-list/
JiuZhang: http://www.jiuzhang.com/solutions/flatten-binary-tree-to-linked-list/
ProgramCreek: http://www.programcreek.com/2013/01/leetcode-flatten-binary-tree-to-linked-list/

Analysis: 

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
    // 1. BFS or pre-order traversal
    public void flatten(TreeNode root) {
        if(root == null) return;
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        TreeNode prev = null;
        
        while(!stack.isEmpty()){
            TreeNode curr = stack.pop();
            if(curr.right != null) stack.push(curr.right);
            if(curr.left != null) stack.push(curr.left);
            if(prev != null){
                prev.left = null;
                prev.right = curr;
            }
            prev = curr;
        }
        
    }
    
}