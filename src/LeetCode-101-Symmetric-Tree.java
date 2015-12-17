/*
LeetCode: https://leetcode.com/problems/symmetric-tree/
LintCode: http://www.lintcode.com/problem/symmetric-binary-tree/
JiuZhang: http://www.jiuzhang.com/solutions/symmetric-binary-tree/
ProgramCreek: http://www.programcreek.com/2014/03/leetcode-symmetric-tree-java/

Analysis:
Recursive solution is easy.
Iterative solution is a little complex.
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
    // 1.Recursive solution
    // public boolean isSymmetric(TreeNode root) {
    //     if(root == null) return true;
        
    //     return isSymmetric(root.left, root.right);
    // }
    
    // private boolean isSymmetric(TreeNode left, TreeNode right){
    //     if(left == null && right == null) return true;
    //     if(left == null || right == null) return false;
    //     if(left.val != right.val) return false;
        
    //     return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    // }
    
    // Iterative solution
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        
        Queue<TreeNode> left = new LinkedList<TreeNode>();
        Queue<TreeNode> right = new LinkedList<TreeNode>();
        
        left.add(root.left);
        right.add(root.right);
        
        while(!left.isEmpty() && !right.isEmpty()){
            TreeNode l = left.poll();
            TreeNode r = right.poll();
            
            if(l == null && r == null)continue;
            
            if((l == null && r != null) || (l != null && r == null)) return false;
            
            if(l.val != r.val) return false;
            
            left.add(l.left);
            left.add(l.right);
            right.add(r.right);
            right.add(r.left);
        }
        
        // Since left queue and right queue have the same size, so at here both of them are empty.
        return true;
        
    }
}