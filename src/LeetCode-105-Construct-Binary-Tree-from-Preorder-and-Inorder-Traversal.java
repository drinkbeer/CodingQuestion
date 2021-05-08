/*
LeetCode: https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
LintCode: http://www.lintcode.com/problem/construct-binary-tree-from-preorder-and-inorder-traversal/
JiuZhang: http://www.jiuzhang.com/solutions/construct-binary-tree-from-preorder-and-inorder-traversal/
ProgramCreek: http://www.programcreek.com/2014/06/leetcode-construct-binary-tree-from-preorder-and-inorder-traversal-java/

Analysis: 

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

in-order:   4 2 5 (1) 6 7 3 8
pre-order: (1) 2 4 5  3 7 6 8

Pos - the position of root node in in-order traversal array
L = pos - inStart, pos exclusive

pre-order left tree: [preStart + 1, preStart + 1 + L - 1]
                    = [preStart + 1, preStart + pos - inStart]
pre-order right tree: [preStart + 1 + L, preEnd]
                    = [preStart + pos - inStart + 1, preEnd]

in-order left tree: [inStart, inStart + L - 1]
                    = [inStart, inStart + pos - inStart - 1]
                    = [inStart, pos - 1]
in-order right tree: [inStart + L + 1, inEnd]
                    = [inStart + pos - inStart + 1, inEnd]
                    = [pos + 1, inEnd]


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
