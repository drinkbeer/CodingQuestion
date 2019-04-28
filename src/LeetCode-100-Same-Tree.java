/*
LeetCode: https://leetcode.com/problems/same-tree/
LintCode: 
JiuZhang: 
ProgramCreek: http://www.programcreek.com/2012/12/check-if-two-trees-are-same-or-not/

Analysis:
1.DFS: Tooooo easy.

2.BFS

Using recursive approach, we need two stach for the two Tree. The order doesn't matter, just need to Traversal all the nodes.
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
    // 1.DFS
//     public boolean isSameTree(TreeNode p, TreeNode q) {
//         if (p == null && q == null) return true;
//         if (p == null || q == null) return false;
        
//         if (p.val != q.val) return false;
        
//         return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
//     }
    
    // 2.BFS (similar to inorder Traversal)
    // Similar to: https://leetcode.com/problems/same-tree/discuss/281890/Clean-Java-Non-recursive-Solution
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        
        if (p.val != q.val) return false;
        
        Stack<TreeNode> first = new Stack<>();
        Stack<TreeNode> second = new Stack<>();
        first.push(p);
        second.push(q);
        
        while(!first.isEmpty() && !second.isEmpty()) {
            
            p = first.pop();
            q = second.pop();
            
            if (p == null && q == null) {
                // do nothing
            } else if (p == null || q == null) {
                return false;
            } else {
                if (p.val != q.val) {
                    return false;
                }
                // pushing left node, or right node, the order doesn't matter.
                first.push(p.left);
                second.push(q.left);
                
                first.push(p.right);
                second.push(q.right);
            }
        }
        
        return true;
    }
}
