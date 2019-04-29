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


/*
Three types of order:

Inorder:        left subtree | root | right subtree
Preorder:       root | left subtree | right subtree
Postorder:      left subtree | right subtree | root 

So from Preorder, we could get root, and use root to split the Inorder to left, and right tree.

Other prople's analysis:


Binary tree一共3种访问顺序：preorder, inorder, postorder。这道题目的推广就是给定一个binary tree的两种访问顺序，重构该binary tree。这类题目给定的两个排序中，如果包括了inorder，且没有重复元素，就非常好解了。解这类题有两个关键点：

1. 在inorder中寻找root的位置，从而从序列中分割出左右子树。

Inorder:     left subtree | root | right subtree
Preorder:   root | left subtree | right subtree
Postorder: left subtree | right subtree | root 

可见root是preorder序列的第一个节点，也是postorder的最后一个节点。所以给定这两个序列的任意一个我们即知道了root->val。通过搜索inorder序列，可以定位root所在的位置，从而也得到了left subtree和right subtree的节点数。

2. 递归构建

当root，left/right subtree都确定后
root->left = construct(inorder(left subtree), preorder(left subtree))
root->right = construct(inorder(right subtree), preorder(right subtree))

*/
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null) return null;
        if (preorder.length != inorder.length) return null;
        
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
    
    // Helper function to build a tree recursively.
    private TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) return null;
        
        // find the root position in inOrder
        int position = findPosition(inorder, inStart, inEnd, preorder[preStart]);
        
        // construct root
        TreeNode root = new TreeNode(preorder[preStart]);
        
        root.left = buildTree(preorder, preStart + 1, preStart + 1 + (position - inStart - 1), inorder, inStart, position - 1);
        root.right = buildTree(preorder, preStart + 1 + (position - inStart - 1) + 1, preEnd, inorder, position + 1, inEnd);
        
        return root;
    }
    
    // Helper function to find a position in an array.
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
