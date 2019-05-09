/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    // 1.Do an inorder traversal using a Stack.
//     public int getMinimumDifference(TreeNode root) {
        
//         Stack<TreeNode> stack = new Stack<>();
//         TreeNode curr = root;
//         TreeNode prev = null;
//         int minAbsDiff = Integer.MAX_VALUE;
        
//         while (curr != null || !stack.isEmpty()) {
//             if (curr != null) {
//                 stack.push(curr);
//                 curr = curr.left;
//             } else {
//                 // we reached the left most node
//                 // start processing current nodes in the tree
//                 curr = stack.pop();
//                 if (prev != null) {
//                     if (Math.abs(prev.val - curr.val) < minAbsDiff) {
//                         minAbsDiff = Math.abs(prev.val - curr.val);
//                     }
//                 }
//                 prev = curr;
//                 curr = curr.right; // proceed the right tree of curr node
//             }
//         }
        
//         return minAbsDiff;
//     }

    //2.DFS to do inorder traversal
    TreeNode prev = null;
    public int getMinimumDifference(TreeNode root) {
        
        int[] minAbsDiff = new int[] {Integer.MAX_VALUE};
        dfs(root, minAbsDiff);
        return minAbsDiff[0];
    }
    
    private void dfs(TreeNode root, int[] minAbsDiff) {
        // root should not be null
        if (root.left != null) dfs(root.left, minAbsDiff);
        // process the current root
        if (prev != null) {
            // current root is not the first node in the inorder traversal
            if (Math.abs(prev.val - root.val) < minAbsDiff[0]) {
                minAbsDiff[0] = Math.abs(prev.val - root.val);
            }
        }
        prev = root;
        if (root.right != null) dfs(root.right, minAbsDiff);
    }
}
