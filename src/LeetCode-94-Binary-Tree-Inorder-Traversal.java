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

    // Another way to write without helper function
//    public List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer> result = new ArrayList<>();
//        if (root == null) return result;
//
//        if (root.left != null) result.addAll(inorderTraversal(root.left));
//        result.add(root.val);
//        if (root.right != null) result.addAll(inorderTraversal(root.right));
//
//        return result;
//    }
    
    // 2.DFS with stack
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
    
    // 3.DFS with Stack(easier to understand than 2.)
//    public List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer> result = new ArrayList<Integer>();
//        if(root == null)return result;
//
//        Stack<TreeNode> stack = new Stack<TreeNode>();
//        TreeNode curr = root;       //define a pointer to track nodes
//
//        while(curr != null || !stack.isEmpty()){
//            // if curr node is not null, push to stack, and go down the tree to left
//            if(curr != null){
//                stack.push(curr);
//                curr = curr.left;
//            }else{
//                // if no left node, pop last left node, process it
//                // then let curr point to right node
//                curr = stack.pop();
//                result.add(curr.val);
//                curr = curr.right;
//            }
//        }
//
//        return result;
//    }
    
    // DFS, trying to do it without additional pointer (This approach will add null to the stack.)
//    public List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer> result = new ArrayList<>();
//
//        if (root == null) return result;
//
//        Stack<TreeNode> stack =  new Stack<>();
//        stack.push(root);
//
//        while (!stack.isEmpty()) {
//            TreeNode curr = stack.peek();
//
//            if (curr != null) {
//                stack.push(curr.left);
//                curr = curr.left;
//            } else {
//                // Means no left node, pop last left node, and process it
//                // then left curr point to right node
//                stack.pop(); // pop last null element
//
//                if (!stack.isEmpty()) {
//                    curr = stack.pop();
//                    result.add(curr.val);
//
//                    // After we proceed the last left element, let's move right
//                    stack.push(curr.right);
//                    curr = curr.right;
//                }
//
//            }
//        }
//
//        return result;
//    }

    // 4. Morris Inorder Traversal
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        TreeNode curr = root;
        while (curr != null) {
            if (curr.left == null) {
                result.add(curr.val);
                curr = curr.right;
            } else {
                // find the predecessor of curr node
                TreeNode pre = curr.left;
                while (pre.right != null && pre.right != curr) {
                    pre = pre.right;
                }

                if (pre.right == null) {
                    pre.right = curr;
                    curr = curr.left;
                } else {
                    // finished traverse all the left tree, so process root now
                    // reset the predecessor's right to null
                    // as we finished traverse all left tree, and root, we should move to right tree
                    result.add(curr.val);
                    pre.right = null;
                    curr = curr.right;
                }
            }
        }

        return result;
    }
}
