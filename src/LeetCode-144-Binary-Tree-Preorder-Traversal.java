/*
LeetCode: https://leetcode.com/problems/binary-tree-preorder-traversal/
LintCode: http://www.lintcode.com/problem/binary-tree-preorder-traversal/
JiuZhang: http://www.jiuzhang.com/solutions/binary-tree-preorder-traversal/
ProgramCreek: http://www.programcreek.com/2012/12/leetcode-solution-for-binary-tree-preorder-traversal-in-java/

Analysis: 
1.DFS

2.Divid and conquer

3.DFS Using a Stack
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
    //     if(root == null) return result;
    //
    //     DFS(root, result);
    //     return result;
    // }
    
    // private void DFS(TreeNode root, List<Integer> result){
    //     //if(root == null) return;
        
    //     result.add(root.val);
    //     DFS(root.left, result);
    //     DFS(root.right, result);
    // }

    // Another way of preorder traversal
//     public List<Integer> preorderTraversal(TreeNode root) {
//         List<Integer> result = new ArrayList<>();
//         if (root == null) return result;

//         result.add(root.val);
//         if (root.left != null) result.addAll(preorderTraversal(root.left));
//         if (root.right != null) result.addAll(preorderTraversal(root.right));

//         return result;
//     }

    // Divid and conquer
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
    
    // 2.DFS Using a Stack
//    public List<Integer> preorderTraversal(TreeNode root) {
//        List<Integer> result = new ArrayList<Integer>();
//        if(root == null) return result;
//
//        Stack<TreeNode> stack = new Stack<TreeNode>();
//        stack.push(root);
//        while(!stack.isEmpty()){
//            TreeNode curr = stack.pop();
//            result.add(curr.val);
//
//            if(curr.right != null) stack.push(curr.right);
//            if(curr.left != null) stack.push(curr.left);
//        }
//
//        return result;
//    }

    // 3. Morris Preorder Traversal
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        TreeNode curr = root;
        while (curr != null) {
            if (curr.left == null) {
                result.add(curr.val);
                curr = curr.right;
            } else {
                // find the predecessor of the curr node
                TreeNode pre = curr.left;
                while (pre.right != null && pre.right != curr) {
                    pre = pre.right;
                }

                if (pre.right == null) {
                    // find the predecessor of the curr node. First handle the curr node, then move to left tree
                    result.add(curr.val);
                    pre.right = curr;
                    curr = curr.left;
                } else {
                    // reached the predecessor, finished processing all nodes in left tree
                    // reset the predecessor's right node, and move right
                    pre.right = null;
                    curr = curr.right;
                }
            }
        }

        return result;
    }
}
