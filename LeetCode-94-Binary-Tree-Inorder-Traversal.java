/*
LeetCode: https://leetcode.com/problems/binary-tree-inorder-traversal/
LintCode: http://www.lintcode.com/problem/binary-tree-inorder-traversal/
JiuZhang: http://www.jiuzhang.com/solutions/binary-tree-inorder-traversal/
ProgramCreek: http://www.programcreek.com/2012/12/leetcode-solution-of-binary-tree-inorder-traversal-in-java/

Analysis: 
1.DFS
2.BFS()
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
    // public List<Integer> inorderTraversal(TreeNode root) {
    //     List<Integer> result = new ArrayList<Integer>();
        
    //     inorderTraversal(root, result);
    //     return result;
    // }
    
    // private void inorderTraversal(TreeNode root, List<Integer> result){
    //     if(root == null) return;
        
    //     if(root.left != null) inorderTraversal(root.left, result);
    //     result.add(root.val);
    //     if(root.right != null) inorderTraversal(root.right, result);
    // }
    
    // 2.BFS
    // public List<Integer> inorderTraversal(TreeNode root) {
    //     List<Integer> result = new ArrayList<Integer>();
    //     if(root == null) return result;
        
    //     Stack<TreeNode> stack = new Stack<TreeNode>();
    //     TreeNode curr = root;
        
    //     while(curr != null || !stack.isEmpty()){
    //         // push curr node's left tree into stack
    //         while(curr != null){
    //             stack.push(curr);
    //             curr = curr.left;
    //         }
            
    //         curr = stack.pop();
    //         result.add(curr.val);
    //         curr = curr.right;
    //     }
        
    //     return result;
    // }
    
    // 3.BFS(easier to understand than 2.)
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root == null)return result;
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode curr = root;       //define a pointer to track nodes
        
        while(curr != null || !stack.isEmpty()){
            // if curr node is not null, push to stack, and go down the tree to left
            if(curr != null){
                stack.push(curr);
                curr = curr.left;
            }else{
                // if no left node, pop last left node, process it
                // then let curr point to right node
                curr = stack.pop();
                result.add(curr.val);
                curr = curr.right;
            }
        }
        
        return result;
    }
    
}