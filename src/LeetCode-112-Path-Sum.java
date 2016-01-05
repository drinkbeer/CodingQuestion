/*
LeetCode: https://leetcode.com/problems/path-sum/
LintCode: http://www.lintcode.com/problem/path-sum/
JiuZhang: http://www.jiuzhang.com/solutions/path-sum/
ProgramCreek: http://www.programcreek.com/2013/01/leetcode-path-sum/

Analysis: 
1.DFS

2.BFS

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
    // 1. DFS
    // public boolean hasPathSum(TreeNode root, int sum) {
    //     if(root == null) return false;
        
    //     return DFS(root, sum, root.val);
    // }
    
    // private boolean DFS(TreeNode root, int sum, int curr){
    //     if(root.left == null && root.right == null && sum == curr){
    //         return true;
    //     }
        
    //     boolean left = false;
    //     if(root.left != null) left = DFS(root.left, sum, curr + root.left.val);
    //     boolean right = false;
    //     if(root.right != null) right = DFS(root.right, sum, curr + root.right.val);
        
    //     return left || right;
    // }
    
    // 2.A simpler DFS
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        
        if(root.left == null && root.right == null && root.val == sum) return true;
        
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
    
    // 3.BFS
    
}