/*
LeetCode: https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
LintCode: http://www.lintcode.com/problem/construct-binary-tree-from-inorder-and-postorder-traversal/
JiuZhang: http://www.jiuzhang.com/solutions/construct-binary-tree-from-inorder-and-postorder-traversal/
ProgramCreek: http://www.programcreek.com/2013/01/construct-binary-tree-from-inorder-and-postorder-traversal/

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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length != postorder.length) return null;
        
        return DFS(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }
    
    private TreeNode DFS(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd){
        if(inStart > inEnd || postStart > postEnd) return null;
        
        int val = postorder[postEnd];
        TreeNode node = new TreeNode(val);
        int position = findPosition(inorder, inStart, inEnd, val);
        
        // after remove node, left length: position - 1 - inStart + 1 = position - inStart
        //                    right length: inEnd - (position + 1) + 1 = inEnd - position
        node.left = DFS(inorder, inStart, position - 1, postorder, postStart, postStart + (position - inStart) - 1);
        node.right = DFS(inorder,position + 1, inEnd, postorder, postStart + (position - inStart), postEnd - 1);
        
        return node;
    }
    
    private int findPosition(int[] arr, int start, int end, int target){
        for(int i = start; i <= end; i++){
            if(arr[i] == target){
                return i;
            }
        }
        return -1;
    }
}