/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/**
Inorder traversal
*/
class Solution {
    // 1.BFS
//     public int kthSmallest(TreeNode root, int k) {
//         if (root == null) return -1;
        
//         int i = 0;
//         Stack<TreeNode> stack = new Stack<>();
//         TreeNode curr = root;
        
//         while (curr != null || !stack.isEmpty()) {
            
//             if (curr != null) {
//                 // push all left node into stack
//                 stack.push(curr);
//                 curr = curr.left;
//             } else {
//                 // start processing right node
//                 curr = stack.pop();
//                 i++;
//                 if (i == k) return curr.val;
//                 curr = curr.right;
//             }
//         }
        
//         return -1;
//     }
    
    // 2.DFS
    int count = 0;
    int result = Integer.MIN_VALUE;

    public int kthSmallest(TreeNode root, int k) {
        traverse(root, k);
        return result;
    }

    public void traverse(TreeNode root, int k) {
        if(root == null) return;
        
        // process the left tree
        traverse(root.left, k);
        // process the current node
        count++;
        if(count == k) {
            result = root.val;
            return;
        }
        // process the right tree
        traverse(root.right, k);       
    }
}
