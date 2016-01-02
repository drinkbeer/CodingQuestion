/*
LeetCode: https://leetcode.com/problems/binary-tree-preorder-traversal/
LintCode: http://www.lintcode.com/problem/binary-tree-preorder-traversal/
JiuZhang: http://www.jiuzhang.com/solutions/binary-tree-preorder-traversal/
ProgramCreek: http://www.programcreek.com/2012/12/leetcode-solution-for-binary-tree-preorder-traversal-in-java/

Analysis: 
1.DFS

2.Divid and conquer

3.BFS
Be careful, stack is FILO. so we need first put right in stack , then put left.
So we can sure left is handled first, then right.

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
    // public List<Integer> preorderTraversal(TreeNode root) {
    //     List<Integer> result = new ArrayList<Integer>();
        
    //     DFS(root, result);
    //     return result;
    // }
    
    // private void DFS(TreeNode root, List<Integer> result){
    //     if(root == null) return;
        
    //     result.add(root.val);
    //     DFS(root.left, result);
    //     DFS(root.right, result);
    // }
    
    // 2.Divid and conquer
    // public List<Integer> preorderTraversal(TreeNode root) {
    //     List<Integer> result = new ArrayList<Integer>();
    //     if(root == null) return result;
        
    //     List<Integer> left = preorderTraversal(root.left);
    //     List<Integer> right = preorderTraversal(root.right);
        
    //     result.add(root.val);
    //     result.addAll(left);
    //     result.addAll(right);
        
    //     return result;
    // }
    
    // 3.BFS
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root == null) return result;
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode curr = stack.pop();
            result.add(curr.val);
            
            if(curr.right != null) stack.push(curr.right);
            if(curr.left != null) stack.push(curr.left);
        }
        
        return result;
    }
}