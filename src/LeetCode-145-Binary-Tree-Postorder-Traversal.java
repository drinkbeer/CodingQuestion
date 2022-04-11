/*
LeetCode: https://leetcode.com/problems/binary-tree-postorder-traversal/
LintCode: http://www.lintcode.com/problem/binary-tree-postorder-traversal/
JiuZhang: http://www.jiuzhang.com/solutions/binary-tree-postorder-traversal/
ProgramCreek: http://www.programcreek.com/2012/12/leetcode-solution-of-iterative-binary-tree-postorder-traversal-in-java/

Analysis: 
1.DFS(Recursive)
2.BFS(Iterative)
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
    // 1.DFS(recursive)
    // public List<Integer> postorderTraversal(TreeNode root) {
    //     List<Integer> result = new ArrayList<Integer>();
    //     if(root == null) return result;
        
    //     DFS(root, result);
    //     return result;
    // }
    
    // private void DFS(TreeNode root, List<Integer> result){        
    //     if(root.left != null) DFS(root.left, result);
    //     if(root.right != null) DFS(root.right, result);
    //     result.add(root.val);
    // }
    
    // DFS(Recursive)
    // public List<Integer> postorderTraversal(TreeNode root) {
    //     List<Integer> result = new ArrayList<Integer>();
    //     if(root == null) return result;
        
    //     result.addAll(postorderTraversal(root.left));
    //     result.addAll(postorderTraversal(root.right));
    //     result.add(root.val);
        
    //     return result;
    // }
    
    // 2.
    // public List<Integer> postorderTraversal(TreeNode root) {
    //     List<Integer> result = new ArrayList<Integer>();
    //     if(root == null) return result;
        
    //     Stack<TreeNode> stack = new Stack<TreeNode>();
    //     TreeNode prev = null, curr = root;
    //     stack.push(root);
        
    //     while(!stack.isEmpty()){
    //         curr = stack.peek();
    //         // traverse down the tree
    //         if(prev == null || curr == prev.left || curr == prev.right){
    //             if(curr.left != null) stack.push(curr.left);
    //             else if(curr.right != null) stack.push(curr.right);
    //         }else if(prev == curr.left){
    //             // traverse up the tree from left
    //             if(curr.right != null) stack.push(curr.right);
    //         }else{
    //             // else 和 else if(prev == curr.right) 有什么区别？
    //             // traverse up the tree from right
    //             result.add(curr.val);
    //             // curr = 
    //             stack.pop();
    //         }
    //         prev = curr;
    //     }
        
    //     return result;
    // }
    
    // 3.DFS
    public List<Integer> postorderTraversal(TreeNode root){
        List<Integer> result = new ArrayList<Integer>();
        if(root == null) return result;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        Stack<TreeNode> out = new Stack<TreeNode>();
        stack.push(root);

        // The input order of "stack" is: root -> left subtree -> right subtree
        // The input order of "out" is: root -> right subtree -> left subtree
        while(!stack.isEmpty()){
            TreeNode curr = stack.pop();
            out.push(curr);

            if(curr.left != null) stack.push(curr.left);
            if(curr.right != null) stack.push(curr.right);
        }

        while(!out.isEmpty()) result.add(out.pop().val);
        
        return result;
    }

    // 4. Morris Postorder Traversal (Single Threaded Binary Tree Traversal)
    // Process in an order of: curr -> right subtree -> left subtree, but addFirst to dequeue (add in an reverse order)
    public List<Integer> postorderTraversal(TreeNode root) {
        Deque<Integer> result = new ArrayDeque<>();
        if (root == null) return new ArrayList<>(result);

        TreeNode curr = root;
        while (curr != null) {
            if (curr.right == null) {
                // No right subtree, all value in "dqueue" are from left subtree, so add "curr" to the first in deque, and continue processing left subtree
                result.addFirst(curr.val);
                curr = curr.left;
            } else {
                // find the successor of the curr node in right tree
                TreeNode p = curr.right;
                while (p.left != null && p.left != curr) {
                    p = p.left;
                }

                if (p.left == null) {
                    // Have not visited the right subtree, process curr, and then move to right subtree
                    // find the successor, starts to process right tree
                    result.addFirst(curr.val);
                    p.left = curr;
                    curr = curr.right;
                } else {
                    // Have visted the whole right subtree and curr, just move to left subtree
                    // find the successor, finished traverse right tree
                    // reset the successor's left node
                    p.left = null;
                    curr = curr.left;
                }
            }
        }

        return new ArrayList<>(result);
    }
    
}
