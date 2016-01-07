/*
LeetCode: https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
LintCode: http://www.lintcode.com/problem/construct-binary-tree-from-preorder-and-inorder-traversal/
JiuZhang: http://www.jiuzhang.com/solutions/construct-binary-tree-from-preorder-and-inorder-traversal/
ProgramCreek: http://www.programcreek.com/2014/06/leetcode-construct-binary-tree-from-preorder-and-inorder-traversal-java/

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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length != inorder.length) return null;
        
        return DFS(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
    
    private TreeNode DFS(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd){
        // end condition
        if(preStart > preEnd || inStart > inEnd) return null;
        
        int val = preorder[preStart];
        TreeNode node = new TreeNode(val);
        
        // get node position in inorder[]
        int position = findPosition(inorder, inStart, inEnd, val);
        
        node.left = DFS(preorder, preStart + 1, preStart + position - inStart, inorder, inStart, position - 1);
        node.right = DFS(preorder, preStart + position - inStart + 1, preEnd, inorder, position + 1, inEnd);
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