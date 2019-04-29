/*
LeetCode: https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
LintCode: http://www.lintcode.com/problem/flatten-binary-tree-to-linked-list/
JiuZhang: http://www.jiuzhang.com/solutions/flatten-binary-tree-to-linked-list/
ProgramCreek: http://www.programcreek.com/2013/01/leetcode-flatten-binary-tree-to-linked-list/

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
    // 1. BFS or pre-order traversal
    public void flatten(TreeNode root) {
        if(root == null) return;
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        TreeNode prev = null;
        
        while(!stack.isEmpty()){
            TreeNode curr = stack.pop();
            if(curr.right != null) stack.push(curr.right);
            if(curr.left != null) stack.push(curr.left);
            if(prev != null){
                prev.left = null;
                prev.right = curr;
            }
            prev = curr;
        }
        
    }
    
}

/*
LeetCode: https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
LintCode: http://www.lintcode.com/problem/flatten-binary-tree-to-linked-list/
JiuZhang: http://www.jiuzhang.com/solutions/flatten-binary-tree-to-linked-list/
ProgramCreek: http://www.programcreek.com/2013/01/leetcode-flatten-binary-tree-to-linked-list/
Analysis: 

Just doing a pre-order traversal. Using one additional 'prev' node to indicate the parent it should connnect to.
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
class Solution {
    // 1.BFS
//     public void flatten(TreeNode root) {
//         if (root == null) return;
        
//         Stack<TreeNode> stack = new Stack<>();
//         stack.push(root);
//         TreeNode prev = null;
        
//         while(!stack.isEmpty()) {
//             TreeNode curr = stack.pop();
            
//             if (curr.right != null) stack.push(curr.right);
//             if (curr.left != null) stack.push(curr.left);
            
//             // verify if we should re-connect
//             if (prev != null) {
//                 prev.left = null;
//                 prev.right = curr;
//             }
            
//             prev = curr;
//         }
//     }
    
    
    // 2. BFS Space: O(1)
    // https://leetcode.com/problems/flatten-binary-tree-to-linked-list/discuss/36977/My-short-post-order-traversal-Java-solution-for-share
//     public void flatten(TreeNode root) {
//         if(root == null) return;
        
//         while(root != null){
//             if(root.left == null){
//                 root = root.right;
//                 continue;
//             }
//             TreeNode predecessor = root.left;
//             while(predecessor != null) {
//                 if(predecessor.right == null) break;
//                 predecessor = predecessor.right;
//             }
//             predecessor.right = root.right;
//             root.right = root.left;
//             root.left = null;
//         }
//     }
    
    // 3.DFS (write by myself, but it doesn't work)
//     public void flatten(TreeNode root) {
//         if (root == null) return;
        
//         flatten(root, null);
//     }
    
//     private TreeNode flatten(TreeNode node, TreeNode prev) {
//         if (prev != null) {
//             prev.left = null;
//             prev.right = node;
//         }
        
//         TreeNode parent = null;
//         if (node.left != null) {
//             parent = flatten(node.left, node);
//         }
//         if (node.right != null) {
//             parent = flatten(node.right, parent);
//         }
//         return parent;
//     }
    
    
    // 4. DFS
    /*
    The idea is to 
    
    1. convert left subtree into a list, 
    2. convert right into a list, 
    3. connect root with leftList.head and then leftList.tail to rightList.head. 
    
    So the key is to find the head and tail of each converted list. Good news is that head is always root, we only to figure out how have to get the tail. The idea is that if the tail of right subtree is not null, we've got the answer, otherwise, tail of left subtree, or root.


    */
//     public void flatten(TreeNode root) {
//         flattenAndGetTail(root);    
//     }
    
//     public TreeNode flattenAndGetTail(TreeNode root) {
//         if(root==null) return null;
        
//         TreeNode leftTail = flattenAndGetTail(root.left);
//         TreeNode rightTail = flattenAndGetTail(root.right);
        
//         if(leftTail!=null) {
//             leftTail.right = root.right;
//             root.right = root.left;
//             root.left = null;
//         }
        
//         if(rightTail!=null) return rightTail;
//         if(leftTail!=null) return leftTail;
//         return root;
//     }
    
    
    // DFS (very short)
    // https://leetcode.com/problems/flatten-binary-tree-to-linked-list/discuss/36977/My-short-post-order-traversal-Java-solution-for-share
    private TreeNode prev = null;

    public void flatten(TreeNode root) {
        if (root == null)
            return;
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }
}
