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

/*

preorder    root | left tree | right tree
inorder     left tree | root | right tree
postorder   left tree | right tree | root

1.Using the postorder to find the root position, and using the root to split the left tree, and right tree in inorder.

2.Construct tree

root.left = construct(inorder(left tree), postorder(left tree))
root.right = construct(inorder(right tree), postorder(right tree))


1, 2, 0, 3, 4

1, 2, 3, 4, 0


*/
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null) return null;
        if (inorder.length != postorder.length) return null;
        
        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }
    
    // Helper function to construct the tree recursively.
    private TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int poStart, int poEnd) {
        if (inStart > inEnd || poStart > poEnd) return null;
        
        // find the position of root in inorder
        // root index is postorder[poEnd]
        int position = findPosition(inorder, inStart, inEnd, postorder[poEnd]);
        
        // construct root node
        TreeNode root = new TreeNode(postorder[poEnd]);
        
        // calculate left tree size
        int leftSize = position - inStart;
        int rightSize = inEnd - position;
        
        root.left = buildTree(inorder, inStart, inStart + leftSize - 1, postorder, poStart, poStart + leftSize - 1);
        root.right = buildTree(inorder, position + 1, inEnd, postorder, poStart + leftSize, poEnd - 1);
        
        return root;
    }
    
    private int findPosition(int[] arr, int start, int end, int target) {
        if (start < 0 || end > arr.length - 1) return -1;
        for (int i = start; i <= end; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
